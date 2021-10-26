class Playfair {


    public static String encrypt(String key, String text, boolean encrypt) {

        char[][] matrix = fillMatrix(key);
        String result = "";
        if (text.length() % 2 != 0) text += "Z";

        for (int i = 0; i < text.length(); i += 2) {

            int[] ch1Cor = new int[2];
            int[] ch2Cor = new int[2];

            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {

                    if (matrix[j][k] == text.charAt(i)) {
                        ch2Cor[0] = j;
                        ch1Cor[1] = k;
                    } else if (matrix[j][k] == text.charAt(i + 1)) {
                        ch1Cor[0] = j;
                        ch2Cor[1] = k;
                    }
                }
            }

            if (encrypt) {
                if (ch1Cor[1] == ch2Cor[1]) {
                    int temp = ch1Cor[0];
                    ch1Cor[0] = ch2Cor[0];
                    ch2Cor[0] = temp;
                    ch1Cor[0] = (ch1Cor[0] + 1) % 5;
                    ch2Cor[0] = (ch2Cor[0] + 1) % 5;
                } else if (ch1Cor[0] == ch2Cor[0]) {
                    ch1Cor[1] = (ch1Cor[1] + 1) % 5;
                    ch2Cor[1] = (ch2Cor[1] + 1) % 5;
                }
            } else {
                if (ch1Cor[1] == ch2Cor[1]) {
                    int temp = ch1Cor[0];
                    ch1Cor[0] = ch2Cor[0];
                    ch2Cor[0] = temp;
                    ch1Cor[0] = (ch1Cor[0] - 1 + 5) % 5;
                    ch2Cor[0] = (ch2Cor[0] - 1 + 5) % 5;
                } else if (ch1Cor[0] == ch2Cor[0]) {
                    ch1Cor[1] = (ch1Cor[1] - 1 + 5) % 5;
                    ch2Cor[1] = (ch2Cor[1] - 1 + 5) % 5;
                }
            }
            result += (matrix[ch1Cor[0]][ch1Cor[1]] + "" + matrix[ch2Cor[0]][ch2Cor[1]]);

        }
        return result;
    }

    private static char[][] fillMatrix(String key) {

        char[][] matrix = new char[5][5];
        int counter = 0;
        char utf8Start = 97;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {

                if (counter < key.length()) matrix[i][j] = key.charAt(counter++);
                else {
                    if (utf8Start == 106) {
                        utf8Start++;
                    }
                    if (!key.contains(String.valueOf(utf8Start))) {
                        matrix[i][j] = utf8Start;
                    } else {
                        j--;
                    }
                    utf8Start++;
                }
            }
        }

        return matrix;
    }
}