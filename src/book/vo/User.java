package book.vo;

public class User {
	private String name;
	private String id;
	private String pw;
	private Genre[] cart;
	private int age;
	private String address;
	private int cartIndex;
	private int grade;
	
	public User() {
		super();
		cart = new Genre[20];
		cartIndex = 0;
		// TODO Auto-generated constructor stub
	}

	public int getCartIndex() {
		return cartIndex;
	}

	public void setCartIndex(int cartIndex) {
		this.cartIndex = cartIndex;
	}


	public User(String name, String id, String pw, int age, String address, int grade) {
		super();
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.age = age;
		this.address = address;
		this.grade = grade;
		cart = new Genre[20];
		cartIndex = 0;
	}

	public User(String name, String id, String pw, int age, String address) {
		super();
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.age = age;
		this.address = address;
		cart = new Genre[20];
		cartIndex = 0;
	}

	public int getGrade() {
		return grade;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public Genre[] getCart() {
		return cart;
	}

	public int getAge() {
		return age;
	}

	public String getAddress() {
		return address;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void setCart(Genre[] cart) {
		this.cart = cart;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getPointDegree() {
		switch(grade) {
		case 1:
			return 0.01;
		case 2:
			return 0.02;
		case 3:
			return 0.03;
			default:
				return 0;
		}//switch(grade)
	}//getPointDegree()
	
}
