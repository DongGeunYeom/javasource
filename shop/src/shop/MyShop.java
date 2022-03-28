package shop;

import java.util.Scanner;

public class MyShop implements IShop {
	
	private Scanner sc = new Scanner(System.in);

	private String title;
	private User users[] = new User[2];
	
	private Product products[] = new Product[5];
	private Product carts[] = new Product[10];
	
	//계정 선택에서 선택한 사용자 정보 담기
	private int selUser;
	
	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public void genUser() {
		// User 객체를 이용해서 2개 생성
		// User 생성 후 배열에 담기
		users[0] = new User("홍길동", PayType.CARD); 		
		users[1] = new User("성춘향", PayType.CASH); 		
	}

	@Override
	public void genProduct() {
		// 핸드폰 3개 생성, 스마트 TV 2개 생성
		products[0] = new CellPhone("갤럭시22", 1500000, "SKT");
		products[1] = new CellPhone("아이폰12", 1200000, "KT");
		products[2] = new CellPhone("아이폰XS", 900000, "LGU");
		products[3] = new SmartTV("LG나노젤", 1500000, "4K");
		products[4] = new SmartTV("삼성울트라HD", 1000000, "Full HD");
	}
	
	

	@Override
	public void start() {
		System.out.println(title+" : 메인 화면 - 계정 선택");
		System.out.println("==============================");
		for(int i = 0; i<users.length; i++) {
			System.out.printf("[%d] %s(%s)\n",i,users[i].getName(),users[i].getPayType());	
		}
		
//		 int i = 0;
//		 for(User user:users){
//		 System.out.printf("[%d] %s(%s)\n",i++, user.getName(), user.getPayType());
//			}
	
		System.out.println("[x] 종 료");
		System.out.print("선택 : ");
		String choice = sc.nextLine();
		System.out.println("###### "+choice+" 선택######");

		// input : 0, 1, x
		// switch 
		// 0, 1 => 위 출력문 보여주고, productList() 호출
		// x(X) => 프로그램 종료
		// 다른게 입력되면 => 입력값을 확인해 주세요
		//					  계정선택 화면 보여주기
		
		
		switch(choice) {
		case "0" : case "1":
			selUser = Integer.parseInt(choice);
			productList();
			break;
		case "x"  : case "X":
			System.out.println("프로그램이 종료되었습니다.");
			break;
		default :
			System.out.println("입력값을 확인해 주세요.");
			start();
			break;			
		}
		sc.close();
	}
	
	public void productList() {
		System.out.println(title+" : 상품 목록 - 상품 선택");
		System.out.println("==============================");
		 
		int i = 0;
			 for(Product product:products){
				 System.out.printf("[%d]", i++);
				product.printDetail();
			 } 

		System.out.println("[h] 메인 화면");
		System.out.println("[c] 체크 아웃");
		System.out.print("선택 : ");
		String choice = sc.nextLine();
		System.out.println("######"+choice+"선택######");	
		
		switch(choice) {
		case "0" : case "1" : case "2" : case "3" : case "4" :
			for(int t = 0; t<=carts.length; t++){
				if(carts[t] == null) {
					carts[t] = products[Integer.parseInt(choice)];
					break;
				}
			}
			productList();
			break;
		case "h" :	case "H":
			System.out.println("메인 화면으로 넘어갑니다.");
			start();
			break;
		case "c"  : case "C":
			System.out.println("체크아웃 하셨습니다.");
			checkOut();
			break;
		default :
			System.out.println("입력값을 확인해 주세요.");
			productList();
			break;			
		}		
		sc.close();
	}
	
	
	public void checkOut() {
		System.out.println(title+" : 체크아웃");
		System.out.println("==============================");
		int i = 0;
		int sum = 0;
		for(Product p:carts) {
			if(p!=null) {
				System.out.printf("[%d] %s(%d)\n",i++,p.getName(),p.getPrice());
				sum += p.getPrice();
			}
		}
		System.out.println();
		System.out.println("==============================");
		System.out.println("결제 방법 : "+users[selUser].getPayType());
		System.out.println("합계 : "+sum+"원 입니다.");
		System.out.println("[p]이전 , [q] 결제 완료");
		System.out.print("선택 : ");
		String choice = sc.nextLine();
		System.out.println("######"+choice+"선택######");
		
		switch(choice) {
		case "p": case "P":
			productList();
			break;		
		case "q": case "Q":
			System.out.println("결제가 완료되었습니다.");
			break;
		default :
			System.out.println("입력값을 확인해 주세요.");
			checkOut();
			break;	
		}
		sc.close();
	}
}

