/**
 * 
 */

/**
 * @author Jewel Lee
 *
 */
import java.util.Scanner;

public class SoftDrinkInventory {

	String[ ] soft_drink = new String[100];
	String[ ] id = new String[100];
	int[ ] starting_inventory = new int[100];
	int[ ] final_inventory = new int[100];
	int[ ] transactions = new int[100];
		
	/**
	 * Initializes all arrays to zero or empty String
	 */
	
	public SoftDrinkInventory() {
		initializeString(soft_drink); 
		initializeString(id); 
		
		initializeInt(starting_inventory);
		initializeInt(final_inventory);
		initializeInt(transactions);	
	}

	/** 
	 * initializeInt: takes an int array parameter 
	 * 		and initializes all array values to zero.
	 */
	private void initializeInt(int[] int_array) {
		for(int i = 0; i < int_array.length; i++) {
			int_array[i] = 0;
		}
	}
	/** 
	 * initializeString: takes a String array parameter 
	 * 		and initializes all values to the empty String ("").
	 */
	private void initializeString(String[] String_array) {
		for(int i = 0; i < String_array.length; i++) {
			String_array[i] = "";
		}		
	}

	/**
	 * Sets the arrays for soft drink name, ID, and starting inventory
	 * 		from information in the data file "data6.txt". 
	 * The array holding final inventory is set to the same values
	 * 		as the starting inventory.
	 */
	public void buildInventory(Scanner sc) {
		int counter = 0;
		while (sc.hasNextLine()) { //"hasNextLine" returns true if there is another line in the input of this scanner.
			String line = sc.nextLine(); //"nextLine" past the current line and returns the input that was skipped.
			String[] split_str = line.split(" "); //"split" splits this string around matches of the given regular expression.
			//assign values 
			soft_drink[counter] = split_str[0];
			id[counter] = split_str[1];
			starting_inventory[counter] = Integer.parseInt(split_str[2]) ;
			final_inventory[counter] = Integer.parseInt(split_str[2]);
			counter ++;
		}
	}

	/**
	 * Processes the transactions (data6trans.txt) 
	 * 		by correctly adjusting the final inventory and transaction counts arrays. 
	 * Data for IDs which don't exist are not processed.
	 */
	public void processTransactions(Scanner sc) {
		while (sc.hasNextLine()) { 
			String line = sc.nextLine(); 
			String[] split_str = line.split(" "); 
			// find ID
			int position = findID(split_str[0]);
			// findID returns a ID position 
			if (position >= 0 ) {
				final_inventory[position] = final_inventory[position] + Integer.parseInt(split_str[1]) ;
				transactions[position]++;
			}
		}
	}
	private int findID(String input_id) {
		for (int i = 0 ; i < id.length ;i++) {
			if (id[i].equals(input_id)) {
				return i;
			}
		}
		// if id doesn't match, return -1
		return -1;
	}
	
	/**
	 * Displays a report including soft drink name, ID, starting inventory, 
	 * 		final inventory, and number of transactions processed.
	 */
	public void displayReport() {
		 //title
		String[] title = { "Soft drink", "ID", "Starting Inventory", "Final Inventory", "# transactions"};
		System.out.printf("%-15s%-10s%15s%20s%20s", title);
		System.out.print("\n");
		for (int i=0; i < id.length; i++) {
			if (!id[i].equals("")) {
				String[] list = {soft_drink[i], id[i], String.valueOf(starting_inventory[i]), String.valueOf(final_inventory[i]), String.valueOf(transactions[i])};
				System.out.printf("%-15s%-5s%14s%22s%22s", list);
				System.out.print("\n");
			}
		}
	}
}
