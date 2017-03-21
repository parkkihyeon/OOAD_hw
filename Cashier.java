package KihyeonPark;

public class Cashier
{
	Pos pos ;
	Cashier(){
		pos = new Pos() ;
	}
	
	// 현금과 카드중에 무엇을 쓸 것인지를 물어봄.
	void Card_or_Cash(Pos pos, Guest guest, int price){		
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
		
		Util.Delay_time(1) ;
		Gui.GetDashboard().append("총 가격은 " + total_price + "원 입니다.\n");
		Card_or_Cash(pos, guest, total_price) ;
		Gui.GetDashboard().append("감사합니다 안녕히 가세요\n");
		Gui.GetDashboard().append("\n");
		Util.Delay_time(1) ;
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