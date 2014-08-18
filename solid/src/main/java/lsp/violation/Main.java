package lsp.violation;

public class Main {

	public static void main(String[] args) {
		Rectangle rec = getRectangle();
		rec.setHeight(7);
		rec.setWidth(3);
		System.out.println("area="+rec.getArea());
	}
	
	public static Rectangle getRectangle() {
		return new Square();
	}

}
