import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		Course course = null;
		
		int amountOfModules = 0;
		Scanner scanner = new Scanner(System.in);
		
		boolean valid = false;
		
		do  {
			try {
				System.out.println("Enter the total amount of course credits: ");
				course = new Course(scanner.nextInt());
				valid = true;
			} catch(InputMismatchException e) {
				System.out.println(e);
			} catch(IllegalArgumentException e) {
				System.out.println(e);
			}
		} while(!valid);
		
		valid = false;
		
		do {
			try {
				System.out.println("Enter the total amount of modules: ");
				amountOfModules = scanner.nextInt();
				if(!(amountOfModules > 1 && amountOfModules <= 10)) {
					throw new IllegalArgumentException("Amount of modules must be between 2-10.");
				}
				valid = true;
			} catch(InputMismatchException e) {
				System.out.println(e);
			} catch(IllegalArgumentException e) {
				System.out.println(e);
			}
		} while(!valid);
		
		valid = false;
		
		for(int i = 0; i < amountOfModules; i++) {
			Module module;;
			module = new Module();
			do {
				try {
					System.out.println("Enter the module name: ");
					module.setName(scanner.next());
					valid = true;
				} catch(IllegalArgumentException e) {
					e.printStackTrace();
				}
			} while(!valid);
			
			valid = false;
			
			do {
				try {
					System.out.println("Enter the module credits: ");
					module.setCredits(scanner.nextInt());
					valid = true;
				} catch(IllegalArgumentException e) {
					System.out.println(e);
				}
			} while(!valid);
			
			valid = false;
			
			Result result;
			result = new Result().setModule(module);
			do {
				try {
					System.out.println("Enter the mark for this module: ");
					result.setMark(scanner.nextInt());
					valid = true;
				} catch(IllegalArgumentException e) {
					System.out.println(e);
				}
			} while(!valid);
		
			course.addResultToList(result);
		}
		
		//Check if enough credits entered and offer to add more or start again.
		
		scanner.close();
		
		System.out.println("Overall Mark: " + course.getOverallOverallAwardMark() + "%");
	}

}
