public class ci{
	public static void main( String[] args ){
		int i, year = 100;
		double money = 300, total = 0, rate = 0.066;
		
		for (i = 0; i < year; i++){
			total += money;
			// if (i == year - 1){
				// break;
			// }
			total *= ( 1 + rate );
			System.out.println(i+1 + "년차 금액 : " + total);
		}
		System.out.println(total);
	}
}