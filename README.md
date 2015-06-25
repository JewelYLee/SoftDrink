# SoftDrink

###Program Specification:

You work at a soft drink distributorship that sells at most 100 different kinds of soft drinks. The program you write for this assignment will process weekly transactions and allow for a report to be displayed that includes the soft- drink name, ID, starting inventory, final inventory, and the number of transactions received.
There are two data files, data6.txt and data6trans.txt, which hold the initial soft drink information and transactions, respectively. The file data6.txt consists of at most 100 lines where each line contains the soft drink name (one string), ID (string), and the starting inventory of cases (int).
The file data6trans.txt holds the transactions. Each transaction consists of the ID followed by the number of cases purchased (positive integer), or the amount sold (negative integer). You can assume the format of the data is correct, but not all IDs are valid. In the case of an invalid ID, do not process the data (ignore it, no error message).

###The SoftDrinkInventory class with the following functionality:

__public constructor__: Initializes arrays holding soft drink name and ID to hold all empty strings (calls intitializeString twice to perform the tasks). Initializes arrays holding starting inventory, final inventory, and the counts of the number of transaction to zero (calls initializeInt three times to perform the tasks).

__public buildInventory__: Sets the arrays for soft drink name, ID, and starting inventory from information in the data file. The array holding final inventory is set to the same values as the starting inventory.

__public processTransactions__: Processes the transactions by correctly adjusting the final inventory and transaction counts arrays. Data for IDs which don't exist are not processed.

__public displayReport__: Displays a report including soft drink name, ID, starting inventory, final inventory, and number of transactions processed.

__private findID__: Takes an ID parameter and returns the position in the array (the subscript) where the soft drink with that ID is found. Return -1 if the ID is not found.

__private initializeInt__: Takes an int array parameter and initializes all array values to zero.

__private initializeString__: Takes a String array parameter and initializes all values to the empty String (“”).
