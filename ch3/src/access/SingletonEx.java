package access;

public class SingletonEx {

	public static void main(String[] args) {
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
		
		System.out.println(obj1 == obj2);
		
		Account account1 = new Account(null, "홍길동", 0);
		Account account2 = new Account(null, "김길동", 0);
		
		System.out.println(account1 == account2);

	}

}
