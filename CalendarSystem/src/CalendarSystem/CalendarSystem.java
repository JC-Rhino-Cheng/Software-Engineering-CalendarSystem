package CalendarSystem;

import java.util.Scanner;
import java.util.Calendar;
import java.lang.Math;

public class CalendarSystem {
     
	 static final int NUMOFERRORTYPE = 5;
     
     /*** Create the user interface of the Calendar System.
      * @param args
      *	@return none
      * Time estimate:O(1)
      */
     public static void main(String[] args) {
    	 
         CalendarSystem calendarsystem = new CalendarSystem();
         boolean exit = false;
         int language = 0;
         while(!exit) {
        	 
             char command = calendarsystem.command(language);
             Scanner in = new Scanner(System.in);
             String input;
             
             switch(command) {
                 case 'A':
                 case 'a':
                	 if(language == 0) {
                		 System.out.printf("�п�J���d�ߤ���]�~/��/��^�G");
                	 }
                	 else System.out.printf("Please enter a date to show calendar: ");

                     input = in.next();
                     calendarsystem.show_calendar(input, language);
                     break;
                 case 'B':
                 case 'b':
                	 if(language == 0) {
                		 System.out.printf("\n�п�J���d�ߦ~�G");
                	 }
                	 else System.out.printf("Please enter a western year to convert: ");
                	 
                     input = in.next();
                     calendarsystem.western_to_zodiac(input, language);
                     break;
                 case 'C':
                 case 'c':
                	 if(language == 0) {
                		 System.out.printf("\n�п�J�d�ߤ���G");
                	 }
                	 else System.out.printf("Please enter a date: ");

                     input = in.next();
                     calendarsystem.count_days(input, language);
                     break;
                 case 'D':
                 case 'd':
                	 if(language == 0) {
                		 System.out.printf("�п�J������⪺�ѼơG");
                	 }
                	 else System.out.printf("Please enter the number of days: ");

                     input = in.next();
                     calendarsystem.count_date(input, language);
                     break;
                 case 'E':
                 case 'e':
                	 language = calendarsystem.change_language(language);
                	 break;
                 case 'F':
                 case 'f':
                     exit = calendarsystem.exit_to_true(language);
                     break;
                 default:
                	 System.out.println(calendarsystem.find_error_message(0, language));
                	 break;
             }
         }   
     }
     
     /*** Output the command choices for user and read the user input.
      * @param language
      *	@return the command input by the user.
      * * Example: User input is 'A': return 'A'.
      * Time estimate: O(n), where n is the input length
      */
     public char command(int language) {
    	 
         if(language == 0) {
        	 System.out.printf("��J���O���X��F�]�����ϥΡ^�H\n\n");
             System.out.printf("��J���O:\n");
             System.out.printf("1) A ��ܸӤ���\n");
             System.out.printf("2) B �褸�ഫ�z��B�ͨv\n");
             System.out.printf("3) C �p��Ѽ�\n");
             System.out.printf("4) D �p����\n");
        	 System.out.printf("5) E Change to English\n");
        	 System.out.printf("6) F ���}\n");
         }
         else {
        	 System.out.printf("Enter a command number or F (exit)\n\n");
             System.out.printf("Commands:\n");
             System.out.printf("1) A Show Calendar (specific year)\n");
             System.out.printf("2) B Year Conversion (western to sexagenary circle and zodiac)\n");
             System.out.printf("3) C Days Calculation (from today)\n");
             System.out.printf("4) D Date Calculation (by number of days)\n");
        	 System.out.printf("5) E ���������媩\n");
        	 System.out.printf("6) F Exit\n");
         }
         
         Scanner scanner = new Scanner(System.in);
         String input = scanner.next();
         if(input.length() > 1) return 'X';
         return input.charAt(0);
     }
     
     /*** Find the relative error message.
      * @param errorNum, language
      *	@return the correct error message.
      * * Example: find_error_message(0, 0): return errorList[0], which
      * 		   is "\n���O���F�I" + "�п�J A/B/C/D/E(�����j�p�g)\n".
      * Time estimate: O(1)
      */
     public String find_error_message(int errorNum, int language) {
    	 
    	 String[] errorList = {
    		 "\n���O���F�I" + "�п�J A/B/C/D/E(�����j�p�g)\n", // wrong command (Chinese) 0
    		 "�п�J���T���榡�GYYYY/MM/DD", // wrong date format (Chinese) 1
    		 "�п�J�H����ƪ�ܪ��褸�~��", // wrong year format (Chinese) 2
    		 "�п�J�@�ӥ����", // wrong number of days (Chinese) 3
    		 "",
    		 "\nOops! Wrong Command! Please enter in right format!", // wrong command (English)
    		 "Please enter the date in right format: YYYY/MM/DD", // wrong date format (English)
    		 "Please enter a positive western year", // wrong year format (English)
    		 "Please enter a positive number" // wrong number of days
    	 };
    	 
    	 return errorList[errorNum + language * NUMOFERRORTYPE];
     }
     
     /*** Change the language of Calendar System.
      * @param language
      * @throws RuntimeException
      * Basically the variable "language" would not have value other than 0 or 1 so far,
      * so throw a RuntimeException if it had happened.
      *	@return language after changed.
      * * Example: language passed in is 0: return 1.
      * Time estimate: O(1)
      */
     public int change_language(int language) {
    	 if(language != 0 && language != 1) throw new RuntimeException("Something went wrong!!!");
    	 return (language-2) / (-2);
     }
     
     /*** Split the string, or specifically date.
      * @param toSplit
      *	@return String array storing the split data.
      * * Example: language passed in is "2022/04/01": return isSplit = {"2022", "04", "01"}.
      * Time estimate: O(n), where n is the length of toSplit
      */
     public String[] split_string(String toSplit) {
    	 
    	 String[] isSplit;
    	 String toReplace;
    	 
    	 toReplace = toSplit.replace(".", "/");
    	 toReplace = toReplace.replace("-", "/");
    	 isSplit = toReplace.split("/");
    	 
    	 return isSplit;
     }
     
     
     /*** Check whether a specific year passed in is a leap year.
      * @param Year
      *	@return 1 if Year is a leap year. Otherwise, 0.
      * * Example 1: Year is 2024: return 1.
      * * Example 2: Year is 2022: return 0.
      * Time estimate:O(1)
      */
     public int isRunNian(int Year) {
    	 if (Year % 400 == 0) return 1;
     	 /*else*/ if (Year % 100 == 0) return 0;
     	 /*else*/ if (Year % 4 == 0) return 1;
     	 /*else*/ /*if (Year % 4 != 0)*/ return 0;
     }
    
     /*** Implement the function of showing calendar.
      * @param inputDate, language
      * @throws RuntimeException, StringIndexOutOfBoundsException, NumberFormatException
      * If the input is not in the format of "YYYY/MM/DD", where the delimiter can be '/' or '.' or '-',
      * then it will throw exception and get caught by try-catch block. 
      *	@return none
      * Time estimate: O(n), bottleneck is string splitting in the method "split_string"
      */
     public void show_calendar(String inputDate, int language) {

         try {
	         
        	 // Splitting the input date string
        	 String[] GoalDate = split_string(inputDate);
	         int[] IntGoalDate = {Integer.parseInt(GoalDate[0])/*�~*/, Integer.parseInt(GoalDate[1])/*��*/, Integer.parseInt(GoalDate[2])/*��*/};
	     
	         // Checking how long this month would be
	         int[] numOfDaysForThisMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	         numOfDaysForThisMonth[1] += isRunNian(IntGoalDate[0]);
	         
	         
	         Calendar GoalCal = Calendar.getInstance();
	         GoalCal.set(IntGoalDate[0], IntGoalDate[1]-1, 1);
	
	         int howManyTabs = GoalCal.get(Calendar.DAY_OF_WEEK)-1;
	         
	         
	         System.out.println("\nSun\tMon\tTue\tWed\tThu\tFri\tSat");
	         for(int i=0;i<howManyTabs;i++)System.out.printf("\t");
	         int curNumOfTabs = howManyTabs;
	         
	         int i = 1;
	         while(i<=numOfDaysForThisMonth[IntGoalDate[1]-1]) {
	         	System.out.printf("%d\t", i);
	         	i++;
	         	curNumOfTabs++;
	         	if(curNumOfTabs == 7) {
	         		System.out.printf("\n");
	         		curNumOfTabs = 0;
	         	}
	         }
	         System.out.printf("\n\n");
	         
         } catch (Exception e){
	    	 //System.out.println("�п�J���T���榡�GYYYY/MM/DD");
        	 System.out.println(this.find_error_message(1, language));
	    	 return;
         }
     }
     
     /*** Convert western years to sexagenary circle and zodiac.
      * @param inputYear, language
      * @throws ArithmeticException
      * If the input is not an positive integer, then it will throw
      * ArithmeticException and get caught by try-catch block.
      *	@return none
      * Time estimate: O(n), where n is the input size
      */
     public void western_to_zodiac(String inputYear, int language) {
    	 
         String[] TianGan = {"��", "��", "�A", "��", "�B", "��", "�v", "��", "��", "��"};
         String[] DiZhi = {"��", "�l", "��", "�G", "�f", "��", "�x", "��", "��", "��", "��", "��"};
         String[] Zodiac = {"��", "��", "��", "��", "��", "�s", "�D", "��", "��", "�U", "��", "��"};

         try {
        	 
		     int westYears = Integer.parseInt(inputYear);
		    
		     if(westYears < 0) {
	        	 throw new ArithmeticException("���������t��>_<");
	         }
		     
		     int T = (westYears - 3) % 60 % 10;
		     int D = (westYears - 3) % 60 % 12;
		    
		     if(language == 0) {
		    	 System.out.println("\n" + westYears + "�O" + TianGan[T] + DiZhi[D] + "�~�A��" + Zodiac[D] + "\n");
		     }
		     else System.out.println("\n" + westYears + " is " + TianGan[T] + DiZhi[D] + "�~�A��" + Zodiac[D] + "\n");
		     
		 } catch(Exception e) {
			 //System.out.println("�п�J�H����ƪ�ܪ��褸�~��");
			 System.out.println(this.find_error_message(2, language));
		 }
     }
    
     /*** Count number of days between today and the specific date.
      * @param inputDate, language
      * @throws RuntimeException, StringIndexOutOfBoundsException, NumberFormatException
      * If the input is not in the format of "YYYY/MM/DD", where the delimiter can be '/' or '.' or '-',
      * then it will throw exception and get caught by try-catch block. 
      *	@return none
      * Time estimate: O(n), bottleneck is string splitting in the method "split_string"
      */
     public void count_days(String inputDate, int language) {
    	 
         try {
        	 
	         // Splitting the input date string
        	 String[] GoalDate = split_string(inputDate);
	         int[] IntGoalDate = {Integer.parseInt(GoalDate[0]), Integer.parseInt(GoalDate[1]), Integer.parseInt(GoalDate[2])};
	        
	         // Get the calendar today
	         Calendar cal = Calendar.getInstance();
	     
	         // Get the calendar of the goal date
	         Calendar GoalCal = Calendar.getInstance();
	         GoalCal.set(IntGoalDate[0], IntGoalDate[1]-1, IntGoalDate[2]);
	        
	         // Count the difference
	         double HowManyDays = Math.abs(( ((GoalCal.getTimeInMillis()/1000 - cal.getTimeInMillis()/1000)) / (60.0*60.0*24.0) ));
	         if(language == 0) {
	        	 System.out.println("\n" + inputDate + "�Z�������٦�" + (int)Math.floor(HowManyDays) + "��\n");
	         }
	         else System.out.println("\n" + inputDate + " is still " + (int)Math.floor(HowManyDays) + " days away from today\n");
	         
         } catch(Exception e) {
        	 //System.out.println("�п�J���T���榡�GYYYY/MM/DD");
        	 System.out.println(this.find_error_message(1, language));
         }
     }
     
     /*** Count the date after a specific number of days from today.
      * @param inputDays, language
      * @throws ArithmeticException
      * If the input is not an positive integer representing a number of days, 
      * then it will throw ArithmeticException.
      *	@return none
      * Time estimate: O(n), where n is the input size
      */
     public void count_date(String inputDays, int language) {
    	 
         try {
        	 
	         // Convert the input days string into int
	         int HowManyDays = Integer.parseInt(inputDays);
	         if(HowManyDays < 0) {
	        	 throw new ArithmeticException("���������t��>_<");
	         }
	        
	         // Get the calendar of now
	         Calendar cal = Calendar.getInstance();

	         // Count the date
	         cal.add(Calendar.DAY_OF_YEAR, HowManyDays);
	        
	         // Adjust the date format
	         int m = cal.get(Calendar.MONTH) + 1;
	         int d = cal.get(Calendar.DATE);
	         if(language == 0) {
	        	 System.out.println("\n����" + inputDays + "�ѬO" + cal.get(Calendar.YEAR) + "/" + (m >=10 ? m : ("0"+m)) + "/" + (d >=10 ? d : ("0"+d)) + "\n");
	         }
	         else System.out.println("\nIt will be " + cal.get(Calendar.YEAR) + "/" + (m >=10 ? m : ("0"+m)) + "/" + (d >=10 ? d : ("0"+d)) + " after " + inputDays + " days\n");
	      
         } catch(Exception e) {
        	 //System.out.println("�п�J�@�ӥ����");
        	 System.out.println(this.find_error_message(3, language));
         }
         
     }
    
     /*** Output finish message and exit Calendar System.
      * @param language
      *	@return true to represent it's time to exit.
      * Time estimate: O(1)
      */
     public boolean exit_to_true(int language) {
	 
	 	 if(language == 0) {
	 		 System.out.println("�����F�I");
	 	 }
	 	 else System.out.println("Closing Calendar System!");
         return true;
     }
    
}