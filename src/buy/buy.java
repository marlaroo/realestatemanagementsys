package buy;

public class buy {
	private int buyid;
	private int price;
	private String date;
	private int customer_id;
	private String customer_name;
	private String customer_nrc;
	private int property_id;
	private String property_name;
	private String property_address;
	private int owner_id;
	private String owner_name;
	private String owner_nrc;
	
	
	public buy() {
		buyid=0;
		price=0;
		date=null;
		customer_id=0;
		customer_name=null;
		customer_nrc=null;
		property_id=0;
		property_name=null;
		property_address=null;
		owner_id=0;
		owner_name=null;
		owner_nrc=null;
	}
	public buy(int buyid,String owner_name,String customer_name,int price, String date,String property_name,String property_address) {
		super();
		this.buyid=buyid;
		this.owner_name=owner_name;
		this.customer_name=customer_name;
		this.price=price;
		this.date=date;
		this.property_name=property_name;
		this.property_address=property_address;
	}
	
	public buy(int buyid,int propertyid,int customerid,int price,String date) {
		super();
		this.buyid = buyid;
		property_id = propertyid;
		customer_id = customerid;
		this.price = price;
		this.date = date;
	}
	public buy(int customerid,String customername,String customernrc) {
		customer_id=customerid;
		customer_name=customername;
		customer_nrc=customernrc;
	}
	public buy(String property_name,String owner_name,String owner_nrc,int price,String property_address) {
		this.property_name=property_name;
		this.owner_name=owner_name;
		this.owner_nrc=owner_nrc;
		this.price=price;
		this.property_address=property_address;
	}
	

	public String getProperty_name() {
		return property_name;
	}

	public void setProperty_name(String property_name) {
		this.property_name = property_name;
	}

	public String getProperty_address() {
		return property_address;
	}

	public void setProperty_address(String property_address) {
		this.property_address = property_address;
	}

	public String getOwner_name() {
		return owner_name;
	}

	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
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

	public String getOwner_nrc() {
		return owner_nrc;
	}

	public void setOwner_nrc(String owner_nrc) {
		this.owner_nrc = owner_nrc;
	}

	public int getBuyid() {
		return buyid;
	}

	public void setBuyid(int buyid) {
		this.buyid = buyid;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

}
