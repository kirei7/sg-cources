package sgcources.part2.task2;

import sgcources.part2.task2.program.Filter;
import sgcources.part2.task2.program.QuakeEntry;

import java.util.ArrayList;
import java.util.StringJoiner;

public class MatchAllFilter implements Filter {

    private ArrayList<Filter> filters;

    public MatchAllFilter() {
        filters = new ArrayList<>();
    }

    public void addFilter(Filter filter) {
        filters.add(filter);
    }
    @Override
    public boolean satisfies(QuakeEntry qe) {
        for (Filter filter : filters) {
            if (!filter.satisfies(qe))
                return false;
        }
        return true;
    }

    @Override
    public String getName() {
        StringJoiner sj = new StringJoiner(" ");
        sj.add("Filters used are:");
        for (Filter filter : filters) {
            sj.add(filter.getName());

        }
        return sj.toString();
    }
}
