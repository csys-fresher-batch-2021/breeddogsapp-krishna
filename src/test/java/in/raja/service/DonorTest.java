package in.raja.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class DonorTest 
{
	@Test
	public void test1() {
	
		boolean valid=DogManager.displayDonor("Kirthika");
		assertTrue(valid);
		
	}
	@Test
	public void test2()
	{
		boolean valid=DogManager.displayDonor("vinay");
		assertFalse(valid);
		
	}
	@Test
	
		public void test3()
		{
			
			boolean valid=DogManager.displayDonor("Swetha");
			assertTrue(valid);
		}
	@Test
	
	public void test4()
	{
		
		boolean valid=DogManager.displayDonor("anu");
		assertFalse(valid);
	}
}


