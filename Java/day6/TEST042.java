interface Icalc {
	public int execute(int i);
}

class AddCalc implements Icalc {
	int seed;
	Addcalc(int i) {
		seed = i;
	}
	
	public int execute(int i) {
		return seed + i;
	}
}

public class TEST042 {
	public static void main(String[] args){
		Apple a = new Apple();
		a.print();
	}
}