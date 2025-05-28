/*
Kyle Reed
Prof. Huang
COS-210-300
5 May 2025
*/

// SelectionSort.java

// Selection Sort algorithm
public class SelectionSort {

    
    // Input array is sorted using Selection Sort algorithm
    public static void sort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;

            // Searches for and finds a minimum element in the unsorted part
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            // Swaps out the minimum element with the first unsorted element of the part
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }
}