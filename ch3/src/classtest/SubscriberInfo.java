package classtest;

public class SubscriberInfo {
		// 속성 : 이름, 아이디, 패스워드, 전화번호, 주소
	
	String userName;
	String userId;
	String userPassword;
	String userNumber;
	String userAddress;
	
		// 기능 : 비밀번호 변경, 전화번호 변경, 주소 변경
	// 비밀번호 변경 : 새로운 비밀번호를 입력받아 기존 비밀번호 변경
	void changePassword(String newPassword) {
		this.userPassword = newPassword;
	}
	
	// 전화번호 변경 : 새로운 전화번호를 입력받아 기존 비밀번호 변경
	void changeNumber(String newNumber) {
		this.userNumber = newNumber;
	}
	
	// 주소 변경 : 새로운 주소를 입력받아 기존 비밀번호 변경
	void changeAddress(String newAddress) {
		this.userAddress = newAddress;
	}

	public SubscriberInfo() {
		super();
	}

	public SubscriberInfo(String userName, String userId, String userPassword) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.userPassword = userPassword;
	}

	public SubscriberInfo(String userName, String userId, String userPassword, String userNumber, String userAddress) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.userPassword = userPassword;
		this.userNumber = userNumber;
		this.userAddress = userAddress;
	}

	
	
}
