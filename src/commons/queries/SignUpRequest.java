package commons.queries;

import commons.dataTypes.User;

import java.io.Serializable;

public class SignUpRequest implements Serializable {
    public User user;

    public SignUpRequest(User user) {
        this.user = user;
    }
}
