import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
	static class PreallocatedList<T> {
		protected T[] items;
		protected int cursize;
		protected int size;
		@SuppressWarnings("unchecked")
		PreallocatedList(int size) {
			items = (T[]) new Object[size];
			this.cursize = 0;
			this.size = size;
		}
		PreallocatedList<T> add(T item) {
			if (cursize == size)
				throw new RuntimeException("PreallocatedList is full");
			items[cursize++] = item;
			return this;
		}
		T get(int index) {
			return items[index];
		}
		@Override
		public String toString() {
			return String.format("[%s]", Arrays.stream(items).limit(cursize).map(x -> x.toString()).collect(Collectors.joining(", ")));
		}
	}

	public static void main(String[] args) {
		var numlist = new PreallocatedList<Integer>(10);
		numlist.add(1).add(2).add(3);
		var strlist = new PreallocatedList<String>(10);
		strlist.add("One").add("Two").add("Three");
		System.out.println(String.format("numlist items: %s", numlist));
		System.out.println(String.format("strlist items: %s", strlist));
	}
}