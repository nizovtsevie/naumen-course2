package naumen.twitter.com.service;

import naumen.twitter.com.domain.User;
import naumen.twitter.com.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    public void createUser(User user)
    {
        userRepo.saveAndFlush(user);
    }
    public List<User> findAll()
    {
        return userRepo.findAll();
    }
    public void deleteAll()
    {
        userRepo.deleteAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }
}
