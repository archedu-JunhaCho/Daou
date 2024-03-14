// º¹½À
package p01;

interface IGreet {
	public String greet();
}

class StarDeco implements IGreet {
	private IGreet greet = null;
	StarDeco(IGreet ig){
		greet = ig;
	}
	public String greet() {
		return "*" + greet.greet() + "*";
	}
}
class SharpDeco implements IGreet {
	private IGreet greet = null;
	SharpDeco(IGreet ig){
		greet = ig;
	}
	public String greet() {
		return "#" + greet.greet() + "#";
	}
}
class HelloGreet implements IGreet {
	public String greet() {
		return "Hello Greet";
	}
	public String StarDeco() {
		return "*" + greet() + "*";
	}
	public String SharpDeco() {
		return "#" + StarDeco() + "#";
	}
}
class MerciGreet implements IGreet {
	public String greet() {
		return "Merci Greet";
	}
}

public class TEST056{
	public static void main(String[] args) {
		HelloGreet i = new HelloGreet();
		System.out.println(i.StarDeco());
		System.out.println(i.SharpDeco());
		IGreet ig = new SharpDeco(new StarDeco(new HelloGreet()));
		IGreet ig2 = new SharpDeco(new StarDeco(new MerciGreet()));
		System.out.println(ig.greet());
		System.out.println(ig2.greet());
	}
}
