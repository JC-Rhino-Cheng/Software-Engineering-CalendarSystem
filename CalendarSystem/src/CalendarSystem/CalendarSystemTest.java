package CalendarSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;

import java.util.Scanner;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;

class CalendarSystemTest {

	CalendarSystem test = null;
	@BeforeEach
	void setUp() throws Exception {
		test = new CalendarSystem();
	}

	@AfterEach
	void tearDown() throws Exception {
		test = null;
	}

	/**
	 * test method: CalendarSystem.isRunNian()
	 * test Year: 2024
	 */
	@Test
	void isRunNian_test1() {
		assertEquals(1, test.isRunNian(2024));
		//fail("Not yet implemented");
	}
	
	/**
	 * test method: CalendarSystem.isRunNian()
	 * test Year: 2022
	 */
	@Test
	void isRunNian_test2() {
		assertEquals(0, test.isRunNian(2022));
		//fail("Not yet implemented");
	}
	
	/**
	 * test method: CalendarSystem.split_string()
	 * test toSplit: "2022/04/01"
	 */
	@Test
	void split_string_test1() {
		String[] ans = test.split_string("2022/04/01");
		assertEquals("2022", ans[0]);
		assertEquals("04", ans[1]);
		assertEquals("01", ans[2]);
		//fail("Not yet implemented");
	}

	/**
	 * test method: CalendarSystem.split_string()
	 * test toSplit: "2022.04.01"
	 */
	@Test
	void split_string_test2() {
		String[] ans = test.split_string("2022.04.01");
		assertEquals("2022", ans[0]);
		assertEquals("04", ans[1]);
		assertEquals("01", ans[2]);
		//fail("Not yet implemented");
	}
	
	/**
	 * test method: CalendarSystem.find_error_message()
	 * test errorNum: 0
	 * test language: 1
	 */
	@Test
	void find_error_message_test1() {
		String expectedOut = "\nOops! Wrong Command! Please enter in right format!";
		assertEquals(expectedOut, test.find_error_message(0, 1));
		//fail("Not yet implemented");
	}

	/**
	 * test method: CalendarSystem.find_error_message()
	 * test errorNum: 3
	 * test language: 0
	 */
	@Test
	void find_error_message_test2() {
		String expectedOut = "請輸入一個正整數";
		assertEquals(expectedOut, test.find_error_message(3, 0));
		//fail("Not yet implemented");
	}
	
	/**
	 * test method: CalendarSystem.change_language()
	 * test language: 0
	 */
	@Test
	void change_language_test1() {
		assertEquals(1, test.change_language(0));
		//fail("Not yet implemented");
	}
	
	/**
	 * test method: CalendarSystem.change_language()
	 * test language: 1
	 */
	@Test
	void change_language_test2() {
		assertEquals(0, test.change_language(1));
		//fail("Not yet implemented");
	}
	
	/**
	 * test method: CalendarSystem.command()
	 * test language: 1
	 * test input: "A"
	 */
	@Test
	void command_test1() {
		String output = "Enter a command number or F (exit)\n\nCommands:\n1) A Show Calendar (specific year)\n2) B Year Conversion (western to sexagenary circle and zodiac)\n3) C Days Calculation (from today)\n4) D Date Calculation (by number of days)\n5) E 切換為中文版\n6) F Exit\n";
		String data = "A";
		ByteArrayOutputStream testOut = new ByteArrayOutputStream();
		ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
		System.setIn(testIn);
		System.setOut(new PrintStream(testOut));
		test.command(1);

		String realOutput = new String(testOut.toByteArray());
		assertEquals(output, realOutput);
		//fail("Not yet implemented");
	}
	
	/**
	 * test method: CalendarSystem.command()
	 * test language: 0
	 * test input: "c"
	 */
	@Test
	void command_test2() {
		String output = "輸入指令號碼或F（結束使用）？\n\n輸入指令:\n1) A 顯示該月月曆\n2) B 西元轉換干支、生肖\n3) C 計算天數\n4) D 計算日期\n5) E Change to English\n6) F 離開\n";
		String data = "c";
		ByteArrayOutputStream testOut = new ByteArrayOutputStream();
		ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
		System.setIn(testIn);
		System.setOut(new PrintStream(testOut));
		test.command(0);

		String realOutput = new String(testOut.toByteArray());
		assertEquals(output, realOutput);
		//fail("Not yet implemented");
	}
	
	/**
	 * test method: CalendarSystem.show_calendar()
	 * test inputDate: "2022/4.2"
	 * test language: 0
	 */
	@Test
	void show_calendar_test1() {
		String output = "\nSun\tMon\tTue\tWed\tThu\tFri\tSat\r\n\t\t\t\t\t1\t2\t\n3\t4\t5\t6\t7\t8\t9\t\n10\t11\t12\t13\t14\t15\t16\t\n17\t18\t19\t20\t21\t22\t23\t\n24\t25\t26\t27\t28\t29\t30\t\n\n\n";
		ByteArrayOutputStream testOut = new ByteArrayOutputStream();
		
		System.setOut(new PrintStream(testOut));
		test.show_calendar("2022/4.2", 0);

		String realOutput = new String(testOut.toByteArray());
		assertEquals(output, realOutput);
		//fail("Not yet implemented");
	}
	
	/**
	 * test method: CalendarSystem.show_calendar()
	 * test inputDate: "asdfjlk"
	 * test language: 1
	 */
	@Test
	void show_calendar_test2() {
		String output = "Please enter the date in right format: YYYY/MM/DD\r\n";
		ByteArrayOutputStream testOut = new ByteArrayOutputStream();
		
		System.setOut(new PrintStream(testOut));
		test.show_calendar("asdfjlk", 1);

		String realOutput = new String(testOut.toByteArray());
		assertEquals(output, realOutput);
		//fail("Not yet implemented");
	}
	
	/**
	 * test method: CalendarSystem.western_to_zodiac()
	 * test inputDate: "2024"
	 * test language: 0
	 */
	@Test
	void western_to_zodiac_test1() {
		String output = "\n2024是甲辰年，屬龍\n\r\n";

		ByteArrayOutputStream testOut = new ByteArrayOutputStream();

		System.setOut(new PrintStream(testOut));
		test.western_to_zodiac("2024", 0);

		String realOutput = new String(testOut.toByteArray());
		assertEquals(output, realOutput);
		//fail("Not yet implemented");
	}
	
	/**
	 * test method: CalendarSystem.western_to_zodiac()
	 * test inputDate: "2024"
	 * test language: 1
	 */
	@Test
	void western_to_zodiac_test2() {
		String output = "\n2024 is 甲辰年，屬龍\n\r\n";

		ByteArrayOutputStream testOut = new ByteArrayOutputStream();

		System.setOut(new PrintStream(testOut));
		test.western_to_zodiac("2024", 1);

		String realOutput = new String(testOut.toByteArray());
		assertEquals(output, realOutput);
		//fail("Not yet implemented");
	}

	/**
	 * test method: CalendarSystem.count_days()
	 * test inputDate: "2022/7.30"
	 * test language: 0
	 */
	@Test
	void count_days_test1() {
		
		LocalDate testDate = LocalDate.of(2022, Month.APRIL, 2);
		LocalDate today = LocalDate.now();
		
		long daysBetween = ChronoUnit.DAYS.between(testDate, today);
		long outputDays = 119 - daysBetween;
		
		String output = "\n2022/7.30距離今天還有" + outputDays +"天\n\r\n";

		ByteArrayOutputStream testOut = new ByteArrayOutputStream();

		System.setOut(new PrintStream(testOut));
		test.count_days("2022/7.30", 0);

		String realOutput = new String(testOut.toByteArray());
		assertEquals(output, realOutput);
		//fail("Not yet implemented");
	}
	
	/**
	 * test method: CalendarSystem.count_days()
	 * test inputDate: "2022.2.22"
	 * test language: 1
	 */
	@Test
	void count_days_test2() {
		
		LocalDate testDate = LocalDate.of(2022, Month.APRIL, 2);
		LocalDate today = LocalDate.now();
		
		long daysBetween = ChronoUnit.DAYS.between(testDate, today);
		long outputDays = 39 + daysBetween;
		
		String output = "\n2022.2.22 is still " + outputDays + " days away from today\n\r\n";

		ByteArrayOutputStream testOut = new ByteArrayOutputStream();

		System.setOut(new PrintStream(testOut));
		test.count_days("2022.2.22", 1);

		String realOutput = new String(testOut.toByteArray());
		assertEquals(output, realOutput);
		//fail("Not yet implemented");
	}

	/**
	 * test method: CalendarSystem.count_date()
	 * test inputDays: "39"
	 * test language: 1
	 */
	@Test
	void count_date_test1() {
		
		LocalDate today = LocalDate.now();
		LocalDate outputDate = today.plusDays(39);
		
		String output = "\nIt will be " + outputDate.toString().replace('-', '/') + " after 39 days\n\r\n";

		ByteArrayOutputStream testOut = new ByteArrayOutputStream();

		System.setOut(new PrintStream(testOut));
		test.count_date("39", 1);

		String realOutput = new String(testOut.toByteArray());
		assertEquals(output, realOutput);
		//fail("Not yet implemented");
	}

	/**
	 * test method: CalendarSystem.count_date()
	 * test inputDays: "-1"
	 * test language: 0
	 */
	@Test
	void count_date_test2() {
		String output = "請輸入一個正整數\r\n";

		ByteArrayOutputStream testOut = new ByteArrayOutputStream();

		System.setOut(new PrintStream(testOut));
		test.count_date("-1", 0);

		String realOutput = new String(testOut.toByteArray());
		assertEquals(output, realOutput);
		//fail("Not yet implemented");
	}

	/**
	 * test method: CalendarSystem.exit_to_true()
	 * test language: 0
	 */
	@Test
	void exit_to_true_test1() {
		String output = "結束了！\r\n";

		ByteArrayOutputStream testOut = new ByteArrayOutputStream();

		System.setOut(new PrintStream(testOut));
		test.exit_to_true(0);

		String realOutput = new String(testOut.toByteArray());
		assertEquals(output, realOutput);
		//fail("Not yet implemented");
	}
	
	/**
	 * test method: CalendarSystem.exit_to_true()
	 * test language: 1
	 */
	@Test
	void exit_to_true_test2() {
		String output = "Closing Calendar System!\r\n";

		ByteArrayOutputStream testOut = new ByteArrayOutputStream();

		System.setOut(new PrintStream(testOut));
		test.exit_to_true(1);

		String realOutput = new String(testOut.toByteArray());
		assertEquals(output, realOutput);
		//fail("Not yet implemented");
	}

	@Test
	void integration_test1() {

		// command
		// input "A"
		command_integrate_test1("A", 0);
		
		// function A, including isRunNian, split_string, find_error_message
		// input 2022/04/02
		show_calendar_integrate_test1("2022/04/02", 0);
		
		// command
		// input "B"
		command_integrate_test1("B", 0);
		
		// function B, including find_error_message
		western_to_zodiac_integrate_test1("2022", 0);
		
		// command
		// input "C"
		command_integrate_test1("C", 0);
		
		// function C, including split_string, find_error_message
		//count_days_integrate_test1();
		
		// command
		// input "D"
		command_integrate_test1("D", 0);
		
		// function D, including find_error_message
		//count_date_integrate_test1();
		
		// command
		// input "E"
		command_integrate_test1("E", 0);
		
		// function E
		change_language_integrate_test1(0);
		
		// command
		// input "F"
		command_integrate_test1("F", 0);
		
		// function F
		exit_to_true_integrate_test1(1);
		
		//fail("Not yet implemented");
	}

	@Test
	void integration_test2() {
		
		// command 
		// input "C" command_integrate_test1("C", 0); 
		command_integrate_test1("E", 0);
		
		// function E
		change_language_integrate_test1(0);
		
		// command
		// input "C"
		command_integrate_test1("C", 1);
		
		// function C, including split_string, find_error_message 
		count_days_integrate_test1("2022.2.22", 1); 
		//split_string_integrate_test1("2022.2.22");
		
		// command 
		// input "D"
		command_integrate_test1("D", 1);
		
		// function D, including find_error_message 
		count_date_integrate_test1("40", 1);
		
		// command
		// input "X"
		command_integrate_test2("X", 1);
		
		// function A, including find_error_message
		// input asd
		show_calendar_integrate_test2("asd", 1);
		
		// function E
		change_language_integrate_test1(1);
		
		// function F
		exit_to_true_integrate_test1(0);
		
		//fail("Not yet implemented");
	}
	
	
	
	
	
	
	
	/* The following are functions for the integration tests, 
	 * which are designed with fixed parameters passed from 
	 * the integration_test1 and integration_test2.
	 */
	void isRunNian_integrate_test1(int year) {
		
		// input year should be 2022
		assertEquals(0, test.isRunNian(year));
		//fail("Not yet implemented");
	}
	

	String[] split_string_integrate_test1(String inputDate) {
		
		// input inputDate should be "2022/04/02"
		String[] ans = test.split_string(inputDate);
		assertEquals("2022", ans[0]);
		assertEquals("04", ans[1]);
		assertEquals("02", ans[2]);
		return ans;
		//fail("Not yet implemented");
	}
	
	String[] split_string_integrate_test2(String inputDate) {
		
		// input inputDate should be "2022.2.22"
		String[] ans = test.split_string(inputDate);
		assertEquals("2022", ans[0]);
		assertEquals("2", ans[1]);
		assertEquals("22", ans[2]);
		return ans;
		//fail("Not yet implemented");
	}
	
	void find_error_message_integrate_test1(int errorNum, int language) {
		
		String expectedOut = "";
		
		String[] errorList = {
    		 "\n指令錯了！" + "請輸入 A/B/C/D/E(不分大小寫)\n", // wrong command (Chinese) 0
    		 "請輸入正確的格式：YYYY/MM/DD", // wrong date format (Chinese) 1
    		 "請輸入以正整數表示的西元年分", // wrong year format (Chinese) 2
    		 "請輸入一個正整數", // wrong number of days (Chinese) 3
    		 "",
    		 "\nOops! Wrong Command! Please enter in right format!", // wrong command (English)
    		 "Please enter the date in right format: YYYY/MM/DD", // wrong date format (English)
    		 "Please enter a positive western year", // wrong year format (English)
    		 "Please enter a positive number" // wrong number of days
    	};
		if(language == 0) {
			if(errorNum == 0) expectedOut = "\n指令錯了！" + "請輸入 A/B/C/D/E(不分大小寫)\n";
			else if(errorNum == 1) expectedOut = "請輸入正確的格式：YYYY/MM/DD";
			else if(errorNum == 2) expectedOut = "請輸入以正整數表示的西元年分";
			else if(errorNum == 3) expectedOut = "請輸入一個正整數";
		}
		else if(language == 1) {
			if(errorNum == 0) expectedOut = "\nOops! Wrong Command! Please enter in right format!";
			else if(errorNum == 1) expectedOut = "Please enter the date in right format: YYYY/MM/DD";
			else if(errorNum == 2) expectedOut = "Please enter a positive western year";
			else if(errorNum == 3) expectedOut = "Please enter a positive number";
		}
		
		assertEquals(expectedOut, test.find_error_message(errorNum, language));
		//fail("Not yet implemented");
	}
	

	void change_language_integrate_test1(int currentLanguage) {
		
		assertEquals(currentLanguage == 1 ? 0 : 1, test.change_language(currentLanguage));
		//fail("Not yet implemented");
	}
	

	void command_integrate_test1(String inputCommand, int language) {
		
		String output;
		output = language == 0 ?
				"輸入指令號碼或F（結束使用）？\n\n輸入指令:\n1) A 顯示該月月曆\n2) B 西元轉換干支、生肖\n3) C 計算天數\n4) D 計算日期\n5) E Change to English\n6) F 離開\n"
				:
				"Enter a command number or F (exit)\n\nCommands:\n1) A Show Calendar (specific year)\n2) B Year Conversion (western to sexagenary circle and zodiac)\n3) C Days Calculation (from today)\n4) D Date Calculation (by number of days)\n5) E 切換為中文版\n6) F Exit\n";
		
		//String data = inputCommand;
		ByteArrayOutputStream testOut = new ByteArrayOutputStream();
		ByteArrayInputStream testIn = new ByteArrayInputStream(inputCommand.getBytes());
		System.setIn(testIn);
		System.setOut(new PrintStream(testOut));
		test.command(language);

		String realOutput = new String(testOut.toByteArray());
		assertEquals(output, realOutput);
		//fail("Not yet implemented");
	}
	
	void command_integrate_test2(String inputCommand, int language) {
		find_error_message_integrate_test1(0, 1);
	}
	
	void show_calendar_integrate_test1(String inputDate, int language) {
		
		// input inputDate should be 2022/04/02
		
		String[] splitDate = split_string_integrate_test1(inputDate);
		isRunNian_integrate_test1(Integer.parseInt(splitDate[0]));
		
		String output;
		output = "\nSun\tMon\tTue\tWed\tThu\tFri\tSat\r\n\t\t\t\t\t1\t2\t\n3\t4\t5\t6\t7\t8\t9\t\n10\t11\t12\t13\t14\t15\t16\t\n17\t18\t19\t20\t21\t22\t23\t\n24\t25\t26\t27\t28\t29\t30\t\n\n\n";
		
		ByteArrayOutputStream testOut = new ByteArrayOutputStream();
		
		System.setOut(new PrintStream(testOut));
		test.show_calendar(inputDate, language);

		String realOutput = new String(testOut.toByteArray());
		assertEquals(output, realOutput);
		//fail("Not yet implemented");
	}
	
	void show_calendar_integrate_test2(String inputDate, int language) {
		
		// input inputDate should be asd
		
		find_error_message_integrate_test1(1, 1);
	}

	void western_to_zodiac_integrate_test1(String inputYear, int language) {
		
		// input inputYear should be "2022"
		String output;
		output = language == 1 ?
				"\n2022 is 壬寅年，屬虎\n\r\n"
				:
				"\n2022是壬寅年，屬虎\n\r\n";

		ByteArrayOutputStream testOut = new ByteArrayOutputStream();

		System.setOut(new PrintStream(testOut));
		test.western_to_zodiac(inputYear, language);

		String realOutput = new String(testOut.toByteArray());
		assertEquals(output, realOutput);
		//fail("Not yet implemented");
	}
	

	void count_days_integrate_test1(String inputDate, int language) {
		
		// input inputDate should be "2022.2.22", language should be 1
		String[] splitDate = split_string_integrate_test2(inputDate);
		
		LocalDate testDate = LocalDate.of(2022, Month.APRIL, 2);
		LocalDate today = LocalDate.now();
		
		long daysBetween = ChronoUnit.DAYS.between(testDate, today);
		long outputDays = 39 + daysBetween;
		
		String output = "\n" + inputDate + " is still " + outputDays + " days away from today\n\r\n";

		ByteArrayOutputStream testOut = new ByteArrayOutputStream();

		System.setOut(new PrintStream(testOut));
		test.count_days(inputDate, language);

		String realOutput = new String(testOut.toByteArray());
		assertEquals(output, realOutput);
		//fail("Not yet implemented");
	}


	void count_date_integrate_test1(String inputDays, int language) {
		
		// input inputDays should be "39", language should be 1
		LocalDate today = LocalDate.now();
		LocalDate outputDate = today.plusDays(Integer.parseInt(inputDays));
		
		String output = "\nIt will be " + outputDate.toString().replace('-', '/') + " after " + inputDays + " days\n\r\n";

		ByteArrayOutputStream testOut = new ByteArrayOutputStream();

		System.setOut(new PrintStream(testOut));
		test.count_date(inputDays, language);

		String realOutput = new String(testOut.toByteArray());
		assertEquals(output, realOutput);
		//fail("Not yet implemented");
	}
	

	void exit_to_true_integrate_test1(int language) {
		
		String output = language == 0 ? "結束了！\r\n" : "Closing Calendar System!\r\n";

		ByteArrayOutputStream testOut = new ByteArrayOutputStream();

		System.setOut(new PrintStream(testOut));
		test.exit_to_true(language);

		String realOutput = new String(testOut.toByteArray());
		assertEquals(output, realOutput);
		//fail("Not yet implemented");
	}
}
