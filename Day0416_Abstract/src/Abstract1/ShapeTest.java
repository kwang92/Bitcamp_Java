package Abstract1;

import java.util.Random;

public class ShapeTest {
	public static void main(String[] args) {
		/*	1. 상속시, 자식클래스의 객체는 부모클래스의 참조변수에 참조 가능하다.
		 * 
		 *  2. 자식클래스의 객체가 부모클래스의 참조변수에 참조 되어 있으면
		 *     자식 클래스에서 새롭게 선언된 변수나, 메서드는 참조하지 못한다.
		 *     사용하려면 자식클래스로의 형변환이 필요하다.
		 *     
		 *  3. 자식클래스에서 부모클래스가 가지는 메서드를 재정의 하였다면 (오버라이딩 )
		 *     부모클래스의 참조변수에서 해당 메서드를 실행하더라도 
		 *     자식클래스의 오버라이딩 된 메서드가 실행된다.
		 * */
		
		Shape s = new Rectangle(5);	// 추상클래스의 객체 생성하는 방법
		System.out.println(s.calArea());
		Shape[] shape = new Shape[10];
		Random ran = new Random();
		
		for(int i = 0; i < 10; i++ ) {
			switch(ran.nextInt(3)) {
			case 0:
				shape[i] = new Rectangle(3);	// 생성자 메개변수 한개
				break;
			case 1:
				shape[i] = new Circle(4);	// 생성자 메개변수 한개
				break;
			case 2:
				shape[i] = new Triangle(5,2);	// 생성자 메개변수 두개
				break;
			}
		}/*
		for(int i = 0; i < 10; i++) {
			System.out.println(shape[i]);
		}*/
	}
}