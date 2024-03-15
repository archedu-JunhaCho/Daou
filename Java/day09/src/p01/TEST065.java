package p01;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TEST065 {
	public static void main(String[] args) {
		Set<String> st = new TreeSet<String>(); 
		st.add("AA");
		st.add("BB");
		st.add("CC");
		st.add("DD");
		
		Iterator<String> it = st.iterator();
		while(it.hasNext()) {
			String t = it.next();
			System.out.println(t);
		}
	}
}
