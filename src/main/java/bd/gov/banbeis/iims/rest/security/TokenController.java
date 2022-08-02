package bd.gov.banbeis.iims.rest.security;

import bd.gov.banbeis.iims.domain.security.TokenStore;
import bd.gov.banbeis.iims.domain.security.User;
import bd.gov.banbeis.iims.repository.TokenStoreRepository;
import bd.gov.banbeis.iims.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController("realm")
@RequiredArgsConstructor
@Transactional
public class TokenController {
    @Value("${iims.token-expiry-days}")
    Long tokenExpiry;

    private final JwtEncoder jwtEncoder;
    private final UserRepository userRepository;
    private final TokenStoreRepository tokenStoreRepository;

    @PostMapping("/token")
    public String token(Authentication authentication){
        Instant now = Instant.now();

        String scope = authentication
                .getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));

        Instant tokenValidTill = now.plus(tokenExpiry, ChronoUnit.DAYS);
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("banbeis.gov.bd")
                .issuedAt(now)
                .expiresAt(tokenValidTill)
                .subject(authentication.getName())
                .claim("scope", scope)
                .build();

        String token = this.jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
        storeToken(token, tokenValidTill, authentication.getName());
        return token;
    }

    private void storeToken(final String token, Instant tokenValidTill, final String username){
        Optional<User> user = userRepository.findByUsername(username);
        TokenStore tokenStore = new TokenStore();
        tokenStore.setUser(user.get());
        tokenStore.setToken(token);
        tokenStore.setValidTill(tokenValidTill);
        tokenStoreRepository.save(tokenStore);
    }
}
