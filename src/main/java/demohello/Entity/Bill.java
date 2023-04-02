package demohello.Entity;

public class Bill {

	private Integer id;
	private String user;
	private String phone;
	private String displayname;
	private String address;
	private double total;
	private int quanty;
	private String note;
	public Bill() {
		super();
	}
	 public Bill(Integer id, String user, String phone, String displayname, String address, double total,int quanty,String note) {
		    this.id = id;
		    this.user = user;
		    this.phone = phone;
		    this.displayname = displayname;
		    this.address = address;
		    this.total = total;
		    this.quanty = quanty;
		    this.note = note;
		  }
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}	
	public String getDisplayname() {
		return displayname;
	}
	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getQuanty() {
		return quanty;
	}
	public void setQuanty(int quanty) {
		this.quanty = quanty;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}
