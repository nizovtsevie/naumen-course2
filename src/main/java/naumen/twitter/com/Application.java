package naumen.twitter.com;
import naumen.twitter.com.domain.*;
import naumen.twitter.com.repos.*;
import naumen.twitter.com.service.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.List;
import java.util.Set;
import java.util.stream.*;

@SpringBootApplication
public class Application {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    private void testJpaMethods() {
        User user = new User();
        user.setActive(false);
        Set<Role> userRole = Stream.of(Role.USER).collect(Collectors.toSet());
        user.setRoles(userRole);
        user.setPassword("123456");
        user.setUsername("VladS");
        userService.createUser(user);
        User user2 = new User();
        user2.setRoles(userRole);
        user2.setPassword("VladSivirukhinProtectsMe");
        user2.setUsername("Smith");
        userService.createUser(user2);
        User users1 = new User();
        users1.setUsername("JonDorian");
        users1.setPassword("VladSivirukhinOneLove");
        users1.setRoles(userRole);
        userService.createUser(users1);

        List<User> users = userService.findAll();
        users.forEach(it -> System.out.println(it));
        userService.deleteAll();

    }
}
