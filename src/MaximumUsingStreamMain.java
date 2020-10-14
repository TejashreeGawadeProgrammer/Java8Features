import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
 
public class MaximumUsingStreamMain {
	public static void main(String args[])
	{
		//filter all the employee whose age is greater than 20 and print the employee names.
		List<Employee> employeeList = createEmployeeList();
		List<String> employeeFilteredList = employeeList.stream()
		          .filter(e->e.getAge()>20)
		          .map(Employee::getName)
		          .collect(Collectors.toList());
		
		employeeFilteredList.forEach((name)-> System.out.println(name));
		
		//count number of employees with age 25
		List<Employee> employeeList1 = createEmployeeList();
		long count = employeeList1.stream()
		.filter(e->e.getAge()>25)
		.count();
		System.out.println("Number of employees with age 25 are : "+count);
		
		//find the employee with name “Mary”
		List<Employee> employeeList2 = createEmployeeList();
		Optional<Employee> e1 = employeeList2.stream()
		          .filter(e->e.getName().equalsIgnoreCase("Mary")).findAny();
		        
		if(e1.isPresent())
			System.out.println(e1.get());
		
		//Given a list of employee, find maximum age of employee?
		List<Employee> employeeList3 = createEmployeeList();
		OptionalInt max = employeeList3.stream().
				          mapToInt(Employee::getAge).max();
		        
		if(max.isPresent())
			System.out.println("Maximum age of Employee: "+max.getAsInt());
 
 
		//sort all the employee on the basis of age?
		/*List<Employee> employeeList5 = createEmployeeList();
		employeeList.sort((e1,e2)->e1.getAge()-e2.getAge());
		employeeList.forEach(System.out::println);*/
		
		
		//join the all employee names with “,” 
		List<Employee> employeeList4 = createEmployeeList();
		List<String> employeeNames = employeeList4
				                     .stream()
				                     .map(Employee::getName)
				                     .collect(Collectors.toList());
		String employeeNamesStr = String.join(",", employeeNames);
		System.out.println("Employees are: "+employeeNamesStr);
 


	}
	
	public static List<Employee> createEmployeeList()
	{
		List<Employee> employeeList=new ArrayList<>();
 
		Employee e1=new Employee("John",21);
		Employee e2=new Employee("Martin",19);
		Employee e3=new Employee("Mary",31);
		Employee e4=new Employee("Stephan",18);
		Employee e5=new Employee("Gary",26);
 
		employeeList.add(e1);
		employeeList.add(e2);
		employeeList.add(e3);
		employeeList.add(e4);
		employeeList.add(e5);
 
		return employeeList;
	}
}