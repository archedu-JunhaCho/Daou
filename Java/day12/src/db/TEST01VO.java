package db;

public class TEST01VO {
	String stId;
	public String getStId() {
		return stId;
	}
	public void setStId(String stId) {
		this.stId = stId;
	}

	String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	String addr;
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}

	// Constructor
	TEST01VO(){
		stId = name = addr = null;
	}
	
}
