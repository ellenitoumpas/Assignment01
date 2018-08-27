import java.util.Scanner;

// COMMENTS: Reduce number of variables, reduce/ reuse some code

public class LandVilleMain {

	public static void main(String[] args) {
		
		Scanner inp = new Scanner(System.in);		
		
		// Input # of rows, # of columns for the land size, check for valid input.		
		boolean moveahead = false;		
		int rows = 0;
		int columns = 0;
		
		
		////////// CAN I REDUCE THIS BIT?? //////////
		
		while (moveahead == false) {
			
			System.out.println("How many rows do you want your land to have?");		
	        rows = inp.nextInt();
	        		        
	        if (rows < 3) {
	        	System.out.print("Number of rows has to be more than 3. ");
	        	//correctRow = false;	        	
	        } else if (rows > 10) {	        	
	        	System.out.print("Number of rows can not be greater than 10. ");
	        	//correctRow = false;
	        } else {
	        	moveahead = true;	
	        }
		}
		
		moveahead = false;
		
		while (moveahead == false) {
			
			System.out.println("How many columns do you want your land to have?");		
	        columns = inp.nextInt();
	        
	        if (columns < 3) {
	        	System.out.print("Number of columns has to be more than 3. ");	        	
	        } else if (columns > 10) {
	        	System.out.print("Number of columns can not be greater than 10. ");
	        } else {
	        	moveahead = true; 
	        }
		}
		
		///////////////////////////////////////////////////
							

		LandVille land = new LandVille(rows, columns);				
		      
		
        // Build a loop to display the menu, prompt for input and process it as per requirements.			
		moveahead = false;		
		System.out.println("What would you like to do now?");	
		
		
		
		
		while (moveahead == false) {
	
			System.out.println("Main Menu\n 1. Build a house\n 2. Display land\n 3. Clear land\n 4. Quit");	
			
			int selectionMade = inp.nextInt();
	        
	        if (selectionMade == 1) {
	        	
	        	System.out.println("You have selected to build a house.");	
	        	
				if (land.hasHouse == true) {
					
					System.out.println("ERROR: You can not have more than one house on your land.");
					
				} else {
					
					//////////CAN I REDUCE THIS BIT?? //////////
					
					// Build a house initializing settings 					
					boolean enoughRows = false;
					boolean enoughColumns = false;					
					int houseRows = 0;
					int houseColumns = 0;
					
					// Should validating that there is enough room happen over at LandVille.java?? Assignment
					// prompts hint at this. If so how do I parse the command back to this point?
					
//					System.out.println("How many rows do you want your house to be?");					
//					houseRows = inp.nextInt();
//					
					
					
					while (enoughRows == false) {

						System.out.println("How many rows do you want your house to be?");					
						houseRows = inp.nextInt();
						int landRowDifference = land.landRows - houseRows;					

						if (landRowDifference >= 2) {
							enoughRows = true;							
						} else {
							
							System.out.println("ERROR: There is not enough room on this land to build a house that big! Select a small number of rows.");					
							enoughRows = false;
						}
						
					}					
					
					while (enoughColumns == false) {
						System.out.println("How many columns do you want your house to be?");					
						houseColumns = inp.nextInt();
						int landColumnDifference = land.landColumns - houseColumns;
						
						if (landColumnDifference >= 2) {
							enoughColumns = true;																				
						} else {
							System.out.println("ERROR: There is not enough room on this land to build a house that big! Select a small number of columns.");					
							enoughColumns = false;
						}						
					}
					
					//////////////////////////////////////////////////
					
					land.buildHouse(houseRows, houseColumns);										
				}
	        	
	        } else if (selectionMade == 2) {

	        	System.out.println("You have selected to display your land.");	
	        	land.displayLand();
	        	
	        } else if (selectionMade == 3) {

	        	System.out.println("You have selected to clear your land.");	
	        	land.clearLand();
	        	
	        } else if (selectionMade == 4) {
	        	
	        	System.out.println("You have selected to quit. See ya!");		        	
	        	System.exit(0);
	        	
	        } else {

	        	System.out.println("You have entered an incorrect value. Please enter a value between 1 and 4.");		        	
	        	
	        }
	        
		}		
		    
	}

}
