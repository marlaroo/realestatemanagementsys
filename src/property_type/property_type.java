package property_type;

public class property_type {
	private int typeid;
	private String name;
	private String description;
	
	public property_type() {
		typeid=0;
		name=null;
		description=null;
	}
	public property_type(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	public property_type(int typeid, String name, String description) {
		super();
		this.typeid = typeid;
		this.name = name;
		this.description = description;
	}

	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}



}
