package KihyeonPark;

import java.util.Random;

public class Main {
	
	static Gui ui = new Gui();
	static Cashier cashier = new Cashier() ;	
	
	static void Cutomer_Comein(){
		Random random_second = new Random() ;
		int time = random_second.nextInt(5) ;
		Util.Delay_time(time) ;
	}
	
	static Guest Customer_doing(){
		Cutomer_Comein();
		Gui.GetDashboard().append("손님이 입장하였습니다.\n");
		Guest g = new Guest() ;
		Gui.GetDashboard().append("(계산을 시작하시오)\n");
		
		return g ;
	}
	
	public static void main(String[] args)
	{
		
		DataBase db = new DataBase() ;
		while(true){		
			cashier.selling(Customer_doing());
			int Total_price = cashier.pos.getSumMoney() ;		
			Gui.Gettf2().setText(String.valueOf(cashier.pos.getNowMoney())+"원");
			Gui.Gettf().setText(String.valueOf(Total_price+"원"));	
		}
	}
}
