package devPak;

public class Gear {
	private int id;
	private String name;
	public Gear() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Gear(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Gear(String name) {
		super();
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Gear [id=" + id + ", name=" + name + "]";
	}
	
	
}
