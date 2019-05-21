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

    @Autowired
    private UserDataService userDataService;


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
        UserData userData = new UserData(user.getId(), "Vlad", "+123456789", "2014-03-26");
        user.setData(userData);
        userDataService.createUserData(userData);
        User user2 = new User();
        user2.setRoles(userRole);
        user2.setPassword("VladSivirukhinProtectsMe");
        user2.setUsername("Smith");
        userService.createUser(user2);
        UserData user2Data = new UserData(user2.getId(), "VladFunNumberOne", "+123654987", "2014-04-03");
        user.setData(user2Data);
        userDataService.createUserData(user2Data);
        User users1 = new User();
        users1.setUsername("JonDorian");
        users1.setPassword("VladSivirukhinOneLove");
        users1.setRoles(userRole);
        userService.createUser(users1);
        UserData users1Data = new UserData(users1.getId(), "VladSivirukhinWillYouMarryMe?", "+78005553535","2014-03-30");
        users1.setData(users1Data);
        userDataService.createUserData(users1Data);
        System.out.println("Test 1");
        List<User> users = userService.findAll();
        users.forEach(it -> System.out.println(it + "\n" + userDataService.findByUserId(it.getId())));
        userService.deleteAll();
        userDataService.deleteAll();

    }
}
