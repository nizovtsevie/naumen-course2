package naumen.twitter.com.repos;

import naumen.twitter.com.domain.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserDataRepo extends JpaRepository<UserData, Long> {
}
