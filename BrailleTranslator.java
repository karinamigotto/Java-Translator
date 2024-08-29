import java.util.HashMap;
import java.util.Map;

public class BrailleTranslator {

    // Define Braille mappings
    private static final Map<Character, String> brailleMap = new HashMap<>();
    private static final Map<String, Character> inverseBrailleMap = new HashMap<>();

    static {
        // Initialize Braille mappings for lowercase letters
        brailleMap.put('a', "O.....");
        brailleMap.put('b', "O.O...");
        brailleMap.put('c', "OO....");
        brailleMap.put('d', "OO.O..");
        brailleMap.put('e', "O.OO..");
        brailleMap.put('f', "OOO...");
        brailleMap.put('g', "OOOO..");
        brailleMap.put('h', "O.OO..");
        brailleMap.put('i', ".OO...");
        brailleMap.put('j', ".OOO..");
        brailleMap.put('k', "O...O.");
        brailleMap.put('l', "O.O.O.");
        brailleMap.put('m', "OO..O.");
        brailleMap.put('n', "OO.OO.");
        brailleMap.put('o', "O.O.O.");
        brailleMap.put('p', "OOO.O.");
        brailleMap.put('q', "OOOOO.");
        brailleMap.put('r', "O.OOO.");
        brailleMap.put('s', ".OO.O.");
        brailleMap.put('t', ".OOOO.");
        brailleMap.put('u', "O...OO");
        brailleMap.put('v', "O.O.OO");
        brailleMap.put('w', ".OOO..");
        brailleMap.put('x', "OO..OO");
        brailleMap.put('y', "OO.OOO");
        brailleMap.put('z', "O.O.OO");

        // Initialize inverse Braille mappings
        for (Map.Entry<Character, String> entry : brailleMap.entrySet()) {
            inverseBrailleMap.put(entry.getValue(), entry.getKey());
        }

        // Add mappings for space and numbers
        brailleMap.put(' ', "......");
        brailleMap.put('0', ".OOOO.");
        brailleMap.put('1', "O.....");
        brailleMap.put('2', "O.O...");
        brailleMap.put('3', "OO....");
        brailleMap.put('4', "OO.O..");
        brailleMap.put('5', "O.OO..");
        brailleMap.put('6', "OOO...");
        brailleMap.put('7', "OOOO..");
        brailleMap.put('8', "O.OO..");
        brailleMap.put('9', ".OO...");

        for (Map.Entry<Character, String> entry : brailleMap.entrySet()) {
            inverseBrailleMap.put(entry.getValue(), entry.getKey());
        }
    }

    public static String translateToBraille(String text) {
        StringBuilder brailleText = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isUpperCase(c)) {
                brailleText.append(".....O").append(brailleMap.get(Character.toLowerCase(c)));
            } else {
                brailleText.append(brailleMap.getOrDefault(c, "......"));
            }
        }
        return brailleText.toString();
    }

    public static String translateToEnglish(String brailleText) {
        StringBuilder englishText = new StringBuilder();
        int i = 0;
        while (i < brailleText.length()) {
            String brailleChar = brailleText.substring(i, Math.min(i + 6, brailleText.length()));
            if (brailleChar.equals(".....O")) {
                englishText.append(Character.toUpperCase(inverseBrailleMap.get(brailleText.substring(i + 6, i + 12))));
                i += 12;
            } else {
                englishText.append(inverseBrailleMap.getOrDefault(brailleChar, '?'));
                i += 6;
            }
        }
        return englishText.toString();
    }
}
