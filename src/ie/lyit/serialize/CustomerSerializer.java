package ie.lyit.serialize;

import java.util.ArrayList;
import ie.lyit.hotel.*;
import java.io.*;
import java.util.*;

public class CustomerSerializer  implements CustomerDAO {
	private ArrayList<Customer> customers;
	final String FILENAME = "customers.bin";
	
	public CustomerSerializer() {
		customers = new ArrayList<Customer>();
	}
	
	@Override
	public void add() {
		Customer customer = new Customer();
		customer.read();
		customers.add(customer);
	}
	
	public void writeRecordsToFile() {
		try {
			FileOutputStream fileStream = new FileOutputStream(FILENAME);
			ObjectOutputStream os = new ObjectOutputStream(fileStream);
			os.writeObject(customers);
			os.close();
		}
		catch(FileNotFoundException fNFE) {
			System.out.println("Cannot create file to store customers");
		}
		catch(IOException ioE) {
			System.out.println(ioE.getMessage());
		}
	}
	
	public void readRecordsFromFile() {
		try {
			FileInputStream fileStream = new FileInputStream(FILENAME);
			ObjectInputStream is = new ObjectInputStream(fileStream);
			customers = (ArrayList<Customer>)is.readObject();
			is.close();
		}
		catch(FileNotFoundException fNFE) {
			System.out.println("Cannot create file to store customer");
		}
		
		catch(IOException ioE) {
			System.out.println(ioE.getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void list() {
		for(Customer tmpCustomer:customers)
		System.out.println(tmpCustomer);
	}
	
	@Override
	public Customer view(){
		Scanner keyboard = new Scanner(System.in);		

		// Read the number of the customers to be viewed from the user
		System.out.println("ENTER CUSTOMER NUMBER : ");
		int customerToView=keyboard.nextInt();
		
		// for every Customer object in customers
	    for(Customer tmpCustomer:customers){
		   // if it's number equals the number of the customerToView
		   if(tmpCustomer.getNumber() == customerToView){
		      // display it
			  System.out.println(tmpCustomer);
			  return tmpCustomer;
		   }
		}
	    // if we reach this code the customer was not found so return null
	    return null;		
	}

	@Override
	public void delete(){	
		// Call view() to find, display, & return the customer to delete
		Customer tempCustomer = view();
		// If the customer != null, i.e. it was found then...
	    if(tempCustomer != null)
		   // ...remove it from customers
	       customers.remove(tempCustomer);
	}
	
	@Override
	public void edit(){	
		// Call view() to find, display, & return the customer to edit
		Customer tempCustomer = view();
		// If the customer != null, i.e. it was found then...
	    if(tempCustomer != null){
		   // get it's index
		   int index=customers.indexOf(tempCustomer);
		   // read in a new customer and...
		   tempCustomer.read();
		   // reset the object in customers
		   customers.set(index, tempCustomer);
	    }
	}
}