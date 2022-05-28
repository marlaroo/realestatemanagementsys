package customer;

public class customer {
	private int customerid;
	private String customername;
	private String customer_nrc;
	private String email;
	private String phone;
	private String address;
	public customer() {
		customerid=0;
		customername=null;
		customer_nrc=null;
		email=null;
		phone=null;
		address=null;
	}
	
	public customer(int customerid, String customername, String customer_nrc, String email, String phone,
			String address) {
		super();
		this.customerid = customerid;
		this.customername = customername;
		this.customer_nrc = customer_nrc;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
	public customer(String customername, String customer_nrc, String email, String phone,
			String address) {
		super();
		this.customername = customername;
		this.customer_nrc = customer_nrc;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
	
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getCustomer_nrc() {
		return customer_nrc;
	}
	public void setCustomer_nrc(String customer_nrc) {
		this.customer_nrc = customer_nrc;
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
