package salariati.controller;

import org.junit.Test;
import salariati.enumeration.DidacticFunction;
import salariati.repository.implementations.EmployeeImpl;
import salariati.validator.EmployeeValidator;

import static org.junit.Assert.*;

public class F01_ECPNonValid {
    private EmployeeValidator employeeValidator=new EmployeeValidator();
    private EmployeeImpl repo=new EmployeeImpl("testari.txt",employeeValidator);
    private EmployeeController ctrl=new EmployeeController(repo);

    @Test
    public void addEmployee() {
        //Prenumele trebuie sa fie format doar din litere si trebuie sa aiba lungimea minim 3
        //Salariul trebuie sa fie format doar din cifre si sa aiba lungimea mai mare decat 2 si sa fie pozitiv
        ctrl.addEmployee("Timofte","Teo3dora","1856701234567",DidacticFunction.ASISTENT,"1200");

        assertEquals("Adding 1 more fruit to list", 1, repo.getEmployeeList().size());

    }
}