package com.msp.dao;

import java.util.Calendar;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.msp.model.Person;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( {"/applicationContext.xml"})
@TransactionConfiguration(transactionManager = "transactionManager")
@Transactional
public class SstaDaoTest {
	
	@Autowired private SessionFactory sessionFactory;
	
	@Test public void testGetDay() {
		try {
			Calendar cal = Calendar.getInstance();
			
			System.out.println("day is " + cal.get(Calendar.DAY_OF_WEEK));
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue("failed with exception", false);
		}
	}
	
//	@Test public void testRollMonth() {
//		try {
//			Calendar cal = Calendar.getInstance();
//			cal.set(Calendar.MONTH, 1);
//			
//			System.out.println("day is " + cal.get(Calendar.DAY_OF_WEEK));
//			System.out.println("date is " + cal.getTime());
//			
//			Date dt = DateUtils.rollMonth(cal.getTime(), -3, true);
//			
//			System.out.println("3 months ago is " + dt);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			Assert.assertTrue("failed with exception", false);
//		}
//	}
	
	@Test public void testGetPerson() {
		try {
			RestDao dao = new RestDao(sessionFactory);
			
			Person s = dao.getPerson(1L);
			
			Assert.assertNotNull("should get results", s);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue("failed with exception", false);
		}
	}
	
	
	@Test public void testSavePerson() {
		try {
			RestDao dao = new RestDao(sessionFactory);
			Person p = new Person();
			
			dao.save(p, false);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue("failed with exception", false);
		}
	}
	

}
