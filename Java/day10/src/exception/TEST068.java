// exception
package exception;

public class TEST068 {
	public static void main(String[] args){
		Car carA = new Car(10);
		try {
			for (;;) {carA.drive();}
		}
		catch(FuelException e) {
			System.out.println("??");
		}
	}
}
