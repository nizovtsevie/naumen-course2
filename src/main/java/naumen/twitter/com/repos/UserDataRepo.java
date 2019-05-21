package naumen.twitter.com.repos;

import naumen.twitter.com.domain.UserData;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserDataRepo extends CrudRepository<UserData, Long> {
    UserData findByUser_Id(Long id);
}
