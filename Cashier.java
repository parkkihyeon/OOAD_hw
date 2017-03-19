package KihyeonPark;

import KihyeonPark.DataBase.product;
import javax.swing.* ;

public class Cashier
{
	int num_of_product = 7 ;
	int sum_money = 0 ;
	static DataBase db = new DataBase() ;
	
	int Calculate_item(Guest guest){
		int total_price = 0 ;
		if(plastic_bag(guest)) total_price+= 100 ;
		
		for(int i=0 ; i<num_of_product ; i++){
			int Barcode_num = Doing_Barcode(guest,i).ordinal();
			int num_of_item = guest.index_numofitem(Barcode_num) ;
			int price_of_item = db.getElementPrice(Barcode_num) ;
			int sum = num_of_item * price_of_item ;
			total_price += sum ;
		}
		
		System.out.println("총 가격은 " + total_price + "원 입니다.");
		return total_price ;
	}
	
	boolean plastic_bag(Guest g){
		System.out.println("비닐봉지 필요하세요?"); 
		if(g.Need_plasticbag == true){
			System.out.println("네"); 
			return true ;
		}
		else {
			System.out.println("아니오"); 		
			return false;
		}
	}
	
	product Doing_Barcode(Guest guest, int item_index){
		product item = null ;
		try{
			for(int j=0; j<num_of_product ; j++){
				if(guest.index_of_item(item_index).getBarcord()==(db.getBarcord(j))){
					 switch(j){
					 case 0:
						 return product.icecream ;
					 case 1:
						 return product.snack ;
					 case 2:
						 return product.gum ;
					 case 3:
						 return product.cigarret ;
					 case 4:
						 return product.kimbab ;
					 case 5:
						 return product.tissue ;
					 case 6:
						 return product.water ;
					 default:
						 return item ;
					 }
				}

			}
		}
		catch(Exception e){
			System.out.println(e);
		} ;
		return item;
	}
	
	public static void main(String[] args)
	{
		// 실행
		
		Guest g = new Guest() ;
		Cashier c = new Cashier() ;
		
		c.Calculate_item(g);
		
	
	}
}