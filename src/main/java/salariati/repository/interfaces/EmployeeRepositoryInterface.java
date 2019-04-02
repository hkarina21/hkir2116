package salariati.repository.interfaces;

import java.util.List;

import salariati.enumeration.DidacticFunction;
import salariati.model.Employee;

public interface EmployeeRepositoryInterface {
	
	boolean addEmployee(Employee employee);
	void deleteEmployee(Employee employee);
	void modifyEmployee(String CNP, DidacticFunction function);
	List<Employee> getEmployeeList();
	List<Employee> getEmployeeBySalary();
    public List<Employee> getEmployeeByAge();

}
