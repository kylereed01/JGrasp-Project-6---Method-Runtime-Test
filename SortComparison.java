/*
Kyle Reed
Prof. Huang
COS-210-300
5 May 2025
*/

// SortComparison.java

/* 
Driver class that runs and compares different sorting methods and algorithms. 
Can generate random arrays of different sizes and compile the average run times
of each sorting method class 
*/
public class SortComparison {

    // Runs each sorting algorithm 5 times per input size to calculate the average
    private static final int RUNS = 5;

    public static void main(String[] args) {
        // Input sizes that are tested
        int[] inputSizes = {100, 500, 1000, 5000, 10000, 50000, 100000, 500000, 1000000};

        System.out.printf("%-12s%-15s%-15s%-15s%-15s%n", "Input Sizes", "Insertion Sort", "Selection Sort", "Merge Sort", "Quick Sort");
        System.out.println("---------------------------------------------------------------------------------------");

        for (int size : inputSizes) {
            long totalInsertionTime = 0;
            long totalSelectionTime = 0;
            long totalMergeTime = 0;
            long totalQuickTime = 0;

            for (int run = 0; run < RUNS; run++) {
                int[] originalArray = generateRandomArray(size);

                int[] arrayToSort;

                // Insertion Sort
                if (size <= 100000000) {
                    arrayToSort = originalArray.clone();
                    long start = System.nanoTime();
                    InsertionSort.sort(arrayToSort);
                    long end = System.nanoTime();
                    totalInsertionTime += (end - start);
                }

                // Selection Sort
                if (size <= 10000000) {
                    arrayToSort = originalArray.clone();
                    long start = System.nanoTime();
                    SelectionSort.sort(arrayToSort);
                    long end = System.nanoTime();
                    totalSelectionTime += (end - start);
                }

                // Merge Sort
                arrayToSort = originalArray.clone();
                long start = System.nanoTime();
                MergeSort.sort(arrayToSort);
                long end = System.nanoTime();
                totalMergeTime += (end - start);

                // Quick Sort
                arrayToSort = originalArray.clone();
                start = System.nanoTime();
                QuickSort.sort(arrayToSort);
                end = System.nanoTime();
                totalQuickTime += (end - start);
            }

            // Calculation of average times (milliseconds for accuracy)
            double avgInsertion = (size <= 1000) ? (totalInsertionTime / RUNS / 1_000_000.0) : 0;
            double avgSelection = (size <= 1000) ? (totalSelectionTime / RUNS / 1_000_000.0) : 0;
            double avgMerge = totalMergeTime / RUNS / 1_000_000.0;
            double avgQuick = totalQuickTime / RUNS / 1_000_000.0;

            System.out.printf("%-12d%-15.3f%-15.3f%-15.3f%-15.3f%n",
                size, avgInsertion, avgSelection, avgMerge, avgQuick);
        }
    }

    
   // Generation of an array that fills with random numbers and returns array
    public static int[] generateRandomArray(int size) {
        java.util.Random rand = new java.util.Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt();
        }
        return arr;
    }
}
