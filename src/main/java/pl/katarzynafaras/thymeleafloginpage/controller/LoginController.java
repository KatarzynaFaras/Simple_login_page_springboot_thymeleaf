package pl.katarzynafaras.thymeleafloginpage.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.katarzynafaras.thymeleafloginpage.model.LoginForm;

@Controller
public class LoginController {


    @GetMapping("/login")
    public String getLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute(name="loginForm")LoginForm loginForm, Model model){

        String username = loginForm.getUsername();
        String password = loginForm.getPassword();

        if("a".equals(username) && "a".equals(password)){
            return "home";
        }

        model.addAttribute("invalidCredentials", true);
            return "login";

    }
}
