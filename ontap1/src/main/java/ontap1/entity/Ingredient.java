package ontap1.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ingredients")
public class Ingredient {
	@Id
	@Column(name = "ingredient_id")
	private String id;
	
	@Column(name = "ingredient_name")
	private String name;
	private String unit;
	private double price;
	private double quantity;
	
	@Column(name = "manufacturing_date")
	private LocalDate manufacturingDate;
	
	@Column(name = "expiry_date")
	private LocalDate expiryDate;
	
	@Column(name = "supplier_name")
	private String supplierName;
	
	@ManyToMany(mappedBy = "ingredients")
	private List<Item> items;
}
