package KihyeonPark;
import KihyeonPark.Util.product;

class Product {
	private String name ;
	private String Barcord ;
	private int number ;
	
	Product(product product_num){
		switch(product_num){
			case icecream:
			{
				name = "icecream" ;
				Barcord = "97888963420705" ;
				break;
			}
			case snack:
			{
				name = "snack" ;
				Barcord = "97888963420715" ;
				break;
			}
			case gum:
			{
				name = "gum" ;
				Barcord = "97888963420725" ;
				break;
			}
			case cigarret:
			{
				name = "cigarret" ;
				Barcord = "97888963420735" ;
				break ;
			}
			case kimbab:
			{
				name = "kimbab" ;
				Barcord ="97888963420745" ;
				break;
			}
			case tissue:
			{
				name = "tissue" ;
				Barcord ="97888963420755" ;
				break;
			}
			case water:
			{
				name = "water" ;
				Barcord = "97888963420765" ;
				break;
			}
			default:
				break;	
		}
		number = 0 ;
	} 
	
	String getName(){
		return name ;
	}
	
	String getBarcord(){
		return Barcord ;
	}
	
	int getNumber(){
		return number ;
	}
	
	void SetName(String name){
		this.name = name ;
	}
	
	void SetBarcord(String barcord){
		this.Barcord = barcord ;
	}
	
	void SetNumber(int num){
		this.number = num ;
	}
	
	void Show_print(){
		System.out.println("name : " + this.name);
		System.out.println("barcord : " + this.Barcord);
		System.out.println("number : " + this.number);
		System.out.println() ;
	}
} ;

