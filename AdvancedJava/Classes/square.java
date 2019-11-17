public class Main {
	static class Square {
		private int size;
		Square(int size) {
			this.size = size;
		}
		public int getArea() {
			return size * size;
		}
		public int getSize() {
			return size;
		}
	}

	public static void main(String[] args) {
		Square sq = new Square(10);
		System.out.println(String.format("Area of square with side length %s is %s", sq.getSize(), sq.getArea()));
	}
}