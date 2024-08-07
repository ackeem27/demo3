package LyncSystems.demo3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final MyUserDetailsService myUserDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(MyUserDetailsService myUserDetailsService, @Lazy PasswordEncoder passwordEncoder) {
        this.myUserDetailsService = myUserDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    public void saveUser(UserData user) {
        myUserDetailsService.saveUser(user);
    }

    public boolean validateUser(UserData user) {
        return myUserDetailsService.validateUser(user);
    }
}
