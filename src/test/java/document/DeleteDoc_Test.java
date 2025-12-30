package document;

import org.testng.Assert;
import org.testng.annotations.Test;

import genric_utilities.BaseClass;
import vtiger_POM.Document_page;
import vtiger_POM.Home_page;

public class DeleteDoc_Test extends BaseClass
{
	@Test(groups = "smoke")
	public void deleteDco()
	{
		Home_page hp = new Home_page(driver);
		hp.clickOnDocLink();
		Document_page docPag = new Document_page(driver);
		docPag.deleteSingleDocument(driver, "Customer968");
	}
}
//{
//	@Test(groups = "smoke")
//	public void deleteDoc()
//	{
//		Home_page hp = new Home_page(driver);
//		hp.clickOnDocLink();
//		Document_page docPage = new Document_page(driver);
//		docPage.deleteSingleDocument(driver, "Customer968");
//		//Assert.fail();
//	}
//}
