package sgcources.task1;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class CaesarCipher {
    private final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String encrypt(String input, int key) {
        if (key < 0) throw new IllegalArgumentException("Key must be a non-negative integer");
        char[] shifted = (ALPHABET.substring(key) + ALPHABET.substring(0, key)).toCharArray();

        char[] result = new char[input.length()];
        char[] inputArray = input.toCharArray();
        for (int i = 0; i < input.length(); i++) {
            char ch = inputArray[i];
            int index = ALPHABET.indexOf(ch);
            if (index < 0) {
                index = ALPHABET.toLowerCase().indexOf(ch);
                if(index > -1) result[i] = Character.toLowerCase(shifted[index]);
                else result[i] = ch;
            }
            else result[i] = shifted[index];
        }
        return new String(result);
    }
    public String encryptTwoKeys(String input, int key1, int key2) {
        char[] inputArray = input.toCharArray();
        StringBuilder oddBuilder = new StringBuilder(),
                evenBuilder = new StringBuilder();
        for (int i = 0; i < inputArray.length; i++) {
            if (i % 2 == 0) oddBuilder.append(inputArray[i]);
            else evenBuilder.append(inputArray[i]);
        }
        char[] oddEncrypted = encrypt(oddBuilder.toString(), key1).toCharArray();
        char[] evenEncrypted = encrypt(evenBuilder.toString(), key2).toCharArray();

        StringBuilder resultBuilder = new StringBuilder();
        for(int i = 0, j = 0; true; ) {
            if (i >= oddEncrypted.length) break;
            resultBuilder.append(oddEncrypted[i]);
            i++;
            if (j >= evenEncrypted.length) break;
            resultBuilder.append(evenEncrypted[j]);
            j++;
        }
        return resultBuilder.toString();
    }

    public static void testCaesar() {
        CaesarCipher encrypter = new CaesarCipher();
        int key = 17;
        try {
            File in = new File("task1_in.txt");
            File out = new File("task1_out.txt");
            BufferedReader reader
                    = new BufferedReader(new InputStreamReader(new FileInputStream(in)));
            BufferedWriter writer
                    = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(out)));
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(encrypter.encrypt(line, key));
                writer.newLine();
            }
            writer.flush();
            reader.close();
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println(encrypter.encryptTwoKeys("First Legion", 23, 17));
    }
    public static void main(String[] args) {
        testCaesar();
    }
}
