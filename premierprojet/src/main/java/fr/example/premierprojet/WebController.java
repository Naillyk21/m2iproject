package fr.example.premierprojet;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class WebController {

    ArrayList<User> listeUser = new ArrayList<User>();

    @GetMapping(value="/index")
    public String index(Model model)
    {
        Date date = new Date();
        Long time = date.getTime();
        String dateajd = date.getDay() + "/" + date.getMonth() + "/" + date.getYear() + " - " + date.getHours() + ":" +date.getMinutes();
        model.addAttribute("time",time);
        model.addAttribute("dateajd",dateajd);
        model.addAttribute("user",new User());
        return "index" ;
    }

    @PostMapping("/index")
    public String index(@ModelAttribute User user,Model model)
    {
        model.addAttribute("user",user);
        System.out.println("------------");
        listeUser.add(user);
        //listeUser.forEach(System.out.println(user.toString()))
        return "index";
    }

}
