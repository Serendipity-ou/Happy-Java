package second_part;

public class Users {
	private String name;
	private String password;
	private boolean avalible=true;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isAvalible() {
		return avalible;
	}
	
	public void setAvalible(boolean avalible) {
		this.avalible = avalible;
	}
	
	@Override
	public String toString() {
		return "Users [�û�����" + name + "\t���룺" + password + "\t״̬��" + avalible + "]";
	}

}
