package salariati.repository.implementations;

import org.junit.Test;
import salariati.enumeration.DidacticFunction;
import salariati.model.Employee;
import salariati.validator.EmployeeValidator;
import salariati.validator.ValidatorException;

import java.util.List;

import static org.junit.Assert.*;

public class F02_WBTNonValid {


        private EmployeeValidator employeeValidator=new EmployeeValidator();
        private EmployeeImpl repo=new EmployeeImpl("testeF02",employeeValidator);

        @Test
        public void modifyEmployee() {
            Employee employeeToAdd=new Employee("Dorel","Marinela","1239873456123", DidacticFunction.ASISTENT,"4300");
            try{repo.addEmployee(employeeToAdd);}
            catch (ValidatorException ex){
                System.out.println(ex.getMessage());
            }

            //List<Employee> employeeList=repo.getEmployeeList();
           Employee e=repo.getEmployeeByCNP("1239873456123");

            repo.modifyEmployee("6789012345612", DidacticFunction.valueOf("TEACHER"));


           // Employee e1=repo.getEmployeeByCNP("1239873456123");
            assertEquals(e.getFunction(),DidacticFunction.valueOf("ASISTENT"));

        }}


