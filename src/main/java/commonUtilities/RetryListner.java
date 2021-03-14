package commonUtilities;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class RetryListner implements IAnnotationTransformer{

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
	    
		@SuppressWarnings("deprecation")
		IRetryAnalyzer  retry = annotation.getRetryAnalyzer();
		
		if (retry == null)	{
			annotation.setRetryAnalyzer(ReTryTests.class);
		}
	}
}
