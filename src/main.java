import java.util.Random;
import java.util.Scanner;
public class main {
	public static void main(String[] args) {
	int money=100;
	int weitermachen=0;
	int anzahlzüge=0;
	
	while(money>0 && weitermachen != 2){
		int einsatz;
		int sumeSpieler=0;
		int sumeBank=0;
		int zug=0;
		
		System.out.println("Your total amount of money: "+money); 
		Random cardwert = new Random();
		int[] card = new int[]{2,3,4,5,6,7,8,9,10,10,10,10,11};
		Scanner input = new Scanner(System.in);
		System.out.println("Place you bet please?");
		einsatz = input.nextInt();
		
		while(sumeBank<17){
			int arraywert = cardwert.nextInt(12);
			sumeBank = sumeBank+card[arraywert];
		}		
		if(zug==0){				
			int y;				
			Scanner input2 = new Scanner(System.in);
			System.out.println("Do you want a card (Press 1 for Yes, 2 for No)");
			y = input2.nextInt();
			while(y==1){
				int arraywert = cardwert.nextInt(12);
				if(card[arraywert]==11){
					int a;
					Scanner input3 = new Scanner(System.in);
					System.out.println("You have an ace, do you want to let it count as 11(Press 1) or as 1(Press 2)?");
					a = input3.nextInt();
					if(a==1){
						card[arraywert]=11;
					}
					if(a==2){
						card[arraywert]=1;
					}
				}
				sumeSpieler = sumeSpieler+card[arraywert];
				System.out.println("Your total card value is (values of all cards you got counted together): "+sumeSpieler+"");
				if(sumeSpieler<=21){
					System.out.println("Do you want another card (Press 1 for Yes, 2 for no)");
					y = input2.nextInt();
				}
				if(sumeSpieler>21){
					System.out.println("Unfortunatly you total cardvalue is over 21 (not good)");
					y=2;
				}
				if(y==2){
					zug++;
					System.out.println("your total cardvalue is: "+sumeSpieler+"");
				}
			}	
			anzahlzüge++;
		}
		if(((sumeSpieler > sumeBank)&& sumeSpieler<22 )|| ((sumeBank > 21)&&(sumeSpieler <22))){
			money = money + einsatz;
			System.out.println("The bank had a total cardvalue of "+sumeBank);
			System.out.println("You won. Your total amount of money is: "+money);
		}
		else if(sumeSpieler==sumeBank){
			System.out.println("It's a tie. Your amount of money is still: "+money);
		}
		else {
			money = money-einsatz;
			System.out.println("The bank had a total card value of "+sumeBank);
			System.out.println("You lost. Your amount of money is: "+money);			
		}
		Scanner input3 = new Scanner(System.in);
		System.out.println("Do you want carry on playing? Yes:1 No:2");
		weitermachen = input3.nextInt();
	  }
	System.out.println("The game is over. Your amount of money is: "+money);
	System.out.println("Btw you lastet for: "+anzahlzüge+" rounds");
   }
}
