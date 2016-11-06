package jrs.models;
import jrs.settings.validators.UniqueUsername;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;
@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @UniqueUsername(message="Username already exists")
    @Size(min = 8, max = 255, message = "Username have to be grater than 8 characters")
    @Column(unique = true)
    private String username;
    @NotNull
    @Size(min = 8, max = 255, message = "Password have to be grater than 8 characters")
    private String password;


    public Account() {

    }

    public Account(Account account){
        this.id = account.getId();
        this.username = account.getUsername();
        this.password = account.getPassword();
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }


}
