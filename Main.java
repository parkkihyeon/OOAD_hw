package KihyeonPark;

import java.util.Random;

public class Main {
	
	static Gui ui = new Gui();
	static Cashier cashier = new Cashier() ;	
	static int guest_number = 1 ;
	
	static void Cutomer_Comein(){
		Random random_second = new Random() ;
		int time = random_second.nextInt(5) ;
		Util.Delay_time(time) ;
	}
	
	static Guest Customer_doing(){
		Cutomer_Comein();
		Gui.GetDashboard().append("손님"+ guest_number++ +" 이 입장하였습니다.\n");
		Guest guest = new Guest() ;
		Gui.GetDashboard().append("(계산을 시작하시오)\n");
		return guest ;
	}
	
	static void Refresh_window(int price) {
		Gui.Gettf2().setText(String.valueOf(cashier.pos.getNowMoney())+"원");
		Gui.Gettf().setText(String.valueOf(price+"원"));	
	}
	
	public static void main(String[] args)
	{	
		DataBase db = new DataBase() ;
		while(true){		
			cashier.selling(Customer_doing());
			Refresh_window(cashier.pos.getSumMoney()) ;		
			
		}
	}
}
