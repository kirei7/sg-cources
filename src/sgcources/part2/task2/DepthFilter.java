package sgcources.part2.task2;

import sgcources.part2.task2.program.Filter;
import sgcources.part2.task2.program.QuakeEntry;

public class DepthFilter implements Filter {

    private final double minDepth;
    private final double maxDepth;
    //this field has to be moved to an abstract class
    private final String name;
    @Override
    public String getName() {
        return name;
    }

    public DepthFilter(double minDepth, double maxDepth, String name) {
        this.minDepth = minDepth;
        this.maxDepth = maxDepth;
        this.name = name;
    }
    public double getMaxDepth() {
        return maxDepth;
    }
    public double getMinDepth() {
        return minDepth;
    }

    @Override
    public boolean satisfies(QuakeEntry qe) {
        double depth = qe.getDepth();
        return (depth >= getMinDepth() && depth <= getMaxDepth() );
    }


}
