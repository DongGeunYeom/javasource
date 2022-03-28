package api;

public class Value {
	int value;

	public Value(int value) {
		super();
		this.value = value;
	}
	
	@Override
	public boolean equals(Object obj) {
		// 주소비교가 아닌 값 비교 재정의
		
		// Object obj = value2;
		// obj instanceof Value : obj가 Value 객체로 변환할 수 있는지 확인

		if(obj instanceof Value) {
			Value v = (Value) obj;
			// 원래 타입으로 강제 형변환
			
			if(this.value == v.value) {
				return true;
			}
			
		}
		return false;
	}

	//인스턴스가 가지고 있는 문자열 반환
	@Override
	public String toString() {
		return "Value [value=" + value + "]";
	}

}


