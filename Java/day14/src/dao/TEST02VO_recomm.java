package dao;

public class TEST02VO_recomm {
	// Column
	private Integer text_no;
	private Integer user_id;
	private String the_time;
	
	// Getter Setter
	public Integer getText_no() { return text_no; }
	public void setText_no(Integer text_no) { this.text_no = text_no; }
	public Integer getUser_id() { return user_id; }
	public void setUser_id(Integer user_id) { this.user_id = user_id; }
	public String getThe_time() { return the_time; }
	public void setThe_time(String the_time) { this.the_time = the_time; }
	
	// Methods
	@Override
	public String toString() {
		return "TEST02VO_recomm {text_no:" + text_no + ", user_id:" + user_id + ", the_time:" + the_time + "}";
	}
	
		
}
