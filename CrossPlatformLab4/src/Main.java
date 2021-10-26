public class Main {

    public static void main(String[] args) {
        System.out.println(ex1("Andriy Andrian Kyrylo Max Nazar Alina Olga Oleg Konduk Nestor"));
        System.out.println(ex2("Програма"));
    }


    public static String ex1(String str) {

        String[] array = str.split(" ");
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int index = 0;
                while(array[i].length() > index && array[j].length() > index) {
                    int n1 = array[i].charAt(index);
                    int n2 = array[j].charAt(index);
                    if (n1 > n2) {
                        String temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    } else if (array[i].charAt(index) == array[j].charAt(index)) {
                        index++;
                    } else {
                        index = 0;
                        break;
                    }
                }

                if (index >= array[i].length() || index >= array[j].length()) {
                    if (array[i].length() > array[j].length()) {
                        String temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    }
                }
            }
        }
        String result = "";
        for (String string: array) {
            result += string + " ";
        }
        return result;
    }


    public static String ex2(String str ) {
        String part1 = "";
        String part2 = "";

        for (int i = 0 ; i < str.length(); i++) {

            if (i % 2 == 0) part2 = str.charAt(i) + part2;
            else part1 += str.charAt(i);
        }
        return part1 + part2;
    }
}
