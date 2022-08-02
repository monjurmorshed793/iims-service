package bd.gov.banbeis.iims.service.security;

import bd.gov.banbeis.iims.domain.security.SystemPrincipal;
import bd.gov.banbeis.iims.domain.security.User;
import bd.gov.banbeis.iims.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SystemUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isEmpty())
            throw new UsernameNotFoundException(username);
        return new SystemPrincipal(user.get());
    }


}
