package second_part;

import java.util.*;

public class Competition {
	private String name=null;
	private Integer number=0;
	private String content=null;
	private Boolean avalible=false;
	
	public Competition() {
	}
		
	public Competition(String name, String content) {
		super();
		this.name = name;
		this.content = content;
	}
	
	//������Ա��Ϣ
	private List<Users> usersList=new ArrayList<Users>();
	
	public List<Users> getUsersList() {
		return usersList;
	}
	
	public void setUsersList(List<Users> usersList) {
		this.usersList = usersList;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Boolean getAvalible() {
		return avalible;
	}
	
	public void setAvalible(Boolean avalible) {
		this.avalible = avalible;
	}
	
	
	@Override
	public String toString() {
		return "Competition [�������ƣ�" + name + "\t��������" + content + "\t����״̬" + avalible + "]";
	}
}