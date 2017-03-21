package KihyeonPark;

import java.util.Vector;

public class DataBase {
	public static enum product{icecream, snack, gum, cigarret, kimbab, tissue, water} ; 
	private int num_of_product = 7 ;
	
	static private String icecream_bar = "97888963420705" ;
	static private String snack_bar = "97888963420715" ;
	static private String gum_bar = "97888963420725" ;
	static private String cigarret_bar = "97888963420735" ;
	static private String kimbab_bar = "97888963420745" ;
	static private String tissue_bar = "97888963420755" ;
	static private String water_bar = "97888963420765" ;

	static Vector<String> barcord = new Vector<String>() ;

	static private int []price = {1000,2000,500,4500,2500,700,600} ;
	static private int []num_of_item = {1000,1000,1000,1000,1000,1000,1000} ;
	
	DataBase(){
		barcord.addElement(icecream_bar);
		barcord.addElement(snack_bar);
		barcord.addElement(gum_bar);
		barcord.addElement(cigarret_bar);
		barcord.addElement(kimbab_bar);
		barcord.addElement(tissue_bar);
		barcord.addElement(water_bar);		
	} ;
	
	
	String getIce_bar(){return icecream_bar ;}
	String getSnack_bar(){return snack_bar ;}
	String getGum_bar(){return gum_bar ;}
	String getCi_bar(){	return cigarret_bar ;}
	String getKim_bar(){return kimbab_bar;}
	String getTis_bar(){return tissue_bar ;}
	String getWater_bar(){return water_bar ;}
	String getBarcord(int idnex){ return barcord.get(idnex) ; }
	
	int getIce_price(){	return price[product.icecream.ordinal()] ;}
	int getSnack_price(){return price[product.snack.ordinal()] ;}
	int getGum_price(){	return price[product.gum.ordinal()] ;}
	int getCi_price(){return price[product.cigarret.ordinal()] ;}
	int getKim_price(){	return price[product.kimbab.ordinal()] ;}
	int getTis_price(){	return price[product.tissue.ordinal()] ;}
	int getWater_price(){return price[product.water.ordinal()] ;}
	int getElementPrice(int index){ return price[index] ; }
	int getNum_of_product(){return num_of_product ; }
	
	static void Setnum_Icecream(int num) { num_of_item[product.icecream.ordinal()] -= num ; }
	static void Setnum_Snack(int num) { num_of_item[product.icecream.ordinal()] -= num ;}
	static void Setnum_Gum(int num) { num_of_item[product.icecream.ordinal()] -= num ;}
	static void Setnum_cigarret(int num) { num_of_item[product.icecream.ordinal()] -= num ;}
	static void Setnum_kimbab(int num) { num_of_item[product.icecream.ordinal()] -= num ;}
	static void Setnum_tissue(int num) { num_of_item[product.icecream.ordinal()] -= num ;}
	static void Setnum_water(int num) { num_of_item[product.icecream.ordinal()] -= num ;}
	public static void SetItem(product Item, int num)
	{
		switch(Item)
		{
		case icecream :
			Setnum_Icecream(num) ;
			break ;
		case snack :
			Setnum_Snack(num) ;
			break ;
		case gum :
			Setnum_Gum(num) ;
			break ;
		case cigarret :
			Setnum_cigarret(num) ;
			break ;
		case kimbab :
			Setnum_kimbab(num) ;
			break ;
		case tissue :
			Setnum_tissue(num) ;
			break ;
		case water :
			Setnum_water(num);
			break ;
		}
		
	}
	
	public static String Show_DB(){
		StringBuffer Show = new StringBuffer().append(" ") ;
		String temp ;
		
		Show.append("icecream : " + num_of_item[0]+"\n") ;
		Show.append("snack : " + num_of_item[1]+"\n") ;
		Show.append("gum : " + num_of_item[2]+"\n") ;
		Show.append("cigarret : " + num_of_item[3]+"\n") ;
		Show.append("kimbab : " + num_of_item[4]+"\n") ;
		Show.append("tissue : " + num_of_item[5]+"\n") ;
		Show.append("water : " + num_of_item[6]+"\n") ;
		temp = Show.toString() ;
		return temp ;
	}
	
}
