package book.controller;

import java.util.Scanner;

import book.vo.Beginner;
import book.vo.Comic;
import book.vo.Fiction;
import book.vo.Genre;
import book.vo.User;

public class BookController {
	private Genre[] books;
	private int bookIndex;
	private Scanner sc;
	private User[] users;
	private int userIndex;
	private boolean isMembers;
	private int memberIndex;
	private int managerPasswords;

	public BookController() {
		super();
		books = new Genre[30];
		bookIndex = 0;
		sc = new Scanner(System.in);
		users = new User[100];
		userIndex = 0;
		isMembers = false;
		memberIndex = 0;
		managerPasswords = 1234;

		books[bookIndex++] = new Fiction("해리포터", "J.K.R", 9000, 30, "소설", "책갈피");
		books[bookIndex++] = new Beginner("컴퓨팅", "ㄱㄱㄱ", 15000, 10, "입문", "공책");
		books[bookIndex++] = new Comic("로어", "레이첼", 5000, 20, "만화", "해당 캐릭터 굿즈");
		books[bookIndex++] = new Fiction("스파이더맨", "아무개", 10000, 12, "소설", "책갈피");
		books[bookIndex++] = new Beginner("자바 입문", "자바맨", 20000, 10, "입문", "공책");
		books[bookIndex++] = new Comic("만화", "코믹맨", 15000, 20, "만화", "해당 캐릭터 굿즈");
		books[bookIndex++] = new Fiction("모순", "양귀자", 15000, 10, "소설", "책갈피");
		books[bookIndex++] = new Fiction("토지", "박경리", 20000, 20, "소설", "책갈피");
		books[bookIndex++] = new Beginner("자바", "이지스", 20000, 10, "입문", "공책");
		books[bookIndex++] = new Beginner("토익", "YBM", 15000, 15, "입문", "공책");
		books[bookIndex++] = new Comic("드래곤볼", "아키라", 30000, 15, "만화", "해당 캐릭터 굿즈");
		books[bookIndex++] = new Comic("원피스", "에이치로", 20000, 10, "만화", "해당 캐릭터 굿즈");

		// 비회원인 경우 비회원: memberIndex = 0
		users[userIndex++] = new User("비회원", "id0000", "pw0000", 0, "주소");

		// 임시 회원
		users[userIndex++] = new User("김가재", "ddd123", "1234", 20, "경기도", 1);
		users[userIndex++] = new User("박가재", "ppp123", "5678", 30, "서울시", 2);
		users[userIndex++] = new User("이가재", "lll123", "1111", 40, "광주시", 3);
		users[userIndex++] = new User("송가재", "sss123", "3333", 50, "부산", 1);
	}

	public void main() {
		while (true) {
			System.out.println("\n-------Book------\n");
			System.out.println("1. 직원 전용");
			System.out.println("2. 손님");
			System.out.println("0. 종료");
			System.out.print("선택 >>  ");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				empMenu();
				break;
			case 2:
				clientMenu();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}// main()

	public void empMenu() {
		System.out.print("관리자 비밀번호를 입력해 주세요 : ");
		int passwords = sc.nextInt();
		if (managerPasswords == passwords) {
			while (true) {
				System.out.println("\n---------- 직원 전용 ----------\n");
				System.out.println("1. 신규 상품 등록");
				System.out.println("2. 재고 변경");
				System.out.println("3. 상품 삭제");
				System.out.println("4. 현재 상품 목록 조회");
				System.out.println("5. 회원 조회");
				System.out.println("0. 이전 메뉴로");
				System.out.print("선택 >> ");
				int select = sc.nextInt();
				switch (select) {
				case 1:
					insertBooks();
					break;
				case 2:
					changeAmount();
					break;
				case 3:
					deleteBooks();
					break;
				case 4:
					showBooks();
					break;
				case 5:
					managingAccount();
					break;
				case 0:
					return;
				}
			}
		} else {
			System.out.println("비밀번호가 틀렸습니다 다시 입력해 주세요.");
			return;
		}
	}// empMenu()

	public void managingAccount() {
		System.out.print("관리자 비밀번호를 입력해 주세요 : ");
		int passwords = sc.nextInt();
		if (managerPasswords == passwords) {
			while (true) {
				System.out.println("\n---------- 회원 관리 전용 ----------\n");
				System.out.println("1. 전체 회원 출력");
				System.out.println("2. 회원 1명 출력");
				System.out.println("3. 회원 정보 수정");
				System.out.println("4. 회원 정보 삭제");
				System.out.println("0. 이전 메뉴로");
				System.out.print("선택 >> ");
				int select = sc.nextInt();
				switch (select) {
				case 1:
					printAllMember();
					break;
				case 2:
					printOneMember();
					break;
				case 3:
					updateMember();
					break;
				case 4:
					deleteMember();
					break;
				case 0:
					return;
				}
			}
		} else {
			System.out.println("비밀번호가 틀렸습니다 다시 입력해 주세요.");
			return;
		}
	}// managingAccount();

	public void printAllMember() {
		System.out.println("\n---------- 전체 회원 정보 출력 ----------\n");
		System.out.println("이름\t아이디\t비밀번호\t나이\t주소\t\t등급");
		System.out.println("------------------------------------------------");
		for (int i = 0; i < userIndex; i++) {
			User u = users[i];
			String grade = printGrade(i);
			System.out.println(u.getName() + "\t" + u.getId() + "\t" + u.getPw() + "\t" + u.getAge() + "\t"
					+ u.getAddress() + "\t\t" + grade);
		}
	}// printAllMember();

	public String printGrade(int indexNum) {
		String grade = "";
		switch (users[indexNum].getGrade()) {
		case 1:
			grade = "Silver";
			break;
		case 2:
			grade = "Gold";
			break;
		case 3:
			grade = "Vip";
			break;
		}
		return grade;
	}// printGrade()

	public void printOneMember() {
		System.out.println("\n---------- 회원 정보 조회 ----------\n");
		System.out.print("조회 할 회원 이름을 입력해 주세요 : ");
		String name = sc.next();
		int searchIndex = searchMember(name);
		if (searchIndex == -1) {
			System.out.println("입력하신 회원정보가 없습니다.");
		} else {
			User u = users[searchIndex];
			System.out.println("이름 : " + u.getName());
			System.out.println("아이디 : " + u.getId());
			System.out.println("비밀번호 : " + u.getPw());
			System.out.println("나이 : " + u.getAge());
			String grade = printGrade(searchIndex);
			System.out.println("등급 : " + grade);
		}
	}// printOneMember();

	public void updateMember() {
		System.out.println("\n----------- 회원 정보 수정 ----------\n");
		System.out.print("수정 할 회원 이름을 입력해 주세요 : ");
		String name = sc.next();
		int searchIndex = searchMember(name);
		if (searchIndex == -1) {
			System.out.println("입력하신 회원정보가 없습니다.");
		} else {
			System.out.print("수정 할 이름을 입력해 주세요 : ");
			String modifyName = sc.next();
			System.out.print("수정 할 비밀번호를 입력해 주세요 : ");
			String modifyPassword = sc.next();
			System.out.print("수정 할 나이를 입력해 주세요 : ");
			int modifyAge = sc.nextInt();
			System.out.print("수정 할 등급을 입력해 주세요[1. Silver / 2. Gold / 3. Vip] : ");
			int modifyGrade = sc.nextInt();
			// 정보 수정>> new로 새로 받게 되면 cart 안에 있는게 다 없어질 것 같아서 일일이 넣었습니다.
			users[searchIndex].setName(modifyName);
			users[searchIndex].setPw(modifyPassword);
			users[searchIndex].setAge(modifyAge);
			users[searchIndex].setGrade(modifyGrade);
		}
		System.out.println("회원 정보 수정이 완료 되었습니다.");
	}// updateMember();

	public void deleteMember() {
		System.out.println("\n---------- 회원 정보 삭제 ----------\n");
		System.out.print("삭제 할 회원 이름을 입력해 주세요 : ");
		String name = sc.next();
		int searchIndex = searchMember(name);
		if (searchIndex == -1) {
			System.out.println("입력하신 회원 정보가 없습니다.");
		} else {
			for (int i = searchIndex; i < userIndex - 1; i++) {
				users[i] = users[i + 1];
			}
			users[--userIndex] = null;
		}
		System.out.println("삭제 완료");
	}// deleteMember();

	public int searchMember(String name) {
		for (int i = 0; i < userIndex; i++) {
			String searchName = users[i].getName();
			if (searchName.equals(name)) {
				return i;
			}
		}
		return -1;
	}// searchMember(String name);

	public void showBooks() {
		System.out.println("\n---------- 상품 목록 ----------\n");
		System.out.println("번호\t책이름\t책저자\t가격\t재고\t장르\t\t사은품");
		System.out.println("-------------------------------------------------------------------");
		for (int i = 0; i < bookIndex; i++) {
			Genre g = books[i];
			System.out.println((i + 1) + "\t" + g.getName() + "\t" + g.getAuthor() + "\t" + g.getPrice() + "\t"
					+ g.getAmount() + "\t" + g.getType() + "\t\t" + g.getEvent());
		} // for
	}// showBooks()

	public void insertBooks() {
		System.out.println("\n---------- 신규 상품 등록 ----------\n");
		System.out.print("책 장르를 입력하세요[소설 / 입문 / 만화] : ");
		String type = sc.next();
		System.out.print("책 이름 입력 : ");
		String name = sc.next();
		System.out.print("책 저자 입력 : ");
		String author = sc.next();
		System.out.print("책 가격 입력 : ");
		int price = sc.nextInt();
		System.out.print("책 수량 입력 : ");
		int amount = sc.nextInt();
		System.out.print("책 이벤트 입력 : ");
		sc.nextLine();
		String event = sc.nextLine();
		switch (type) {
		case "소설":
			Fiction f = new Fiction(name, author, price, amount, type, event);
			books[bookIndex++] = f;
			break;
		case "입문":
			Beginner b = new Beginner(name, author, price, amount, type, event);
			books[bookIndex++] = b;
			break;
		case "만화":
			Comic c = new Comic(name, author, price, amount, type, event);
			books[bookIndex++] = c;
			break;
		}
	}// insertBooks()

	public void deleteBooks() {
		showBooks();
		System.out.print("삭제 할 상품 번호를 입력하세요 : ");
		int bookNo = sc.nextInt();
		for (int i = bookNo - 1; i < bookIndex - 1; i++) {
			books[i] = books[i + 1];
		}
		books[--bookIndex] = null;
		System.out.println("상품 삭제가 완료 되었습니다.");
	}// deleteBooks()

	public void changeAmount() {
		showBooks();
		System.out.print("변경 할 재고 번호를 입력하세요 : ");
		int bookNo = sc.nextInt();
		System.out.print("변경 할 재고 수량을 입력하세요 : ");
		int modifyAmount = sc.nextInt();
		Genre genre = books[bookNo - 1];
		genre.setAmount(modifyAmount);
		System.out.println("재고 변경이 완료되었습니다.");
	}// changeAmount()

	////////////// 손님 ////////////////////////
	// 하고 싶은 것: 장바구니에 추가할때 이미 있는 목록이면 구매수량만 바꾸기>> 환불, 교환 모두

	public void clientMenu() {
		while (true) {
			if(isMembers) {
				System.out.println("\n===== " + users[memberIndex].getName() + "님, 환영합니다 =====\n");
			}//if로그인 상태
			else {
				System.out.println("\n=====  환영합니다 =====\n");
			}//else
			System.out.println("1. 상품 목록");
			System.out.println("2. 장바구니 추가");
			System.out.println("3. 환불");
			System.out.println("4. 교환");
			System.out.println("5. 장바구니 조회");
			if (isMembers) {
				System.out.println("6. 회원 정보 조회");
				System.out.println("7. 로그 아웃");
			} // if로그인한 경우
			else {
				System.out.println("6. 회원 가입");
				System.out.println("7. 로그인");
			} // else 로그인안 경우
			System.out.println("0. 이전 메뉴");
			System.out.print("선택 >> ");
			int select = sc.nextInt();
			System.out.println();
			switch (select) {
			case 1:// 전체 목록
				showBooks();
				break;
			case 2:// 장바구니 추가
				addCart();
				break;
			case 3:// 환불
				refund();
				break;
			case 4:// 교환
				exchange();
				break;
			case 5:// 장바구니 조회
				showCart();
				break;
			case 6:// 회원정보 조회/ 회원가입
				if (isMembers) {
					printMyMembership();
				} // if
				else {
					signUp();
				} //
				break;
			case 7:// 로그아웃 / 로그인
				if (isMembers) {
					signOut();
				} // if
				else {
					signIn();
				} // else
				break;
			case 0:// 종료
				return;
			}// switch(select)

		} // while(true)
	}// clientMenu()

	public void printMyMembership() {
		User u = users[memberIndex];
		System.out.println("나의 정보 조회");
		System.out.println("이름 : " + u.getName());
		System.out.println("아이디 : " + u.getId());
		System.out.println("비번 : " + u.getPw());
		System.out.println("나이 : " + u.getAge());
		System.out.println("주소 : " + u.getAddress());
		String grade = "";
		switch (u.getGrade()) {
		case 1:
			grade = "Silver";
			break;
		case 2:
			grade = "Gold";
			break;
		case 3:
			grade = "Vip";
			break;
		}
		System.out.println("등급 : " + grade);

		System.out.print("수정하시겠습니까?[y/n]: ");
		char answer = sc.next().charAt(0);
		if (answer == 'y') {
			updateMyMember();
		}
	}// printMyMembership()

	public void updateMyMember() {
		User u = users[memberIndex];
		System.out.println("나의 정보 수정");
		System.out.println("1. 이름");
		System.out.println("2. 비밀번호");
		System.out.println("3. 나이");
		System.out.println("4. 주소");
		System.out.print("선택 :  ");
		int select = sc.nextInt();
		switch (select) {
		case 1:
			System.out.print("수정할 이름을 입력하시오 : ");
			String name = sc.next();
			u.setName(name);
			break;
		case 2:
			System.out.print("수정할 비밀번호를 입력하시오 : ");
			String pw = sc.next();
			u.setPw(pw);
			break;
		case 3:
			System.out.print("수정할 나이를 입력하시오 : ");
			int age = sc.nextInt();
			u.setAge(age);
			break;
		case 4:
			System.out.print("수정할 주소를 입력하시오 : ");
			sc.nextLine();
			String address = sc.nextLine();
			u.setAddress(address);
			break;
		}
		System.out.println("수정 완료");
	}// updateMyMember()

	public void addCart() {
		Genre[] cart = users[memberIndex].getCart();
		showBooks();
		System.out.print("장바구니에 추가할 책 번호를 입력하세요 : ");
		int bookNo = sc.nextInt() - 1;
		System.out.print("구매하실 수량을 입력하세요 : ");
		int amount = sc.nextInt();
		Genre g = books[bookNo];
		int stock = g.getAmount() - amount;
		if (stock < 0) {
			System.out.println("재고가 부족합니다.");
			return;
		} // if
		books[bookNo].setAmount(stock);
		int searchIndex = searchCartIndex(books[bookNo].getName());
		if (searchIndex == -1) {
			addNewCart(bookNo, amount);
		} // if 장바구니에 동일한 책이 없는 경우
		else {
			cart[searchIndex].setAmount(amount + cart[searchIndex].getAmount());
		} // else
		System.out.println("장바구니에 추가되었습니다");
	}// addCart()

	public void addNewCart(int bookNo, int amount) {
		Genre g = books[bookNo];
		User u = users[memberIndex];
		Genre[] cart = u.getCart();
		switch (g.getType()) {
		case "소설":// fiction
			cart[u.getCartIndex()] = new Fiction(g.getName(), g.getAuthor(), g.getPrice(), amount, g.getType(),
					g.getEvent());
			u.setCartIndex(u.getCartIndex() + 1);
			break;
		case "입문":// Beginner
			cart[u.getCartIndex()] = new Beginner(g.getName(), g.getAuthor(), g.getPrice(), amount, g.getType(),
					g.getEvent());
			u.setCartIndex(u.getCartIndex() + 1);
			break;
		case "만화":// Comic
			cart[u.getCartIndex()] = new Comic(g.getName(), g.getAuthor(), g.getPrice(), amount, g.getType(),
					g.getEvent());
			u.setCartIndex(u.getCartIndex() + 1);
			break;
		}// switch(type)
	}// addNewCart()

	public void refund() {
		User u = users[memberIndex];
		Genre[] cart = u.getCart();
		showCart();
		if (u.getCartIndex() == 0) {
			System.out.println("장바구니가 비어있습니다.");
			return;
		} // if
		System.out.println("-------------------------------------------------------------");
		System.out.print("환불할 책의 번호를 입력하세요 : ");
		int cartNo = sc.nextInt() - 1;
		System.out.print("환불할 책의 수량을 입력하세요 : ");
		int refundNo = sc.nextInt();
		Genre g = cart[cartNo];
		if (g.getAmount() < refundNo) {
			System.out.println("수량을 잘못 입력하셨습니다.");
			return;
		} // if
		else {
			int searchIndex = searchBookIndex(g.getName());
			if (g.getAmount() == refundNo) {
				int stock = g.getAmount() + books[searchIndex].getAmount();
				books[searchIndex].setAmount(stock);
				for (int i = cartNo; i < u.getCartIndex() - 1; i++) {
					cart[i] = cart[i + 1];
				} // for
				u.setCartIndex(u.getCartIndex() - 1);
				cart[u.getCartIndex()] = null;
			} // if
			else {
				cart[cartNo].setAmount(cart[cartNo].getAmount() - refundNo);
				int stock = refundNo + books[searchIndex].getAmount();
				books[searchIndex].setAmount(stock);
			} // else
		} // else
		System.out.println("성공적으로 환불처리되었습니다.");
	}// refund()

	public void exchange() {
		User u = users[memberIndex];
		Genre[] cart = u.getCart();
		showCart();
		if (u.getCartIndex() == 0) {
			System.out.println("장바구니가 비어있습니다.");
			return;
		} // if
		System.out.println("-------------------------------------------------------------");
		System.out.print("교환하길 원하는 책의 번호를 입력하세요 : ");
		int cartNo = sc.nextInt() - 1;
		System.out.print("교환할 책의 수량을 입력하세요 : ");
		int abAmount = sc.nextInt();
		Genre g1 = cart[cartNo];
		if (abAmount > g1.getAmount()) {
			System.out.println("수량을 잘못 입력하셨습니다.");
			return;
		} // if(장바구니 안에 있는 수량 초과)
		g1.setAmount(g1.getAmount() - abAmount);
		int searchIndex = searchBookIndex(g1.getName());
		int stock = abAmount + books[searchIndex].getAmount();
		books[searchIndex].setAmount(stock);

		// 구매할 책 넣는 부분
		showBooks();
		System.out.print("교환할 책의 번호를 입력하세요 : ");
		int bookNo = sc.nextInt() - 1;
		System.out.println("구매 수량을 입력하세요 : ");
		int amount = sc.nextInt();
		Genre g2 = books[bookNo];
		if (g2.getAmount() - amount < 0) {
			System.out.println("재고가 부족합니다.");
			return;
		} // if
		g2.setAmount(g2.getAmount() - amount);
		if (g1.getAmount() == 0) {
			int searchCartIndex = searchCartIndex(g2.getName());
			if (searchCartIndex == -1) {
				switch (g2.getType()) {
				case "소설":
					cart[cartNo] = new Fiction(g2.getName(), g2.getAuthor(), g2.getPrice(), amount, g2.getType(),
							g2.getEvent());
					break;
				case "입문":
					cart[cartNo] = new Beginner(g2.getName(), g2.getAuthor(), g2.getPrice(), amount, g2.getType(),
							g2.getEvent());
					break;
				case "만화":
					cart[cartNo] = new Comic(g2.getName(), g2.getAuthor(), g2.getPrice(), amount, g2.getType(),
							g2.getEvent());
					break;
				}// switch(type)
			} // if
			else {
				cart[searchCartIndex].setAmount(amount + cart[searchCartIndex].getAmount());
				for (int i = cartNo; i < u.getCartIndex() - 1; i++) {
					cart[i] = cart[i + 1];
				} // for
				u.setCartIndex(u.getCartIndex() - 1);
				cart[u.getCartIndex()] = null;
			} // else
		} // if>> 아예 장바구니에 있는 해당 책을 전체 빼고 다른 것을 넣는 경우
		else {
			int searchCartIndex = searchCartIndex(g2.getName());
			if (searchCartIndex == -1) {
				addNewCart(bookNo, amount);
			} // if 장바구니에 동일한 책이 없는 경우
			else {
				cart[searchCartIndex].setAmount(amount + cart[searchCartIndex].getAmount());
			} // else

		} // else
		System.out.println("성공적으로 교환처리 되었습니다.");
	}// exchange()

	public void showCart() {
		User u = users[memberIndex];
		Genre[] cart = u.getCart();
		System.out.println("\n-------------------- 장바구니 목록 -------------------------\n");
		System.out.println("번호\t책 이름\t저자\t장르\t가격\t구매수량\t총 금액\t사은품");
		System.out.println("-------------------------------------------------------------");
		int totalPrice = 0;
		double totalPoint = 0;
		for (int i = 0; i < u.getCartIndex(); i++) {
			Genre g = cart[i];
			int bookPrice = g.getAmount() * g.getPrice();
			double bookPoint = g.getAmount() * g.getPoint();
			System.out.println((i + 1) + "\t" + g.getName() + "\t" + g.getAuthor() + "\t" + g.getType() + "\t"
					+ g.getPrice() + "\t" + g.getAmount() + "\t" + bookPrice + "\t" + g.getEvent());
			totalPrice += bookPrice;
			totalPoint += bookPoint;
		} // for
		System.out.println("-------------------------------------------------------------");
		System.out.println("총 금액 : " + totalPrice + "원");
		// user의 등급에 따른 적립률 차이를 둘것임
		totalPoint += totalPoint * u.getPointDegree();
		// 포인트는 정수단위로 보는게 좋으므로 소수점 버리고 정수로 형변환
		System.out.println("적립될 포인트 : " + (int) totalPoint);
		if (u.getCartIndex() == 0) {
			System.out.println("장바구니가 비어있습니다.");
		} // if
	}// showCart()

	public int searchBookIndex(String name) {
		for (int i = 0; i < bookIndex; i++) {
			if (name.equals(books[i].getName())) {
				return i;
			} // if
		} // for
		return -1;
	}// searchBookIndex()

	public int searchCartIndex(String name) {
		User u = users[memberIndex];
		Genre[] cart = u.getCart();
		for (int i = 0; i < u.getCartIndex(); i++) {
			if (name.equals(cart[i].getName())) {
				return i;
			} // if
		} // for
		return -1;
	}// searchCartIndex()

	public void signUp() {
		boolean wrongID = true;
		System.out.println("======= 회원 가입 =======");
		System.out.print("이름 : ");
		String name = sc.next();
		String id = "";
		while (wrongID) {
			int check = 0;
			System.out.print("ID : ");
			String temp = sc.next();
			for (int i = 0; i < userIndex; i++) {
				if (temp.equals(users[i].getId())) {
					System.out.println("중복된 ID 입니다. 다시 입력하세요.");
					check = 1;
					break;
				} // if 중복여부
			} // for 중복 체크
			if (check == 0) {
				wrongID = false;
				id = temp;
			} // if 중복 없음
		} // while(wrongID): id 중복 안되게
		System.out.print("PW : ");
		String pw = sc.next();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		System.out.print("주소 : ");
		sc.nextLine();
		String address = sc.nextLine();
		users[userIndex++] = new User(name, id, pw, age, address);
		System.out.println("회원가입이 완료되었습니다.");
	}// signUp()

	public void signIn() {
		System.out.println("----- 로그인 페이지 ------");
		System.out.print("ID : ");
		String id = sc.next();
		System.out.print("PW : ");
		String pw = sc.next();
		int signIndex = signInResult(id, pw);
		if (signIndex == -2) {
			System.out.println("잘못된 비밀번호 입니다.");
		} // if
		else if (signIndex == -1) {
			System.out.println("일치하는 아이디가 존재하지 않습니다.");
		} // else if
		else {
			isMembers = true;
			memberIndex = signIndex;
			System.out.println("로그인 되었습니다! " + users[memberIndex].getName() + "님, 환영합니다:)");
		} // else
	}// signIn()

	public int signInResult(String id, String pw) {
		for (int i = 0; i < userIndex; i++) {
			if (id.equals(users[i].getId())) {
				if (pw.equals(users[i].getPw())) {
					return i;// id, pw 둘다 일치
				} // if
				return -2;// id만 일치
			} // if
		} // for
		return -1;// 일치하는 id없음
	}// signInResult(,)

	public void signOut() {
		isMembers = false;
		memberIndex = 0;
	}// signOut()
}// class
