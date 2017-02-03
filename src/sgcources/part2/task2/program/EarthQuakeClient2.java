package sgcources.part2.task2.program;

import sgcources.part2.task2.*;

import java.util.*;

public class EarthQuakeClient2 {
    public EarthQuakeClient2() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f) {

        ArrayList<QuakeEntry> answer = new ArrayList<>();
        for(QuakeEntry qe : quakeData) {
            if (f.satisfies(qe)) {
                answer.add(qe);
            }
        }
        return answer;
    } 

    public void quakesWithFilter() { 
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/part2/data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");

        List<Filter> filters = new ArrayList<>(4);
        //filters.add(new MagnitudeFilter(4, 5));
        //filters.add(new DepthFilter(-35000, -12000));
        filters.add(new DistanceFilter(new Location(35.42,139.43), 10000000, "Distance"));
        filters.add(new PhraseFilter("end", "Japan", "Phrase"));
        ArrayList<QuakeEntry> filteredList = new ArrayList<>(list);

        for (Filter f : filters) {
            filteredList = filter(filteredList, f);
        }

        for (QuakeEntry qe: filteredList) {
            System.out.println(qe);
        } 
    }

    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "../data/nov20quakedata.atom";
        String source = "data/part2/data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: "+list.size());
    }

    public void dumpCSV(ArrayList<QuakeEntry> list) {
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }
    }

    public void testMatchAllFilter() {
        ArrayList<QuakeEntry> list  = getData();
        //this is commented on purpose (according to the task)
        /*for (QuakeEntry quakeEntry : list) {
            System.out.println(quakeEntry.toString());
        }*/
        MatchAllFilter maf = new MatchAllFilter();
        maf.addFilter(
                new MagnitudeFilter(0, 2, "Magnitude")
        );
        maf.addFilter(
                new DepthFilter(-100000, -10000, "Depth")
        );
        maf.addFilter(
                new PhraseFilter("any", "a", "Phrase")
        );
        printList(filter(list, maf));
        System.out.println(maf.getName());
    }

    public void testMatchAllFilter2​() {
        ArrayList<QuakeEntry> list  = getData();
        MatchAllFilter maf = new MatchAllFilter();
        maf.addFilter(
                new MagnitudeFilter(0, 3, "Magnitude")
        );
        maf.addFilter(
                new DistanceFilter(new Location(36.1314, -95.9372), 10000000, "Distance")
        );
        maf.addFilter(
                new PhraseFilter("any", "Ca", "Phrase")
        );
        printList(filter(list, maf));
    }

    private ArrayList<QuakeEntry> getData() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/part2/data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");
        return list;
    }

    private void printList(Collection<QuakeEntry> collection) {
        for (QuakeEntry quakeEntry : collection) {
            System.out.println(quakeEntry.toString());
        }
    }
}
