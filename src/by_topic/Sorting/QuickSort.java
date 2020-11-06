package by_topic.Sorting;

/**
 *
 */
public class QuickSort {
    public static void main(String[] args) {
        int arr[] = {8,2,9,6,1,5,4,1,1,1};
        quicksort (arr,0,arr.length-1);
        for (int i = 0; i<arr.length ;i++) {
            System.out.print(arr[i] + " ");
        }
    }
    private static void quicksort(int[] arr, int start, int end) {
        if (start < end) {
            int r = partition(arr, start, end);
            quicksort(arr,start,r-1);
            quicksort(arr,r+1,end);
        }
    }
    private static int partition (int[] arr, int start, int end) {
        int pivot = arr[end];
        int p = start-1;
        for (int i = start; i < end; i++) {  // 2,1,4,|6|,8,5,9  start =0, end=6
            if (arr[i] <= pivot)
            {
                p++;
                int temp = arr[i];
                arr[i] = arr[p];
                arr[p] =  temp;
            }
        } // p is the position of pivot now !!
        arr[end] = arr[p+1];
        arr[p+1] = pivot;
        return p+1;
    }
}