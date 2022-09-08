package il.ac.hit.validation;

public class Validation {

	public Validation() {

	}
    /**
     * This method checking the id vaildation 
     */
	public boolean checkId(String id) {

		try {
			//check if we can convert it to int 
			int num = Integer.parseInt(id);
		} catch (NumberFormatException e) {

			return false;
		}

		return true;

	}
	
	
    /**
     * This method checking the price vaildation 
     */
	public boolean checkPrice(String price) {

		try {
			//check if we can convert it to  double
			double num = Double.parseDouble(price);
		} catch (NumberFormatException e) {

			return false;
		}

		return true;

	}
	
	  /**
     * This method checking the item vaildation 
     */
	public boolean checkItems(String descrption,String name,String category,String id, String price, String date)
	{
		//checking if there is nothing in the strings - empty strings
	   if (name.equals("")|| descrption.equals("")|| category.equals("")||  id.equals("")||  price.equals("")|| date.equals("")) {
		   return false;
	   }
		//checking if the price and the id can do convert with the functions
	  if(!((checkPrice(price))&&( checkId(id)))) {
		   return false;

	  }
	  return true;
	}
	
}
	
		
		

	
	
	
	


