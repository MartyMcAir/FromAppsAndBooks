public class Main {
	static class Rectangle {
		protected int width, height;
		Rectangle(int width, int height) {
			this.width = width;
			this.height = height;
		}
		public int getArea() {
			return width * height;
		}
	}

	static class Square extends Rectangle {
		Square(int size) {
			super(size, size);
		}
	}

	public static void main(String[] args) {
		Rectangle sq = new Square(10);
		Rectangle rect = new Rectangle(10, 20);
		System.out.println(String.format("sq is %s, its area is %s", sq.getClass().getSimpleName(), sq.getArea()));
		System.out.println(String.format("rect is %s, its area is %s", rect.getClass().getSimpleName(), rect.getArea()));
	}
}