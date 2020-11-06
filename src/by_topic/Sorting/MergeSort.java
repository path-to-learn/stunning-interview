package by_topic.Sorting;

/**
 * Complexity = nlog(n)
 */
public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {12,14,15,6,8,9 };
        int arrTemp[] = new int[arr.length];
        mergeSort(arr, arrTemp, 0, arr.length-1);
        for (int i : arr)
            System.out.print(i + " ");
    }

    private static void mergeSort(int[] arr, int[] arrTemp, int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            mergeSort(arr, arrTemp, low, middle);
            mergeSort(arr, arrTemp, middle + 1, high);
            merge(arr, arrTemp, low, middle, high);
        }
    }

    private static void merge(int[] arr, int[] arrTemp, int low, int middle, int high) {
        for (int i = low; i <= high; i++) {
            arrTemp[i] = arr[i];
        }
        int p = low, q = middle + 1, j = low;
        while ((p <= middle) && (q <= high)) {
            if (arrTemp[p] <= arrTemp[q]) {
                arr[j] = arrTemp[p];
                p++;
            } else {
                arr[j] = arrTemp[q];
                q++;
            }
            j++;
        }
        // only the left side of the elements are copied because right side is always there.
        // remianing will be greater than 0 if , all right side array is small and copied quickly
        int remaining = middle - p;
        for (int i =0; i<=remaining;i++)
            arr[j+i] = arrTemp[p+i];
    }
}
