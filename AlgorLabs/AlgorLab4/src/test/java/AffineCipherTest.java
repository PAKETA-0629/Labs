import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class AffineCipherTest {

    @Test
    public void determinateTest() {

        int[][] k = {
                {2, 3, 5},
                {7, 11, 13},
                {17, 19, 23}
        };

        int[] s = {3, 5, 7};
        String text = "Alina";
        String encode = AffineCipher.code(k, s, text);
        String decode = AffineCipher.decode(k, s, encode);
        System.out.println(encode + "\n" + decode);
        }

    @Test
    public void transposeTest() {

        int[][] actual = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] expected = {
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9}
        };

        assertArrayEquals(expected, AffineCipher.transposedMatrix(actual));
    }

    @Test
    public void multiplyTest() {
        int[][] K = {
                {-17, -22},
                {-6, -29}
        };

        int[] S = {1, 5};


        int[][] KK = {
                {1, 2},
                {3, 4}
        };

        int[] SS = {16, 11};

        int[] result2 = AffineCipher.multiplyMatrixOnArray(KK, SS);
        int[] result = AffineCipher.multiplyMatrixOnArray(K, S);
        assertArrayEquals(new int[]{1, 18}, result2);
        assertArrayEquals(new int[]{21, 34}, result);


    }

    @Test
    public void addTest() {
        assertArrayEquals(new int[]{20, 30}, AffineCipher.addArrays(new int[]{15, 26}, new int[]{5, 4}));
        assertArrayEquals(new int[]{15, 17}, AffineCipher.addArrays(new int[]{14, 12}, new int[]{1, 5}));
    }

    @Test
    public void minorBuilderTest() {

        int[][] matrix1 = {
                {1, 3, 0},
                {3, 2, 4},
                {6, 1, 3}
        };

        int[][] minor11 = {
            {2, 4},
            {1, 3}
        };

        int[][] minor12 = {
                {3, 4},
                {6, 3}
        };

        int[][] minor13 = {
                {3, 2},
                {6, 1}
        };

        int[][] matrix2 = {
                {1, 2},
                {3, 4}
        };
        int[][] K = {
                {1, 2, 9, 4, 5, 6, 7},
                {6, 5, 8, 9, 10, 7, 8},
                {11, 12, 13, 14, 15, 8, 9},
                {16, 17, 20, 19 ,20, 9, 10},
                {21, 22, 23, 24, 111, 10, 11},
                {228, 113, 9, 115, 33, 117, 12},
                {572, 1, 6, 7, 1, 7, 8}
        };

        int[][] expected = {
                {5, 8, 9, 10, 7, 8},
                {12, 13, 14, 15, 8, 9},
                {17, 20, 19 ,20, 9, 10},
                {22, 23, 24, 111, 10, 11},
                {113, 9, 115, 33, 117, 12},
                {1, 6, 7, 1, 7, 8}
        };

        assertArrayEquals(expected, AffineCipher.buildMinor(K, 0, 0));
        assertArrayEquals(minor11, AffineCipher.buildMinor(matrix1, 0, 0));
        assertArrayEquals(minor12, AffineCipher.buildMinor(matrix1, 0, 1));
        assertArrayEquals(minor13, AffineCipher.buildMinor(matrix1, 0, 2));

    }
}
