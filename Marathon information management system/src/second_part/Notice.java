package second_part;

public class Notice {
	private String name=null;
	private String content=null;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "notice [�������ƣ�" + name + "\t�������ݣ�" + content + "]";
	}
}