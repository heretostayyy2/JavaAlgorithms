import java.util.Arrays;
import java.util.Scanner;

public class AlgorithmSelector {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements in the list:");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Enter the elements of the list:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("Choose an operation: 1 for Sorting, 2 for Searching");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                sortArray(scanner, array);
                break;
            case 2:
                searchArray(scanner, array);
                break;
            default:
                System.out.println("Invalid choice");
        }

        scanner.close();
    }

    private static void sortArray(Scanner scanner, int[] array) {
        System.out.println("Choose a sorting algorithm: 1 for Bubble Sort, 2 for Quick Sort");
        int choice = scanner.nextInt();

        long startTime = System.nanoTime();

        switch (choice) {
            case 1:
                bubbleSort(array);
                System.out.println("Sorted array using Bubble Sort: " + Arrays.toString(array));
                System.out.println("Time Complexity: O(n^2)");
                break;
            case 2:
                quickSort(array, 0, array.length - 1);
                System.out.println("Sorted array using Quick Sort: " + Arrays.toString(array));
                System.out.println("Time Complexity: O(n log n)");
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }

        long endTime = System.nanoTime();
        System.out.println("Execution time: " + (endTime - startTime) + " nanoseconds");
    }

    private static void searchArray(Scanner scanner, int[] array) {
        System.out.println("Choose a searching algorithm: 1 for Linear Search, 2 for Binary Search");
        int choice = scanner.nextInt();

        System.out.println("Enter the value to search:");
        int value = scanner.nextInt();

        long startTime = System.nanoTime();
        int result = -1;

        switch (choice) {
            case 1:
                result = linearSearch(array, value);
                System.out.println("Time Complexity: O(n)");
                break;
            case 2:
                Arrays.sort(array); // Binary search requires sorted array
                result = binarySearch(array, value);
                System.out.println("Time Complexity: O(log n)");
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }

        long endTime = System.nanoTime();
        System.out.println("Execution time: " + (endTime - startTime) + " nanoseconds");

        if (result == -1) {
            System.out.println("Value not found in the array");
        } else {
            System.out.println("Value found at index: " + result);
        }
    }

    private static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    private static int linearSearch(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    private static int binarySearch(int[] array, int value) {
        int low = 0, high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == value) {
                return mid;
            }
            if (array[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
