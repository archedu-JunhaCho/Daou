// setting class from Another File
package p01;

import java.io.BufferedReader;
import java.io.FileReader;

interface ILogic {
	public void work();
}
class Logic1 implements ILogic {
	public void work(){
		System.out.println("Logic 1");
	}
}

public class TEST071 {
	public static void main(String[] args) throws Exception{
		Class <?> cls = Class.forName("p01.Logic1");
		ILogic logic = (ILogic)cls.newInstance();
		logic.work();
		
		BufferedReader bin = new BufferedReader(new FileReader("C:\\Users\\TECH2-16\\Desktop\\config.data"));
		String line = bin.readLine();
		System.out.println(line);
		bin.close();
	}
}
