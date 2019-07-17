package com.basedulislam.home_file_container;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.basedulislam.overall_file_container.SIMS_data_access_object;
import com.basedulislam.overall_file_container.Student_information_management_system;

public class App {

	// Scanner class for user input in console
	public static Scanner sc = new Scanner(System.in);

	// import beans file
	public static ApplicationContext context = new ClassPathXmlApplicationContext(
			"com/basedulislam/beans_file_container/beans.xml");

	// Instance of Dao class
	public static SIMS_data_access_object simsdao = (SIMS_data_access_object) context.getBean("simsdao");

	// Instance of this class
	public static Student_information_management_system sims = (Student_information_management_system) context
			.getBean("sims");
	
	// Main Class
	public static void main(String[] args) {
		try {
			displayInfo();
			continueProcess();
		} catch (DataAccessException ex) {
			// Getting error
			System.out.println("Error-> " + ex.getMessage() + " " + ex.getClass() + " " + ex.getCause());
		}
		// close beans file
		((ClassPathXmlApplicationContext) context).close();

	}

	public static void continueProcess() {
		boolean checked = true; // for while loop continue
		while (checked) {
			try {
				int value = sc.nextInt();
				switch (value) {
				case 1:
					sc.nextLine();
					// Set field value
					System.out.println("Enter Name of the Student");
					sims.setName(sc.nextLine());
					
					System.out.println("Enter Name of Department of the Student");
					sims.setDept(sc.nextLine());
					
					
					System.out.println("Enter email of the Student");
					sims.setEmail(sc.nextLine());
					
					
					System.out.println("Enter blood group of the Student");
					sims.setBloodGroup(sc.nextLine());
					// Function calling for inserting value into database table
					simsdao.insertDataIntoTable(sims);
					
					displayInfo();
					break;
				case 2:
					// Get data from database table using function: getStudentInfo()
					List<Student_information_management_system> list_stdinfo = simsdao.getStudentInfo();
					// For showing the retrieve data to console
					for (Student_information_management_system object : list_stdinfo) {
						System.out.println(object);
					}
					displayInfo();
					break;
				case 3:
					sc.nextLine();
					// Search by name
					System.out.println("Enter name that you search");
					List<Student_information_management_system> list_stdinfo_for_single = simsdao
							.getJustOneObject(sc.nextLine());
					for (Student_information_management_system object : list_stdinfo_for_single) {
						System.out.println(object);
					}
					
					displayInfo();
					break;
				case 4:
					
					// Delete Single object
					System.out.println("Enter Integer id that show you in list and delete this");
					simsdao.delete(sc.nextInt());
					sc.nextLine();
					displayInfo();
					break;
				case 0:
					checked = false;
					System.out.println("***** Thank you for used this apps *****");
					break;
				default:
					System.out.println("Enter 0 to 4 values");
					displayInfo();
					break;
				}
			}catch(InputMismatchException ex) {
				System.out.println("You are enter wrong character so terminate this apps, Thank you.");
				checked = false;
			}
		}
	}
	
	public static void displayInfo() {
		System.out.println("Hello users:\nSelect 2 for show information of student\nSelect 1 for insert information\nSelect 3 for search informaiton\nSelect 4 for delete an information\nSelect 0 or others for terminate this app");
	}
}
