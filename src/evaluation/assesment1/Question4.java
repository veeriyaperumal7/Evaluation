package  evaluation.assesment1;
import java.util.*;
public class Question4 {

	public static void main(String[] args) {
	Scanner read = new Scanner(System.in);
	System.out.print("Enter the string : ");
	String s=read.nextLine();
    System.out.print("Enter the row : ");
    int row = read.nextInt();
    if(row<=0) {
    	System.out.println("Row value must be greater than 0.");return;
    }
    if(row==1) {
    	System.out.println(s);return;
    }
    char[][] pattern= new char[row][s.length()];
    fillPattern(pattern,s,row);
    for(char[] arr : pattern) {
    	for(char i : arr) {
    		
    			System.out.print(i+" ");
    		
    	}System.out.println();
      }
	}

	private static void fillPattern(char[][] pattern, String s, int row) {
		int difference=0,k=0,l=0;
		for(int i=0;i<s.length();i++) {
			for(int j=0;j<row;j++) {
				if(i==0 || i%(row-1)==0) {
					pattern[j][i]=s.charAt(k);
					k++;
					if(k>=s.length()) {
						return;
					}difference=0;
				}else {
					if((row)-difference-1==j) {
						pattern[j][i]=s.charAt(k);
						k++;
						if(k>=s.length()) {
							return;
						}
					}
				}
			}difference++;
		}return;
	}
}
