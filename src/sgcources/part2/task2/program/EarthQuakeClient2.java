package sgcources.part2.task2.program;

import sgcources.part2.task2.DepthFilter;
import sgcources.part2.task2.DistanceFilter;
import sgcources.part2.task2.MagnitudeFilter;
import sgcources.part2.task2.PhraseFilter;

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
        filters.add(new DistanceFilter(new Location(35.42,139.43), 10000000));
        filters.add(new PhraseFilter("end", "Japan"));
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

}
