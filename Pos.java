package KihyeonPark;

import KihyeonPark.DataBase.product;

public class Pos {
	private int num_of_product;
	static private int sum_of_money;
	private int now_money;
	static boolean running;
	Guest guest;

	Pos() {
		num_of_product = DataBase.getNum_of_product();
		sum_of_money = 0;
		now_money = 0;
	}

	static void Request_Item(){
		try{
			int purchasing_numofItem = Integer.parseInt(Stock_gui.getAdd_item().getText()) ;
			product select_itemnum = product.valueOf((String) Stock_gui.getComboBox().getSelectedItem()) ; 
			DataBase.SetItem(select_itemnum, -purchasing_numofItem);
		}
		catch(Exception e){System.out.println(e);} ;
	}
	
	int getSumMoney() {
		return sum_of_money;
	}

	int getNowMoney() {
		return now_money;
	}

	// pos로 아이템을 계산하는 과정.
	int Calculate_item(Guest guest) {
		int total_price = 0;

		for (int i = 0; i < num_of_product; i++) {
			int Barcode_num = Doing_Barcode(guest, i).ordinal();
			int num_of_item = guest.getnum_itemof(Barcode_num);
			int price_of_item = DataBase.getElementPrice(Barcode_num);
			int sum = num_of_item * price_of_item;
			
			if (sum == 0) continue;
			
			Gui.Waiting_Barcord() ;
			DataBase.SetItem(Doing_Barcode(guest, i), num_of_item);
			Gui.GetDashboard().append(DataBase.getBarcord(Barcode_num) + "(" + Doing_Barcode(guest, i) + ") : " + sum + "원 " + "\n");
			total_price += sum;
		}
		return total_price;
	}

	void ChangingGuest(Guest guest) {
		this.guest = guest;
	}

	void Receive_Cash(int price) {
		sum_of_money += price;
		now_money = price;
	}

	void Receive_Card(int price) {
		sum_of_money += price;
		now_money = price;
	}
		
	// 바코드를 찍는 과정
	product Doing_Barcode(Guest guest, int item_index) {
		product item = null;
		try {
			for (int j = 0; j < num_of_product; j++) {
				if (guest.getItem_ofindex(item_index).getBarcord() == (DataBase.getBarcord(j))) {
					switch (j) {
					case 0:
						return product.icecream;
					case 1:
						return product.snack;
					case 2:
						return product.gum;
					case 3:
						return product.cigarret;
					case 4:
						return product.kimbab;
					case 5:
						return product.tissue;
					case 6:
						return product.water;
					default:
						return item;
					}
				}

			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return item;
	}
}
