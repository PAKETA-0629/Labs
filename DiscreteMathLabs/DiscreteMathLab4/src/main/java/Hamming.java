
public class Hamming {


    protected static int[] encode(int[] a) {

        int[] encode;

        // вираховуємо кількість контрольних біт
        int i = 0, parity_count = 0, j = 0, k = 0;
        while(i < a.length) {

            // 2^(контрольний біт) має дорівнювати поточній позиції
            // поточна позиція це (число біт + число контрольних біт + 1).

            if(Math.pow(2, parity_count) == i + parity_count + 1) {
                parity_count++;
            }
            else {
                i++;
            }
        }

        encode = new int[a.length + parity_count];

        for(i = 1; i <= encode.length; i++) {
            if(Math.pow(2, j) == i) {
                // знаходимо місце контрольного біта та ставимо 2.

                encode[i-1] = 2;
                j++;
            }
            else {
                encode[k+j] = a[k++];
            }
        }

        for(i = 0 ; i < parity_count; i++) {
            // обчислюємо кожен контрольний біт

            encode[((int) Math.pow(2, i))-1] = getParity(encode, i);
        }
        return encode;
    }


    static int getParity(int[] b, int power) {
        int parity = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i] != 2) {
                // якщо i не містить не задане значення,
                // ми збережмео цей індекс в k, додав 1,
                // потім ми конвертуємо його в двійкову строку:

                int k = i + 1;
                String s = Integer.toBinaryString(k);

                // якщо біт у місці розташування двійкового значення індексу 2 ^ (потужність) дорівнює 1
                // ми маємо первірти значення на цій позиції.
                // перевіряєм якщо це значення 1 або 0, обчислимо парне значення.

                int x = ((Integer.parseInt(s)) / ((int) Math.pow(10, power))) % 10;
                if (x == 1) {
                    if (b[i] == 1) {
                        parity = (parity + 1) % 2;
                    }
                }
            }
        }
        return parity;
    }


    static void receive(int[] a, int parity_count) {

        int power;

        int parity[] = new int[parity_count];

        String syndrome = new String();

        for(power = 0; power < parity_count; power++) {

            for(int i = 0; i < a.length; i++) {

                int k = i+1;
                String s = Integer.toBinaryString(k);

                int bit = ((Integer.parseInt(s)) / ((int) Math.pow(10, power))) % 10;
                if(bit == 1) {
                    if(a[i] == 1) {
                        parity[power] = (parity[power]+1)%2;
                    }
                }
            }
            syndrome = parity[power] + syndrome;
        }

        int error_location = Integer.parseInt(syndrome, 2);
        if( error_location != 0) {
            System.out.println("Error is at location " + error_location + ".");
            a[error_location - 1] = (a[error_location - 1] + 1) % 2;
            System.out.println("Corrected code is:");
            for(int i=0 ; i < a.length ; i++) {
                System.out.print(a[a.length-i-1]);
            }
            System.out.println();
        }
        else {
            System.out.println("There is no error in the received data.");
        }

        System.out.print("Original data sent was: ");
        power = parity_count-1;
        StringBuilder result = new StringBuilder();
        for(int i = a.length ; i > 0 ; i--) {
            if(Math.pow(2, power) != i) {
                result.append(a[i-1]);
            }
			else {
                power--;
            }
        }
        System.out.println(result.reverse());
        System.out.println();
    }

}