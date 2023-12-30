package foodcourt.controller;

import java.util.Scanner;

import foodcourt.dao.Crud;
import foodcourt.dto.User;

public class Controller {
	static Scanner scan=new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		Crud c=new Crud();
		boolean check=true;
		System.out.println("******************************welcome to hotel*******************");
		do {
			System.out.println("enter your choice");
			System.out.println("1.register\n2.login(after register only go for login to view food items)");
			int choice=scan.nextInt();
			switch(choice){
			case 1:{
				System.out.println("enter your name");
				String name=scan.next();
				System.out.println("enter gender ");
				String gender=scan.next();
				System.out.println("enter your age");
				int age=scan.nextInt();
				System.out.println("enter phno");
				int phno=scan.nextInt();
				System.out.println("enter email");
				String email=scan.next();
				System.out.println("enter password");
				String pwd=scan.next();
				System.out.println("how much money you keep in wallet");
				double wallet=scan.nextDouble();
				User u=new User(name,gender,age,phno,email,pwd,wallet);
				c.saveUser(u);
				}break;
			case 2:{
				System.out.println("enter email");
				String email=scan.next();
				System.out.println("enter password");
				String pwd=scan.next();
				User u=new User(email,pwd);
				boolean res=c.fetch(u);
				if(res==false)
					System.out.println("enter valid data");
				if(res==true) { 
				boolean ch=true;
				double bill=0;
				double balance=0;
				double wallet =c.userWallet(email);
				do{
					System.out.println("enter your choice");
					System.out.println("1.select item\n2.add amount to wallet\n3.exit");
					int s=scan.nextInt();
					switch(s) {
					case 1:{
						c.fetchFood();
						System.out.println("enter slno of which item you want");
						int n=scan.nextInt();
						System.out.println("how many quantity you want");
						int quantity=scan.nextInt();
						double item=c.item(n)*quantity;
						 wallet=c.userWallet(email);
						if(item>wallet) 
							System.out.println("no sufficient balance add amount to wallet");
						else if(wallet>=item) {
							bill=bill+item;
							/*System.out.println("bill is***********"+bill);*/
							System.out.println("your remaining balance is:"+(wallet-item));
							balance=wallet-item;
						c.walletUpdate(balance,email);
						}
						}break;
					case 2:{
						System.out.println("how much money you want to add");
						double money=scan.nextDouble();
						c.walletUpdate(wallet+money,email);
						System.out.println("amount added....");
						}break;
					case 3:{
							ch=false;
							//check=false;
							System.out.println("your bill is:"+bill);
							System.out.println("your remaining balance is:"+balance);
							System.out.println("-------------thank you-----------");
							c.walletUpdate(balance,email);
						 	}break;
					default:{
						System.out.println("enter valid data");
							}
							}
				}while(ch);
			}break;
			}
		default:{
			System.out.println("enter valid data");
			}
				}
		}while(check);
}
}

