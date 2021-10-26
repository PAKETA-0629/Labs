public class Main {

    public static void main(String[] args) {

        String text = "Kyrylo";
        int[] bag = {9, 14, 25, 49, 100, 199, 400, 1000};

        int[] result = BackPack.code(text, bag);
        System.out.print("Code:\t");
        for (int num : result) System.out.print(num + " ");

        String decode = BackPack.decode(result, bag);
        System.out.println("\nText:\t" + decode);

    }
}
