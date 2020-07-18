package commons.queries;

import java.io.Serializable;

public class UpdateBlockList implements Serializable {
    boolean isAddingUser;
    String username;

    public UpdateBlockList(boolean isAddingUser, String username) {
        this.isAddingUser = isAddingUser;
        this.username = username;
    }
}
