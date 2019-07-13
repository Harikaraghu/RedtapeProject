package scripts;

import org.testng.annotations.Test;

import ProjectPageFlow_Reuse.ReUse_PageFlow;
import config.StartBrowser;

public class TC06Test extends StartBrowser {
	
	@Test
	  public void RedTapeProductsPage2Test() throws Exception {
		  
		  ReUse_PageFlow PgFlow = new ReUse_PageFlow();
		  PgFlow.RedTapeProductsPage2();
	  }
}
