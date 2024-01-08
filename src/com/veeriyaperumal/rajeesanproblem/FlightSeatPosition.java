package com.veeriyaperumal.rajeesanproblem;

import java.util.Scanner;
import java.util.HashMap;

public class FlightSeatPosition {
	private static Scanner read = new Scanner(System.in);

	public static void main(String[] args) {
		/*
		 * Wrong input validation not handled.
		 */
		System.out.print("Enter the input : ");
		int seatNo = read.nextInt();
		if(seatNo<1) {
			System.out.print("Invalid shest no.");
			return;
		}
		System.out.print("Output : " + getSeatNumber(seatNo));
	}

	private static String getSeatNumber(int seatNo) {
		
		if(seatNo%6==0 || seatNo%6==1) {
			  return "Window Seat";
		}else if(seatNo%6==2 || seatNo%6==5) {
			return "Middle Seat";
		}else {
			return "Aisle Seat";
		}
		
//		int line1 = 1, line2 = 2, line3 = 3, line4 = 4, line5 = 5, line6 = 6;
//
//		for (int i = 0; i < 18; i++) {
//			if (line1 == seatNo) {
//               return "Window Seat";
//			} else if (line2 == seatNo) {
//				 return "Middle Seat";
//			} else if (line3 == seatNo) {
//				 return "Aisle Seat";
//			} else if (line4 == seatNo) {
//				 return "Aisle Seat";
//			} else if (line5 == seatNo) {
//				 return "Middle Seat";
//			} else if (line6 == seatNo) {
//				 return "Window Seat";
//			}
//			if(i%2==0) {
//				line1+=11;line2+=9;line3+=7;line4+=5;line5+=3;line6+=1;
//			}else {
//				line1+=1;line2+=3;line3+=5;line4+=7;line5+=9;line6+=11;
//			}
//			
//		}
//		return "No seats available";

	}
}
