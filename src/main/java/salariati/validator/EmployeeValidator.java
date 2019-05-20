package salariati.validator;


import salariati.enumeration.DidacticFunction;
import salariati.model.Employee;
import salariati.validator.ValidatorException;


public class EmployeeValidator {
	
	public EmployeeValidator(){}

	public void isValid(Employee employee) throws ValidatorException {
		String err="";
		if(!(employee.getLastName().matches("[a-zA-Z]+") && (employee.getLastName().length()> 2)))
			err=err.concat("Last Name not valid");
		if(!( employee.getCnp().matches("[0-9]+") && (employee.getCnp().length() == 13)))
			err=err.concat("CNP not valid");
		if(!( employee.getFunction().equals(DidacticFunction.ASISTENT) ||
								   employee.getFunction().equals(DidacticFunction.LECTURER) ||
								   employee.getFunction().equals(DidacticFunction.TEACHER)))
			err=err.concat("Function is not valid");
		if(!( employee.getSalary().matches("[0-9]+") &&(employee.getSalary().length() <6) && (employee.getSalary().length() > 1) && (Integer.parseInt(employee.getSalary()) > 0)
		))
			err=err.concat("Salary is not valid");
		if(err!="")
			throw new ValidatorException(err);
		
		//return isLastNameValid && isCNPValid && isFunctionValid && isSalaryValid;
	}



	}


	

