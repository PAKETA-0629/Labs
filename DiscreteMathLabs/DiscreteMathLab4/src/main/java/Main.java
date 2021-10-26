import java.util.Arrays;

public class Main {


    public static void main(String[] args) {

        int[] encode = Hamming.encode(new int[]{1, 0, 1, 0, 1, 0, 1, 0});
        System.out.println(Arrays.toString(encode));
        Hamming.receive(encode, 4);
    }
}
