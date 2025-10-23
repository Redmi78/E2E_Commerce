package FailedTestCases;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    int maxRetryCount = 1;
    //int Count = 0;
    ThreadLocal<Integer> retryCount = ThreadLocal.withInitial(() -> 0);
    @Override
    public boolean retry(ITestResult result) {
       if(!result.isSuccess()){
           System.out.println("Retrying test: " + result.getName());
           if(retryCount.get() < maxRetryCount){
               retryCount.set(retryCount.get()+1);
               return true;
           }
       }
       return false;
    }
}
