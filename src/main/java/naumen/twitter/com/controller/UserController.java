package naumen.twitter.com.controller;

import naumen.twitter.com.domain.Role;
import naumen.twitter.com.domain.User;
import naumen.twitter.com.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping
    public String userList(@AuthenticationPrincipal User user, Model model) {
        boolean isAdmin = user.getRoles().contains(Role.ADMIN);
        model.addAttribute("users", userRepo.findAll());
        model.addAttribute("isAdmin", isAdmin);

        return "userList";
    }

    @GetMapping("{user}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user
    ) {
        user.setUsername(username);
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());
        user.getRoles().clear();

        for(String key : form.keySet()) {
            if(roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userRepo.save(user);

        return "redirect:/user";
    }
}
