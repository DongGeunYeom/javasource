package interfacetest2;

public class SoundableEx {
	
	public String msg;

	public static void main(String[] args) {
		printSound(new Dog());
		printSound(new Cat());
		
	}
	
	private static void printSound(Soundable soundable) {
		System.out.println(soundable.sound());
	}
	
}
