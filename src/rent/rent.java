package rent;

public class rent {
	private int rentid;
	private int price;
	private int deposite;
	private String from_date;
	private String to_date;
	private int customer_id;
	private String customer_name;
	private String customer_nrc;
	private int property_id;
	private String name;
	private String property_address;
	private int owner_id;
	private String owner_name;
	private String owner_nrc;
	
	public rent() {
		rentid=0;
		price=0;
		deposite=0;
		from_date=null;
		to_date=null;
		customer_id=0;
		property_id=0;
	}
	public rent(int rentid,int customer_id,int property_id, int price, int deposite, String from_date, String to_date) {
		super();
		this.rentid = rentid;
		this.customer_id = customer_id;
		this.property_id = property_id;
		this.price = price;
		this.deposite = deposite;
		this.from_date = from_date;
		this.to_date = to_date;

	}
	public rent(int price, int deposite, String from_date, String to_date,int customer_id,int property_id ) {
		super();
		this.price = price;
		this.deposite = deposite;
		this.from_date = from_date;
		this.to_date = to_date;
		this.customer_id = customer_id;
		this.property_id = property_id;

	}

	public rent(int rentid,String owner_name,String customer_name,int price, int deposite, String from_date, String to_date,String name,String property_address) {
		super();
		this.rentid=rentid;
		this.name=name;
		this.owner_name=owner_name;
		this.customer_name=customer_name;
		this.price = price;
		this.deposite = deposite;
		this.from_date = from_date;
		this.to_date = to_date;
		this.property_address=property_address;
	

	}
	public rent(int customerid,String customername,String customernrc) {
		customer_id=customerid;
		customer_name=customername;
		customer_nrc=customernrc;
		
	}
	public rent(String name,String ownername,String ownernrc,int price,String property_address) {
		this.name=name;
		owner_name=ownername;
		owner_nrc=ownernrc;
		this.price=price;
		this.property_address=property_address;
	}
	
	public String getProperty_address() {
		return property_address;
	}
	public void setProperty_address(String property_address) {
		this.property_address = property_address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRentid() {
		return rentid;
	}
	public void setRentid(int rentid) {
		this.rentid = rentid;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDeposite() {
		return deposite;
	}
	public void setDeposite(int deposite) {
		this.deposite = deposite;
	}
	public String getFrom_date() {
		return from_date;
	}
	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}
	public String getTo_date() {
		return to_date;
	}
	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getProperty_id() {
		return property_id;
	}
	public void setProperty_id(int property_id) {
		this.property_id = property_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCustomer_nrc() {
		return customer_nrc;
	}
	public void setCustomer_nrc(String customer_nrc) {
		this.customer_nrc = customer_nrc;
	}
	public int getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(int owner_id) {
		this.owner_id = owner_id;
	}
	public String getOwner_name() {
		return owner_name;
	}
	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	public String getOwner_nrc() {
		return owner_nrc;
	}
	public void setOwner_nrc(String owner_nrc) {
		this.owner_nrc = owner_nrc;
	}
	
	
	

}
