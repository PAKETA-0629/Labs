import org.junit.Test;

public class HammingTest {
    @Test
    public void test() {

        int[] encode = Hamming.encode(new int[]{1, 1, 1, 1, 0, 0, 0, 0});
        Hamming.receive(encode, 4);
    }

    @Test
    public void test1() {


    }
}
