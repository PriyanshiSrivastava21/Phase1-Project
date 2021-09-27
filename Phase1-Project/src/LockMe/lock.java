package LockMe;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
//import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class lock {
	
	
	File f=new File("file-db.txt");
	static File f1=new File("UserCredential.txt");
	public ArrayList<User> registration(ArrayList<User> user,User users) {
		
		user.add(users);

		try {
			PrintWriter pw =new PrintWriter(new FileOutputStream(f,true));
			pw.println(user);
		System.out.println("Registration successfully!!");
		pw.close();
		
		}
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		return user;
	}
	public  void login(String username,String password) throws FileNotFoundException {
		try {
		Scanner myReader=new Scanner(f);
		boolean found=false;
		while(myReader.hasNextLine() && !found) {
			if((myReader.next().equals(username)) &&(myReader.next().equals(password))){
				System.out.println("Login Successfully!!!");
				found=true;
				break;
			}
			
		}
		if(! found) {
			System.out.println("Not Found");
		}
	
	}catch (FileNotFoundException e) {
		System.out.println("An erroe aagyi");
		e.printStackTrace();
	}
		
	}
	public static ArrayList<UserCredential> storeCredentials(ArrayList<UserCredential> cred,UserCredential creds) {
		
		cred.add(creds);

		try {
			PrintWriter pw =new PrintWriter(new FileOutputStream(f1,true));
			pw.println(cred);
		System.out.println("Store successfully");
		pw.close();
//		f.close();
		
		}
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		return cred;

	}
	public static  void fetchCredentials(String username) throws FileNotFoundException {
		
		try {
		Scanner myReader= new Scanner(f1);
		while(myReader.hasNextLine()) {
			String data=myReader.nextLine();
			
				
			
			System.out.println(data);
		}
		myReader.close();
		}catch (FileNotFoundException e) {
			System.out.println("Error occurred");
			e.printStackTrace();
		}
		}
	public static void delete(String sitename) {
		File myobj=new File("UserCredential.txt");
	 	if(myobj.delete()) {
	 		System.out.println("Deleted the " +myobj.getName()+"file");
	 	}
	 	else {
	 		System.out.println("Failed to delete");
	 	}

	}
}
		

