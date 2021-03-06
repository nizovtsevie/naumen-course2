package naumen.twitter.com.repos;

import naumen.twitter.com.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String userName);
    List<User> findAllByUsername(String userName);
}
