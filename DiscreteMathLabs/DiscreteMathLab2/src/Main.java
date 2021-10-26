import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        String text = "Садок вишневий коло хати";

        ArithmeticCoding arithmeticCoding = new ArithmeticCoding();
        BigDecimal code = arithmeticCoding.code(text).stripTrailingZeros();

        System.out.println("Code: \t\t\t" + code);

        String result = arithmeticCoding.decode(code);

        System.out.println("Decode text: \t" + result);
    }

}
