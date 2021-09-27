package LockMe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
//import lockmeapp.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import LockMe.lock;

public class AuthenticateUser {
	public static Scanner keyboard;
	public static Scanner input;
	public static Scanner lockerInput;
	//output data 
	public static PrintWriter output;
	
	
		public static void main(String[] args) throws IOException {
		initApp();
		welcomeScreen();
		
		ArrayList<User>user=new ArrayList<User>();
		lock lock=new lock();
		Scanner input=new Scanner(System.in);
		int choice,c;
		do {//main menu for user
				  System.out.println("1: Register");
		          System.out.println("2: Login");
		          System.out.println("3: Exit ");
		          System.out.println("Enter your Choice:");
		          choice=input.nextInt();
		   switch(choice) {
		
				case 1://Registration 
						System.out.println("==========================================");
			    		System.out.println("||					||");
			    		System.out.println("||   WELCOME TO REGISTRATION PAGE	||");
			    		System.out.println("||					||");
			    		System.out.println("==========================================");
						System.out.println("Enter Username:");
						String username=keyboard.next();
						System.out.println("Enter Password:");
						String password=keyboard.next();
						lock.registration(user, new User(username,password));
						break;
					
				case 2://Login
						System.out.println("==========================================");
			    		System.out.println("||					||");
			    		System.out.println("||   WELCOME TO LOGIN PAGE	        ||");
			    		System.out.println("||					||");
			    		System.out.println("==========================================");
			    		
						File file = new File("C:\\Users\\Priyanshi Srivastava.LAPTOP-2HRHC2DK\\eclipse-workspace\\Phase1-Project\\file-db.txt");
						  
						Scanner scanner = new Scanner(System.in);
				        
						System.out.println("Enter your Username: ");
				        String inpusername = scanner.nextLine();
				        
				        System.out.println("Enter your Password: ");
					    String inppassword = scanner.nextLine();
			
				        System.out.println("Checking to see if username exists...");
				        BufferedReader bufferedReader;
				        try {
				            bufferedReader = new BufferedReader(new FileReader(file));
				            String line;
				           boolean usernameExists = false;
				            while((line = bufferedReader.readLine()) != null) {
				            	//System.out.println(line);
				            	
				                if (line.equals(inpusername)) {
				                    usernameExists = true;
				                    break;
				                }
				            }
				            if (usernameExists) {
				                System.out.println("USER NOT FOUND : 404 Error");
				            } else {
				                System.out.println("Login Successfully!!");
				            }
				        } catch (FileNotFoundException e) {
				            e.printStackTrace();
				        } catch (IOException e) {
				            e.printStackTrace();
				        }
			        lockerOptions(inpusername);
				        break;
				case 3://Exit
					System.out.println("Thank you for using this app");
					System.exit(0);
					
					default:
			            System.out.println("Invalid choice! Please make a valid choice. \n\n");
			            break;
				}
				System.out.println("Do you Wish to Continue? Enter 1 for yes");
				c=input.nextInt();
        	}while(c==1);
        System.out.println("Thank you for your valuable time");	
	}
		
	//App welcome Screen 	
	public static void welcomeScreen() {
			System.out.println("==========================================");
			System.out.println("||					||");
			System.out.println("||   Welcome To LockMe APP		||");
			System.out.println("||   Your Personal Digital Locker	||");
			System.out.println("||					||");
			System.out.println("==========================================");
			
	}
	public static void initApp() {
		File  dbFile = new File("file-db.txt");
		//File  lockerFile = new File("lockerme.txt");
		try {
			//read data from db file
			input = new Scanner(dbFile);
			
			//read data from keyboard
			keyboard = new Scanner(System.in);
			
			//output 
			output = new PrintWriter( new FileWriter(dbFile,true));
			
		} catch (IOException e) {
			System.out.println("404 : File Not Found ");
		}
		
	}
	//options for user after login
	public static void lockerOptions(String inpUsername) throws FileNotFoundException {
		int c;
		ArrayList<UserCredential>cred=new ArrayList<UserCredential>();
		Scanner sc = new Scanner(System.in);
		 
		 do // labeling the while loop
         {
			 System.out.println("1 . FETCH ALL STORED CREDENTIALS ");
		System.out.println("2 . STORED CREDENTIALS ");
		System.out.println("3 . DELETE CREDENTIALS ");
		System.out.println("Enter your choice:");
		int option = sc.nextInt();
		switch(option) {
			case 1 ://fetch data
				System.out.println("==========================================");
				System.out.println("||					||");
				System.out.println("||   WELCOME TO DIGITAL LOCKER 	        ||");
				System.out.println("||   FETCH  CREDENTIALS 	        ||");
				System.out.println("||					||");
				System.out.println("==========================================");
				System.out.println("Enter User2"
						+ "Name:");
				String username1=keyboard.next();
				lock.fetchCredentials(username1);
				break;
			case 2 ://Store data
				System.out.println("==========================================");
				System.out.println("*					*");
				System.out.println("*   WELCOME TO DIGITAL LOCKER STORE YOUR CREDS HERE	 *");
				System.out.println("*					*");
				System.out.println("==========================================");
				
				System.out.println("Enter SiteName:");
				String sitename=keyboard.next();
				System.out.println("Enter UserName:");
				String username=keyboard.next();
				System.out.println("Enter Password:");
				String password=keyboard.next();
				lock.storeCredentials(cred,new UserCredential (sitename,username,password));
				break;
			case 3://Delete data 
				System.out.println("==========================================");
			System.out.println("||					||");
			System.out.println("||   WELCOME TO DIGITAL LOCKER 	        ||");
			System.out.println("||   DELETE 	                        ||"); 
			System.out.println("||					||");
			System.out.println("==========================================");
				System.out.println("Enter SiteName you want to delete:");
				String delsitename=keyboard.next();
				lock.delete(delsitename);
				break;
			default :
				System.out.println("Invalid choice! Please make a valid choice. \n");
				break;
		}System.out.println("Do you want to continue this App? Press 1 for yes");
        c=sc.nextInt();
        }while(c==1);
		
	}

		
}