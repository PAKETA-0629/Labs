public class Main2 {

    public static void main(String[] args) {
        String word = "Kyrylo Maltsev";
        Hofmann hf = new Hofmann();
        String result = hf.code(word);
        String decode = hf.decode(result);
        System.out.println("""
                ____________
                Hofmann code
                ------------""");
        System.out.println("\n" + "Word:\t" + word + "\n" + "Code:\t" + result + "\n" + "Decode:\t" + decode);
    }
}
