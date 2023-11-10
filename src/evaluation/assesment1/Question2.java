package evaluation.assesment1;
import java.util.*;

public class Question2 {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		System.out.print("Enter the number : ");
		int n=read.nextInt();
		if(isJumbledNumber(n)) {
			System.out.print(n+" is a jumbled number.");
		}else {
			System.out.print(n+" is not a jumbled number.");
		}
	}

	public static boolean isJumbledNumber(int n) {
		String num = String.valueOf(n);
		for(int i=1;i<num.length();i++) {
			if((int)num.charAt(i-1)-(int)num.charAt(i)==1 || (int)num.charAt(i-1)-(int)num.charAt(i)==-1 || num.charAt(i-1)==num.charAt(i)) {
				continue;
			}else {
				return false;
			}
		}
		return true;
	}

}
