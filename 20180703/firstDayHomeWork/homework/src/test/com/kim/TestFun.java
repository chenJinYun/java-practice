package test.com.kim;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import com.kim.Fun;

public class TestFun {
	private static Fun kim;
	@BeforeClass
	public static void init() {
		kim=new Fun();
	}
	@Test
	public void testBubbleSort() {
		boolean passed=true;
		int[] ms= {4,6,8,2,33,77,1,99};
		kim.bubbleSort(ms);
		for (int i = 0; i < ms.length-1; i++) {
			if(ms[i]>ms[i+1]) {
				passed=false;
			}
		}
		assertTrue(passed);
	}
	@Test
	public void testSelectSort() {
		boolean passed=true;
		int[] arr= {3,677,89,11,77,332,7,321,76};
		kim.selectSort(arr);
		for (int i = 0; i < arr.length-1; i++) {
			if(arr[i]>arr[i+1]) {
				passed=false;
			}
		}
		assertTrue(passed);
	}
	@Test
	public void testBinarySearch() {
		int[] ms= {1,2,3,4,5,6,7,8};
		int m1=kim.binarySearch(ms,3);
		int m2=kim.binarySearch(ms, 7);
		int m3=kim.binarySearch(ms, 0);
		assertTrue(m1==2);
		assertTrue(m2==6);
		assertTrue(m3==-1);
	}
	
}
