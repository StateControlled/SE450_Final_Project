package depaul.edu.Item;

/**
 * The {@code IAbstractItem} interface contains common methods for {@code items}.
 **/
public interface IAbstractItem {
	/**
	 * Returns the {@code manufacturer} of the item.
	 **/
	public String getManufacturer();
	/**
	 * Returns the {@code itemName} of the item. 
	 **/
	public String getItemName();
	/**
	 * Returns the {@code price} of the item.
	 **/
	public double getPrice();
	/**
	 * Returns the item's unique identifier, or {@code UID}.
	 **/
	public String getUID();
	/**
	 * Returns a simple String with only basic information about the item.<p>
	 * Intended to be displayed to a customer.
	 **/
	public String view();
}
