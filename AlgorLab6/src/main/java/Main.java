public class Main {

    public static void main(String[] args) {

        String text = "Kyrylo Maltsev";
        int[] code = RSA.code(text, 139, 311, 139);
        for (int num : code) {
            System.out.print(num + " ");
        }
        System.out.println();

        String decode = RSA.decode(code, 139, 311, 139);
        System.out.println(decode);

    }
}
