package rikesh.puri.fibonacci;

import java.util.ArrayList;
import java.util.List;

public class Factory {
		
//		static List<Integer> fibArr = new ArrayList<Integer>();
//		fibArr.add(0);
		
		public static int getFib(int index) {
//			try {
//				int myNumber = fibArr.get(index);
//				return myNumber;
//			}
//			catch (IndexOutOfBoundsException e) {
				/* Declare an array to store Fibonacci numbers. */
				int n = index;
		        int f[] = new int[n + 1]; 
		        int i; 
		  
		        /* 0th and 1st number of the series are 0 and 1*/
		        f[0] = 0; 
		  
		        if (n > 0) { 
		            f[1] = 1; 
		  
		            for (i = 2; i <= n; i++) { 
		                /* Add the previous 2 numbers in the series 
		             and store it */
		                f[i] = f[i - 1] + f[i - 2]; 
		            } 
		        } 
		        //fibArr.add(index, f[n]);
		        return f[n];
			
		}
}
