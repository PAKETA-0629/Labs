public class Main {


    public static void main(String[] args) {

        String[] key = new String[]{"key", "crypto"};
        String code = new String(Vigenere.encrypt(key, "Кирило Текст Лаба".toCharArray()));
        String result = new String(Vigenere.decipher(key, code.toCharArray()));

        System.out.println("Text: ciphertext" + "\n" + "Key: key, crypto");
        System.out.println("Code: " + code + "\n" + "Decode: " + result + "\n");

        String result2 = Playfair.encrypt("crypto", "ciphertext", true);
        String text2 = Playfair.encrypt("crypto", result2, false);
        System.out.println("Text: ciphertext" + "\n" + "Key: crypto");
        System.out.println("Code: " + result2 + "\n" + "Decode: " + text2);

    }
}