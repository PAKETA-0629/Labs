import java.io.*;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) {
        String text = "Kyrylo Maltsev";
        String code = code(convert(text), text.length() * 8);
        String decode = decode(code);

    }


    public static String deconvert(int[] bitArray) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < bitArray.length;) {
            String temp = "";
            while (temp.length() != 8) {
                temp += bitArray[i++];
            }
            stringBuilder.append((char) Integer.parseInt(temp, 2));
        }

        return stringBuilder.toString();

    }


    public static int[] convert(String str) {

        int[] result = new int[str.length() * 8];
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            String binaryString = Integer.toBinaryString(str.charAt(i)); // 00001010
            while (binaryString.length() != 8) {
                binaryString = "0" + binaryString;
            }
            for (int j = 0; j < binaryString.length(); j++) {

                if (binaryString.charAt(j) == '1') { result[index++] = 1; }
                else { result[index++] = 0; }
            }
        }

        return result;
    }


    public static String code(int[] bitArray, int len) {
        String str = "";
        try (BufferedReader br = new BufferedReader(new FileReader("/home/kyrylo/IdeaProjects/InfProtectLab1/resources/input.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            str = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int[] lenByte = new int[8];
        String binaryLen = Integer.toBinaryString(len);
        for (int i = binaryLen.length() - 1, index = lenByte.length - 1; i >= 0; i--) {
            if (binaryLen.charAt(i) == '1') lenByte[index] = 1;
            index--;
        }

        String code = meth(str, bitArray, lenByte);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("/home/kyrylo/IdeaProjects/InfProtectLab1/resources/input.txt"))) {
            writer.write(code);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //-------------------------------------------------------------------------------------------------------------------------------------------

        return code;
    }


    public static String decode(String code) {
        int[] decode = dig(code);
        String result = deconvert(decode);
        System.out.println(Arrays.toString(decode));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("/home/kyrylo/IdeaProjects/InfProtectLab1/resources/output.txt"))) {
            writer.write(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    public static int[] dig(String str) {
        int[] lenArray = new int[8];
        int len;
        String[] array = str.split("[a-zA-Z,\n]+");

        for (int i = 1; i < lenArray.length + 1; i++) {
            if (array[i].equals(" ")) lenArray[i - 1] = 0;
            else if (array[i].equals("  ")) lenArray[i - 1] = 1;
        }

        String temp = "";
        for (int i = 0; i < lenArray.length; i++) {
            temp += lenArray[i];
        }
        len = Integer.parseInt(temp, 2);
        int[] result = new int[len];


        for (int i = 9, index = 0; index < result.length; i++) {
            if (array[i].equals(" ")) result[index++] = 0;
            else if (array[i].equals("  ")) result[index++] = 1;
        }

        return result;
    }


    public static String meth(String str, int[] bitArray, int[] len) {
        String[] array = str.split("[ ]+");
        if (array.length < bitArray.length) return str;
        StringBuilder result = new StringBuilder();
        int i;

        for (int j = 0; j < len.length; j++) {
            result.append(array[j]).append(" ");
            if (len[j] == 1) result.append(" ");
        }

        for (i = 0; i < bitArray.length; i++) {

            result.append(array[i]).append(" ");
            if (bitArray[i] == 1) result.append(" ");
        }

        for (int j = i; j < array.length; j++) {
            result.append(array[i]);
            if (j != array.length - 1) result.append(" ");
        }

        return result.toString();
    }
}
