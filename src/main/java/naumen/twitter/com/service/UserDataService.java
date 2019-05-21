package naumen.twitter.com.service;

import naumen.twitter.com.domain.UserData;
import naumen.twitter.com.repos.UserDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDataService {

    @Autowired
    private UserDataRepo userDataRepo;

    public Optional<UserData> findByUserId(Long id){
        return userDataRepo.findById(id);
    }

    public void createUserData(UserData userdata)
    {
        userDataRepo.saveAndFlush(userdata);
    }

    public void deleteAll()
    {
        userDataRepo.deleteAll();
    }
}
