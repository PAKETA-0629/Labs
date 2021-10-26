import java.util.Random;

public class Main {


    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
           int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }


    public static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int i = (low - 1);

        for(int j = low; j <= high - 1; j++) {
             if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static boolean binarySearch(int arr[], int elementToSearch) {

        int firstIndex = 0;
        int lastIndex = arr.length - 1;

        while(firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            if (arr[middleIndex] == elementToSearch) {
                return true;
            }

            else if (arr[middleIndex] < elementToSearch)
                firstIndex = middleIndex + 1;

            else if (arr[middleIndex] > elementToSearch)
                lastIndex = middleIndex - 1;

        }
        return false;
    }


    public static void main(String[] args) {
//        int result1 = ex1(10, 15);
//        System.out.println("\n" + result1);

        double result2 = ex2(5, 12.7);
        System.out.println(result2);
    }


    public static int ex1(int n, int m) {
        Random random = new Random();
        int sum = 0;
        int[] array1 = new int[n];
        int[] array2 = new int[m];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = random.nextInt(100) + 1;
            array2[i] = random.nextInt(100) + 1;
        }

        for (int i = n - 1; i < array2.length; i++) {
            array2[i] = random.nextInt(100) + 1;
        }

        quickSort(array1, 0, array1.length - 1);
        quickSort(array2, 0, array2.length - 1);

        for (int num: array1) {
            System.out.print(num + " ");
        }
        System.out.println();
        for (int num: array2) {
            System.out.print(num + " ");
        }

        for (int num: array1) {
            if (!binarySearch(array2, num)) {
                sum += num;
            }
        }
        return sum;
    }


    public static double ex2(int n, double x) {
        double result = 0;
        for (int i = 1; i <= n; i++) {

            double powX = x;
            for (int pow = 1; pow < i; pow++) {
                powX *= x;
            }

            int factorial = 1;
            for (int j = 2; j <= i; j++) {
                factorial *= j;
            }

            result += powX / factorial;
        }

        return result;
    }

}
