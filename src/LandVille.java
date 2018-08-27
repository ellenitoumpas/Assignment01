class LandVille {
	
	private int[][] land; // Why is this private??
	boolean hasHouse; // should I make this private then set up an accessor to get this value when needed?
	private int value;
	int landRows;
	int landColumns;
		
	// The LandVille constructor
	public LandVille(int maxRows, int maxColumns) {		
		landRows = maxRows;
		landColumns = maxColumns;
		land = new int [landRows][landColumns];
		clearLand();					
	}
		
	
	// Displays the land grid (prints the array)
	public void displayLand() {  							
		for (int i = 0; i < landRows; i++) {		
			for (int j = 0; j < landColumns; j++) {				
				System.out.print(land[i][j]+" ");
			}				
			System.out.print("\n");
		}				
	}
	
	


	// Clears land, setting all elements of the array to value 0 and hasHouse set to false
	public void clearLand() {
		
		for (int i = 0; i < landRows; i++) {		
			for (int j = 0; j < landColumns; j++) {
				land[i][j] = 0; 
			}				
		}		
		
		hasHouse = false;			
		
	}

	// ASSIGNMENT PROMPT: Build a house	
	// ASSIGNMENT PROMPT: Validate the inputs to ensure they make sense for the size of the land
	// 		- display an error message and return if they don't.	
	// ASSIGNMENT PROMPT: Ensure none of the other rules are violated
	//		- again display an error message and return if they are violated
	
	
	// My question...how do we validate here and not in the Main class? 
	// If we validate here how do we send the program back to the program where it just left?
	

	public void buildHouse(int rows, int columns) {
		
		int houseRows = rows;
		int houseColumns = columns;
		int propertyRows = houseRows + 1;
		int propertyColumns = houseColumns + 1;
	
		// assign land array element values	
		for (int i = 0; i <= propertyRows; i++) {			
			for (int j = 0; j <= propertyColumns; j++) {				
				if ((i == 0 && j <= propertyColumns) || (i == propertyRows && j <= propertyColumns) ||  (i <= propertyRows && j == 0)  || (i <= propertyRows && j == propertyColumns)) {
					land[i][j] = 1; 
				} else if ( 1 <= i && i <= houseRows && 1 <= j && j <= houseColumns ) {
					land[i][j] = 8;
				} else {
					land[i][j] = 0;
				}							
			}				
		}	
		
		hasHouse = true;
		displayLand();	
	}
		
}