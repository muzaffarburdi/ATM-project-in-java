package lab;

import java.util.InputMismatchException;
import java.util.Scanner;



abstract class atm {  // Abstraction 
	private String [] account = {"maju41204-1","maju41204-2","maju41204-3"};	
	private String [] pin = {"1233","1244","1255"};
	private long [] money = {10000,20000,3000};   // Encapsulation
	private String [] transfer = {"meezan123-1","hbl123-2","mcb123-3"};
	private String yes = "yes";
	int x = 0;
	
	boolean login(String loginaccount,String loginpin){
		for(int i = 0;i<account.length;i++){
			if(loginaccount.equals(account[i])&&loginpin.equals(pin[i])){
				x = (i);
				return true;
			}
		}
		return false;
	}

	public long[] getMoney() {
		return money;
	}

	public void setMoney(long[] money) {
		this.money = money;
	}
	
void transfer(){

	for(int i = 0;i<=transfer.length;i++){
		Scanner sc1 = new Scanner(System.in);
		System.out.print("Please Enter correct Account Number of the other party:");
		String taccount = sc1.next();
		System.out.print("Please Enter  the transfer amount:");
		int c = sc1.nextInt();
		if(taccount.equals(transfer[i])){
			if(i== i){
				if(c <= money[x]){
					System.out.println("Please check the account name:"+taccount);
					System.out.println("Are you sure to transfer money: yes / no?");
					String yesNo = sc1.next();
					if(yesNo.equals(yes)) {
						System.out.println(" Amount Transfer succeeded ");
						money[x]= money[x]-c;
						System.out.println("Your current balance is:"+money[x]);
						break;
					}else {
						System.out.println("--- Transfer failed ---");
						System.out.println("Your current balance is:"+money[x]);
						break;
					}
				}else {
					System.out.println("Transfer failed, your balance is insufficient !!");
					break;
				}
			}else{
				System.out.println("Account Number entered incorrectly! Cannot transfer money !!!");
				break;
			}
		}
		else if(i == 2){
			System.out.println("The Account Number you entered is wrong!");
			System.out.println("Please Try agian later!");
			break;
			
		}
		System.out.println("The Account Number you entered is wrong! or Amount!");	
		
	}
     
			
		
}
abstract void fastcash();
}
class fastcash extends atm {	// Inheritance
	void fastcash(){
		try {
	    Scanner sc = new Scanner(System.in);
		System.out.println("Please select choice:\n1. 500 withdrawal amount\n2. 1000 withdrawal amount\n3. 5000 withdrawal amount\n4. 10000 withdrawal amount\n5. 20000 withdrawal amount");
		System.out.print("Please enter choise:");
		int s = sc.nextInt();
		if (s>=1 &&  s<=5) {
		switch(s){
		case 1:
			int fastcash1=500;
			if(fastcash1 <= getMoney()[x]) {
				getMoney()[x] = getMoney()[x] - fastcash1;
				System.out.println("Withdrawal amount:"+fastcash1);
				System.out.println("balance:"+getMoney()[x]);
			}else {
				System.out.println("Insufficient balance");
			}
			
			break;
		case 2:
			int fastcash2=1000;
			if(fastcash2 <= getMoney()[x]) {
				getMoney()[x] = getMoney()[x] - fastcash2;
				System.out.println("Withdrawal amount:"+fastcash2);
				System.out.println("balance:"+getMoney()[x]);
			}else {
				System.out.println("Insufficient balance");
			}
			break;
		case 3:
			int fastcash3=5000;
			if(fastcash3 <= getMoney()[x]) {
				getMoney()[x] = getMoney()[x] -fastcash3;
				System.out.println("Withdrawal amount:"+fastcash3);
				System.out.println("balance:"+getMoney()[x]);
			}else {
				System.out.println("Insufficient balance");
			}
			break;
		case 4:
			int fastcash4=10000;
			if(fastcash4 <= getMoney()[x]) {
				getMoney()[x] = getMoney()[x] - fastcash4;
				System.out.println("Withdrawal amount:"+fastcash4);
				System.out.println("balance:"+getMoney()[x]);
			}else {
				System.out.println("Insufficient balance");
			}
			break;
		case 5:
			int fastcash5=20000;
			if(fastcash5 <= getMoney()[x]) {
				getMoney()[x] = getMoney()[x] - fastcash5;
				System.out.println("Withdrawal amount:"+fastcash5);
				System.out.println("balance:"+getMoney()[x]);
			}else {
				System.out.println("Insufficient balance or invalid input");
			}
			break;
		}
		
		}
                else {
                    System.out.println("---Invalid Input---");
                }
		}
		catch(InputMismatchException exception)
		{
		System.out.println("---Wrong Input---");	
		}
				
}
}


class withdraw extends fastcash{
	void withdraw(){
		Scanner sc5 = new Scanner(System.in);
		try {
		System.out.print("Enter the withdrawal amount:");
		int withdraw = sc5.nextInt();
		if(withdraw >=0) {
		if(withdraw <= getMoney()[x]) {
			getMoney()[x] = getMoney()[x] - withdraw;
			System.out.println("Withdrawal amount:"+withdraw);
			System.out.println("balance:"+getMoney()[x]);
		}else {
			System.out.println("Insufficient balance!!!");
		}
		}
		else {
			System.out.println("---Invalid Input---");
		}
		}
		catch(InputMismatchException exception)
		{
		System.out.println("---Wrong Input---");	
		}
	}
}
	
class deposit extends withdraw{
	void deposit() {
		try {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the deposit amount:");
		long deposit = sc.nextLong();
		if(deposit >=0) {
		getMoney()[x] = getMoney()[x] + deposit;
		System.out.println("The deposit amount is:"+deposit+"! Deposit successful!");
		System.out.println("The current balance is:"+getMoney()[x]);
	}
		else {
			System.out.println("---Invalid Input---");
		}
		}
		catch(InputMismatchException exception)
		{
		System.out.println("---Wrong Input---");	
		}
	}
	
	void cbalance() {
		System.out.println("The current balance is:");      // Polymorphism 
	}
		
	
}
class cbalance extends deposit{
	void cbalance() {
		System.out.println("The current balance is:"+getMoney()[x]);
	}
}


public class Main{
	public static void main(String[]args){
		cbalance a1 = new cbalance();
		System.out.println("----------ATM Project by Muzaffar Rafique Burdi & Karan Kumar----------");
		System.out.println("*********************** Welcome to MAJU ATM***********************");
		for(int i = 1;i <= 3;i++) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter your Bank Account Number:");
			String account= sc.next();
			System.out.println("Enter your Bank account PIN:");
			String pin= sc.next();
			while(a1.login(account, pin)){
				if(a1.login(account, pin)){
					try
					{
					System.out.println("Please select your choice: \n1. transfer \n2. Fast cash \n3. Withdrawal \n4. Deposit \n5.Check balance \n6. Exit");
                                        System.out.print("Please enter choise:");
					int number = sc.nextInt();
					if(number>=0 && number<=6) {
					switch(number){
					case 1:
						a1.transfer();
						break;
					case 2:
						a1.fastcash();
						break;
					case 3:
						a1.withdraw();
						break;
					case 4:
						a1.deposit();
						break;
					case 5:
						a1.cbalance();
						break;
					case 6:
						System.out.print("*** Thanks for using MAJU ATM ***");
						return;
						
					}
				}
				else {
						System.out.println("---Invalid Input---");
					
				}
			
			
		}
					catch(InputMismatchException exception)
					{
					System.out.println("---Wrong Input---");	
					}
					
				}
				
	}
	
	
	}
		System.out.println("Invalid Input");
    
}
}
