package LyncSystems.demo3;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class InsertTest {
    @Autowired
    UserRepository userRepository;
   @Autowired
   PasswordEncoder passwordEncoder;

   @Test
    public void insertUser(){
       User user = new User();
       user.setUsername("user1");
       String rawpassword = "userpassword";
       String encodedpassword = passwordEncoder.encode(rawpassword);
       user.setPassword(encodedpassword);
       userRepository.save(user);


   }
}
