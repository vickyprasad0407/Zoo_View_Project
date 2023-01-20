package com.practiceWeb_package;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.zooview.generics.BaseClass1;
@Listeners(com.zooview.generics.ListnerImplementaion.class)
public class DemoRun extends BaseClass1 {
	@Test
	public void test()
	{
		System.out.println("hello");
		Assert.fail();
	}

}
