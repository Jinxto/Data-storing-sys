package org.acme;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main{
	


  public static void main(String[]args) {
	  Quarkus.run(args);
  }
  public static class mainApp implements QuarkusApplication{
 //Override run method because we are using custom run method with parameters and logic, instead of default run method provided by the Quarkus application interface
 //when you start quarkus application, quarkus will automatically call this `run` method to start your application"	  
 // This is where you can do ur main method logic, here is an illustration only.	  
 //Right now we are using AppLifeCycleBean with @ApplicationScope annotation. Which means everytime the app starts the lifecycle will automatically create and run and do main logic.	  
	@Override
	public  int run(String...args) throws Exception {
		

		Quarkus.waitForExit();
		return 0;
	}
	  
  } 
}