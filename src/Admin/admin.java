package Admin;

public class admin {
	private int adminid;
	private String name;
	private String password;
	
	public admin()
	{
		adminid=0;
		name=null;
		password=null;
	}
	public admin(int adminid,String name,String password) {
		this.adminid=adminid;
		this.name=name;
		this.password=password;
	}
	public int getAdminid() {
		return adminid;
	}
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}
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
	
	
}
