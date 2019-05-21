package salariati.controller;

import org.junit.Test;
import salariati.enumeration.DidacticFunction;
import salariati.model.Employee;
import salariati.repository.implementations.EmployeeImpl;
import salariati.validator.EmployeeValidator;
import salariati.validator.ValidatorException;

import static org.junit.Assert.*;
import static salariati.enumeration.DidacticFunction.ASISTENT;

public class F01_ECPValid {
    private EmployeeValidator employeeValidator=new EmployeeValidator();
    private EmployeeImpl repo=new EmployeeImpl("testari.txt",employeeValidator);
    private EmployeeController ctrl=new EmployeeController(repo);

    @Test
    public void addEmployee() {
        //Prenumele trebuie sa fie format doar din litere si trebuie sa aiba lungimea minim 3
        //Salariul trebuie sa fie format doar din cifre si sa aiba lungimea mai mare decat 2 si sa fie pozitiv
        try{ctrl.addEmployee("Timofte","Teodora","1856701234567",DidacticFunction.ASISTENT,"1200");
            assertEquals("Adding 1 more employee to list", 6, repo.getEmployeeList().size());}
        catch (ValidatorException e) {
            System.out.println(e.getMessage());


        }
    }


}