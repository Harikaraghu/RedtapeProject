package scripts;

import org.testng.annotations.Test;

import ProjectPageFlow_Reuse.ReUse_PageFlow;
import config.StartBrowser;

public class TC01Test extends StartBrowser {
	 @Test
	  public void redtapeloginTest() throws Exception 
	  {
		   ReUse_PageFlow PgFlow = new ReUse_PageFlow();
		   PgFlow.RedTapeLogin();
		   
		   
	  }
}
