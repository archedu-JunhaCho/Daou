/** DTO ( VO ) **/
package dao;

public class TEST02VO_text {
	// Column
	private Integer text_no;
	private String content;
	private Integer recomm;
	
	// Getter Setter
	public Integer getText_no() { return text_no;}
	public void setText_no(Integer text_no) { this.text_no = text_no; }
	public String getContent() { return content; }
	public void setContent(String content) { this.content = content; }
	public Integer getRecomm() { return recomm; }
	public void setRecomm(Integer recomm) { this.recomm = recomm; }

	// Methods
	@Override
	public String toString() {
		return "TEST02VO_text {text_no:" + text_no + ", content:" + content + ", recomm:" + recomm + "}";
	}

}
