package commons.queries;

import commons.dataTypes.User;

import java.io.Serializable;

public class SignUpResult implements Serializable {
    //null if unsuccessful
    public User user;

    public SignUpResult(User user) {
        this.user = user;
    }
}
