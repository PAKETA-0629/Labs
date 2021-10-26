public class Main {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        sort_shell(returnArray(100000));
        long endTime = System.currentTimeMillis();
        System.out.println("Sort Shell of 100000 elem:\t\t" + ((double) (endTime - startTime) / 1000));

        startTime = System.currentTimeMillis();
        countingSort(returnArray(100000), 100000);
        endTime = System.currentTimeMillis();
        System.out.println("Counting sort of 100000 elem:\t" + ((double) (endTime - startTime) / 1000));

        startTime = System.currentTimeMillis();
        quickSort(returnArray(100000), 0, 99999);
        endTime = System.currentTimeMillis();
        System.out.println("Quick sort of 100000 elem:\t\t" + ((double) (endTime - startTime) / 1000));

    }


    public static int[] returnArray(int len) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = len - i;
        }
        return array;
    }


    public static void sort_shell(int[] a){
        int i, j, k, h, m = 0, b = a.length;
        int[] d = { 1, 4, 10, 23, 57, 145, 356, 911, 1968, 4711, 11969, 27901,
                84801, 213331, 543749, 1355339, 3501671, 8810089, 21521774,
                58548857, 157840433, 410151271, 1131376761, 2147483647 };
        while (d[m] < b) ++m;
        while (--m >= 0){
            k = d[m];
            for (i = k; i < b; i++){
                j=i;
                h=a[i];
                while ((j >= k) && (a[j-k] > h)){
                    a[j]=a[j-k];
                    j -= k;
                }
                a[j] = h;
            }
        }
    }


    public static int[] countingSort(int[] theArray, int maxValue) {

        int numCounts[] = new int[maxValue + 1];
        for (int num : theArray) {
            numCounts[num]++;
        }
        int[] sortedArray = new int[theArray.length];
        int currentSortedIndex = 0;
        for (int n = 0; n < numCounts.length; n++) {
            int count = numCounts[n];
            for (int k = 0; k < count; k++) {
                sortedArray[currentSortedIndex] = n;
                currentSortedIndex++;
            }
        }
        return sortedArray;
    }


    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return;

        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        int opora = array[middle];

        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }
}
