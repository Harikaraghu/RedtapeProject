package ProjectPageFlow_Reuse;

import PageFactory_OR.CartPage;
import PageFactory_OR.CheckoutPage;
import PageFactory_OR.FootWearPage;
import PageFactory_OR.HomePage;
import PageFactory_OR.ProductsPage;
import PageFactory_OR.ProductsPage2;
import PageFactory_OR.SignIn_Page;
import SeleniumCommands.ActionDriver;
import config.StartBrowser;

public class ReUse_PageFlow extends StartBrowser {
	
	ActionDriver aDriver;
	
	public ReUse_PageFlow() 
	{
		aDriver = new ActionDriver();
	}
	
	public void RedTapeLogin() throws Exception 
	{
		 StartBrowser.ChildTest = StartBrowser.ParentTest.createNode("Login in to Application");
		 Thread.sleep(5000);
		 aDriver.Click(SignIn_Page.LnkSignIn, "SignIn Link");
		 aDriver.Type(SignIn_Page.txtUsername, "raghuchattu87@gmail.com", "UserName");
		 aDriver.Type(SignIn_Page.txtPassWord, "Ammulu@16", "PassWord");
		 aDriver.Click(SignIn_Page.btnSignIn, "SignIn Button");
		   
	}
	
	public void  RedTapeHomePage() throws Exception 
	{
		StartBrowser.ChildTest = StartBrowser.ParentTest.createNode("Application Home Page");
		aDriver.VerifyLoginUserName(HomePage.txtTitle, "RAGHUR...", "Login UserName");
		aDriver.Action(HomePage.Msproduts, "Products DropDown");
		aDriver.Click(HomePage.LnkShirts, "Shirts Link");
	}
	public void RedTapeProductsPage1() throws Exception 
	{
		StartBrowser.ChildTest = StartBrowser.ParentTest.createNode("Application Mens Shirts Products Page");
		aDriver.VerifyPageUrl("https://redtape.com/apparel/shirts", "Men-Shirts Products Page");
		Thread.sleep(5000);
		aDriver.Click(ProductsPage.slctProduct, "Shirt");
		Thread.sleep(2000);
		aDriver.Click(ProductsPage.SlctSize, "Shirt Size");
		aDriver.SelectOption(ProductsPage.SlctQnty, "2", "Product Quantity");
		aDriver.Click(ProductsPage.BtnCart, "AddToCart Button");
	}
	
	public void RedTapeCartPage() throws Exception 
	{
		StartBrowser.ChildTest = StartBrowser.ParentTest.createNode("Application Cart Page");
		Thread.sleep(2000);
		aDriver.VerifyPageUrl("https://redtape.com/cart","Cart Page");
		Thread.sleep(5000);
		aDriver.Click( CartPage.BtnCntShping, "Continue-Shopping Button");
	}
	
	public void RedTapeFootWearPage() throws Exception 
	{   
		StartBrowser.ChildTest = StartBrowser.ParentTest.createNode("Application FootWear Products Home Page");
		aDriver.VerifyPageUrl("https://redtape.com/footwear", "FootWear Products Home Page");
		aDriver.Action(HomePage.Msproduts, "Products DropDown");
		aDriver.Action(FootWearPage.MsAct, "SubProducts Menu");
		Thread.sleep(2000);
		aDriver.Click(FootWearPage.LnkProducts, "T-Shirts Link");
		aDriver.VerifyPageUrl("https://redtape.com/apparel/ladies-tshirt", "WoMen-T-Shirts Products Page");
	}
	
	public void RedTapeProductsPage2() throws Exception 
	{   
		StartBrowser.ChildTest=StartBrowser.ParentTest.createNode("Application Women T-Shirts Products Page");
		Thread.sleep(5000);
		aDriver.Click(ProductsPage2.BtnADtCrt, "Add To Cart Button");
		Thread.sleep(2000);
		aDriver.Click(ProductsPage.SlctSize, "T-Shirt Size");
		aDriver.SelectOption(ProductsPage.SlctQnty, "3", "Product Quantity");
		aDriver.Click(ProductsPage.BtnCart, "AddToCart Button");
	}
	
	public void RedTapeFinalCartPage() throws Exception 
	{
		StartBrowser.ChildTest = StartBrowser.ParentTest.createNode("Application Final Cart Page");
		Thread.sleep(3000);
		aDriver.VerifyPageUrl("https://redtape.com/cart", "Cart Page");
		aDriver.Click(CartPage.BtnPlcOrder, "Place Order Button");
	}
	
	public void RedTapeCheckoutPage() throws Exception 
	{
		StartBrowser.ChildTest = StartBrowser.ParentTest.createNode("Application Checkout Page");
		aDriver.VerifyPageUrl("https://redtape.com/checkout", "Checkout Page");
		aDriver.Type(CheckoutPage.txtFName, "VenkataRaghuRam", "First Name");
		aDriver.Type(CheckoutPage.txtLName, "Chattu", "Last Name");
		aDriver.Type(CheckoutPage.txtMobile, "8978284830", "Mobile");
		aDriver.SelectOption(CheckoutPage.slctCntry, "India", "Country");
		aDriver.SelectOption(CheckoutPage.SlctState, "Andhra Pradesh", "State");
		aDriver.Type(CheckoutPage.txtCity, "Guntur", "City");
		aDriver.Type(CheckoutPage.txtPcode, "522002", "PinCode");
		aDriver.Click(CheckoutPage.BtnSvctn, "Save & Continue");
	}

}
