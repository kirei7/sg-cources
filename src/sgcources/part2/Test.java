package sgcources.part2;

import sgcources.part2.program.EarthQuakeClient;

public class Test {
    public static void main(String[] args) {
        EarthQuakeClient client = new EarthQuakeClient();

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

    }

    private static void announceTest(String testName) {
        System.out.println();
        System.out.println(testName);
    }
}
