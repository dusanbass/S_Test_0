package devPak;

public class GearList {
	private int id_car;
	private int id_gear;
	public GearList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GearList(int id_car, int id_gear) {
		super();
		this.id_car = id_car;
		this.id_gear = id_gear;
	}
	public int getId_car() {
		return id_car;
	}
	public void setId_car(int id_car) {
		this.id_car = id_car;
	}
	public int getId_gear() {
		return id_gear;
	}
	public void setId_gear(int id_gear) {
		this.id_gear = id_gear;
	}
	@Override
	public String toString() {
		return "GearList [id_car=" + id_car + ", id_gear=" + id_gear + "]";
	}
	
	
}
