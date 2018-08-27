import java.util.Scanner;


public class LandVilleMain {
	
	
	public static boolean checkRows (int rows, int min, int max) {		
		if (rows < min) {
        	System.out.println("ERROR :: Number of rows has to be more than "+ min +".");   
        	return false;
        } else if (rows > max) {	        	
        	System.out.println("ERROR :: Number of rows can not be greater than "+ max+".");  
        	return false;
        } else {
        	return true;	
        }			
	}
			
	
	public static boolean checkColumns (int columns, int min, int max) {		
		if (columns < min) {
        	System.out.println("ERROR :: Number of columns has to be more than "+ min +".");   
        	return false;
        } else if (columns > max) {	        	
        	System.out.println("ERROR :: Number of columns can not be greater than "+ max +".");  
        	return false;
        } else {
        	return true;	
        }		
	}
	
	
	public static boolean checkSpace (int landHouseSpace, int selection, int minSpace) {				
		if (selection <= 0) {
			System.out.println("ERROR :: You must enter a value greater than 0.");
			return false;
		} else if (landHouseSpace >= minSpace) {			
			return true;							
		} else {			
			System.out.println("ERROR :: There is not enough room on this land to build a house that big! Select a smaller value.");					
			return false;
		}				
	}
	
	
	public static void main(String[] args) {
			
		Scanner inp = new Scanner(System.in);										
		int rows = 0;
		int columns = 0;
		boolean moveahead = false;
		
		
		// input number of rows for land and check if allowed		
		while (moveahead == false) {			
			System.out.println("How many rows do you want your land to have?");		
	        rows = inp.nextInt();	        
	        moveahead = checkRows(rows, 3, 10);	        
		}
			
		
		// reset moveahead boolean
		moveahead = false; 
						

		// input number of columns for land and check if allowed
		while (moveahead == false) {			
			System.out.println("How many columns do you want your land to have?");		
	        columns = inp.nextInt();	        
	        moveahead = checkRows(columns, 3, 10);
		}
		
		
		// create land object							
		LandVille land = new LandVille(rows, columns);				
		      
		
        // Build a loop to display the menu, prompt for input and process it as per requirements.							
		System.out.println("What would you like to do now?");			
		boolean menu = false;
				
		
		while (menu == false) {	
			System.out.println("Main Menu\n 1. Build a house\n 2. Display land\n 3. Clear land\n 4. Quit");	
			int selectionMade = inp.nextInt();
	        			
			// selection options
	        if (selectionMade == 1) {	 
	        	
	        	System.out.println("You have selected to build a house.");
	        	
				if (land.hasHouse == true) {					
					System.out.println("ERROR: You can not have more than one house on your land.");					
				} else {														
					// reset moveahead boolean
					moveahead = false;										
					int houseRows = 0;
					int houseColumns = 0;
					int difference = 0;
										
					// checking enough space with rows
					while (moveahead == false) {
						System.out.println("How many rows do you want your house to be?");					
						houseRows = inp.nextInt();
						difference = land.landRows - houseRows;					
						moveahead = checkSpace(difference, houseRows, 2);										
					}					
					
					moveahead = false;
										
					// checking enough space with columns
					while (moveahead == false) {
						System.out.println("How many columns do you want your house to be?");					
						houseColumns = inp.nextInt();
						difference = land.landColumns - houseColumns;
						moveahead = checkSpace(difference, houseColumns, 2);												
					}
										
					land.buildHouse(houseRows, houseColumns);	
					//land.displayLand();
				}
	        	
	        } else if (selectionMade == 2) {

	        	System.out.println("You have selected to display your land.");	
	        	land.displayLand();
	        	
	        } else if (selectionMade == 3) {

	        	System.out.println("You have selected to clear your land.");	
	        	land.clearLand();
	        	//land.displayLand();
	        	
	        } else if (selectionMade == 4) {
	        	
	        	System.out.println("You have selected to quit. See ya!");		        	
	        	System.exit(0);
	        	
	        } else {

	        	System.out.println("You have entered an incorrect value. Please enter a value between 1 and 4.");		        	
	        	
	        }
	        
		}		
		    
	}

}
