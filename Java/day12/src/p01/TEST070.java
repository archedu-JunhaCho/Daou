// create instance
package p01;

class Apple {
	int data = 1;
}

public class TEST070 {
	public static void main(String[] args) throws Exception {
		Class <?> cls = Class.forName("p01.Apple");
		Object obj = cls.newInstance();
		Apple a2 = (Apple) cls.newInstance();
		Apple a = (Apple)obj;
		
		System.out.println(cls);
		System.out.println(obj);
		System.out.println(a.data);
	}
}
