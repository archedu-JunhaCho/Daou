/** DTO ( VO ) **/
package dao;

public class TEST02VO {
	// Column
	private Integer no;
	private String the_time;
	private String data;
	// Getter Setter
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	
	public String getThe_time() {
		return the_time;
	}
	public void setThe_time(String the_time) {
		this.the_time = the_time;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	// Methods
	@Override
	public String toString() {
		return "{\n  no:" + no + ", \n  the_time:" + the_time + ", \n  data:" + data + "\n}";
	}

}
