package naumen.twitter.com.controller;

import naumen.twitter.com.domain.Message;
import naumen.twitter.com.domain.User;
import naumen.twitter.com.repos.MessageRepo;
import naumen.twitter.com.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("{user}")
    public String listProfile(@PathVariable User user, Model model)
    {
        Iterable<Message> messages = messageRepo.findByAuthor(user);
        model.addAttribute("user", user);
        model.addAttribute("messages", messages);
        return "profile";
    }

    @GetMapping("/search")
    public String searchProfile(@RequestParam(required = false, defaultValue = "") String username, Model model) {
        Iterable<User> users = userRepo.findAllByUsername(username);

        model.addAttribute("users", users);
        model.addAttribute("username", username);

        return "profileSearch";
    }

}
