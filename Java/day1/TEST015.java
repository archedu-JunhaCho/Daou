// TEST015.java
public class TEST015{
	public static void main(String[] args){
		int year = 100, money = 100;
		double total = 100, rate = 0.066;
		
		for (int i = 0; i < year; i++){
			total *= ( 1 + rate );
		}
		System.out.println(total);
	}
}