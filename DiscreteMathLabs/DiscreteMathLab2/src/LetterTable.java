import java.math.BigDecimal;
import java.math.RoundingMode;

public class LetterTable {


    private final char[] letters;
    private final BigDecimal[] values;


    LetterTable(String str) {
        this.letters = countLetters(str);
        this.values = countValues(str);
    }


    public void printTable() {
        for (int i = 0; i < letters.length; i++) {
            System.out.print(letters[i] + " " + values[i]);
            System.out.println();
        }
        System.out.println();

    }


    public char[] getLetters() {
        return letters;
    }


    public BigDecimal[] getValues() {
        return values;
    }



    private BigDecimal[] countValues(String str) {
        char[] chArray = this.letters;
        BigDecimal[] numArray = new BigDecimal[chArray.length];

        for (int i = 0; i<chArray.length; i++) {
            BigDecimal count = new BigDecimal(0);
            for (int j = 0; j<str.length(); j++) {
                if (str.charAt(j)==chArray[i]) count = count.add(new BigDecimal(1));
            }
            numArray[i] = count.divide(new BigDecimal(str.length()), 2, RoundingMode.HALF_UP);
        }
        return numArray;
    }


    private static char[] countLetters(String str) {
        String letters = "";

        for (int i = 0; i<str.length(); i++) {
            if (!letters.contains(String.valueOf(str.charAt(i)))) letters += str.charAt(i);
        }

        return letters.toCharArray();

    }
}
