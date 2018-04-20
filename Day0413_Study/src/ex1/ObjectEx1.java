package ex1;

public class ObjectEx1 {
	public static void main(String[] args) {
		// 자식클래스의 객체를 부모클래스의 참조변수에 참조 시키기
		Car c1 = new SportsCar();
		Car c2 = new Bus();

		if(c2 instanceof SportsCar) {
			SportsCar sc = (SportsCar)c2;
			sc.turboOff();
			sc.turboOn();
			System.out.println(sc);
		}
		else if(c2 instanceof Bus){
			Bus bus = (Bus)c2;
			bus.switchGate();
			System.out.println(bus);
		}
		// instanceof : 인스턴스가 어느 클래스의 객체인지 확인할 때 사용 ( 상속관계에서  ex : 다수상속 )
	}
}