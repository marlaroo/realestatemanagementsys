package Owner;


public class owner {
	private int ownerid;
	private String ownername;
	private String owner_nrc;
	private String email;
	private String phone;
	private String address;
	
	public owner() {
		ownerid=0;
		ownername=null;
		owner_nrc=null;
		email=null;
		phone=null;
		address=null;
	}
	public owner(int ownerid) {
		this.ownerid=ownerid;
	}
	public owner(String ownername, String owner_nrc, String email, String phone, String address) {
		super();
		this.ownername = ownername;
		this.owner_nrc = owner_nrc;
		this.email = email;
		this.phone = phone;
		this.address = address;
		
	}
	public owner(int ownerid, String ownername, String owner_nrc, String email, String phone, String address) {
		super();
		this.ownerid = ownerid;
		this.ownername = ownername;
		this.owner_nrc = owner_nrc;
		this.email = email;
		this.phone = phone;
		this.address = address;
		
	}
	
	public int getOwnerid() {
		return ownerid;
	}
	public void setOwnerid(int ownerid) {
		this.ownerid = ownerid;
	}
	public String getOwnername() {
		return ownername;
	}
	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}
	public String getOwner_nrc() {
		return owner_nrc;
	}
	public void setOwner_nrc(String owner_nrc) {
		this.owner_nrc = owner_nrc;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
