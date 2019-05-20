package salariati.controller;

import org.junit.Test;
import salariati.enumeration.DidacticFunction;
import salariati.model.Employee;
import salariati.repository.implementations.EmployeeImpl;
import salariati.validator.EmployeeValidator;
import salariati.validator.ValidatorException;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class EmployeeControllerTest {


    private EmployeeValidator employeeValidator=new EmployeeValidator();
    private EmployeeImpl repo=new EmployeeImpl("testari.txt",employeeValidator);
    private EmployeeController ctrl=new EmployeeController(repo);

    @Test
    public void test01() {
        List<Employee> employees=ctrl.getEmployeeListBySalary();
        Employee  minByAge = employees
                .stream()
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(NoSuchElementException::new);
        Employee first=employees.get(0);
        assertEquals("Should be Marcelin", first, minByAge);


    }


    @Test
    public void test02() {
        try{ctrl.addEmployee("Grigore","Dorina","123987345199", DidacticFunction.ASISTENT,"300");}
        catch (ValidatorException ex){
            System.out.println(ex.getMessage());
        }
        List<Employee> employees=ctrl.getEmployeeListBySalary();
        Employee  minByAge = employees
                .stream()
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(NoSuchElementException::new);
        Employee first=employees.get(0);
        assertEquals("Should be Grigore", first, minByAge);
    }



}