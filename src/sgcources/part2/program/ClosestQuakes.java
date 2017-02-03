package sgcources.part2.program;
/**
 * Find N-closest quakes
 * 
 * @author Duke Software/Learn to Program
 * @version 1.0, November 2015
 */

import java.util.*;

public class ClosestQuakes {
    public ArrayList<QuakeEntry> getClosest(ArrayList<QuakeEntry> quakeData, Location current, int howMany) {
        int size = quakeData.size() < howMany ? quakeData.size() : howMany;
        ArrayList<QuakeEntry> ret = new ArrayList<>(size);
        List<Entry> sortedList = sortByDistance(quakeData, current);
        for (int i = 0; i < howMany; i++) {
            ret.add(sortedList.get(i).getQuakeEntry());
        }
        return ret;
    }

    public void findClosestQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size());

        Location jakarta  = new Location(-6.211,106.845);

        ArrayList<QuakeEntry> close = getClosest(list,jakarta,3);
        for(int k=0; k < close.size(); k++){
            QuakeEntry entry = close.get(k);
            double distanceInMeters = jakarta.distanceTo(entry.getLocation());
            System.out.printf("%4.2f\t %s\n", distanceInMeters/1000,entry);
        }
        System.out.println("number found: "+close.size());
    }


    private List<Entry> sortByDistance(
            ArrayList<QuakeEntry> quakeData,
            Location current
    ) {
        List<Entry> sortedList = new ArrayList<>(quakeData.size());
        for (QuakeEntry quakeEntry : quakeData) {
            sortedList.add(new Entry(
                    quakeEntry,
                    quakeEntry.getLocation().distanceTo(current)
            ));
        }
        Collections.sort(sortedList, (o1, o2) -> o1.getDistance().compareTo(o2.getDistance()));
        return sortedList;
    }

    private static class Entry {
        private QuakeEntry quakeEntry;
        private Float distance;
        Entry(QuakeEntry quakeEntry, Float distanceTo) {
            this.quakeEntry = quakeEntry;
            this.distance = distanceTo;
        }
        public QuakeEntry getQuakeEntry() {
            return quakeEntry;
        }
        public Float getDistance() {
            return distance;
        }
    }

}
