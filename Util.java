package KihyeonPark;

public class Util {
	static enum product{icecream, snack, gum, cigarret, kimbab, tissue, water} ; 

	static void Delay_time(int time){
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void LitteDelay_time(int time){
		try {
			Thread.sleep(time*100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
