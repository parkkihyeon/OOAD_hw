package KihyeonPark;
import java.util.Random ;
import java.util.Vector;
import KihyeonPark.Util.product;

public class Guest {
	int money ;
	boolean Need_plasticbag ;
	Vector<Product> item_list ;
	static int wait_time = 5 ;
	static int product_size = 8 ;
	
	Guest(){
		money = 100000 ;
		item_list = new Vector<Product>() ;
		Shopping_Time() ;
		Demand_Item() ;
	}
	
	// 아이템을 장바구니에 넣다
	void Put_stuff(Product stuff){
		item_list.addElement(stuff);
	}
	
	// 쇼핑 시간
	void Shopping_Time(){
		Random product_ran = new Random() ;
		Util.Delay_time(product_ran.nextInt(wait_time)+1);
	}
	
	// 장바구니에 담아 사는 것을 요청한다.
	void Demand_Item(){
		Random product_ran = new Random() ;
		product[] item_ = product.values() ;
		for(int i=0 ; i< item_.length ; i++){
			Product item = new Product(item_[i]);
			int num_of_item = product_ran.nextInt(product_size) ;
			num_of_item -= 3 ;
			if(num_of_item <= 0) num_of_item = 0 ;
			item.SetNumber(num_of_item);
			Put_stuff(item) ;
		}
		
		if(product_ran.nextInt(2) == 0 )
			Need_plasticbag = false ;
		else
			Need_plasticbag = true ;
	}
	
	// index번째의 장바구니에 있는 아이템을 리턴한다.
	Product getItem_ofindex(int index){
		return item_list.get(index) ;
	}
	
	// index번째의 장바구니에 있는 아이템의 갯수를 리턴한다.
	int getnum_itemof(int index){
		return getItem_ofindex(index).getNumber();
	}
	
	// 카드의 여부
	boolean IsCard(int price){
		Random Random_num = new Random() ;
		if(Random_num.nextInt(2) == 0 ){
			// 카드
			return true ;
		}
		else {
			money -= price ;
			return false ;
			// 현금
		}
			
	}
}
