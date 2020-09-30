//Jump Search is a searching algorithm for sorted arrays.
//Basic idea is to search fewer elements than linear search 
public class JumpSearch{
	public static int jumpSearch(int[] arr, int x) 
	{ 
		int len = arr.length; 

		// Finding block size to be jumped 
		int step = (int)Math.floor(Math.sqrt(len)); 

		// Finding the block where element is 
		// present (if it is present) 
		int prev = 0; 
		while (arr[Math.min(step, len)-1] < x) 
		{ 
			prev = step; 
			step += (int)Math.floor(Math.sqrt(len)); 
			if (prev >= len) 
				return -1; 
		} 

		// Doing a linear search for x in block 
		// beginning with prev. 
		while (arr[prev] < x) 
		{ 
			prev++; 

			// If we reached next block or end of 
			// array, element is not present. 
			if (prev == Math.min(step, len)) 
				return -1; 
		} 

		// If element is found 
		if (arr[prev] == x) 
			return prev; 

		return -1; 
	} 

	public static void main(String [] args) 
	{ 
		int arr[] = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 
					34, 55, 89, 144, 233, 377, 610};
		int x = 55; 
		// Finding the index of 55 in arr using Jump Search 
		int index = jumpSearch(arr, x); 
		// Printing the index where 'x' is located 
		System.out.println("\nNumber " + x + " is at index " + index); 
	} 
} 
//STEP 1: Jump from index 0 to index 4;
//STEP 2: Jump from index 4 to index 8;
//STEP 3: Jump from index 8 to index 12;
//STEP 4: Since the element at index 12 is greater than 55 we will jump back a step to come to index 8.
//STEP 5: Perform linear search from index 8 to get the element 55.(This will reduce the number of steps)