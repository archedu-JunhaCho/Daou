// exception
package exception;

class FuelException extends Exception{
	String code = "code setting";
	private static final long serialVersionUID = -7536894190840451795L;

	FuelException(String msg){
		super(msg);
	}
}

class Car {
	int fuel = 0;
	Car(int a){
		fuel = a;
	}
	void drive() throws FuelException{
		if(fuel == 0) {
			throw new FuelException("에러 발생!!");
		}
		System.out.println("9km gogo");
		fuel--;
	}
}


public class TEST067 {
	public static void main(String[] args){
		Car carA = new Car(10);
		for (;;) {
			try {
				carA.drive();
			}
			catch(FuelException e) {
				System.out.println("??" + e.code);
				break;
			}
		}
	}
}
