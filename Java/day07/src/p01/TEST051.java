// string vs string buffer
package p01;

public class TEST051 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		sb.append("Hello");
		sb.append(" ");
		sb.append("World");
		System.out.println(sb);
		String s = sb.toString();
		System.out.println(s);
	}
}
