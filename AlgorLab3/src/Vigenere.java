class Vigenere {


    public static char[] encrypt(String[] key, char[] text) {

        for (String s : key) {

            for (int i = 0; i < text.length; i++) {

                text[i] = (char) ((text[i] + s.charAt(i % s.length())) % 2048);
            }
        }

        return text;
    }


    public static char[] decipher(String[] key, char[] code) {

        for (String s : key) {

            for (int i = 0; i < code.length; i++) {

                code[i] = (char) ((code[i] - s.charAt(i % s.length()) + 2048) % 2048);
            }
        }

        return code;
    }
}