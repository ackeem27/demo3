package LyncSystems.demo3;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@org.springframework.stereotype.Controller
public class Logincontroller {
    @GetMapping("/login")
    public String login(){
       return"login" ;
    }

    @GetMapping("/home")
    public String home(){
        return"home";
    }
    @GetMapping("/signup")
    public String signup(){
        return"signup";

    }
    @PostMapping("/login")
    public String processLoginForm(@ModelAttribute("user") UserData user) {
        // Handle the login logic here
        return "redirect:/home";}

}
