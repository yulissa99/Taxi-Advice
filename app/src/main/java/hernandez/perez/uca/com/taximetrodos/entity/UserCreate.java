package hernandez.perez.uca.com.taximetrodos.entity;

/**
 * Created by LENOVO on 7/5/2018.
 */

public class UserCreate {

    private String email;
    private String password;
    private String username;
    private String realm;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealm() {
        return realm;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }
}
