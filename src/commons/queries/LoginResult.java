package commons.queries;

import commons.dataTypes.User;

import java.io.Serializable;

public class LoginResult implements Serializable {
    public User user;
    public String message;
    //null if user and pass doesn't match

    public LoginResult(User user, String message) {
        this.user = user;
        this.message = message;
    }
}
