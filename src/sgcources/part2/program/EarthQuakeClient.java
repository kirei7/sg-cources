package sgcources.part2.program;

import java.util.*;

public class EarthQuakeClient {
    public EarthQuakeClient() {
        // TODO Auto-generated constructor stub
    }

    public void dumpCSV(ArrayList<QuakeEntry> list){
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                    qe.getLocation().getLatitude(),
                    qe.getLocation().getLongitude(),
                    qe.getMagnitude(),
                    qe.getInfo());
        }

    }

    public void createCSV(){
        ArrayList<QuakeEntry> list = getData();
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
        for (QuakeEntry qe : list) {
            System.out.println(qe);
        }
    }

    public void bigQuakes() {
        ArrayList<QuakeEntry> list = getData();
        printList(filterByMagnitude(list, 5.0));
    }

    public void closeToMe(){
        ArrayList<QuakeEntry> list = getData();

        // This location is Durham, NC
        //Location city = new Location(35.988, -78.907);

        // This location is Bridgeport, CA
        Location city =  new Location(38.17, -118.82);
        ArrayList<QuakeEntry> filteredList = filterByDistanceFrom(list, 1000, city);
        for (QuakeEntry quakeEntry : filteredList) {
            System.out.println(quakeEntry.getLocation().distanceTo(city)
                    + quakeEntry.getInfo()
            );
        }
        System.out.println("Found " + filteredList.size() +" quakes that match that criteria");
    }

    public void quakesOfDepth​() {
        ArrayList<QuakeEntry> list = getData();
        printList(
                filterByDepth​(list, -10000, -5000)
        );
    }

    public void quakesByPhrase1() {
        ArrayList<QuakeEntry> list = getData();
        printList(
                filterByPhrase​(list, "end", "California")
        );
    }
    public void quakesByPhrase2() {
        ArrayList<QuakeEntry> list = getData();
        printList(
                filterByPhrase​(list, "any", "Can")
        );
    }
    public void quakesByPhrase3() {
        ArrayList<QuakeEntry> list = getData();
        printList(
                filterByPhrase​(list, "start", "Explosion")
        );
    }


    private ArrayList<QuakeEntry> filterByMagnitude(ArrayList<QuakeEntry> quakeData,
                                                    double magMin) {
        ArrayList<QuakeEntry> answer = new ArrayList<>();
        for (QuakeEntry quakeEntry : quakeData) {
            if (quakeEntry.getMagnitude() > magMin) answer.add(quakeEntry);
        }
        return answer;
    }

    private ArrayList<QuakeEntry> filterByDistanceFrom(ArrayList<QuakeEntry> quakeData,
                                                       double distMax,
                                                       Location from) {
        //not sure where conversion from km to m should be done
        //so let it be here
        distMax *= 1000;
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for (QuakeEntry quakeEntry : quakeData) {
            if (quakeEntry.getLocation().distanceTo(from) < distMax)
                answer.add(quakeEntry);
        }
        return answer;
    }

    private ArrayList<QuakeEntry> filterByDepth​(ArrayList<QuakeEntry> quakeData, double minDepth, double maxDepth) {
        ArrayList<QuakeEntry> resultList = new ArrayList<>();
        for (QuakeEntry entry : quakeData) {
            double depth = entry.getDepth();
            if (depth > minDepth && depth < maxDepth)
                resultList.add(entry);
        }
        return resultList;
    }

    private ArrayList<QuakeEntry> filterByPhrase​(
            ArrayList<QuakeEntry> quakeData,
            String where,
            String phrase
    ) {
        if (where == null) throw new NullPointerException();
        ArrayList<QuakeEntry> resultList = new ArrayList<>();

        switch (where) {
            case "start":
                for (QuakeEntry entry : quakeData) {
                    if (entry.getInfo().startsWith(phrase))
                        resultList.add(entry);
                }
                break;
            case "end":
                for (QuakeEntry entry : quakeData) {
                    if (entry.getInfo().endsWith(phrase))
                        resultList.add(entry);
                }
                break;
            case "any":
                for (QuakeEntry entry : quakeData) {
                    if (entry.getInfo().contains(phrase))
                        resultList.add(entry);
                }
                break;
            default:
                throw new IllegalArgumentException("Only 'start', 'end', 'any' values allowed");
        }
        return resultList;
    }

    private ArrayList<QuakeEntry> getData() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");
        return list;
    }

    private void printList(ArrayList<QuakeEntry> list) {
        for (QuakeEntry quakeEntry : list) {
            System.out.println(quakeEntry.toString());
        }
        System.out.println("Found " + list.size() +" quakes that match that criteria");
    }
}
