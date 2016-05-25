import java.text.NumberFormat;
import java.util.Scanner;

public class ComparisonFinal
{
    public static void main(String[] args)
    {
        // Declares variables for the two employees and arrays

        double employeeA;
        double employeeB;
        int length = 2;
        
        String[] names = new String[length];
        double[] aSales = new double[length];
        double[] totalComp = new double[length];

        /* Calls SalesPeople and TotalComp classes to get end user input the 
         * first salesperson and calculates the total compensation for the 
         * salesperson for the year. */
        
         for (int counter = 0; counter < length; counter++) 
        {
            SalesPeople person = new SalesPeople();
            person.enterNames();

            AnnualSales sales = new AnnualSales();
            sales.enterAnnualSales(person.employee);

            PotentialComp totalA = new PotentialComp();
            totalA.GetNewCompensationRate(sales.annualSales);
 
            names[counter] = person.employee;
            aSales[counter] = sales.annualSales;
            totalComp[counter] = totalA.totalComp;  
        }
        
        
         
        /* Begins the table that will display the arrays that are setup in the
         * for loops.*/

        System.out.println("Sales Person\tAnnual Sales\tTotal Compensation");
        
        System.out.println();
        
        for (int counter = 0; counter < 1; counter++)
        {
            System.out.println(names[0] + "\t\t" + NumberFormat
                               .getCurrencyInstance().format(aSales[0]) +
                               "\t" + NumberFormat.getCurrencyInstance()
                               .format(totalComp[0]));
        
            System.out.println(names[1] + "\t\t" + NumberFormat
                               .getCurrencyInstance().format(aSales[1]) +
                               "\t" + NumberFormat.getCurrencyInstance()
                               .format(totalComp[1]));
        }
            
            System.out.println();
            
            /* Calculates the differences between the two salespeople and 
             * and assigns them to each a variable. */
            
            employeeA = aSales[1] - aSales[0];
            employeeB = aSales[0] - aSales[1];
            
            /* Print to screen the amount that employeeA is going to need to 
             * exceed employeeB's total compensation.*/
            
        if (aSales[0] < aSales[1])
        {
            System.out.println(names[0] + " will need to earn "
                               + NumberFormat.getCurrencyInstance()
                               .format((employeeA + 1)) + " to exceed the total"
                               + " compensation of " + names[1] + ".");
        }
        
            /* Print to screen the amount that employeeB is going to need to 
             * exceed employeeA's total compensation.*/
        
        else
        {
            System.out.println(names[1] + " will need to earn "
                               + NumberFormat.getCurrencyInstance()
                               .format((employeeB + 1)) + " to exceed the total"
                               + " compensation of " + names[0] + ".");
        }
    }
}

//***************************************************************************//

class SalesPeople // Declares class of SalesPeople
{
    String employee;

    public void enterNames()
    {
        // End user will input the name of the salesperson.
        
        Scanner person = new Scanner(System.in);
        System.out.print("Enter the name of the employee: ");
            
        /*Validation of the end user inputting a name without a number or a
          special character in it.*/
            
            while (!person.hasNext("[A-Z,a-z]+")) 
            {
                System.out.println();
                System.out.println("Your name cannot have numbers or"
                                   + " special characters in it.");
                System.out.println();
                System.out.print("Enter the name of the employee: ");
                person.next();
            }
            
        employee = person.next();    
    } 
}

//***************************************************************************//

class AnnualSales // Declares TotalComp class
{
     // introduces variables needed to make all of the calculations.
     
        double annualSales;
       
       
       
    public void enterAnnualSales(String employee)
    {  
        // Prompts the end user to Enter the annual sales of the employee
        
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the annual sales for " + employee + ": ");

        /*Validation of the end user inputting a name without a letter or a
          special character in it.*/
        
        while (!keyboard.hasNextDouble())
        {
            System.out.println();
            System.out.println("Your annual sales cannot have letters or"
                               + " special characters in it." );
            System.out.println();
            System.out.print("Enter the annual sales for " + employee
                             + ": ");
            keyboard.next();
        }
            annualSales = keyboard.nextDouble();
        
            PotentialComp callCalc = new PotentialComp();
            callCalc.GetNewCompensationRate(annualSales);
            
            System.out.println("The employee's total annual compensation is " +
                          java.text.NumberFormat.getCurrencyInstance().format
                          (callCalc.totalComp));
  
        System.out.println();
        
       
        
       
     }//end of totalCompensation
     
}//end of class

//***************************************************************************//

class PotentialComp {
       
       double annualPay;   //refers to the base annual pay of $30,000
       double commission;  //refers to the Commission dollar amount
       double commissionRate;  //standard commission rate of 8%
       double totalComp;     // refers to annual pay plus commission
    
   public double GetNewCompensationRate(double annualSales)
   {
       
       if (annualSales < 320000)
       { 
          commissionRate = annualSales*.00;    
       }   
       else if (annualSales < 400000)
       { 
          commissionRate = annualSales*.08;
       }
       else if (annualSales >= 400000)
       { 
          commissionRate = annualSales*.1;
       }
       
       
       annualPay = 30000;  
       commission = annualSales * commissionRate;
       totalComp = commissionRate + annualPay; 
       
       return totalComp;
   }
}

/*References
*
*  Gladdis, T. (2011).  Starting out with Java: Early Objects (4th ed.). 
*            Retrieved from The UOP Ebook Collection database.
*
*  http://stackoverflow.com/questions/3090795/restrict-string-input-from-user-
*  to-alphabetic-and-numerical-values
*/
