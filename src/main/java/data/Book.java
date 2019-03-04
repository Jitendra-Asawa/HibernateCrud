package data;

public class Book {
	private int id;
	private String name;
	private int price;
	private int pageCount;

//	private Book(BookBuilder builder) {
//		this.id = builder.id;
//		this.name = builder.name;
//		this.pageCount = builder.pageCount;
//		this.price = builder.price;
//	}

	public Book() {
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + ", pageCount=" + pageCount + "]";
	}

//	public static class BookBuilder {
//		private int id;
//		private String name;
//		private int price;
//		private int pageCount;
//
//		public BookBuilder(int id, String name) {
//			this.id = id;
//			this.name = name;
//		}
//
//		public BookBuilder setId(int id) {
//			this.id = id;
//			return this;
//		}
//
//		public BookBuilder setName(String name) {
//			this.name = name;
//			return this;
//		}
//
//		public BookBuilder setPrice(int price) {
//			this.price = price;
//			return this;
//		}
//
//		public BookBuilder setPageCount(int pageCount) {
//			this.pageCount = pageCount;
//			return this;
//		}
//
//		public Book build() {
//			return new Book(this);
//		}
//	}

}
