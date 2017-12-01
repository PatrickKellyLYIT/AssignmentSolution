package ie.lyit.testers;

import java.io.Serializable;

import ie.lyit.hotel.Menu;
import ie.lyit.serialize.CustomerSerializer;

public class CustomerSerializerTester  implements Serializable{
	public static void main(String[] args) {
		CustomerSerializer customerSerializer = new CustomerSerializer();
		
//		customerSerializer.add();
//		customerSerializer.add();
//		customerSerializer.writeRecordsToFile();
//		
//		
//		customerSerializer.readRecordsFromFile();
//		customerSerializer.list();
		
		//	create a menu object
		Menu menuObj = new Menu();
		
		//Using a do-while, create a switch to act as the menu interface.
		do {
			menuObj.display();
			menuObj.readOption();
			
			switch(menuObj.getOption()) {
			case 1:customerSerializer.add(); break;
			case 2:customerSerializer.list(); break;
			case 3:customerSerializer.view(); break;
			case 4:customerSerializer.edit(); break;
			case 5:customerSerializer.delete(); break;
			case 6:break;
			default:System.out.println("Invalid entry");
			}
		}while(menuObj.getOption() != 6);
		
		//write all items created to a file
		customerSerializer.writeRecordsToFile();
		
		//Read all items from file back into program
		customerSerializer.readRecordsFromFile();
		
		//list all files read into program
		customerSerializer.list();
	}
}