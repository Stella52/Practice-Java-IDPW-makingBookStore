package book.vo;

public abstract class Genre {
	private String name;
	private String author;
	private int price;
	private int amount;
	private String type; // Fiction : 1/ Beginner : 2 / Comic:3
	private String event;
	
	public Genre() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Genre(String name, String author, int price, int amount, String type, String event) {
		super();
		this.name = name;
		this.author = author;
		this.price = price;
		this.amount = amount;
		this.type = type;
		this.event = event;
	}
	public String getName() {
		return name;
	}
	public String getAuthor() {
		return author;
	}
	public int getPrice() {
		return price;
	}
	public int getAmount() {
		return amount;
	}
	public String getType() {
		return type;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	
	public abstract double getPoint();
	
}
