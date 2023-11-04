package sanitytests;

import org.testng.Assert;
import org.testng.annotations.Test;

import annoatations.RetryFailedCount;
import base.BaseTest;

public class LoginTest extends BaseTest {
	
	@Test
	void Test1() {
		Assert.assertEquals(5, 5);
	}
	
	@RetryFailedCount(value = 2)
	@Test
	void Test2() {
		Assert.assertEquals("abc1", "abc");
	}
	
	@RetryFailedCount(value = 4)
	@Test
	void Test3() {
		Assert.assertEquals(true, false);
	}
	

}
