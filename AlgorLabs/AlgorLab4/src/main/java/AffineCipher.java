
public class AffineCipher {

    protected static String alphabet = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя _!?";
    protected static int mod = alphabet.length();


    public static String code(int[][] K, int[] S, String text) {

        K = modMatrix(K);
        S = modArray(S);

        long determinant = findDeterminant(K);
        System.out.println(determinant);

        if (checkSimpleNumbers(determinant, mod) != 1 || determinant == 1) {
            System.out.println("ERROR: Determinant and mod should be mutually prime numbers");
            System.out.println(determinant + " " + mod);
            return text;
        }

        if (K.length != K[0].length) {
            System.out.println("ERROR: the matrix K must be square");
            return text;
        } else if (K.length != S.length) {
            System.out.println("ERROR: the matrix S must have same length of column as matrix K");
            return text;
        }

        if (text.length() % K.length != 0) {
            for (int i = 0; i < text.length() % K.length; i++) {
                text += " ";
            }
        }


        int[] letterValue = new int[text.length()];

        for (int i = 0; i < text.length(); i+= S.length) {
            int[] X = new int[S.length];
            for (int j = 0; j < S.length; j++) {
                X[j] = alphabet.indexOf(text.charAt(i+j));
            }
            int[] AX = multiplyMatrixOnArray(K, X);
            int[] res = addArrays(AX, S);
            System.arraycopy(res, 0, letterValue, i, X.length);
        }

        String code = "";
        for (int i = 0; i < letterValue.length; i++) {
            code += alphabet.charAt(letterValue[i]);
        }

        return code;
    }


    public static String decode(int[][] K, int[] S, String code) {

        K = modMatrix(K);
        S = modArray(S);


        long determinant = findDeterminant(K);
        if (checkSimpleNumbers(determinant, mod) != 1 || determinant == 1) {
            System.out.println("ERROR: Determinant and mod should be mutually prime numbers");
            System.out.println(determinant + " " + mod);
            return code;
        }

        long RDeterminant = extended_gcd(mod, determinant)[2];

        int[][] matrixT = transposedMatrix(K);
        int[][] matrixA = new int[matrixT.length][matrixT.length];

        for (int i = 0; i < matrixT.length; i++) {
            for(int j = 0; j < matrixT.length; j++) {
                int[][] minorMatrix = buildMinor(matrixT, i, j);
                int cof = (int) Math.pow(-1, i + 1 + j + 1);
                if (minorMatrix.length == 1) matrixA[i][j] = cof * minorMatrix[0][0];
                else {
                    long detOfMinor = findDeterminant(minorMatrix);
                    matrixA[i][j] = (int) (cof * detOfMinor);
                }
            }
        }

        int[][] matrixR = multiplyMatrixOnNum(matrixA, RDeterminant);
        int[] SS = multiplyMatrixOnArray(multiplyMatrixOnNum(matrixR, -1), S);
        int[] letterValue = new int[code.length()];

        for (int i = 0; i < code.length(); i+= SS.length) {
            int[] X = new int[SS.length];
            for (int j = 0; j < SS.length; j++) {
                X[j] = alphabet.indexOf(code.charAt(i+j));
            }
            int[] AX = multiplyMatrixOnArray(matrixR, X);
            int[] res = addArrays(AX, SS);
            System.arraycopy(res, 0, letterValue, i, X.length);
        }

        String text = "";
        for (int i = 0; i < letterValue.length; i++) {
            text += alphabet.charAt(letterValue[i]);
        }

        return text;

    }


    protected static int[][] modMatrix(int[][] matrix) {

        int[][] result = new int[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {

                while (matrix[i][j] < 0) {
                    matrix[i][j] += mod;
                }
                result[i][j] = matrix[i][j] % mod;
            }
        }

        return result;
    }


    protected static int[] modArray(int[] array) {
        int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {

            while (array[i] < 0) {
                array[i] += mod;
            }
            result[i] = array[i] % mod;
        }

        return result;
    }


    protected static int[] addArrays(int[] array1, int[] array2) {

        int[] result = new int[array1.length];
        for (int i = 0; i < array2.length; i++) {
            result[i] = (array1[i] + array2[i]) % mod;
        }

        return result;
    }


    protected static int[] multiplyMatrixOnArray(int[][] matrix, int[] array) {
        int[] result = new int[array.length];

        for (int i = 0; i < matrix.length; i++) {
            int temp = 0;
            for (int j = 0; j < matrix.length; j++) {
                temp += matrix[i][j] * array[j];
            }
            while (temp < 0) {
                temp += mod;
            }
            result[i] = temp % mod;
        }
        return result;
    }


    protected static int[][] multiplyMatrixOnNum(int[][] matrix, long num) {

        int[][] result = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                result[i][j] = (int) ((matrix[i][j] * num) % mod);
                if (result[i][j] < 0) {
                    while (result[i][j] < 0) {
                        result[i][j] += mod;
                    }
                }
            }
        }

        return result;
    }


    protected static int[][] transposedMatrix(int[][] matrix) {
        int[][] matrixT = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrixT[i][j] = matrix[j][i];
            }
        }
        return matrixT;
    }


    protected static long[] extended_gcd(long a, long b) {
        long[] res = new long[3];
        if (b == 0)
        {
            res[0] = a; res[1] = 1; res[2] = 0;
            return res;
        }
        res = extended_gcd(b,a % b);
        long s = res[2];
        res[2] = res[1] - (a / b) * res[2];
        res[1] = s;
        while (res[2] < 0) {
            res[2] += mod;
        }
        return res;

    }


    protected static long checkSimpleNumbers(long determinant, long mod) {
        if (determinant == 0) return mod;

        return checkSimpleNumbers(mod % determinant, determinant);
    }


    protected static long findDeterminant(int[][] matrix) {
        long determinant = 0;

        if (matrix.length == 2) {
            determinant = (long) matrix[0][0] * matrix[1][1] - (long) matrix[0][1] * matrix[1][0];
        } else {

            for (int i = 0; i < matrix.length; i++) {
                int cof = (int) Math.pow(-1, i + 1 + 1);
                int det = matrix[i][0] * cof * findMinor(matrix, i, 0);
                while (det < 0) {
                    det += mod;
                }
                determinant += det % mod;
            }
        }

        while (determinant < 0) {
            determinant += mod;
        }

        return determinant % mod;
    }


    protected static int findMinor(int[][] matrix, int row, int column) {

        int[][] minorMatrix = buildMinor(matrix, row, 0);

        int result = 0;
        if (minorMatrix.length == 2) {
            int det = minorMatrix[0][0] * minorMatrix[1][1] - minorMatrix[0][1] * minorMatrix[1][0];
            while (det < 0) {
                det += mod;
            }
            return det;
        } else {

            for (int i = 0; i < minorMatrix.length; i++) {
                int cof = (int) Math.pow(-1, i + 1 + 1);
                int det = cof * minorMatrix[i][column] * findMinor(minorMatrix, i, column);
                while (det < 0) {
                    det += mod;
                }
                result += det % mod;
            }
        }
        return result % mod;
    }


    protected static int[][] buildMinor(int[][] matrix, int row, int column) {

        int[][] minorMatrix = new int[matrix.length-1][matrix.length-1];
        int[] buffer = new int[minorMatrix.length*minorMatrix.length];

        for (int i = 0, bufferIndex = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == row) {
                    break;
                }
                else if (j != column) {
                    buffer[bufferIndex++] = matrix[i][j];
                }
            }
        }

        for (int i = 0, bufferIndex = 0; i < minorMatrix.length; i++) {
            for (int j = 0; j < minorMatrix.length; j++) {
                minorMatrix[i][j] = buffer[bufferIndex++];

            }
        }
        return minorMatrix;
    }

}
