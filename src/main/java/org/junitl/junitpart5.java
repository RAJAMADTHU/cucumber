package org.junitl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.samp.Baseclass;
import org.samp.runingclass;
import org.samp.tasku3;



public class junitpart5  extends Baseclass
{

	@Test
	public void tc() {
		// TODO Auto-generated method stub
Result ru = JUnitCore.runClasses(runingclass.class,tasku3.class);


System.out.println("total test runcount;"+ru.getRunCount());
System.out.println("total test runtime;"+ru.getRunTime());
System.out.println("total test failurecount;"+ru.getFailureCount());
System.out.println("total testignorecount;"+ru.getIgnoreCount());
List<Failure> failures = ru.getFailures();

for (Failure fai : failures) {
	System.out.println(fai);
}
	}
	
}
