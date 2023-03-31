package demohello.Entity;

public class Categorys {
	private Integer id;
	private String name;
	private String description;


	public Categorys() {
		super();
	}
	public Categorys(int id,String name, String description ) {
		this(name,description);
		this.id=id;
		
		
	}
	public Categorys(String name, String description ) {				
		this.name=name;
		this.description=description;
	}




	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
