/**
 * Kimberly Gonzalez 2/20/20
 *
 * This program uses random integers in an array to create a max heap for the Priority Queue. It will display the raw
 * data in un-organized random order. Then it will display the same numbers in organized max heap order after it passes
 * through the method to organize it to max heap. It will also display the heap's max element (the root) as well as
 * extracting/removing the max from the heap and displaying the new remaining and re-organized max heap.
 */
public class Max_Heap_Project
{
    //keeps track of the array heap size
    public static int heapSize = 0;

    public static void main(String[] args)
    {
        int A[] = new int[11];

        //begins to build max heap
        buildMaxHeap(A);

        System.out.println("\nRaw Data: ");

        //creates 100 random integers and inserts them into the array
        //sends it to the maxHeapInsert method to insert to max heap
        for (int i = 0; i < 10; i++)
        {
            int num = (int) (Math.random()* 100);

            //will display unorganized random integers
            System.out.print(num + " ");

            //inserts the random integers into max heap
            maxHeapInsert(A, num);
        }

        //displays the organized map heap
        System.out.println("\n\nMax Heap: ");
        printHeap(A);

        //displays the max element number (the root)
        System.out.println("\n\nMax is: " + heapMaximum(A));

        //removes the max element (root)
        System.out.println("\nExtracting Max " + heapExtractMax(A));

        //displays the heap re-organized after removing the max (root)
        System.out.println("\nHeap With Max Removed and Reorganized Max-Heap: ");
        printHeap(A);
        System.out.println(" ");
    }

    /**
     * Print the elements in the max heap array
     * @param A the array
     */
    public static void printHeap(int A[])
    {
        for (int i = 1; i <= heapSize; i++)
        {
            System.out.print(A[i] + " ");
        }
        System.out.print(" ");
    }

    /**
     * Pseudocode in ppt/lecture to build a max heap from the array
     * @param A the Array
     */
    public static void buildMaxHeap(int A[])
    {
        for (int i = heapSize / 2; i >= 1; i--)
        {
            maxHeapify(A, i);
        }
    }

    /**
     * Inserts a new key into the heap tree
     * @param A the array
     * @param key the element
     */
    public static void maxHeapInsert(int A[], int key)
    {
        heapSize = heapSize + 1;

        A[heapSize] =  Integer.MIN_VALUE;

        heapIncreaseKey(A, heapSize, key);
    }

    /**
     * Increases the element of i's key to key's value
     * @param A
     * @param i
     * @param key
     */
    public static void heapIncreaseKey(int A[], int i, int key)
    {
        if (key < A[i])
        {
            System.out.println("New key is smaller than current key.");
        }

        A[i] = key;

        //if parent is less than current key, then exchanges/swaps them
        while ((i > 1) && (A[i / 2] < A[i]))
        {
            int exchange = A[i / 2];

            A[i / 2] = A[i];

            A[i] = exchange;

            i = i / 2;
        }
    }

    /**
     * Removes the max element in the max heap and returns it
     * @param A the array
     * @return max element
     */
    public static int heapExtractMax(int A[])
    {
        int max = A[1];

        A[1] = A[heapSize];

        heapSize = heapSize - 1;

        maxHeapify(A, 1);

        return max;
    }

    /**
     * Compares for the left and right child to find the largest value to put them in the correct position
     * @param A the array
     * @param i the current index/node
     */
    public static void maxHeapify(int A[], int i)
    {
        // how to find left and right child
        int l = 2 * i;
        int r = (2 * i) + 1;

        //current position/node is the largest
        int largest = i;

        //left is largest if it's larger than current index array element
        if ((l <= heapSize) && (A[l] > A[i]))
        {
            largest = l;
        }
        else
            largest = i;

        // right is larger if it's larger than largest index array element
        if ((r <= heapSize) && (A[r] > A[largest]))
        {
            largest = r;
        }

        //if largest is not the current index/node, exchanges them
        if (largest != i)
        {
            int exchange = A[largest];

            A[largest] = A[i];

            A[i] = exchange;

            maxHeapify(A, largest);
        }
    }

    /**
     * Simply reutrns the max element without removing it, looks at root
     * @param A the array
     * @return the max element (the root)
     */
    public static int heapMaximum(int A[])
    {
        return A[1];
    }
}
