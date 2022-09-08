/* Meital Elmakaies 207058322
Yuval Rozilyo 313930703 */

package il.ac.hit.model;

import java.util.Objects;
/**
 * class for describe an cost item in the store 
 * @author Meital Elmakaies
 *
 */
public class CostItem {
    private int id;
    private String name;
    private String description;
    private double price;
    private String date;
    private String category;
    private String user;
   
    
    /**
     * Constructor
     */
    public CostItem(int id, String name, String description, double price,String date, String category,String user) {
    	//Data initialization
        setId(id);
        setName(name);
        setDescription(description);
        setPrice(price);
        setDate(date);
        setCategory(category);
        setUser(user);
    }

    /**
     * This method return the date
     */    
    public String getDate() {
		return date;
	}
    /**
     * This method set the date of the costItem 
     */
	public void setDate(String date) {
		this.date = date;
	}

    /**
     * This method return the category
     */	
	public String getCategory() {
		return category;
	}
    /**
     * This method set the category of the costItem 
     */
	public void setCategory(String category) {
		this.category = category;
	}

    /**
     * This method return the user
     */
	public String getUser() {
		return user;
	}
    /**
     * This method set the user
     */
	public void setUser(String user) {
		this.user = user;
	}
	/**
     *  Default constructor
     */
    public CostItem() {

    }

    /**
     * This method return the id
     */
    public int getId() {
        return id;
    }

    /**
     * This method set the id
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * This method return the name
     */
    public String getName() {
        return name;
    }
    /**
     * This method set the name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * This method return the description of the costItem 
     */
    public String getDescription() {
        return description;
    }
    /**
     * This method set the description of the costItem 
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * This method return the price of the costItem 
     */
    public double getPrice() {
        return price;
    }
    /**
     * This method set the price of the costItem 
     */
    public void setPrice(double price) {
        this.price = price;
    }
    /**
     * This method return the string of the  details costItem 
     */
    @Override
	public String toString() {
		return "CostItem [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", date="
				+ date + ", category=" + category + "]";
	}
    

	/**
     * hashCode - return costItem that the method equals using 
     */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
    /**
     * this method checking if the items equals
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CostItem other = (CostItem) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

   
}
