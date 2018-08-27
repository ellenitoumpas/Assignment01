class LandVille {
	
	private int[][] land; // Why is this private??
	boolean hasHouse; // should I make this private then set up an accessor to get this value when needed?
	private int value;
	int landRows;
	int landColumns;
	boolean moveahead;
		
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



	public void buildHouse(int rows, int columns) {
		
		int houseRows = rows;
		int houseColumns = columns;
	
		// assign land array element values	
		for (int i = 0; i <= (houseRows + 1); i++) {			
			for (int j = 0; j <= (houseColumns + 1); j++) {				
				if ((i == 0 && j <= (houseColumns + 1)) || (i == (houseRows + 1) && j <= (houseColumns + 1)) ||  (i <= (houseRows + 1) && j == 0)  || (i <= (houseRows + 1) && j == (houseColumns + 1))) {
					land[i][j] = 1; 
				} else if ( 1 <= i && i <= (houseRows + 1) && 1 <= j && j <= (houseColumns + 1) ) {
					land[i][j] = 8;
				} else {
					land[i][j] = 0;
				}							
			}				
		}	
		
		hasHouse = true;
			
	}
		
}