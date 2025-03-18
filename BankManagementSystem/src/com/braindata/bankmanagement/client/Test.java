package com.braindata.bankmanagement.client;

import com.braindata.bankmanagement.service.*;
import com.braindata.bankmanagement.serviceImpl.*;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		
		Rbi bank = new Sbi();
		
		Scanner sc = new Scanner(System.in);
		
		int operation;
		
		do {
			
			System.out.println("\n🏦 Welcome to the Online Banking System! 🏦\n");

			System.out.println("🔹 Choose an option below:\n");
			System.out.println("[1] ➤ Create a New Account");
			System.out.println("[2] ➤ View Account Details");
			System.out.println("[3] ➤ Deposit Money");
			System.out.println("[4] ➤ Withdraw Money");
			System.out.println("[5] ➤ Check Account Balance");
			System.out.println("[6] ➤ Exit");
			
			System.out.print("\n➡ Choose Your Choice : ");
			
		    operation = sc.nextInt();
			
			switch(operation) {
			
			case 1 : bank.createAccount();
					 break;
			
			case 2 : bank.displayAllDetails();
					 break;
			
			case 3 : bank.depositeMoney();
					 break;
					 
			case 4 : bank.withdrawal();
					 break;
					 
			case 5 : bank.balanceCheck();
					 break;
					 
			case 6 : System.out.println("Have a great day! Visit again.");
					 break;
					 
			default :
					  System.out.println("Please Enter Valid Operation.");
					  
			}		 
			
			
		}while(operation != 6);
		
		
			
		
		
		
	}
}
