package LyncSystems.demo3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new UserData());
        return "login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("user", new UserData());
        return "signup";
    }

    @PostMapping("/signup")
    public String processSignupForm(@ModelAttribute("user") UserData user, RedirectAttributes redirectAttributes) {
        userService.saveUser(user);
        redirectAttributes.addFlashAttribute("message", "Sign up successful. Please log in.");
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String processLoginForm(@ModelAttribute("user") UserData user, RedirectAttributes redirectAttributes) {
        if (userService.validateUser(user)) {
            return "redirect:/home";
        } else {
            redirectAttributes.addFlashAttribute("error", "Invalid username or password.");
            return "redirect:/login";
        }
    }
}
