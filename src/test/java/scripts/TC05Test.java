package scripts;

import org.testng.annotations.Test;

import ProjectPageFlow_Reuse.ReUse_PageFlow;
import config.StartBrowser;

public class TC05Test extends StartBrowser {
	 @Test
	  public void RedTapeFootWearPageTest() throws Exception {
		  
		  ReUse_PageFlow PgFlow = new ReUse_PageFlow();
		  PgFlow.RedTapeFootWearPage();
	  }
}
