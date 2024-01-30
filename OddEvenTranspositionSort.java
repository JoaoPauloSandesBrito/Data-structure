public class OddEvenTranspositionSort {
    
    public static void main(String[] args) {
        int[] array = {10,5,13,2,3,8,7,4};
        oddEvenTranspositionSort(array);
        
        System.out.println("Array ordenado:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
    
    public static void oddEvenTranspositionSort(int[] array) {
        int n = array.length;
        boolean isSorted = false;
        
        while (!isSorted) {
            isSorted = true;
            System.out.print("PAR: ");
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.print("\n");
            // Fase ímpar (odd)
            for (int i = 1; i < n - 1; i += 2) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    isSorted = false;
                }
            }

            System.out.print("IMPAR: ");
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.print("\n");
            // Fase par (even)
            for (int i = 0; i < n - 1; i += 2) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    isSorted = false;
                }
            }
        }
    }
    
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
