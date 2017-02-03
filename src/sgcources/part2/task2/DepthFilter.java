package sgcources.part2.task2;

import sgcources.part2.task2.program.Filter;
import sgcources.part2.task2.program.QuakeEntry;

public class DepthFilter implements Filter {

    private final double minDepth;
    private final double maxDepth;

    public DepthFilter(double minDepth, double maxDepth) {
        this.minDepth = minDepth;
        this.maxDepth = maxDepth;
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
