package Lab8;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AccountTester {

	@Test
	void testDeposit1() {
		Date date = new Date(); 
		Account a1 = new Current(10, 100.0, "John Smith", date, 3000);
		a1.deposit(100);
		double actual = 200; 
		double expected = a1.getBalance();
		assertEquals(expected, actual, 0.001, "Deposite() Failed!" + expected + " expected but "+ actual + " is given");
	
	}

	@Test
	void testDeposit2() {
		Date date = new Date(); 
		Account a1 = new Current(10, 100.0, "John Smith", date, 3000);
		a1.deposit(0);
		double actual = 100; 
		double expected = a1.getBalance();
		assertEquals(expected, actual, 0.001, "Deposite() Failed!" + expected + " expected but "+ actual + " is given");
	
	}
	@Test
	void testWithdraw1() {
		Date date = new Date(); 
		Account a1 = new Current(10, 100.0, "John Smith", date, 3000);
		try {
			a1.withdraw(50);			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());			
		}
		double actual = 50; 
		double expected = a1.getBalance();
		assertEquals(expected, actual, 0.001, "Withdraw() Failed!" + expected + " expected but "+ actual + " is given");
	}

	@Test
	void testWithdraw2() {
		Date date = new Date(); 
		Account a1 = new Current(10, 100.0, "John Smith", date, 3000);
		a1.deposit(0);
		double actual = 100; 
		double expected = a1.getBalance();
		assertEquals(expected, actual, 0.001, "Withdraw() Failed!" + expected + " expected but "+ actual + " is given");
	
	}

	@Test
	void testWithdraw3() {
		Date date = new Date(); 
		Account a1 = new Current(10, 100.0, "John Smith", date, 3000);
		assertThrows(NotEnoughMoneyException.class, ()->a1.withdraw(150));
	}
	
	@Test
	void testWithdraw4() {
		Date date = new Date(); 
		Account a1 = new Current(10, 4000.0, "John Smith", date, 3000);
		assertThrows(TransferNotAllowedException.class, ()->a1.withdraw(3500));
	}
	@Test
	void testWithdraw5() {
		Date date = new Date(); 
		Account a1 = new Current(10, 4000.0, "John Smith", date, 3000);
		assertThrows(TransferNotAllowedException.class, ()->a1.withdraw(3500));
	}

	@Test
	void testWithdraw6() {
		Date date = new Date(); 
		Account a1 = new Current(10, 3000.0, "John Smith", date, 3000);
		assertThrows(NotEnoughMoneyException.class, ()-> a1.withdraw(3500));
	}

	@Test
	void testGetAccountNo() {
		Date date = new Date(); 
		Account a1 = new Current(10, 100.0, "John Smith", date, 3000);
		int actual = 10; 
		int expected = a1.getAccountNo();
		assertEquals(expected, actual, "getAccountNo() Failed!" + expected + " expected but "+ actual + " is given");
	}
	
	@Test
	void testGetBalance() {
		Date date = new Date(); 
		Account a1 = new Current(10, 100.0, "John Smith", date, 3000);
		double actual = 100; 
		double expected = a1.getBalance();
		assertEquals(expected, actual, 0.001, "getBalance() Failed!" + expected + " expected but "+ actual + " is given");
	}
	
	@Test
	void testDateOpened() {
		Date date = new Date(); 
		Account a1 = new Current(10, 100.0, "John Smith", date, 3000);
		Date actual = date; 
		Date expected = a1.getDateOpened();
		boolean equal = actual.compareTo(expected) == 0;
		assertTrue(equal, "getDateOpened() Failed!" ); 
	}
	
	@Test
	void testGetName() {
		Date date = new Date(); 
		Account a1 = new Current(10, 100.0, "John Smith", date, 3000);
		String actual = "John Smith"; 
		String expected = a1.getFullName();
		boolean equal = actual.compareTo(expected) == 0;
		assertTrue(equal, "getFullName() Failed!" ); 
	}

	@Test
	void testTransferFrom1() {
		Date date = new Date(); 
		Account a1 = new Current(10, 100.0, "John Smith", date, 3000);
		Account a2 = new Current(20, 200.0, "Jane Smith", date, 3000);
		try {
			a1.transferFrom(a2,50);			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		double actual = 50;
		double expected = a1.getBalance();
		assertEquals(expected, actual, 0.001, "transferFrom() Failed!" + expected + " expected as a balance of the source account but "+ actual + " is given");
	}

	@Test
	void testTransferFrom2() {
		Date date = new Date(); 
		Account a1 = new Current(10, 100.0, "John Smith", date, 3000);
		Account a2 = new Current(20, 200.0, "Jane Smith", date, 3000);
		try {
			a1.transferFrom(a2,50);			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		double actual = 250;
		double expected = a2.getBalance();
		assertEquals(expected, actual, 0.001, "transferFrom() Failed!" + expected + " expected as a balance of the target account but "+ actual + " is given");
	}
	
	@Test
	void testTransferFrom3() {
		Date date = new Date(); 
		Account a1 = new Current(10, 100.0, "John Smith", date, 3000);
		Account a2 = new Current(20, 200.0, "Jane Smith", date, 3000);
		assertThrows(NotEnoughMoneyException.class, ()->a1.transferFrom(a2,150));

	}
	@Test
	void testTransferFrom4() {
		Date date = new Date(); 
		Account a1 = new Current(10, 3500.0, "John Smith", date, 3000);
		Account a2 = new Current(20, 200.0, "Jane Smith", date, 3000);
		assertThrows(TransferNotAllowedException.class, ()->a1.transferFrom(a2,3200));

	}
	
	@Test
	void testCompareTo1() {
		Date date = new Date(); 
		Account a1 = new Current(10, 3500.0, "John Smith", date, 3000);
		Account a2 = new Current(10, 3500.0, "John Smith", date, 3000);
		int actual = a1.compareTo(a2);
		int expected = 0; 
		assertEquals(expected, actual, "compareTo() Failed!" + expected + " expected but "+ actual + " is given");
	}

	@Test
	void testCompareTo2() {
		Date date = new Date(); 
		Account a1 = new Current(10, 3500.0, "John Smith", date, 3000);
		Account a2 = new Current(20, 30.0, "Jane Smith", date, 3000);
		int actual = a1.compareTo(a2);
		int expected = -1; 
		assertEquals(expected, actual, "compareTo() Failed!" + expected + " expected but "+ actual + " is given");
	}
	
	@Test
	void testCompareTo3() {
		Date date = new Date(); 
		Account a1 = new Current(10, 3500.0, "John Smith", date, 3000);
		Account a2 = new Current(20, 30.0, "Jane Smith", date, 3000);
		int actual = a2.compareTo(a1);
		int expected = 1; 
		assertEquals(expected, actual, "compareTo() Failed!" + expected + " expected but "+ actual + " is given");
	}

	@Test
	void testCompareTo4() {
		Date date = new Date(); 
		Account a1 = new Current(10, 3500.0, "John Smith", date, 3000);
		Account a2 = new Current(11, 3500.0, "John Smith", date, 3500);
		int actual = a1.compareTo(a2);
		int expected = -1; 
		assertEquals(expected, actual, "compareTo() Failed!" + expected + " expected but "+ actual + " is given");
	}
}
