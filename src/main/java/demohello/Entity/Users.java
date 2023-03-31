package demohello.Entity;

public class Users {
	private Integer  id;
	private String user;
	private String password;
	private String displayname;
	private String address;
	private String vaitro;
	public Users() {
		super();
	}
	  public Users(Integer id, String user, String password, String displayname, String address, String vaitro) {
		    this.id = id;
		    this.user = user;
		    this.password = password;
		    this.displayname = displayname;
		    this.address = address;
		    this.vaitro = vaitro;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getVaitro() {
		return vaitro;
	}
	public void setVaitro(String vaitro) {
		this.vaitro = vaitro;
	}
}

