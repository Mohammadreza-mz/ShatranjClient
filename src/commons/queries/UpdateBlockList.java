package commons.queries;

import java.io.Serializable;

public class UpdateBlockList implements Serializable {
    public String username,blockedUsername;
    public boolean isAddingUser;

    public UpdateBlockList(String username, String blockedUsername, boolean isAddingUser) {
        this.username = username;
        this.blockedUsername = blockedUsername;
        this.isAddingUser = isAddingUser;
    }
}
