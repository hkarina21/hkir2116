package salariati.controller;

import org.junit.Test;
import salariati.enumeration.DidacticFunction;
import salariati.repository.implementations.EmployeeImpl;
import salariati.validator.EmployeeValidator;
import salariati.validator.ValidatorException;

import static org.junit.Assert.*;

public class F01_BVANonValidT2 {


    private EmployeeValidator employeeValidator=new EmployeeValidator();
    private EmployeeImpl repo=new EmployeeImpl("testariBVA.txt",employeeValidator);
    private EmployeeController ctrl=new EmployeeController(repo);

    @Test
    public void addEmployee() {
        //Prenumele trebuie sa fie format doar din litere si trebuie sa aiba lungimea minim 3
        //Salariul trebuie sa fie format doar din cifre si sa aiba lungimea mai mare decat 2 si sa fie pozitiv
        try{ctrl.addEmployee("Alexandrescu", "Georgiana", "1256701234590", DidacticFunction.ASISTENT, "1234567");}
        catch (ValidatorException e){
            System.out.println(e.getMessage());
        }

        assertEquals("salary length is not correct", 1, repo.getEmployeeList().size());


    }

}