import java.util.Random;

public class pi{
	public static void main(String[] args){
		int i, cnt_true = 0, cnt_false = 0, r = 3, cnt = 1000000000;
		double x, y, result; 
		Random random = new Random();
		
		for (i = 0; i < cnt; i++){
			x = random.nextFloat() * r;
			y = random.nextFloat() * r;
			if(x*x + y*y <= r*r){
				cnt_true++;
			}
			else {
				cnt_false++;
			}
		}
		result = ((double) cnt_true / (cnt_true + cnt_false)) * 4;
		System.out.println("cnt_t : " + cnt_true + ", cnt_f : " + cnt_false);
		System.out.println("result : " + result);
	}
}
