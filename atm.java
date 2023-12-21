package cpm.opps;

import java.util.HashMap;
import java.util.Scanner;

public class atm {

	public static void main(String[] args) {
		// install ATM
		ATMop obj = new ATMop();
	}

}

class Data{
	float balance;
}

// create constructor 
class ATMop{
	//create instance variable
//	float balance;
	Scanner sc = new Scanner(System.in);//Global object
	HashMap <Integer , Data > map = new HashMap<>();
	
	ATMop(){
	 System.out.println("welcome to our ATM");
	 op();
	}
	
	//create op() method and hash map because multi users thats why using hash map
	public void op() {
		System.out.println("enter your pin code:");
		int pincode = sc.nextInt();
		
		if(map.containsKey(pincode) == true) {
			Data obj = map.get(pincode);
			menu(obj);
		}
		else {
			System.out.println("*********************");
			System.out.println("please create account first");
			System.out.println("set your pin code:");
			int pin = sc.nextInt();
			Data obj = new Data();
			map.put(pin , obj);
			menu(obj);
		}
		
		
	}
	

	//create method and we take input and object
	
	public void menu(Data obj) {
		System.out.println("**********************");
		System.out.println("please enter vaild number: ");
		
		System.out.println("1 . Check balance");
		System.out.println("2 . deposit maney");
		System.out.println("3 . withdeaw maney");
		System.out.println("4 . check another account");//checking different pins
		System.out.println("5 . exit");
		
		//input for taking user
		
		int x = sc.nextInt();
		if(x==1) {
			check_balance(obj);
		}
		else if(x==2) {
			deposit(obj);
		}
		else if(x==3) {
			withdraw(obj);
		} 
		else if(x == 4) {
			op();
		}
		else if(x == 5) {
			System.out.println("thank you!!!!");
			}
		else {
			System.out.println("please enter vaild number");
			menu(obj);
		}
		
	}

	//create methods one by one
	
	public void check_balance(Data obj) {
		System.out.println("your balance " + obj.balance);
		menu(obj);
	}
	
	public void deposit(Data obj) {
		System.out.println("enter your amount");
		float a = sc.nextFloat();
		
		obj.balance = obj.balance + a; //add amount
		
		System.out.println("amount deposited successfully");
		menu(obj);
	}
	
	public void withdraw(Data obj) {
		System.out.println("enter your amount: ");
		float a = sc.nextFloat();
		if(obj.balance >= a) {
			 obj.balance = obj.balance - a; //take bal nd mins
				System.out.println("amount withdraw successfully");
		}
		else {
			System.out.println("insufficent balance");
		}
	   
		menu(obj);
	}
	
	

	
}
