package book.vo;

public class Comic extends Genre{

	public Comic() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comic(String name, String author, int price, int amount, String type, String event) {
		super(name, author, price, amount, type, event);
	}
	
	@Override
	public double getPoint() {
		return 0.02*getPrice();
	}
	
}
