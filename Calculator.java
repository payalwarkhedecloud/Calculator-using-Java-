import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator 
{

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalc = true;

        System.out.println("...Welcome to Java Calculator...");

        while (continueCalc) 
        {
            double num1 = 0, num2 = 0;
            char operator;
            double result = 0;

            try 
            {
                // Input first number
                System.out.print("Enter the first number: ");
                num1 = scanner.nextDouble();

                // Input operator
                System.out.print("Enter operator (+, -, *, /, ,^): ");
                operator = scanner.next().charAt(0);

                // Input second number
                System.out.print("Enter the second number: ");
                num2 = scanner.nextDouble();

                // Perform calculation
                switch (operator) 
                {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        if (num2 == 0) {
                            System.out.println("Error: Division by zero is not allowed.");
                            continue;
                        }
                        result = num1 / num2;
                        break;
                    case '%':
                        if (num2 == 0) {
                            System.out.println("Error: Modulus by zero is not allowed.");
                            continue;
                        }
                        result = num1 % num2;
                        break;
                    case '^':
                        result = Math.pow(num1, num2);
                        break;
                    default:
                        System.out.println("Invalid operator! Please use +, -, *, /, %, or ^.");
                        continue;
                }

                System.out.println("The Result of num1 and num2 is: " + result);

            } 
	        catch (InputMismatchException e) 
	        {
                System.out.println("Invalid input! Please enter numeric values.");
                //scanner.nextLine(); // clear invalid input
                //continue;
            }

            // Ask if the user wants to continue
            System.out.print("Do you want to perform another calculation? (y/n): ");
            char choice = scanner.next().charAt(0);
            if (choice != 'y' && choice != 'Y') 
	        {
                continueCalc = false;
                System.out.println("Thank you for using the Java Calculator");
            }
        }

        scanner.close();
    }
}