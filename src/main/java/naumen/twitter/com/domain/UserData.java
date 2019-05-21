package naumen.twitter.com.domain;
import javax.persistence.*;
import java.sql.Date;

@Entity
public class UserData {
    @Id
    private Long id;
    private String name;
    private String phoneNumber;
    private Date registrationDate;
    private String description;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public UserData() {

    }

    public UserData(long id, String name, String phoneNumber, String registrationDate) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.registrationDate = Date.valueOf(registrationDate);
    }

    public long getId() {
        return id;
    }

    public void setId(long UId) {
        this.id = UId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

