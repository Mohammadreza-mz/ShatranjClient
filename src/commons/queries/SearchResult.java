package commons.queries;

import commons.dataTypes.SearchDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

public class SearchResult implements Serializable {
    public LinkedList<SearchDetails> searchResult;

    public SearchResult(LinkedList<SearchDetails> searchResult) {
        this.searchResult = searchResult;
    }
}
