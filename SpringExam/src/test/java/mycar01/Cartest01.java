package mycar01;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Cartest01 {

	@Test
	public void 자동차에_장착된_타이어_브랜드_테스트() {
		System.out.println("테스트 입니다.");
		Car car = new Car();
		assertEquals("현재 장착된 타이어는 한국에서 만든 타이어", car.getTireBrand());
	}

}
