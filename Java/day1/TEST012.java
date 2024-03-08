public class TEST012{
	public static void main(String[] args){
		System.out.println(10 + 10);
		System.out.println(10 + 10.0);
		System.out.println("s" + 10 + 10.0);
		System.out.println(true);
		
		double total = 100, ci = 0.066;
		total *= (1 + ci);
		System.out.println(total);
	}
}