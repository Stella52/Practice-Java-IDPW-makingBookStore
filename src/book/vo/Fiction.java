package book.vo;

public class Fiction extends Genre{

	public Fiction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fiction(String name, String author, int price, int amount, String type, String event) {
		super(name, author, price, amount, type, event);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getPoint() {
		return 0.05*getPrice();
	}
}
