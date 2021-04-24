package pm.data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import static java.math.RoundingMode.HALF_UP;

public abstract class Product {

	public static final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);
	private int id;
	private String name;
	private BigDecimal price;
	private Rating rating;

	Product() {
		this(0, "no name", BigDecimal.ZERO);
	}

	Product(int id, String name, BigDecimal price, Rating rating) {
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

	public abstract Product applyRating(Rating newRating);
//	{
//		return new Product(id, name, price, newRating);
//	}

	public LocalDate getBestBefore() {
		return LocalDate.now();
	}

	@Override
	public String toString() {
		return id + ", " + name + ", " + price + ", " + getDiscount() + ", " + rating.getStars() + ", "
				+ getBestBefore();
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 23 * hash + this.id;
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
//		if(obj != null && getClass() == obj.getClass()) {
		if (obj instanceof Product) {
			final Product other = (Product) obj;
			return this.id == other.id && Objects.equals(this.name, other.name);
		}
		return false;
	}

	// Hashcode represent an immutable property of the object, a kind of unique
	// identity

}
