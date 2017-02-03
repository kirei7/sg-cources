package sgcources.part2.task1;

import sgcources.part2.task1.program.ClosestQuakes;
import sgcources.part2.task1.program.EarthQuakeClient;

public class Test {
    public static void main(String[] args) {
        EarthQuakeClient client = new EarthQuakeClient();
        ClosestQuakes closestQuakes = new ClosestQuakes();
        LargestQuakes largestQuakes = new LargestQuakes();

        announceTest("bigQuakes Test");
        client.bigQuakes();

        announceTest("closeToMe Test");
        client.closeToMe();

        announceTest("quakesOfDepth Test");
        client.quakesOfDepth​();

        announceTest("quakesByPhrase1 Test");
        client.quakesByPhrase1();
        announceTest("quakesByPhrase2 Test");
        client.quakesByPhrase2();
        announceTest("quakesByPhrase3 Test");
        client.quakesByPhrase3();

        announceTest("findClosestQuakes Test");
        closestQuakes.findClosestQuakes();

        announceTest("findLargestQuakes Test");
        largestQuakes.findLargestQuakes​();

    }

    private static void announceTest(String testName) {
        System.out.println();
        System.out.println(testName);
    }
}
