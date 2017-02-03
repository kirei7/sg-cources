package sgcources.part2.task2;

import sgcources.part2.task2.program.Filter;
import sgcources.part2.task2.program.Location;
import sgcources.part2.task2.program.QuakeEntry;

public class DistanceFilter implements Filter {

    private final Location location;
    private final double maxDistance;

    public DistanceFilter(Location location, double maxDistance) {
        this.location = location;
        this.maxDistance = maxDistance;
    }
    public Location getLocation() {
        return location;
    }
    public double getMaxDistance() {
        return maxDistance;
    }

    @Override
    public boolean satisfies(QuakeEntry qe) {
        return qe.getLocation().distanceTo(getLocation()) < getMaxDistance();
    }
}
