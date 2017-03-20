package KihyeonPark;

public class Cashier
{
	Pos pos ;
	Gui ui ;
	Cashier(Gui ui){
		this.ui = ui ;
		pos = new Pos(ui) ;
	}
	
	void Delay_time(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 현금과 카드중에 무엇을 쓸 것인지를 물어봄.
	void Card_or_Cash(Pos pos, Guest guest, int price){
//		ui.GetDashboard().append("카드로 하시겠습니까 현금으로 하시겠습니까\n");
		
		if(guest.IsCard(price)){
			pos.Receive_Card(price);
		}
		else 
			pos.Receive_Cash(price);
	}
	
	// 판매과정의 전반적인 프로세스 
	void selling(Guest guest){
		pos.ChangingGuest(guest);
		int total_price  = 0 ;
		if(plastic_bag(guest)) 
			total_price+= 100 ;
		total_price += pos.Calculate_item(guest) ;
		
		Delay_time() ;
		ui.GetDashboard().append("총 가격은 " + total_price + "원 입니다.\n");
		Card_or_Cash(pos, guest, total_price) ;
		ui.GetDashboard().append("감사합니다 안녕히 가세요\n");
		ui.GetDashboard().append("\n");
		Delay_time() ;
	}
	
	// 비닐봉지의 여부
	boolean plastic_bag(Guest g){
		if(g.Need_plasticbag == true){
			return true ;
		}
		else {
			return false;
		}
	}
	
	
}