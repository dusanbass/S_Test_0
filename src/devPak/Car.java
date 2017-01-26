package devPak;

public class Car {
	private int id;
	private String make;
	private String type;
	private String img;
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Car(String make, String model) {
		super();
		this.make = make;
		this.type = model;
	}
	public Car(String make, String model, String img) {
		super();
		this.make = make;
		this.type = model;
		this.img = img;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}

	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", make=" + make + ", type=" + type + ", img=" + img + "]";
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
