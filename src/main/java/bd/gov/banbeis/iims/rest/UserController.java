package bd.gov.banbeis.iims.rest;

import bd.gov.banbeis.iims.domain.security.User;
import bd.gov.banbeis.iims.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.Arrays;
import java.util.List;

@RestController("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping()
    public ResponseEntity<Void> createUser(User user){
        return createUsers(Arrays.asList(user));
    }

    @PostMapping("/batch")
    public ResponseEntity<Void> createUsers(List<User> users){
        for(User user: users){
            if(user.getRawPassword()==null)
                user.setRawPassword(RandomStringUtils.random(10, 'A','B','C','D','E','F','G','H','J','K','M','N','2','3','4','5','6','7','8','9'));
            user.setPassword(passwordEncoder.encode(user.getRawPassword()));
        }
        userRepository.saveAll(users);
        return ResponseEntity.ok().build();
    }
}
