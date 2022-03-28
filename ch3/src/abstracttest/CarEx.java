package abstracttest;

public class CarEx {
	public static void main(String[] args) {
		// Car car = new Car();
		// Cannot instantiate the type Car

		// 다형성을 해결 할 객체 생성은 가능
		Car car = new SportsCar();
		car.startCar();
		car.drive();
		car.stop();
		car.turnOff();
		
		car = new Truck();
		car.startCar();
		car.drive();
		car.stop();
		car.turnOff();
	}

}
