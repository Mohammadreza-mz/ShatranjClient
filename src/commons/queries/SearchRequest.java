package commons.queries;

import java.io.Serializable;

public class SearchRequest implements Serializable {
    //"" for all
    // opponent from last games on top
    public String username,prefix;

    public SearchRequest(String username, String prefix) {
        this.username = username;
        this.prefix = prefix;
    }
}
