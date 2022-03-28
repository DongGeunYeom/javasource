package extend;

/* 상속(extends) : 확장
 * 부모 (상위, super) 클래스
 * 자식(하위) 클래스
 * 클래스 재사용 => 중복을 줄여줌
 * 
 *  상속할 때 자식이 부모를 선택함
 *  private 접근 제한자를 갖는 필드, 메소드는 상속 불가
 *  상속은 하나의 클래스만 가능
 *  
 *  모든 클래스는 무조건 하나의 클래스를 상속 받음 => Object클래스
 *  
 *  하나의 클래스 안에 동일한 이름으로 여러 개 존재
 *  메소드 오버라이딩(메소드 재정의) - 상속인 경우에만
 *  - 부모가 넘겨주는 메소드를 자식 클래스에서 다시 정의하는 것
 *  - 우선되는 메소드는 자식 메소드가 우선함
 *  
 *  메소드 오버로딩 - 생성자, 메소드
 *  
 */ 


public class DMBCellPhoneEx {

	public static void main(String[] args) {
		DMBCellPhone dmb = new DMBCellPhone();
		
		dmb.model = "삼성";
		dmb.color = "black";
		dmb.channel = 7;
		
		dmb.powerOn();
		dmb.turnOn();
		dmb.changeChannel(11);
		dmb.turnOff();
		dmb.bell();
		dmb.sendVoice("여보세요");
		dmb.receiveVoice("안녕하세요");
		dmb.hangUp();
		
		}

}
