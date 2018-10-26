package array_left_rotation;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	

    public static void main(String[] args) {
    	start( new Scanner(System.in) );
    }
    
    public static void start( Scanner scanner ) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];
        
        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }
        
        shiftLeft(a, d, n);
        
    	for (int i = 0; i < n; i++) {
    		System.out.print(a[i] + " ");
    	}

        scanner.close();
    }
    
    private static void shiftLeft( int[] array, int times, int size ) {
    	int [] original = array.clone();
    	for (int i = 0; i < size; i++) {
    		int position = i - times;
    		if ( position < 0 ) {
    			position+= size;
    		}
    		array[position] = original[i];
    	}
    }

    // [0] -> [4] 		0 -> pos1   0 -4 = -4 + size = 0
    // [1] -> [0] 		1 -> pos2   1 -4 = -3 + size = 1
    // [2] -> [1] 		2 -> pos3   2 -4 = -2 + size = 2
    // [3] -> [2] 		3 -> pos4   3 -4 = -1 + size = 3
    // [4] -> [3] 		4 -> pos0   4 -4 = 0
    
}
