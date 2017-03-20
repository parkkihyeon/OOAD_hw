package KihyeonPark;

import java.util.Random;

public class Main {
	
	static Gui ui = new Gui();
	static Cashier cashier = new Cashier(ui) ;	
	
	static void Delay_time(int time){
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void Cutomer_Comein(){
		Random random_second = new Random() ;
		int time = random_second.nextInt(5) ;
		Delay_time(time) ;
	}
	
	static Guest Customer_doing(){
		Cutomer_Comein();
		ui.GetDashboard().append("손님이 입장하였습니다.\n");
		Guest g = new Guest() ;
		ui.GetDashboard().append("(계산을 시작하시오)\n");
		
		return g ;
	}
	
	public static void main(String[] args)
	{
		while(true){		
			cashier.selling(Customer_doing());
			int Total_price = cashier.pos.getSumMoney() ;		
			ui.Gettf().setText(String.valueOf(Total_price));	
		}
	}
}
