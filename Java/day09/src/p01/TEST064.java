package p01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TEST064 {
	public static void main(String[] args) {
		// Linked
		System.out.println("===============");
		List<String> lst_Link = new LinkedList<String>();
		lst_Link.add("A");
		lst_Link.add("B");
		lst_Link.add("C");
		for (int i = 0; i < lst_Link.size(); i++) {
			System.out.println(lst_Link.get(i));
		}
		// Array
		System.out.println("===============");
		List<String> lst_Arr = new ArrayList<String>();
		lst_Arr.add("A");
		lst_Arr.add("B");
		lst_Arr.add("C");
		lst_Arr.add("B");
		lst_Arr.add("C");
		lst_Arr.remove("C");
		for (int i = 0; i < lst_Arr.size(); i++) {
			System.out.println(lst_Arr.get(i));
		}
	}
}
