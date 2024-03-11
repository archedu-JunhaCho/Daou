class Note {
	private int idx;
	private String note;
	
	Note() {
		idx = 0;
		note = "None";
	}
	
	String getNote() {
		String tmp;
		tmp = note;
		return tmp;
	}
	
	String setNote(String input) {
		note = input;
		return "";
	}
}


public class TEST038 {
	public static void main(String[] args) {
		Note nt = new Note();
		System.out.println(nt.getNote());
		nt.setNote("Hello");
		System.out.println(nt.getNote());
	} 
}