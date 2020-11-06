package mycar02;

public class Driver {

	//스프링 없이 의존성 주입하기 : 생성자를 통한 의존성 주입
	public static void main(String[] args) {
		
		//Tire tire = new AmericaTire();
		Tire tire = new KoreaTire();
		Car car = new Car(tire);
		
		System.out.println(car.getTireBrand());
	}

}
