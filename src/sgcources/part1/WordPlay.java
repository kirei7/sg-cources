package sgcources.part1;

public class WordPlay {

    private final String VOWELS = "AEIOU";

    public boolean isVowel(Character ch) {
        ch = Character.toUpperCase(ch);
        return  (VOWELS.indexOf(ch) >= 0);
    }

    public String replaceVowels(String phrase, Character ch) {
        char[] charArray = phrase.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            if (isVowel(charArray[i]))
                sb.append(ch);
            else
                sb.append(charArray[i]);
        }
        return sb.toString();
    }

    public String emphasize(String phrase, Character ch) {
        char[] charArray = phrase.toCharArray();
        ch = Character.toUpperCase(ch);
        for (int i = 0; i < charArray.length; i++) {
            if (Character.toUpperCase(charArray[i]) == ch) {
                if(i % 2 == 0)
                    charArray[i] = '*';
                else
                    charArray[i] = '+';
            }
        }
        return new String(charArray);
    }
}
