package commons.dataTypes;

import java.util.Comparator;

public class ScoreboardComparator implements Comparator<SearchDetails> {
    @Override
    public int compare(SearchDetails o1, SearchDetails o2) {
        if(o1.win>o2.win)
            return -1;
        if(o1.win<o2.win)
            return 1;
        if(o1.lose<o2.lose)
            return -1;
        if(o1.lose>o2.lose)
            return 1;
        return 0;
    }
}
