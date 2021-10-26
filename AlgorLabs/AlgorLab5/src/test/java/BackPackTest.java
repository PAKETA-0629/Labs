import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;



public class BackPackTest {

    @Test
    public void test1() {
        String text = "Kyrylo";
        int[] bag = {9, 14, 25, 49, 100, 199, 400, 1000};

        int[] result = BackPack.code(text, bag);

        String decode = BackPack.decode(result, bag);
        System.out.println(decode);

    }
}
