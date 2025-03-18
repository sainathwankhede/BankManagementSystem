package com.braindata.bankmanagement.serviceImpl;

import com.braindata.bankmanagement.model.*;
import com.braindata.bankmanagement.service.*;
import java.util.Scanner;

public class Sbi implements Rbi  {
	
	 Scanner sc  = new Scanner(System.in);
	
	 Account acc = new Account();
	
	

	 //static values
	static double minBalance = 500.00;
	static double minDeposite = 100.00;
	static double maxDeposite = 50000.00;
	static double minWithdrawAmt = 50.00;
	static double maxWithdrawAmt = 100000.00;
	
	
	
	
	public void createAccount() {
		
//		int accNo = Integer.parseInt(sc.nextLine()); //To Preventing the issue of skipping input.
		
		System.out.print("\nEnter Account Number = ");
		int accNo = sc.nextInt();
		sc.nextLine();
		
		System.out.print("\nEnter Your Name =  ");
		String name = sc.nextLine();
		
		System.out.print("\nEnter Your Mobile No = ");
		String mobNo = sc.nextLine();
		
		System.out.print("\nEnter Your adharNo = ");
		String adharNo = sc.nextLine();
		
		System.out.print("\nEnter Your gender (Male / Female) = ");
		String gender = sc.nextLine();
		
		System.out.print("\nEnter Your Age = ");
		int age = sc.nextInt();
		
		
		
		
		acc.setAccNo(accNo);
		acc.setName(name);
		acc.setMobNo(mobNo);
		acc.setAdharNo(adharNo);
		acc.setGender(gender);
		acc.setAge(age);
		acc.setBalance(minBalance);
		
		System.out.println("\n✅ Congratulations! Your account has been successfully created.");
		 
	}
	
	public void displayAllDetails() {
		
		int enteredAccNo;
		do {
			System.out.print("\nEnter Account Number : ");
			enteredAccNo = sc.nextInt();
			
			if(enteredAccNo == 0) {
				System.out.println("\n📢 Oops! It looks like you haven't created an account yet.");
				System.out.println("💡 Tip: Choose '1' to open a new account and enjoy our services!");
				break;
			}
			else if(enteredAccNo == acc.getAccNo()) {
				System.out.println("\n📌 Account Details: ");
				System.out.println("---------------------------------");
				System.out.println("🔹 Account No           : " + acc.getAccNo());
				System.out.println("🔹 Name                 : " + acc.getName());
				System.out.println("🔹 Gender               : " + acc.getGender());
				System.out.println("🔹 Age                  : " + acc.getAge());
				System.out.println("🔹 Mobile No            : " + acc.getMobNo());
				System.out.println("🔹 Adhar No             : " + acc.getAdharNo());
				System.out.println("🔹 Initial Balance      : " + acc.getBalance());
				
			}else {
				System.out.println("Invalid Account Number! Please enter the correct Account Number.");
			}
			
		}while(enteredAccNo != acc.getAccNo());
		
		
		
		
	}
	
	public void depositeMoney() {
		
		int enteredAccNo;
		
		do {
			
			System.out.print("Enter Account Number =  ");
			enteredAccNo = sc.nextInt();
			
			if(enteredAccNo == 0) {
				System.out.println("\n📢 Oops! It looks like you haven't created an account yet.");
				System.out.println("💡 Tip: Choose '1' to open a new account and enjoy our services!");
				break;
			}
			
			else if(enteredAccNo == acc.getAccNo()) 
			{
				
				double enteredDepAmt;
				do {
					
					System.out.print("\nEnter Deposit Amount (100Rs. - 50000Rs.) = ");
					enteredDepAmt = sc.nextDouble();
					
					if((enteredDepAmt >= minDeposite) && (enteredDepAmt <= maxDeposite) ) {
						double updatedBalance = acc.getBalance() + enteredDepAmt;
						acc.setBalance(updatedBalance);
						System.out.println("\n✅Amount Deposited Successfully.");
						System.out.println("\n💰 New Balance: ₹" + updatedBalance);
					}else if(enteredDepAmt < minDeposite) {
						System.out.println("\nPlease enter an amount of ₹" + minDeposite + " or more.");
					}else {
						System.out.println("\n➡ Please enter an amount up to ₹" + maxDeposite + ".");
					}
					
				}while(!((enteredDepAmt >= minDeposite) && (enteredDepAmt <= maxDeposite)) );
				
				
			}
			else 
			{
				System.out.println("\nInvalid Account Number! Please enter the correct Account Number.");
			}
		}while(enteredAccNo != acc.getAccNo());
		
		
		System.out.println("Deposite money");
	}
	
	public void withdrawal() {
		
		
		int enteredAccNo;
		
		do {
			
			System.out.print("Enter Account Number =  ");
			enteredAccNo = sc.nextInt();
			
			if(enteredAccNo == 0) {
				System.out.println("\n📢 Oops! It looks like you haven't created an account yet.");
				System.out.println("💡 Tip: Choose '1' to open a new account and enjoy our services!");
				break;
			}
			
			else if(enteredAccNo == acc.getAccNo()) 
			{
				double enteredWithdrawAmt ;
				
				double initialBalance = acc.getBalance();
				
				
				do {
					System.out.println("\\n💰 Enter the amount you want to withdraw: ₹");
					enteredWithdrawAmt = sc.nextDouble();
					
					if((((initialBalance - enteredWithdrawAmt) >= (minBalance + minWithdrawAmt)) && (enteredWithdrawAmt >= minWithdrawAmt && enteredWithdrawAmt <= maxWithdrawAmt)) || (((initialBalance - enteredWithdrawAmt) >= (minBalance + minWithdrawAmt)) && (enteredWithdrawAmt >= minWithdrawAmt && enteredWithdrawAmt <= maxWithdrawAmt))) {
						double updatedAmt = initialBalance - enteredWithdrawAmt;
						acc.setBalance(updatedAmt);
						System.out.println("\n✅ Amount Withdrawn Successfully.");
						System.out.println("\n💰 New Balance: ₹" + acc.getBalance() );
					}else if(enteredWithdrawAmt < 50){
						System.out.println("\n❌ Minimum withdrawal amount is ₹50. Please enter a valid amount.");
						
					}else {
						 System.out.println("\n❌ Insufficient balance! Your current balance is ₹" + acc.getBalance());
						 break;
					}
							
					
				}while(!((((initialBalance - enteredWithdrawAmt) >= (minBalance + minWithdrawAmt)) && (enteredWithdrawAmt >= minWithdrawAmt && enteredWithdrawAmt <= maxWithdrawAmt)) || (((initialBalance - enteredWithdrawAmt) >= (minBalance + minWithdrawAmt)) && (enteredWithdrawAmt >= minWithdrawAmt && enteredWithdrawAmt <= maxWithdrawAmt))));
								
			}
			else 
			{
				System.out.println("\nInvalid Account Number! Please enter the correct Account Number.");
			}
		}while(enteredAccNo != acc.getAccNo());
	
		System.out.println("Money Withdrawl");
	}
	
	public void balanceCheck() {
		
		int enteredAccNo;
		do {
			System.out.print("\nEnter Account Number : ");
			enteredAccNo = sc.nextInt();
			
			if(enteredAccNo == 0) {
				System.out.println("\n📢 Oops! It looks like you haven't created an account yet.");
				System.out.println("💡 Tip: Choose '1' to open a new account and enjoy our services!");
				break;
			}
			else if(enteredAccNo == acc.getAccNo()) {
				System.out.println("\n💰 Your Current Balance: ₹" + acc.getBalance());	
			}else {
				System.out.println("Invalid Account Number! Please enter the correct Account Number.");
			}
			
		}while(enteredAccNo != acc.getAccNo());
	}

}

