package salariati.main;

import salariati.model.Employee;
import salariati.repository.implementations.EmployeeImpl;
import salariati.repository.interfaces.EmployeeRepositoryInterface;

import salariati.validator.EmployeeValidator;
import salariati.controller.EmployeeController;
import salariati.enumeration.DidacticFunction;
import salariati.validator.ValidatorException;

import java.util.List;
import java.util.Scanner;

//functionalitati
//F01.	 adaugarea unui nou angajat (nume, prenume, CNP, functia didactica, salariul de incadrare);
//F02.	 modificarea functiei didactice (asistent/lector/conferentiar/profesor) a unui angajat;
//F03.	 afisarea salariatilor ordonati descrescator dupa salariu si crescator dupa varsta (CNP).

public class StartApp {
	
	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
		EmployeeValidator employeeValidator=new EmployeeValidator();
		EmployeeRepositoryInterface employeesRepository = new EmployeeImpl("employees.txt",employeeValidator);
		EmployeeController employeeController = new EmployeeController(employeesRepository);





			int option;
			boolean run = true;
			while(run){
				System.out.println();
				System.out.println("1. Adauga");
				System.out.println("2.Modifica");
				System.out.println("3.Tipareste in functie de salariu");
				System.out.println("4.Tipareste in functie de varsta");
				System.out.print("\nOptiune: ");
				option = Integer.parseInt(in.nextLine());
				switch (option) {
					case 1:
						System.out.println();
						String firstName,lastName,cnp,salary,function;
						System.out.print("First name: ");
						firstName = in.nextLine();
						System.out.print("Last Name: ");
						lastName = in.nextLine();
						System.out.print("CNP: ");
						cnp = in.nextLine();
						System.out.println("Function: ");
						System.out.println("1-ASSISTENT");
						System.out.println("2-LECTURER");
						System.out.println("3-TEACHER");
						function=in.nextLine();
						System.out.println("Salary: ");
						salary=in.nextLine();
						try{
						if(function.equals(1))
						{
							employeeController.addEmployee(firstName,lastName,cnp,DidacticFunction.ASISTENT,salary);}
						else if(function.equals(2)){
							employeeController.addEmployee(firstName,lastName,cnp,DidacticFunction.LECTURER,salary);}
						else{if(function.equals(3)){
							employeeController.addEmployee(firstName,lastName,cnp,DidacticFunction.TEACHER,salary);}}}
							catch (ValidatorException e){
								System.out.println(e.getMessage());
							}

						break;
					case 2:
						System.out.println("CNP: ");
						cnp=in.nextLine();
						System.out.println("Function: ");
						function=in.nextLine();
						employeeController.modifyEmployee(cnp,DidacticFunction.valueOf(function));

							break;
					case 3:
						int optiont;
						boolean runt = true;

						List<Employee>lista=employeeController.getEmployeeListBySalary();
						for (Employee e:lista
							 ) {
							System.out.println(e.getLastName()+" "+e.getFristName()+" "+e.getSalary());

						}

						break;
					case 4:

						List<Employee>lista1=employeeController.getEmployeeListByAge();
						for (Employee e:lista1
						) {
							System.out.println(e.getLastName()+" "+e.getFristName()+" "+e.getCnp());

						}





					default:
						System.out.println("Optiune invalida");
				}}}
		/*for(Employee _employee : employeeController.getEmployeesList())
			System.out.println(_employee.toString());
		System.out.println("-----------------------------------------");
		
		/*Employee employee = new Employee("LastName", "1234567894321", DidacticFunction.ASISTENT, "2500");
		employeeController.addEmployee(employee);
		
		for(Employee _employee : employeeController.getEmployeesList())
			System.out.println(_employee.toString());
		
		EmployeeValidator validator = new EmployeeValidator();
		System.out.println( validator.isValid(new Employee("LastName", "1234567894322", DidacticFunction.TEACHER, "3400")) );
		*/
	}


