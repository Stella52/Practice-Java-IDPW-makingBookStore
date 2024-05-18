package book.vo;

public class Beginner extends Genre{

	public Beginner() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Beginner(String name, String author, int price, int amount, String type,String event) {
		super(name, author, price, amount, type, event);
	}
	
	@Override
	public double getPoint() {
		return 0.07*getPrice();
	}
	
}
