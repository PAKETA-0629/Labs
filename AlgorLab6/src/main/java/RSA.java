public class RSA {

    static int mod;
    static String binaryE;
    static int euler;


    protected static int[] code(String text, int p, int q, int e) {

        mod = p * q;
        euler = (p - 1) * (q - 1);
        binaryE = Integer.toBinaryString(e);
        int[] result = new int[text.length()];

        for (int i = 0; i < text.length(); i++) {

            int m = text.charAt(i);
            result[i] = binaryExponentiation(m);

        }
        return result;
    }


    protected static String decode(int[] c, int p, int q, int e) {

        int d = extended_gcd(euler, e)[2] % euler;
        binaryE = Integer.toBinaryString(d);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < c.length; i++) {
            int m = c[i];
            result.append( (char) binaryExponentiation(m));
        }
        return result.toString();

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
        while (res[2] < 0) {
            res[2] += euler;
        }
        return res;

    }


    protected static int binaryExponentiation(int m) {

        int z = 1;
        for (int i = 0; i < binaryE.length(); i++) {
            z = (z * z) % mod;
            if (binaryE.charAt(i) == '1') z *= m;
            z %= mod;
        }
        return z;
    }
}
