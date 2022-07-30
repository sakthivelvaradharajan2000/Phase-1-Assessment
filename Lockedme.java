package finalAssessment;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lockedme {
 void welcome() throws IOException {
	 System.out.println("WELCOME!");
	 System.out.println("Prototype for LockedMe.com");
	 System.out.println("Developed by Sakthivel V");
	 menu1();
 }
 void menu1() throws IOException {
	 while(true) {
	 System.out.println("\nChoose the operation from the options!");
	 System.out.println("1. Sort file names");
	 System.out.println("2. Business-level operations");
	 System.out.println("3. Exit");
	 Scanner sc = new Scanner(System.in);
	 try {
	 int a = sc.nextInt();
	 if(a==1 || a==2 || a==3) {
	 switch (a) {
	 case 1:{
		 sortfunc();
		 break;
	 }
	 case 2:{
		 menu2();
		 break;
	 }
	 case 3:{
		 System.out.println("Exitting program");
		 System.exit(0);
	 }
	 }
	 }
	 else {
		 System.out.println("Please enter 1 or 2 or 3!");
		 menu1();
	 }
 }catch(InputMismatchException e){
	 System.out.println("Please enter only 1, 2 or 3!");
 }
 }
 }

void menu2() throws IOException {
	while(true) {
	 System.out.println("\nChoose the operation from the options!");
	 System.out.println("1. Add a file");
	 System.out.println("2. Delete a file");
	 System.out.println("3. Search a file");
	 System.out.println("4. Back to Main");
	 Scanner sc = new Scanner(System.in);
	 try {
	 int b = sc.nextInt();
	 if(b==1||b==2||b==3||b==4) {
	 switch (b) {
	 case 1: {
		createfunc();
		break;
	 }
	 case 2:{
		 deletefunc();
		 break;
	 }
	 case 3: {
		 searchfunc();
		 break;
	 }
	 case 4:{
		 menu1();
		 break;
	 }
	 }
	 }
	 else {
		 System.out.println("Please enter 1, 2, 3 or 4!");
	 }
 }catch(InputMismatchException e){
	 System.out.println("Please enter only 1, 2, 3 or 4!");
 }
	}
}
void sortfunc() {

	File f = new File("C:\\Users\\sakth\\Desktop\\java\\");
	String filename[] = f.list();
	String temp;
	for(int i=0;i<filename.length;i++) {
		for(int j=i+1;j<filename.length;j++) {
			if(filename[i].compareTo(filename[j])>0) {
    			temp = filename[i];
    			filename[i]=filename[j];
    			filename[j]=temp;
    		}
		}
	}
	System.out.println("Sorted files: ");
	for(int i=0;i<filename.length;i++) {
		System.out.print(filename[i]+" ");
	}
	
}
 void searchfunc() {
	File f = new File("C:\\Users\\sakth\\Desktop\\java\\");
	String filename[] = f.list();
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter filename to search: ");
	String s = sc.next();
	s=s.concat(".txt");
	boolean a = false;
	for(int i=0;i<filename.length;i++) {
		if(filename[i].equals(s)) {
			a = true;
			break;
		}
		else {
			a = false;
		}
	}
	if(a) {
		System.out.println("File exists!");
	}
	else {
		System.out.println("File not found!");
	}
}
 void deletefunc() {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter file name to delete:");
	String s = sc.nextLine();
	File file = new File("C:\\Users\\sakth\\Desktop\\java\\"+s+".txt");
	if (file.delete()) {
    System.out.println("File deleted successfully");
    }
	else {
    System.out.println("No file found.");
    }	
}
void createfunc() throws IOException {
	 Scanner sc = new Scanner(System.in);
	 System.out.println("Enter filename to add: ");
	 String str = sc.nextLine();
	 
	 File file = new File("C:\\Users\\sakth\\Desktop\\java\\"+str+".txt");
	  
     if (file.createNewFile()){
       System.out.println("File is created!");
     }else{
       System.out.println("File already exists.");
     }
}
 public static void main(String[] args) throws IOException { 
	 Lockedme lm = new Lockedme();
	 lm.welcome();
 }
}
