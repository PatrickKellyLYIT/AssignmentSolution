package ie.lyit.hotel;

import java.io.Serializable;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Customer extends Person implements Serializable{// INHERITANCE - Customer IS-A Person
	// Customer has name, address, & phoneNumber from Person
	private String emailAddress;    // AND emailAddress
	private int number;			    // AND number

	private static int nextNumber=1;// static for unique number - starts off at 1
	
	// Default Constructor
	// Called when object is created like this ==> 
	//   Customer cObj = new Customer();	
	public Customer(){
		super();			// NOTE:Don't need to call super() explicitly.
		emailAddress=null;
		// Set number to static nextNumber before incrementing nextNumber
		number=nextNumber++;
	}
	
	// Initialization Constructor
	// Called when object is created like this ==>
	// Customer cObj = new Customer("Mr","Joe","Doe","12 Hi Rd,Letterkenny",
	//                              "0871234567","joe@hotmail.com");
	public Customer(String t, String fN, String sn, String address, 
			        String pNo, String email){
		// Call super class constructor - Passing parameters required by Person ONLY!
		super(t, fN, sn, address, pNo);
		// And then initialise Customers own instance variables
		emailAddress=email;
		// And finally set number to static nextNumber before incrementing nextNumber
		number=nextNumber++;
	}

	// OVERRIDING the Person toString() method!
	// Calling Persons toString() method, and adding additional bits
	@Override
	public String toString(){
		return super.toString() + "," + emailAddress;
	}

	// equals() method
	// ==> Called when comparing an object with another object, 
	//     e.g. - if(c1.equals(c2))				
	// ==> Probably sufficient to compare customer numbers as they're unique
	@Override
	public boolean equals(Object obj){
		Customer cObject;
		if (obj instanceof Customer)
		   cObject = (Customer)obj;
		else
		   return false;
		   
	    return(this.number==cObject.number);
	}

	// set() and get() methods
	public void setEmailAddress(String emailAddress){
		this.emailAddress=emailAddress;
	}
	public String getEmailAddress(){
		return this.emailAddress;
	}	
	// You shouldn't be able to setNumber() as it is unique, 
	// so don't provide a setNumber() method
	public int getNumber(){
		return number;
	}
	
	//Read() method which reads in the customer number, name, address, phone number and email of the customer
	public void read(){
		JTextField txtNumber = new JTextField();
		txtNumber.setText("" + this.getNumber());
		JTextField txtTitle = new JTextField();
		txtTitle.requestFocus();
		JTextField txtFirstName = new JTextField();
		JTextField txtSurname = new JTextField();
		JTextField txtAddress = new JTextField();
		JTextField txtPhoneNo = new JTextField();
		JTextField txtEmail = new JTextField();
		
		//popup with a display box which displays the following information
		Object[] message = {
				"Customer Number:", txtNumber,
				"Title:", txtTitle,
				"First Name:", txtFirstName,
				"Surname:", txtSurname,
				"Address:", txtAddress,
				"Phone Number:", txtPhoneNo,
				"Email Address:", txtEmail,
		};

		int option = JOptionPane.showConfirmDialog(null, message, "Enter Customer details", JOptionPane.OK_CANCEL_OPTION);
		
		//If OK is selected, store information from fields in the appropriate variables
		if (option == JOptionPane.OK_OPTION){
			String title = txtTitle.getText();
			String firstName = txtFirstName.getText();
			String surname = txtSurname.getText();
			Name name = new Name(title, firstName, surname);
			this.name = name;
			this.address = txtAddress.getText();
			this.phoneNumber = txtPhoneNo.getText();
			this.emailAddress = txtEmail.getText();
		}
	}
}