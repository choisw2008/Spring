package mycar05;

import static org.junit.Assert.*;

import org.junit.Test;

import com.edu.mycar05.Car;
import com.edu.mycar05.KoreaTire;
import com.edu.mycar05.Tire;

public class CarTest {

	@Test
	public void 한국타이어_장착_테스트() {
		Tire tire1 = new KoreaTire();
		Car car1 = new Car();
		car1.setTire(tire1);
		assertEquals("장착된 타이어 : 한국에서 만든 타이어", car1.getTireBrand());
	}
	@Test
	public void 미국타이어_장착_테스트() {
		Tire tire2 = new KoreaTire();
		Car car2 = new Car();
		car2.setTire(tire2);
		assertEquals("장착된 타이어 : 한국에서 만든 타이어", car2.getTireBrand());
	}

}
