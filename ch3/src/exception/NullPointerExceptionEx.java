package exception;

public class NullPointerExceptionEx {
	public static void main(String[] args) {
		Account[] account = new Account[2];
		System.out.println(account[0]);
//		System.out.println(account[0].depNumber);
		
		try {
			System.out.println(account[0].depNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
