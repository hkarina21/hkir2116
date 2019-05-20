package salariati.integration;

import org.junit.Test;
import salariati.controller.EmployeeController;
import salariati.enumeration.DidacticFunction;
import salariati.model.Employee;
import salariati.repository.implementations.EmployeeImpl;
import salariati.validator.EmployeeValidator;
import salariati.validator.ValidatorException;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class IntegrationTest {

    private EmployeeValidator employeeValidator=new EmployeeValidator();
    private EmployeeImpl repo=new EmployeeImpl("employees.txt",employeeValidator);
    private EmployeeController ctrl=new EmployeeController(repo);




  //  @Test
  //  public void test01() {
        //P->A
        //Prenumele trebuie sa fie format doar din litere si trebuie sa aiba lungimea minim 3
        //Salariul trebuie sa fie format doar din cifre si sa aiba lungimea mai mare decat 2 si sa fie pozitiv
  //      try{ctrl.addEmployee("Alexandrescu", "Raluca", "1856701234567", DidacticFunction.LECTURER, "12054");}
  //      catch (ValidatorException e){
      //      System.out.println(e.getMessage());
   //     }

   //     assertEquals("Adding 1 more employee to list", 1, repo.getEmployeeList().size());


   // }


   // @Test
   // public void test02() {
        //P->B
 //       Employee employeeToAdd=new Employee("Grigore","Dorina","1239873456199",DidacticFunction.ASISTENT,"4300");
  //      try{repo.addEmployee(employeeToAdd);}
   //     catch (ValidatorException ex){
   //         System.out.println(ex.getMessage());
    //    }

  //      //List<Employee> employeeList=repo.getEmployeeList();
  //      //Employee e=repo.getEmployeeByCNP("1239873456199");
   //     repo.modifyEmployee("1239873456199", DidacticFunction.valueOf("TEACHER"));
   //     Employee e1=repo.getEmployeeByCNP("1239873456199");
   //     assertEquals(DidacticFunction.valueOf("TEACHER"),e1.getFunction());
   // }


  //  @Test
 //   public void test03(){
    //P->C
  //      List<Employee> employees=ctrl.getEmployeeListBySalary();
   //     Employee  minByAge = employees
   //             .stream()
   //             .min(Comparator.comparing(Employee::getSalary))
    //            .orElseThrow(NoSuchElementException::new);
    //    Employee first=employees.get(0);
    //    assertEquals("Should be Marcelin", first, minByAge);

   // }

    @Test
    public void test04(){
        //P->B->C->A B-valid C-valid A-not valid

        try{
        repo.modifyEmployee("1239873456199", DidacticFunction.valueOf("ASISTENT"));
        Employee e1=repo.getEmployeeByCNP("1239873456199");
        assertEquals(DidacticFunction.valueOf("ASISTENT"),e1.getFunction());
        List<Employee> employees=ctrl.getEmployeeListBySalary();
        Employee  minByAge = employees
                .stream()
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(NoSuchElementException::new);
        Employee first=employees.get(0);
        assertEquals("Should be Marcelin", first, minByAge);
        ctrl.addEmployee("Timofte","Teodora","1256701234590",DidacticFunction.ASISTENT,"12r");}
        catch (ValidatorException e){
            System.out.println(e.getMessage());
        }
    }


/*
    @Test
    public void test05(){
      // P->A->B A-valid B-valid
        try {
                ctrl.addEmployee("Zanoaga", "Andreea", "1856700034567", DidacticFunction.ASISTENT, "3200");
                assertEquals("Adding 1 more employee to list", 6, repo.getEmployeeList().size());
                ctrl.modifyEmployee("1856700034567", DidacticFunction.valueOf("LECTURER"));
                Employee e1 = repo.getEmployeeByCNP("1856700034567");
                assertEquals(DidacticFunction.valueOf("LECTURER"), e1.getFunction());
            } catch (ValidatorException e) {
                System.out.println(e.getMessage());
            } }
*/
    @Test
    public void test06(){
        //P->B->A->C B-not valid A-valid C-valid

    try{

        ctrl.modifyEmployee("1234567777123",DidacticFunction.valueOf("TEACHER"));
        Employee e1 = repo.getEmployeeByCNP("1856700034567");
        assertEquals(DidacticFunction.valueOf("LECTURER"), e1.getFunction());
        ctrl.addEmployee("Mocanu", "Andreea", "1889004567123", DidacticFunction.ASISTENT, "200");
        assertEquals("Adding 1 more employee to list", 7, repo.getEmployeeList().size());
        List<Employee> employees=ctrl.getEmployeeListBySalary();
        Employee  minByAge = employees
                .stream()
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(NoSuchElementException::new);
        Employee first=employees.get(0);
        assertEquals("Should be Andreea Mocanu", first, minByAge);
    }

    catch (ValidatorException e){
        System.out.println(e.getMessage());
    }
    }



    }















