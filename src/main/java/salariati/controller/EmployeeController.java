package salariati.controller;

import java.util.List;

import salariati.enumeration.DidacticFunction;
import salariati.model.Employee;
import salariati.repository.interfaces.EmployeeRepositoryInterface;

public class EmployeeController {
	
	private EmployeeRepositoryInterface employeeRepository;
	
	public EmployeeController(EmployeeRepositoryInterface employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public void addEmployee(String firstname,String lastname,String cnp,DidacticFunction function,String salary)
	{	Employee employee=new Employee(firstname,lastname,cnp,function,salary);
		employeeRepository.addEmployee(employee);
	}
	
	public List<Employee> getEmployeesList() {
		return employeeRepository.getEmployeeList();
	}

	public Integer getSizeList(){
	    return getEmployeesList().size();
    }
	
	public void modifyEmployee(String cnp, DidacticFunction function) {
		employeeRepository.modifyEmployee(cnp,function);
	}

	public void deleteEmployee(Employee employee) {
		employeeRepository.deleteEmployee(employee);
	}

	public List<Employee>getEmployeeListBySalary(){return employeeRepository.getEmployeeBySalary();}

	public List<Employee>getEmployeeListByAge(){return  employeeRepository.getEmployeeByAge();}
	
}
