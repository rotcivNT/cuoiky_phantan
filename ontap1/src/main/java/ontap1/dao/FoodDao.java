package ontap1.dao;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.query.NativeQuery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import ontap1.entity.Food;
import ontap1.entity.Item;
import ontap1.services.FoodServices;

public class FoodDao implements FoodServices, Serializable {
	EntityManager em;

	public FoodDao() {
		em = Persistence.createEntityManagerFactory("ontap1").createEntityManager();
	}

	@Override
	public boolean addFood(Food food) throws RemoteException {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(food);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Item> listItems(String supplierName) throws RemoteException {
		List<Item> lists = new ArrayList<Item>();
		String query = "select i.id, i.name, i.description, i.on_special, i.price from items i join items_ingredients ii on i.id = ii.item_id \r\n"
				+ "join ingredients ig on ig.ingredient_id = ii.ingredient_id\r\n"
				+ "where i.on_special = 1 and ig.supplier_name like :name";
		Query q = em.createNativeQuery(query);
		q.setParameter("name", "%" + supplierName.toLowerCase() + "%");
		
		List<Object[]> listObject = q.getResultList();
		for (Object[] obj : listObject) {
			Item item = new Item() {
			};
			item.setId((String) obj[0]);
			item.setName((String) obj[1]);
			item.setDescription((String) obj[2]);
			item.setOnSpecial((Boolean) obj[3]);
			item.setPrice((Double) obj[4]);
			lists.add(item);
		}
		return lists;
	}

	@Override
	public Map<Food, Double> listFoodAndCost() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
