/*
Kyle Reed
Prof. Huang
COS-210-300
5 May 2025
*/

// InsertionSort.java
 
// Insertion Sort algorithm
public class InsertionSort {
    
    // Input array is sorted using Insertion Sort algorithm
    public static void sort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Elements that are greater than key are moved one position forward
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}