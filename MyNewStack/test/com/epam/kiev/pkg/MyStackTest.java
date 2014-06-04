package com.epam.kiev.pkg;

import java.util.EmptyStackException;
import static org.hamcrest.CoreMatchers.*;


import org.junit.After;
import org.junit.Before;
import org.junit.ComparisonFailure;
import org.junit.Test;

import static org.junit.Assert.*;
import junit.framework.AssertionFailedError;

import org.apache.log4j.Logger;

import com.epam.kiev.pkg.MyStack;

public class MyStackTest {
	private static Logger log = Logger.getLogger(MyStackTest.class);
	private MyStack stack;

	@Before
	public void setUp() throws Exception {
		stack= new MyStack();
	}

	@After
	public void tearDown() throws Exception {
		stack = null;
	}


	
	@Test //проверка empty
	public void testEmpty() {
		stack.empty();
		try{
			assertEquals(0, stack.position);	
		} catch (AssertionError e){
			   log.error ("Stack isn't empty!");
		}
		
	}
	
	@Test //проверка push
	public void testPush() {
		stack.push(11);
		stack.push(1);
		try{
			assertThat(stack.push(11), is(11));			
		} catch (AssertionError e){
			   log.error ("Method push work incorrect!");
		}
	}
	@Test //проверка peek
	public void testPeek() {
		stack.push(11);
		stack.push(1);
		stack.push(20);
		try{	
			assertThat(stack.peek(), is(20));	
		} catch (AssertionError e){
			   log.error ("Method peek work incorrect!");
		}
	}
	@Test //проверка pop
	public void testPop() {
		stack.push(11);
		stack.push(18);
		stack.push(12);
		stack.pop();
		try{
			
			assertThat(stack.peek(), is(18));		
		} catch (AssertionError e){
			   log.error ("Method pop work incorrect!");
		}
	}
	@Test(expected=IndexOutOfBoundsException.class)
	public void tst_IndexOutOfBounds()
	{
		for (int i=0; i<=12; i++){
		stack.push(1);
		}
	}
	
	@Test(expected=EmptyStackException.class)
	public void tst_EmptyStackPeek(){
		stack.empty();
		stack.peek();
		
	}
	
	@Test(expected=EmptyStackException.class)
	public void tst_EmptyStackPop(){
		stack.empty();
		stack.pop();
		
	}
	

	

}