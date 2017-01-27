package sgcources.task1;

import sgcources.TestNotPassedException;

public class TestWordPlay {
    WordPlay wordPlay = new WordPlay();

    public static void main(String[] args) {
        TestWordPlay test = new TestWordPlay();
        test.isVowelTest();
        test.replaceVowelsTest();
        test.emphasizeTest();
        System.out.println("All tests passed");
    }

    private void isVowelTest() {
        if (wordPlay.isVowel('F')) throw new TestNotPassedException();
        if (!wordPlay.isVowel('a')) throw new TestNotPassedException();
        if (!wordPlay.isVowel('A')) throw new TestNotPassedException();
    }
    private void replaceVowelsTest() {
        String origin = "Hello world";
        String verificationString = "H*ll* w*rld";
        char ch = '*';
        
        String replaced =  wordPlay.replaceVowels(origin, ch);
        if (!replaced.equals(verificationString)) throw new TestNotPassedException(
                            "String should be: [" + verificationString +
                            "] Given: [" + replaced + ']'
        );
    }

    private void emphasizeTest() {
        String origin = "Mary Bella Abracadabra";
        String verificationString = "M+ry Bell+ +br*c*d*br+";

        String replaced =  wordPlay.emphasize(origin, 'a');
        if (!replaced.equals(verificationString)) throw new TestNotPassedException(
                "String should be: [" + verificationString +
                        "] Given: [" + replaced + ']'
        );
    }

}
