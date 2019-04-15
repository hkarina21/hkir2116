package salariati.repository.implementations;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import salariati.enumeration.DidacticFunction;
import salariati.exception.EmployeeException;

import salariati.model.Employee;

import salariati.repository.interfaces.EmployeeRepositoryInterface;
import salariati.validator.EmployeeValidator;

public class EmployeeImpl implements EmployeeRepositoryInterface {

	private final String employeeDBFile ;

	private EmployeeValidator employeeValidator ;

	public EmployeeImpl(String employeeDBFile,EmployeeValidator employeeValidator){
		this.employeeDBFile=employeeDBFile=employeeDBFile;
		this.employeeValidator=employeeValidator;
	}

	@Override
	public boolean addEmployee(Employee employee) {
		if (employeeValidator.isValid(employee)) {
			BufferedWriter bw = null;
			try {
				bw = new BufferedWriter(new FileWriter(employeeDBFile, true));

				bw.write(employee.toString());

				bw.close();
				return true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public void deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub

	}



	@Override
	public void modifyEmployee(String CNP,DidacticFunction function) {
		List<Employee>employeeList=this.getEmployeeList();
		Employee emn=new Employee();
		for (Employee em :employeeList
			 ) {if(em.equalsStringCNP(CNP)){
			emn.setFirstName(em.getFristName());
			emn.setLastName(em.getLastName());;
			emn.setFunction(function);
			emn.setCnp(em.getCnp());
			emn.setSalary(em.getSalary());
			employeeList.set(employeeList.indexOf(em),emn);

			try(BufferedWriter writer=new BufferedWriter(new FileWriter("employees.txt"))){
				employeeList.forEach (candidat->{
					try{
						writer.write(candidat.getFristName() + ";" + candidat.getLastName() + ";" + candidat.getCnp() + ";" + candidat.getFunctionString()+";"+candidat.getSalary() + '\n');
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
			}catch (FileNotFoundException e) {
				System.out.println("Fisierul nu a fost gasit !");
			} catch (IOException e) {
				System.out.println("I/O error");
			}

		}

		}





		}









	@Override
	public List<Employee> getEmployeeList() {
		List<Employee> employeeList = new ArrayList<Employee>();

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(employeeDBFile));
			String line;
			int counter = 0;
			while ((line = br.readLine()) != null) {

				try {
					Employee employee = Employee.getEmployeeFromString(line, counter);
					employeeList.add(employee);
				} catch (EmployeeException ex) {
					System.err.println("Error while reading: " + ex.toString());
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("Error while reading: " + e);
		} catch (IOException e) {
			System.err.println("Error while reading: " + e);
		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
					System.err.println("Error while closing the file: " + e);
				}
		}

		return employeeList;
	}


	@Override
	public List<Employee> getEmployeeBySalary() {
		List<Employee> employeeList = this.getEmployeeList();
		employeeList.sort(Comparator.comparing(Employee::getSalary));


		return employeeList;
	}


	public List<Employee> getEmployeeByAge() {
		List<Employee> employeeList = this.getEmployeeList();

		Collections.sort(employeeList, new Comparator<Employee>() {
			@Override
			public int compare(Employee u1, Employee u2) {
				return u1.getCnp().substring(1, 2).compareTo(u2.getCnp().substring(1, 2));
			}
		});
		return employeeList;


	}
}
