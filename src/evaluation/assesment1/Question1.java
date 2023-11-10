package evaluation.assesment1;

import java.util.Scanner;

public class Question1 {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		System.out.print("Enter the number : ");
	    int number = read.nextInt();
	    int[][] pattern= new int[number][number];
	    fillPattern(pattern,number);
	    for(int[] arr : pattern) {
	    	for(int i : arr) {
	    		if(i!=0) {
	    			if(i>9) {
	    				System.out.print(i+" ");
	    			}else {
	    			System.out.print(i+"  ");
	    			}
	    	} else{
	    		System.out.print("   ");
	    	}
	    	}System.out.println();
	      }
		}

		private static void fillPattern(int[][] pattern, int number) {
			int row=number-1,startRow=0,startColumn=0,endColumn=number-1,num=1;
			while(startRow<row && startColumn<endColumn) {
			for(int i=0;i<=row;i++) {
				pattern[i][startColumn+i]=num++;
			}startColumn++;
			 row--;
			for(int i=row;i>=startRow;i--) {
				pattern[i][endColumn]=num++;
			}endColumn--;
			for(int i=endColumn;i>startColumn;i--) {
				pattern[startRow][i]=num++;
			}startRow++;row--;
		}
	}
}
