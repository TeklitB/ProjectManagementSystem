package pm.data;

import java.math.BigDecimal;
import static java.math.RoundingMode.HALF_UP;

public class Product {

	public static final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);
	private int id;
	private String name;
	private BigDecimal price;
	private Rating rating;

	public Product() {
		this(0, "no name", BigDecimal.ZERO);
	}

	public Product(int id, String name, BigDecimal price, Rating rating) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.rating = rating;
	}

	public Product(int id, String name, BigDecimal price) {
		this(id, name, price, Rating.NOT_RATED);
	}

	public int getId() {
		return id;
	}

	/**
	 * to make a class immutable remove any setter method in the class
	 * 
	 * @return
	 */
//	public void setId(int id) {
//		this.id = id;
//	}

	public String getName() {
		return name;
	}

//	public void setName(String name) {
//		this.name = name;
//	}

	public BigDecimal getPrice() {
		return price;
	}

//	public void setPrice(final BigDecimal price) {
//		// price = BigDecimal.ONE;
//		this.price = price;
//	}

	public Rating getRating() {
		return rating;
	}

	public BigDecimal getDiscount() {
		return price.multiply(DISCOUNT_RATE).setScale(2, HALF_UP);
	}

	public Product applyRating(Rating newRating) {
		return new Product(id, name, price, newRating);
	}
}
