public class Main {


    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        bubbleSort(returnArray(100000));
        long endTime = System.currentTimeMillis();
        System.out.println("Bubble sort of 100000 elem:\t\t"  + ((double) (endTime - startTime) / 1000));

        startTime = System.currentTimeMillis();
        selectionSort(returnArray(100000));
        endTime = System.currentTimeMillis();
        System.out.println("Selection sort of 100000 elem:\t"  + ((double) (endTime - startTime) / 1000));

        startTime = System.currentTimeMillis();
        insertionSort(returnArray(100000));
        endTime = System.currentTimeMillis();
        System.out.println("Insertion sort of 100000 elem:\t"  + ((double) (endTime - startTime) / 1000));
    }


    public static int[] returnArray(int len) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = len - i;
        }
        return array;
    }


    public static void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }


    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
    }


    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while(j >= 0 && current < array[j]) {
                array[j+1] = array[j];
                j--;
            }

            array[j+1] = current;
        }
    }
}
