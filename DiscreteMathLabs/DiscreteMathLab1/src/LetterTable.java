public class LetterTable {


    private final char[] letters;
    private final int[] values;


    LetterTable(String str) {
        this.letters = countLetters(str);
        this.values = countValues(str);
        sortByValues();
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


    public int[] getValues() {
        return values;
    }


    private void sortByValues() {
        for (int i = 0; i < values.length; i++) {
            int max = values[i];
            char maxLetter = letters[i];
            int maxId = i;
            int maxLetterId = i;
            for (int j = i + 1; j < values.length; j++) {
                if (values[j] > max) {
                    max = values[j];
                    maxLetter = letters[j];
                    maxId = j;
                    maxLetterId = j;
                }
            }

            int temp1 = values[i];
            values[i] = max;
            values[maxId] = temp1;

            char temp2 = letters[i];
            letters[i] = maxLetter;
            letters[maxLetterId] = temp2;
        }
    }


    private int[] countValues(String str) {
        char[] chArray = this.letters;
        int[] numArray = new int[chArray.length];

        for (int i = 0; i<chArray.length; i++) {
            int count = 0;
            for (int j = 0; j<str.length(); j++) {
                if (str.charAt(j)==chArray[i]) count++;
            }
            numArray[i] = count;
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
