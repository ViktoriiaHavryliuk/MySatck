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
	public void testThatStackIsEmpty() {
        assertTrue(stack.empty());
	}
	
	@Test //проверка push
	public void testThatCheksPushMetod() {
		int somerandomValue1 = 11;
		int somerandomValue2 = 42;
		stack.push(somerandomValue1);
		stack.push(somerandomValue2);
		assertThat(stack.push(somerandomValue2), is(somerandomValue2));			
	}
	@Test //проверка peek
	public void testCheksPeekMethod() {
		int somerandomValue1 = 11;
		int somerandomValue2 = 42;
		stack.push(somerandomValue1);
		stack.push(somerandomValue1);
		stack.push(somerandomValue2);
		assertThat(stack.peek(), is(somerandomValue2));	
	}
	@Test //проверка pop
	public void testThatChecksPopMethod() {
		int somerandomValue1 = 11;
		int somerandomValue2 = 42;
		stack.push(somerandomValue1);
		stack.push(somerandomValue2);
		stack.push(somerandomValue1);
		stack.pop();
		ssertThat(stack.peek(), is(somerandomValue2));		
	}
	@Test(expected=IndexOutOfBoundsException.class)
	public void tst_IndexOutOfBounds()
	{
		int somerandomValue1 = 11;
		int maxStackSize = 10;
		for (int i=0; i<=(maxStackSize+1); i++){
		stack.push(somerandomValue1);
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
