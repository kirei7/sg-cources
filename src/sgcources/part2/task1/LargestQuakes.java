package sgcources.part2.task1;

import sgcources.part2.task1.program.EarthQuakeParser;
import sgcources.part2.task1.program.QuakeEntry;

import java.util.*;

public class LargestQuakes {

    public void findLargestQuakes​() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);

        System.out.println("read data for "+list.size()+" quakes");

        System.out.println("Index of largest: " + indexOfLargest​(list));

        for (QuakeEntry quakeEntry : getLargest(list, 5 )) {
            System.out.println(quakeEntry.toString());
        }

    }

    public int indexOfLargest​(ArrayList<QuakeEntry> data) {
        double maxSize = data.get(0).getMagnitude();
        int maxNum = 0;
        for (int i = 1; i < data.size(); i++) {
            double current = data.get(i).getMagnitude();
            if (current > maxSize) {
                maxSize = current;
                maxNum = i;
            }
        }
        return maxNum;
    }

    public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData, int howMany) {
        int size = quakeData.size() < howMany ? quakeData.size() : howMany;
        ArrayList<QuakeEntry> largest = new ArrayList<>(size);
        // probably there should be a LinkedList instance, but since indexOfLargest()
        // function's parameter is an ArrayList type it's ArrayList too
        ArrayList<QuakeEntry> temp = new ArrayList<>(quakeData);

        for (int i = 0; i < size; i++) {
            int index = indexOfLargest​(temp);
            largest.add(
                    temp.get(index)
            );
            temp.remove(index);
        }

        return largest;
    }
}
