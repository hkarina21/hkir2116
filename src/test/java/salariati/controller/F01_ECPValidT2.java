package salariati.controller;

import org.junit.Test;
import salariati.enumeration.DidacticFunction;
import salariati.repository.implementations.EmployeeImpl;
import salariati.validator.EmployeeValidator;
import salariati.validator.ValidatorException;

import static org.junit.Assert.*;

public class F01_ECPValidT2 {


        private EmployeeValidator employeeValidator=new EmployeeValidator();
        private EmployeeImpl repo=new EmployeeImpl("testari.txt",employeeValidator);
        private EmployeeController ctrl=new EmployeeController(repo);

        @Test
        public void addEmployee() {
        //Prenumele trebuie sa fie format doar din litere si trebuie sa aiba lungimea minim 3
        //Salariul trebuie sa fie format doar din cifre si sa aiba lungimea mai mare decat 2 si sa fie pozitiv
       try{ ctrl.addEmployee("Georgescu","Mihaela","1256701234590", DidacticFunction.TEACHER,"1400");}
       catch (ValidatorException e){
               System.out.println(e.getMessage());
       }

        assertEquals("Adding 1 more employee to list", 1, repo.getEmployeeList().size());

    }



}