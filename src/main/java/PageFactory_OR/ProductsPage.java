package PageFactory_OR;

import org.openqa.selenium.By;

public class ProductsPage {
	
	public static By slctProduct = By.xpath("//*[@id='infinite']/div[4]/div[4]/a[2]");
	public static By SlctSize = By.xpath("//*[@id='CPBody_up1']/div//div[1]/ul/li[2]");
	public static By SlctQnty = By.id("CPBody_ddlquantity");
	public static By BtnCart = By.xpath("//*[@id='CPBody_up1']/div[3]/div[1]/input[2]");

}
