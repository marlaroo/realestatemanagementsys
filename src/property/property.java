package property;

public class property {
	private int propertyid;
	private int ownerid;
	private int typeid;
	private String ownername;
	private String ownernrc;
	private String name;
	private String property_type;
	private String area;
	private int price;
	private String address;
	private String update;
	private String status;
	private String description;
	
	public property() {
		propertyid=0;
		name=null;
		ownername=null;
		ownernrc=null;
		property_type=null;
		area=null;
		price=0;
		update=null;
		address=null;
		status=null;
		description=null;
		
	}
	public property(String name,String area,int price,String address,String update,String status,String description) {
		this.name=name;
		this.area=area;
		this.price=price;
		this.address=address;
		this.update=update;
		this.status=status;
		this.description=description;
	}
	public int getOwnerid() {
		return ownerid;
	}
	public void setOwnerid(int ownerid) {
		this.ownerid = ownerid;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public property(int id,String name, String area, int price, String address,String update, String status, String description,String ownername) {
		super();
		propertyid=id;
		this.name=name;
		this.area = area;
		this.price = price;
		this.address = address;
		this.update=update;
		this.status = status;
		this.description = description;
		this.ownername=ownername;
	}
	public property(int id,String property_type, String area, int price, String address,String update, String status, String description,String ownername,String ownernrc) {
		super();
		propertyid=id;
		this.property_type=property_type;
		this.area = area;
		this.price = price;
		this.address = address;
		this.update=update;
		this.status = status;
		this.description = description;
		this.ownername=ownername;
		this.ownernrc=ownernrc;
	}
	
	public String getOwnernrc() {
		return ownernrc;
	}
	public void setOwnernrc(String ownernrc) {
		this.ownernrc = ownernrc;
	}
	public void setOwnername(String ownername) {
		this.ownername=ownername;
	}
	public String getOwnername() {
		return ownername;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProperty_type() {
		return property_type;
	}
	public void setProperty_type(String property_type) {
		this.property_type = property_type;
	}
	public String getUpdate() {
		return update;
	}
	public void setUpdate(String update) {
		this.update = update;
	}
	public int getPropertyid() {
		return propertyid;
	}
	public void setPropertyid(int propertyid) {
		this.propertyid = propertyid;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	

}
