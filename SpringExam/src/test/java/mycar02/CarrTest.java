package mycar02;

import static org.junit.Assert.*;

import org.junit.Test;

public class CarrTest {

	@Test
	public void test() {
		Tire tire1 = new KoreaTire();
		Car car = new Car(tire1);
		assertEquals("장착된 타이어 : 한국에서 만든 타이어", car.getTireBrand());
	}
	@Test
	public void 미국타이어_장착_타이어브랜드_테스트() {
		Tire tire2 = new AmericaTire();
		Car car = new Car(tire2);
		assertEquals("장착된 타이어 : 미국에서 만든 타이어", car.getTireBrand());
	}
}
