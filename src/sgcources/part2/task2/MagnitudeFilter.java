package sgcources.part2.task2;


import sgcources.part2.task2.program.Filter;
import sgcources.part2.task2.program.QuakeEntry;

public class MagnitudeFilter implements Filter {

    private final double minMag;
    private final double maxMag;

    public MagnitudeFilter(double minMag, double maxMag) {
        this.minMag = minMag;
        this.maxMag = maxMag;
    }
    public double getMaxMag() {
        return maxMag;
    }
    public double getMinMag() {
        return minMag;
    }

    @Override
    public boolean satisfies(QuakeEntry qe) {
        double magnitude = qe.getMagnitude();
        return (magnitude >= getMinMag() && magnitude <= getMaxMag() );
    }
}
