package evaluation.assesment1;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Perumutaion {

	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		System.out.println("Enter the size of a number : ");
		int n = read.nextInt();
		int arr[] = new int[n];
		ArrayList<int[]> result = new ArrayList<>();
		System.out.print("Enter the number one by one : ");
		for(int i=0;i<n;i++) {
			arr[i]=read.nextInt();
		}
		findPermutation(0,n,result,arr);
		System.out.println("Permutation of a number is  : ");
		for(int[] temp : result) {
			System.out.println(Arrays.toString(temp));
		}
		
	}

	private static void findPermutation(int start, int end, ArrayList<int[]> result,int [] arr) {
		if(start>=end) {
			int tempArray[] = Arrays.copyOf(arr, end);
			result.add(tempArray);
			return ;
		}
		for(int i=start;i<end;i++) {		
			swap(i,start,arr);
			findPermutation(start+1, end, result,arr);
			swap(i,start,arr);
		}
	}

	private static void swap(int i, int j, int[] arr) {
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}

















