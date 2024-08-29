public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Main <text>");
            return;
        }

        String inputText = args[0];

        if (inputText.chars().allMatch(c -> c == 'O' || c == '.')) {
            System.out.println(BrailleTranslator.translateToEnglish(inputText));
        } else {
            System.out.println(BrailleTranslator.translateToBraille(inputText));
        }
    }
}
