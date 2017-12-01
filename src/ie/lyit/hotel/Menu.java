package ie.lyit.hotel;

import java.io.Serializable;
import java.util.Scanner;

public class Menu implements Serializable{
   private int option;
   
   //Create a display method to display the instructions for the menu
   public void display(){
     System.out.println("\t1. Add");
	 System.out.println("\t2. List");
	 System.out.println("\t3. View");
	 System.out.println("\t4. Edit");
	 System.out.println("\t5. Delete");
	 System.out.println("\t6. Quit");		
   }
	
   //Read in a user input to choose an option from the menu
   public void readOption(){
      Scanner kbInt = new Scanner(System.in);
  	  System.out.println("\n\tEnter Option [1|2|3|4|5|6]");
   	  option=kbInt.nextInt();
   }
   
   //get the users selected option
	public int getOption(){
	   return option;
	}	
}