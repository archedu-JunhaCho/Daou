// Call setting and Do
package p02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Method;


interface ILogic {
	public void work();
}
class Logic1 implements ILogic {
	public void work(){
		System.out.println("Logic 1");
	}
}

public class TEST072 {
	public static void main(String[] args) throws Exception{
		BufferedReader bin = new BufferedReader(new FileReader("C:\\Users\\TECH2-16\\Desktop\\config.data"));
		String line = bin.readLine();
		String doit = bin.readLine();
		Class <?> cls = Class.forName(line);
		
		Method[] mtds = cls.getMethods();
		for (int i = 0; i < mtds.length; i++) {
			if(mtds[i].getName().equals(doit)) {
				System.out.println(">> " + mtds[i]);
				ILogic logic = (ILogic)cls.newInstance();
				logic.work();
				mtds[i].invoke(cls.newInstance());
			}
		}
		
		bin.close();
	}
}
