package ontap1.services;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import ontap1.entity.Food;
import ontap1.entity.Item;

public interface FoodServices extends Remote {
	public boolean addFood(Food food) throws RemoteException;
	public List<Item> listItems (String suppliorName) throws RemoteException;
	public Map<Food, Double> listFoodAndCost() throws RemoteException;
}
