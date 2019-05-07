package salariati.repository.implementations;

import org.junit.Test;
import salariati.enumeration.DidacticFunction;
import salariati.model.Employee;
import salariati.validator.EmployeeValidator;
import salariati.validator.ValidatorException;

import java.util.List;

import static org.junit.Assert.*;

public class F02_WBTValid {


    private EmployeeValidator employeeValidator=new EmployeeValidator();
    private EmployeeImpl repo=new EmployeeImpl("employees.txt",employeeValidator);





    @Test
    public void modifyEmployee() {
        Employee employeeToAdd=new Employee("Grigore","Dorina","1239873456199",DidacticFunction.ASISTENT,"4300");
        try{repo.addEmployee(employeeToAdd);}
        catch (ValidatorException ex){
            System.out.println(ex.getMessage());
        }

        //List<Employee> employeeList=repo.getEmployeeList();
        //Employee e=repo.getEmployeeByCNP("1239873456199");
        repo.modifyEmployee("1239873456199", DidacticFunction.valueOf("TEACHER"));
        Employee e1=repo.getEmployeeByCNP("1239873456199");
        assertEquals(DidacticFunction.valueOf("TEACHER"),e1.getFunction());
}}