
public class Main {
    public static void main(String[] args) {

        String word = "Kyrylo Maltsev";
        ShannonFano shannonFano = new ShannonFano();
        String result = shannonFano.code(word);
        String decode = shannonFano.decode(result);
        System.out.println("""
                ___________
                ShannonFano
                -----------""");
        System.out.println("\n" + "Word:\t" + word + "\n" + "Code:\t" + result + "\n" + "Decode:\t" + decode);

    }
}
