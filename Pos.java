package KihyeonPark;

import KihyeonPark.DataBase.product;

public class Pos {
	private int num_of_product;
	static private int sum_of_money;
	static DataBase db;
	static Gui ui ;
	Guest guest;

	Pos(Gui ui) {
		db = new DataBase();
		num_of_product = db.getNum_of_product();
		sum_of_money = 0;
		this.ui = ui;
	}

	int getSumMoney() {
		return sum_of_money;
	}

	// pos로 아이템을 계산하는 과정.
	int Calculate_item(Guest guest) {
		int total_price = 0;

		for (int i = 0; i < num_of_product; i++) {
			int Barcode_num = Doing_Barcode(guest, i).ordinal();	
			int num_of_item = guest.index_numofitem(Barcode_num);
			int price_of_item = db.getElementPrice(Barcode_num);
			int sum = num_of_item * price_of_item;
			if(sum == 0 ) continue ;
			Calculation_time() ;
			ui.GetDashboard().append( db.getBarcord(Barcode_num) +"("+Doing_Barcode(guest, i) + ") : " + sum + "원,  " + "\n");
			total_price += sum;
		}
		return total_price;
	}

	void ChangingGuest(Guest guest) {
		this.guest = guest;
	}

	void Receive_Cash(int price) {
		sum_of_money += price;
	}

	void Receive_Card(int price) {
		sum_of_money += price;
	}

	void Calculation_time(){
	
	}
	
	// 바코드를 찍는 과정
	product Doing_Barcode(Guest guest, int item_index) {
		product item = null;
		try {
			for (int j = 0; j < num_of_product; j++) {
				if (guest.index_of_item(item_index).getBarcord() == (db.getBarcord(j))) {
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