import java.util.Scanner;
import java.util.ArrayList;

public class ContactBook {
    public static void main(String[] args) throws Exception {
        
        Scanner input = new Scanner(System.in);
        int selection = 0;
        String done;
        String junk;
        do{
            System.out.print("\033[H\033[2J");
        try{
            System.out.print(
                "Please select an option: \n" + 
                "[1]: View Contacts \n" + 
                "[2]: Search for Contact \n" +
                "[3]: Add New Contact \n" +
                "[4]: Manage Contact \n" +
                "[5]: Help \n" + 
                "[0]: Quit \n"
            );
            selection = input.nextInt();
            
            switch(selection){
                case 1:
                ContactBook.viewContacts();
                break;
                case 2:
                ContactBook.searchContacts();
                break;
                case 3:
                ContactBook.addNewContact();
                break;
                case 4:
                ContactBook.manageContact();
                break;
                case 5:
                System.out.println("\nInstructions: ");
                System.out.println("Press 1 to view ALL contacts");
                System.out.println("Press 2 to search and view for specific contacts");
                System.out.println("Press 3 to add a new contact");
                System.out.println("Press 4 to edit or remove a contact");
                System.out.println("Press 0 to quit");
                System.out.print("Press \"Enter\" to continue");
                done = input.nextLine();
                done = input.nextLine(); 
                break;
                case 0:
                break;

                default:
                throw new Exception();

            }
            if (selection > 5 || selection < 0){
                System.out.print("Invalid Selection");
                continue;
            }
        }
        catch(Exception ex){
            System.out.println("Invalid Input");
            junk = input.nextLine();
        }
        }while(selection != 0);
        input.close();
    }



    public static ArrayList<Contact> contacts = new ArrayList<Contact>();

    public static void addNewContact(){
        System.out.print("\033[H\033[2J");
        Contact newContact = new Contact();
        ArrayList<String> notes = new ArrayList<String>();
        String junk;
        do{
            
            try{
                System.out.println("Enter Contact Information:");
                newContact.setFirstName();
                newContact.setLastName();
                newContact.setPhoneNumber();
                newContact.setEmail();
                newContact.setNotes();
                contacts.add(newContact);
                break;
            }
            catch(Exception ex){
                System.out.println("Invalid Input");
            }
        }while(true);
    }

    public static void viewContacts(){
        System.out.print("\033[H\033[2J");
        System.out.println("Contacts: \n");
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < contacts.size(); i++){
            contacts.get(i).printInfo();
        }
        System.out.print("Press \"Enter\" to continue");
        String done = input.nextLine(); 
        
    }

    public static void searchContacts(){
        System.out.print("\033[H\033[2J");
        Scanner input = new Scanner(System.in);
        int decision;
        ArrayList<Contact> listOfContacts = new ArrayList<Contact>();
        String junk;
        String done;
        do{
            
            try{
                System.out.println("What would you like to search by?");
                System.out.println("[1] First Name");
                System.out.println("[2] Last Name");
                System.out.println("[3] Phone Number");
                System.out.println("[4] Email");
                decision = input.nextInt();
                switch(decision){
                    case 1:
                    listOfContacts = searchByFirst();
                    break;
                    case 2:
                    listOfContacts = searchByLast();
                    break;
                    case 3:
                    listOfContacts = searchByPhone();
                    break;
                    case 4:
                    listOfContacts = searchByEmail();
                    break;
                    default:
                    throw new Exception();
                }
                if (listOfContacts.size() > 0){
                    System.out.println("Contacts: \n");
                    for (int i = 0; i < listOfContacts.size(); i++){
                        (listOfContacts.get(i)).printInfo();
                    }
                }
                else{
                    System.out.println("No contacts found");
                }
                System.out.print("Press \"Enter\" to continue");
                done = input.nextLine(); 
                done = input.nextLine();
                break;
            }
            catch(Exception ex){
                System.out.println("Invalid Input");
                junk = input.nextLine();
            }
        }while(true);

    }

    public static ArrayList<Contact> searchByFirst(){
        System.out.print("\033[H\033[2J");
        Scanner input = new Scanner(System.in);
        String junk;
        do{
            try{
                ArrayList<Contact> arr = new ArrayList<Contact>();
                String first;
                System.out.print("Enter first name to search contacts by: ");
                first = input.next();
                
                for (int i = 0; i < contacts.size(); i++){
                    if (first.equals(contacts.get(i).firstName)){
                        arr.add(contacts.get(i));
                    }
                }
                return arr;
            }
            catch(Exception ex){
                System.out.println("Invalid Input");
                junk = input.nextLine();
            }
        }while(true);
        
    }

    public static ArrayList<Contact> searchByLast(){
        System.out.print("\033[H\033[2J");
        Scanner input = new Scanner(System.in);
        String junk;
        do{
            try{
                
                ArrayList<Contact> arr = new ArrayList<Contact>();
                String last;
                System.out.print("Enter last name to search contacts by: ");
                last = input.next();
                
                for (int i = 0; i < contacts.size(); i++){
                    if (last.equals(contacts.get(i).lastName)){
                        arr.add(contacts.get(i));
                    }
                }
                return arr;
            }
            catch(Exception ex){
                System.out.println("Invalid Input");
                junk = input.nextLine();
            }
        }while(true);
        
    }

    public static ArrayList<Contact> searchByPhone(){
        System.out.print("\033[H\033[2J");
        Scanner input = new Scanner(System.in);
        String junk;
        do{
            try{
                
                ArrayList<Contact> arr = new ArrayList<Contact>();
                long number;
                System.out.print("Enter Phone number to search contacts by: ");
                number = input.nextLong();
                
                for (int i = 0; i < contacts.size(); i++){
                    if (number == contacts.get(i).phoneNumber){
                        arr.add(contacts.get(i));
                    }
                }
                return arr;
            }
            catch(Exception ex){
                System.out.println("Invalid Input");
                junk = input.nextLine();
            }
        }while(true);
    }

    public static ArrayList<Contact> searchByEmail(){
        System.out.print("\033[H\033[2J");
        String junk;
        Scanner input = new Scanner(System.in);
        do{
            try{
                
                ArrayList<Contact> arr = new ArrayList<Contact>();
                String email;
                System.out.print("Enter email to search contacts by: ");
                email = input.next();
                
                for (int i = 0; i < contacts.size(); i++){
                    if (email.equals(contacts.get(i).email)){
                        arr.add(contacts.get(i));
                    }
                }
                return arr;
            }
            catch(Exception ex){
                System.out.println("Invalid Input");
                junk = input.nextLine();
            }
        }while(true);

    }

    private static void manageContact(){
        System.out.print("\033[H\033[2J");
        Scanner input = new Scanner(System.in);
        ArrayList<Contact> arr = new ArrayList<Contact>();
        Contact item;
        String junk;
        do{
            try{
                arr = searchByPhone();
                if (arr.size() == 1){
                    item = arr.get(0);
                    manageContact(item);
                }
                else{
                    System.out.println("No Contact found");
                }
                break;
            }
            catch(Exception ex){
                System.out.println("Invalid Input");
                junk = input.nextLine();
            }
        }while(true);
    }

    private static void manageContact(Contact item){
        System.out.print("\033[H\033[2J");
        Scanner input = new Scanner(System.in);
        int decision;
        String junk;
        do{
            try{
                item.printInfo();
                System.out.println();
                System.out.println("Would you like to edit or delete the contact?");
                System.out.println("[1] Edit");
                System.out.println("[2] Delete");
                System.out.println("[3] Exit");
                decision = input.nextInt();
                switch(decision){
                    case 1:
                    edit(item);
                    break;

                    case 2:
                    remove(item);
                    break;

                    case 3:
                    break;

                    default:
                    throw new Exception();
                }
                break;
            }
            catch(Exception ex){
                System.out.println("Invalid Input");
                junk = input.nextLine();
            }
        }while(true);
    }

    private static void edit(Contact item){
        System.out.print("\033[H\033[2J");
        Scanner input = new Scanner(System.in);
        int decision;
        String junk;
        do{
            try{
                System.out.println("What would you like to edit?");
                System.out.println("[1] Name");
                System.out.println("[2] Phone number");
                System.out.println("[3] Email");
                System.out.println("[4] Exit");
                decision = input.nextInt();
                switch(decision){
                    case 1:
                    System.out.println("Enter Information:");
                    item.setFirstName();
                    item.setLastName();
                    break;
                    case 2:
                    System.out.println("Enter Information:");
                    item.setPhoneNumber();
                    break;
                    case 3:
                    System.out.println("Enter Information:");
                    item.setEmail();
                    case 4:
                    break;
                    default:
                    throw new Exception();
                }
                break;
            }
            catch(Exception ex){
                System.out.println("Invalid Input");
                junk = input.nextLine();
            }
        }while(true);
    }
    private static void remove(Contact item){
        contacts.remove(item);
    }
}

class Contact{
    public String firstName;
    public String lastName;
    public Long phoneNumber;
    public String email;
    public ArrayList<String> notes = new ArrayList<>();

    Contact(){

    }
    

    public void setFirstName(){
        
        Scanner input = new Scanner(System.in);
        String junk;
        do{
            try{
                System.out.print("First Name: ");
                firstName = input.next();
                break;
            }
            catch(Exception ex){
                System.out.println("Invalid Input");
                junk = input.nextLine();
            }
        }while(true);
    }

    public void setLastName(){
      
        Scanner input = new Scanner(System.in);
        String junk;
        do{
            try{
                System.out.print("Last Name: ");
                lastName = input.next();
                break;
            }
            catch(Exception ex){
                System.out.println("Invalid Input");
                junk = input.nextLine();
            }
        }while(true);
    }

    public void setPhoneNumber() throws Exception, IllegalArgumentException{
        
        Scanner input = new Scanner(System.in);
        long tempNumber;
        long longmin = 999999999L;
        long longmax = 99999999999L;
        String junk;
        do{
            try{
                System.out.print("Phone number: ");
                tempNumber = input.nextLong();
                for (int i = 0; i < ContactBook.contacts.size(); i++){
                    if (tempNumber == ContactBook.contacts.get(i).phoneNumber){
                        throw new Exception();
                    }
                }
                if (tempNumber <= longmin || tempNumber > longmax){
                    throw new Exception();
                }
                else{
                    phoneNumber = tempNumber;
                }
                break;
            }
            catch(Exception ex){
                System.out.println("Invalid Input");
                junk = input.nextLine();
            }
            
        }while(true);
    }

    public void setEmail(){
        
        Scanner input = new Scanner(System.in);
        String junk;
        do{
            try{
                System.out.print("Email: ");
                email = input.next();
                break;
            }
            catch(Exception ex){
                System.out.println("Invalid Input");
                junk = input.nextLine();
            }
        }while(true);
        input.reset();
    }

    public void setNotes(){
        Scanner input = new Scanner(System.in);
        input.reset();
        int selection = 0;
        String junk;
        do{
            try{
                System.out.println("Would you like to add a note?");
                System.out.println("[1] Yes");
                System.out.println("[2] No");
                selection = input.nextInt();
                if (selection == 1){
                    updateNotes();
                }
                else if(selection == 2){
                    break;
                }
                else{
                    throw new Exception();
                }
            }
            catch(Exception ex){
                System.out.println("Invalid Input 1");
                junk = input.nextLine();
            }
        }while(true);
        
    }

    private void updateNotes(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter note: ");
        String newNote = input.next();
        notes.add(newNote);
    }

    public void printInfo(){
        Scanner input = new Scanner(System.in);
        System.out.println("Name: " + firstName + ' ' + lastName);
        System.out.print("Phone number: ");
        String numberStr = phoneNumber.toString();
        if (numberStr.length() == 10){
            System.out.println('(' + numberStr.substring(0,3) + ") " + 
            numberStr.substring(3,6) + '-' + 
            numberStr.substring(6,10));
        }
        else if (numberStr.length() == 11){
            System.out.println('+' + numberStr.substring(1) + 
            '(' + numberStr.substring(1, 4) +
            ") " + numberStr.substring(4,7) + '-' +
            numberStr.substring(7, 11));
        }
        System.out.println("Email: " + email);
        System.out.println("Notes:");
        for (int i = 0; i < notes.size(); i++){
            System.out.println((i+1) + ": " + notes.get(i));
        }
        if (notes.size() == 0){
            System.out.println("None");
        }
        System.out.print("\n");
        
    }
}