package ontap1.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "items")
@Inheritance(strategy = jakarta.persistence.InheritanceType.JOINED)
public abstract class Item {
	@Id
	protected String id;

	protected String name;

	protected double price;

	protected String description;

	@Column(name = "on_special")
	protected boolean onSpecial;

	@ManyToMany
	@JoinTable(name = "items_ingredients", joinColumns = @jakarta.persistence.JoinColumn(name = "item_id"), inverseJoinColumns = @jakarta.persistence.JoinColumn(name = "ingredient_id"))
	private List<Ingredient> ingredients;

	public Item() {
	}

	public Item(String id, String name, double price, String description, boolean onSpecial,
			List<Ingredient> ingredients) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.onSpecial = onSpecial;
		this.ingredients = ingredients;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isOnSpecial() {
		return onSpecial;
	}

	public void setOnSpecial(boolean onSpecial) {
		this.onSpecial = onSpecial;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description
				+ ", onSpecial=" + onSpecial + "]";
	}

}
