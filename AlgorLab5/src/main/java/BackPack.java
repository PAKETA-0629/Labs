import java.util.Arrays;

public class BackPack {

    static int mod;
    static int k;

    public static int[] code(String text, int[] bag) {

        String[] binaryText = new String[text.length()];

        for (int i = 0; i < text.length(); i++) {
            String binary = Integer.toBinaryString(text.charAt(i));
            if (binary.length() < 8) {

                while (binary.length() != 8) {
                    binary = "0" + binary;
                }
            } else if (binary.length() % 8 != 0) {

                while (binary.length() % 8 != 0) {
                    binary = "0" + binary;
                }
            }
            binaryText[i] = binary;

        }

        int sum = Arrays.stream(bag).sum();
        mod = sum + 1;
        k = 7;

        int[] extendedBag = new int[bag.length];
        for (int i = 0; i < extendedBag.length; i++) {
            extendedBag[i] = (bag[i] * k) % mod;
        }

        int[] result = new int[text.length()];

        for (int i = 0; i < binaryText.length; i++) {
            for (int j = 0; j < binaryText[i].length(); j++) {
                if (binaryText[i].charAt(j) == '1') result[i] += extendedBag[j];
            }
        }

        return result;
    }


    public static String decode(int[] ciphertext, int[] bag) {

        int cof = extended_gcd(mod, k)[2];

        int[] temp = new int[ciphertext.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = (ciphertext[i] * cof) % mod;
        }

        StringBuilder result = new StringBuilder();

        String text = "";

        for (int elem : temp) {
            int index = bag.length - 1;
            while (index >= 0) {
                if (bag[index] <= elem) {
                    result.append("1");
                    elem -= bag[index];
                }
                else result.append("0");
                index--;
            }
            int abc = Integer.parseInt(result.reverse().toString(), 2);
            text += (char) abc;
            result = new StringBuilder();
        }

        return text;
    }


    protected static int[] extended_gcd(int a, int b) {
        int[] res = new int[3];
        if (b == 0)
        {
            res[0] = a; res[1] = 1; res[2] = 0;
            return res;
        }
        res = extended_gcd(b,a % b);
        int s = res[2];
        res[2] = res[1] - (a / b) * res[2];
        res[1] = s;
        while(res[2] < 0) {
            res[2] += mod;
        }
        return res;

    }

}
