package KihyeonPark;
import java.util.Random ;
import java.util.Vector;
import KihyeonPark.DisplayCase.product;

public class Guest {
	int money ;
	boolean Need_plasticbag ;
	Vector<Product> list ;
	static int wait_time = 5 ;
	static int product_size = 5 ;
	
	Guest(){
		money = 100000 ;
		list = new Vector<Product>() ;
		Shopping_Time() ;
		Demand_Item() ;
	}
	
	void Put_stuff(Product stuff){
		list.addElement(stuff);
	}
	
	void Shopping_Time(){
		Random product_ran = new Random() ;
		try {
			Thread.sleep((product_ran.nextInt(wait_time)+1)*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void Demand_Item(){
		Random product_ran = new Random() ;

		product[] item_ = product.values() ;
		for(int i=0 ; i< item_.length ; i++){
			Product item = new Product(item_[i]);
			int num_of_item = product_ran.nextInt(product_size) ;
			item.SetNumber(num_of_item);
			Put_stuff(item) ;
		}
		
		if(product_ran.nextInt(2) == 0 )
			Need_plasticbag = false ;
		else
			Need_plasticbag = true ;
	}
	
	Product index_of_item(int index){
		return list.get(index) ;
	}
	
	int index_numofitem(int index){
		return index_of_item(index).getNumber();
	}
	
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
