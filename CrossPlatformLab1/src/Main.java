public class Main {

    public static void main(String[] args) {
        int num = 2;
        int value = 6;
        int result1 = meth(num, value);
        System.out.println(result1);
        char[] array = {'H', 'e', 'l', 'l', 'o'};
        String result2 = charArrayToString(array);
        System.out.println(result2.getClass().getName() + " " + result2);
        int n1 = 4, n2 = 4;
        boolean result3 = equals(n1, n2);
        System.out.println(result3);
        System.out.println(sum(1, 2, 3, 10, 37, 100));
    }


    private static int meth(int num, int value) {

        return num << value;

    }


    private static String charArrayToString(char[] array) {

        String result = "";
        for (char ch: array) {
            result += ch;
        }

        return result;

    }


    private static boolean equals(int n1, int n2) {

        return n1 == n2;
    }


    private static int sum(int ... nums) {
        int result = 0;

        for (int num : nums) {
            result+=num;
        }
        return result;
    }

}
