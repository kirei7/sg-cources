package sgcources.part2.task2;

import sgcources.part2.task2.program.EarthQuakeClient2;

public class Test extends sgcources.part2.task1.Test{
    public static void main(String[] args) {
        EarthQuakeClient2 client = new EarthQuakeClient2();

        announceTest("quakesWithFilter Test");
        client.quakesWithFilter();

        announceTest("testMatchAllFilter Test");
        client.testMatchAllFilter();
        announceTest("testMatchAllFilter2 Test");
        client.testMatchAllFilter2​();


    }
}
