package mycar03;

public class Car {
	Tire tire;

	//생성자 방식과 다른 부분
	public Tire getTire() { 
		return tire;
	}
	//생성자 방식과 다른 부분
	public void setTire(Tire tire) {
		this.tire = tire;
	}
	public String getTireBrand() {
		return "장착된 타이어 : " + tire.getBrand();
	}
	
}



