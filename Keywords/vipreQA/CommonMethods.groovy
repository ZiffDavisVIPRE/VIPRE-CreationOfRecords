package vipreQA

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.webui.common.WebUiCommonHelper

import internal.GlobalVariable
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.driver.DriverFactory

public class CommonMethods {
	@Keyword
	def ClickNewObj(TestObject to, int timeout) {
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement element = WebUiCommonHelper.findWebElement(to, timeout)
		JavascriptExecutor executor = ((driver) as JavascriptExecutor)
		executor.executeScript('arguments[0].click()',element)
	}

	@Keyword
	def static void LoginToSalesforce(String URL, String username, String password) {
		WebUI.openBrowser(URL, FailureHandling.STOP_ON_FAILURE)
		WebUI.maximizeWindow(FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForElementVisible(findTestObject('Object Repository/QA Sandbox/Login_Page/input_Username'), 20, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/QA Sandbox/Login_Page/input_Username'), FailureHandling.STOP_ON_FAILURE)
		WebUI.sendKeys(findTestObject('Object Repository/QA Sandbox/Login_Page/input_Username'), username, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/QA Sandbox/Login_Page/input_Password'), FailureHandling.STOP_ON_FAILURE)
		WebUI.sendKeys(findTestObject('Object Repository/QA Sandbox/Login_Page/input_Password'), password, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/QA Sandbox/Login_Page/btn_Login'), FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def static void LoginasUser(String Username) {
		WebUI.click(findTestObject('Object Repository/QA Sandbox/HomePage/btn_Setup'), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/QA Sandbox/HomePage/btn_SetupforCurrentApp'), FailureHandling.STOP_ON_FAILURE)
		WebUI.switchToWindowIndex(1)
		WebUI.setText(findTestObject('Object Repository/QA Sandbox/HomePage/txt_SearchSetup'),Username)
		WebUI.click(findTestObject('Object Repository/QA Sandbox/HomePage/Clk_SelectSearchUser',[('value') : Username]))
		WebUI.switchToFrame(findTestObject('Object Repository/QA Sandbox/HomePage/Ifrm_User'), 20)
		WebUI.verifyElementPresent(findTestObject('Object Repository/QA Sandbox/HomePage/Chkbox_IsActiveChecked'),20)
		WebUI.click(findTestObject('Object Repository/QA Sandbox/HomePage/btn_Login'), FailureHandling.STOP_ON_FAILURE)
		WebUI.closeWindowIndex(0)
	}

	@Keyword
	def static void AccountCreation(String AccountRecordType,String AccountName,String BillingCountry,String BillingStreet,String BillingCity,String PostalCode,String RegNo,String SalesTerritory) {
		//CustomKeywords.'vipreQA.CommonMethods.ClickNewObj',(findTestObject('Object Repository/QA Sandbox/Account/Tab_Account'),20)
		//WebUI.click(findTestObject('Object Repository/QA Sandbox/Account/Tab_Account'), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/QA Sandbox/Account/btn_New'), FailureHandling.STOP_ON_FAILURE)

		WebUI.comment('Selecting the Account Record Type')
		WebUI.click(findTestObject('Object Repository/QA Sandbox/Account/Radiobtn_AccountType',[('value') : AccountRecordType]), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/QA Sandbox/Account/btn_Next'), FailureHandling.STOP_ON_FAILURE)

		WebUI.comment('Entering Account Name')
		WebUI.sendKeys(findTestObject('Object Repository/QA Sandbox/Account/txt_AccountName'), AccountName)

		WebUI.comment('Clicking Test Account')
		WebUI.scrollToElement(findTestObject('Object Repository/QA Sandbox/Account/lbl_TestAccount'), 20)
		WebUI.click(findTestObject('Object Repository/QA Sandbox/Account/chkbox_TestAccount'))

		WebUI.comment('Billing Country')
		WebUI.scrollToElement(findTestObject('Object Repository/QA Sandbox/Account/lbl_BillingCountry'), 20)
		WebUI.click(findTestObject('Object Repository/QA Sandbox/Account/drpdwn_BillingCountryNone'))
		WebUI.click(findTestObject('Object Repository/QA Sandbox/Account/drpdwn_BillingCountryValue',[('value') : BillingCountry]))

		WebUI.comment('Billing Street')
		WebUI.setText(findTestObject('Object Repository/QA Sandbox/Account/txt_BillingStreet'), BillingStreet)

		WebUI.comment('Billing City')
		WebUI.setText(findTestObject('Object Repository/QA Sandbox/Account/txt_BillingCity'), BillingCity)

		WebUI.comment('Postal Code')
		WebUI.setText(findTestObject('Object Repository/QA Sandbox/Account/txt_PostalCode'), PostalCode)

		WebUI.comment("Company Registration Number")
		if(WebUI.verifyElementPresent(findTestObject('Object Repository/QA Sandbox/Account/txt_CompanyRegNo'), 20, FailureHandling.OPTIONAL))
		{
			WebUI.setText(findTestObject('Object Repository/QA Sandbox/Account/txt_CompanyRegNo'),RegNo)
		}
		else
		{
			println 'Excel Micro dont have Company Registration Number'
		}
		WebUI.comment('Selecting Sales Territory')
		WebUI.scrollToElement(findTestObject('Object Repository/QA Sandbox/Account/lbl_SalesTerritory'), 20)
		WebUI.click(findTestObject('Object Repository/QA Sandbox/Account/drpdwn_SalesTerritoryNone'))
		WebUI.click(findTestObject('Object Repository/QA Sandbox/Account/drpdwn_SalesTerritoryValue',[('value') : SalesTerritory]))

		WebUI.comment('Click on Save Button')
		WebUI.click(findTestObject('Object Repository/QA Sandbox/Account/btn_Save'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/QA Sandbox/Account/Verify_AccountPage'), 30)


		WebUI.comment('Verify all field values')
		WebUI.verifyElementPresent(findTestObject('Object Repository/QA Sandbox/Account/Verify_Account_HomePage'), 20, FailureHandling.STOP_ON_FAILURE)
		WebUI.scrollToElement(findTestObject('Object Repository/QA Sandbox/Account/Verify_AccountName'), 20, FailureHandling.STOP_ON_FAILURE)
		WebUI.verifyElementText(findTestObject('Object Repository/QA Sandbox/Account/Verify_AccountName'), AccountName, FailureHandling.STOP_ON_FAILURE)
		WebUI.verifyElementText(findTestObject('Object Repository/QA Sandbox/Account/Verify_AccountRecordType'), AccountRecordType, FailureHandling.STOP_ON_FAILURE)
		//WebUI.verifyElementChecked(findTestObject('Object Repository/QA Sandbox/Account/Verify_TestAccount'), 20)
		WebUI.scrollToElement(findTestObject('Object Repository/QA Sandbox/Account/Verify_SalesTerritory'), 20)
		WebUI.verifyElementText(findTestObject('Object Repository/QA Sandbox/Account/Verify_SalesTerritory'), SalesTerritory, FailureHandling.STOP_ON_FAILURE)

	}

	@Keyword
	def static void ContactCreation(String Salutation, String FirstName, String LastName, String Email, String Ph, String Title, String AccountName) {
		//WebUI.verifyElementPresent(findTestObject('Object Repository/QA Sandbox/Contact/Verify_NewContactText'), 20, FailureHandling.STOP_ON_FAILURE)
		WebUI.scrollToElement(findTestObject('Object Repository/QA Sandbox/Contact/lbl_Salutation'), 20)
		WebUI.click(findTestObject('Object Repository/QA Sandbox/Contact/drpdwn_SalutationNone'))
		WebUI.click(findTestObject('Object Repository/QA Sandbox/Contact/drpdwn_SalutationValue',[('value') : Salutation]))
		WebUI.setText(findTestObject('Object Repository/QA Sandbox/Contact/txt_FirstName'), FirstName)
		WebUI.setText(findTestObject('Object Repository/QA Sandbox/Contact/txt_LastName'), LastName)
		WebUI.setText(findTestObject('Object Repository/QA Sandbox/Contact/txt_Email'), Email)
		WebUI.setText(findTestObject('Object Repository/QA Sandbox/Contact/txt_Phone'), Ph)
		WebUI.setText(findTestObject('Object Repository/QA Sandbox/Contact/txt_Title'), Title)
		WebUI.click(findTestObject('Object Repository/QA Sandbox/Contact/btn_Save'))

		String ContactName = FirstName+' '+LastName

		WebUI.click(findTestObject('Object Repository/QA Sandbox/Contact/Click_ContactCreated',[('value') : ContactName]))
		String Name = Salutation+' '+ContactName
		println(Name)

		WebUI.comment('Verify the values of Created Contact Object')
		WebUI.verifyElementPresent(findTestObject('Object Repository/QA Sandbox/Contact/Verify_ContactObject'), 20, FailureHandling.STOP_ON_FAILURE)
		//WebUI.scrollToElement(findTestObject('Object Repository/QA Sandbox/Contact/Tab_Details'), 20)
		WebUI.scrollToPosition(0, 100)
		WebUI.click(findTestObject('Object Repository/QA Sandbox/Contact/Tab_Details'), FailureHandling.STOP_ON_FAILURE)
		WebUI.verifyElementText(findTestObject('Object Repository/QA Sandbox/Contact/Verify_NameField'), Name, FailureHandling.STOP_ON_FAILURE)
		WebUI.verifyElementText(findTestObject('Object Repository/QA Sandbox/Contact/Verify_Email'), Email, FailureHandling.STOP_ON_FAILURE)
		if(WebUI.verifyElementText(findTestObject('Object Repository/QA Sandbox/Contact/Verify_Phone_EXM'), Ph, FailureHandling.OPTIONAL))
		{
			println 'Excel Micro Record Phone Number Field'
		}
		else if(WebUI.verifyElementText(findTestObject('Object Repository/QA Sandbox/Contact/Verify_Phone_VIPRE',[('value') : Ph]), Ph, FailureHandling.OPTIONAL))
		{
			String Phone = WebUI.getText(findTestObject('Object Repository/QA Sandbox/Contact/Verify_Phone_VIPRE',[('value') : Ph]))
			println(Phone)
			WebUI.verifyMatch(Phone, Ph, false)
			println 'VIPRE Record Phone Number Field'
		}

		WebUI.verifyElementText(findTestObject('Object Repository/QA Sandbox/Contact/Verify_Title'), Title, FailureHandling.STOP_ON_FAILURE)
		WebUI.verifyElementText(findTestObject('Object Repository/QA Sandbox/Contact/Verify_AccountName'), AccountName, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def static void QuoteCreation(String SalesTerritory, String BillingEntity, String BillingModel, String QuoteType, String AccountName, String Contact, String SalesChannel, String BillingTerm) {
		WebUI.verifyElementPresent(findTestObject('Object Repository/QA Sandbox/DirectQuote_Creation/btn_DirectQuote'), 20, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/QA Sandbox/DirectQuote_Creation/btn_DirectQuote'), FailureHandling.STOP_ON_FAILURE)
		WebUI.verifyElementPresent(findTestObject('Object Repository/QA Sandbox/DirectQuote_Creation/TxtVerify_NewDirectQuote'), 20, FailureHandling.STOP_ON_FAILURE)
		WebUI.scrollToElement(findTestObject('Object Repository/QA Sandbox/DirectQuote_Creation/lbl_SalesTerritory'), 20, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/QA Sandbox/DirectQuote_Creation/lbl_SalesTerritory_Value'), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/QA Sandbox/DirectQuote_Creation/input_SalesTerritory', [('value') : SalesTerritory]), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/QA Sandbox/DirectQuote_Creation/lbl_BillingEntityNone'), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/QA Sandbox/DirectQuote_Creation/input_BillingEntity', [('value') : BillingEntity]), FailureHandling.STOP_ON_FAILURE)
		WebUI.verifyElementText(findTestObject('Object Repository/QA Sandbox/DirectQuote_Creation/BillingModel',[('value') : BillingModel]), BillingModel)
		WebUI.click(findTestObject('Object Repository/QA Sandbox/DirectQuote_Creation/btn_Save'), FailureHandling.STOP_ON_FAILURE)

		WebUI.comment('Verify the value for the created quote')
		WebUI.click(findTestObject('Object Repository/QA Sandbox/DirectQuote_Creation/Tab_Related'), FailureHandling.STOP_ON_FAILURE)
		if(WebUI.verifyElementNotVisible(findTestObject('Object Repository/QA Sandbox/DirectQuote_Creation/Tab_Related'), FailureHandling.OPTIONAL))
		{
			WebUI.scrollToElement(findTestObject('Object Repository/QA Sandbox/DirectQuote_Creation/Tab_Related'), 20)
		}
		WebUI.waitForElementVisible(findTestObject('Object Repository/QA Sandbox/DirectQuote_Creation/lbl_Quotes'), 20)
		WebUI.click(findTestObject('Object Repository/QA Sandbox/DirectQuote_Creation/Select_Quote'), FailureHandling.STOP_ON_FAILURE)

		WebUI.verifyElementPresent(findTestObject('Object Repository/QA Sandbox/DirectQuote_Creation/TxtVerify_Quote'), 20)
		WebUI.verifyElementText(findTestObject('Object Repository/QA Sandbox/DirectQuote_Creation/Verify_QuoteType'), QuoteType)
		WebUI.verifyElementText(findTestObject('Object Repository/QA Sandbox/DirectQuote_Creation/Verify_Account'), AccountName)
		WebUI.verifyElementText(findTestObject('Object Repository/QA Sandbox/DirectQuote_Creation/Verify_PrimaryContact'), Contact)
		WebUI.verifyElementPresent(findTestObject('Object Repository/QA Sandbox/DirectQuote_Creation/Verify_QuoteAssistant_AddProduct'), 20)
		if(WebUI.verifyElementNotVisible(findTestObject('Object Repository/QA Sandbox/DirectQuote_Creation/lbl_Status'),FailureHandling.OPTIONAL))
		{
			WebUI.scrollToElement(findTestObject('Object Repository/QA Sandbox/DirectQuote_Creation/lbl_Status'), 20)
		}
		String Status = WebUI.getText(findTestObject('Object Repository/QA Sandbox/DirectQuote_Creation/Verify_Status'))
		println('Status:'+Status)
		WebUI.verifyMatch(Status, 'Draft', false)
		WebUI.verifyElementText(findTestObject('Object Repository/QA Sandbox/DirectQuote_Creation/Verify_SalesChannel'), SalesChannel)
		WebUI.scrollToElement(findTestObject('Object Repository/QA Sandbox/DirectQuote_Creation/lbl_Status'), 20)
		WebUI.verifyElementText(findTestObject('Object Repository/QA Sandbox/DirectQuote_Creation/Verify_BillingModel'), BillingModel)
		WebUI.verifyElementText(findTestObject('Object Repository/QA Sandbox/DirectQuote_Creation/Verify_BillingTerm'), BillingTerm)
		WebUI.verifyNotEqual(findTestObject('Object Repository/QA Sandbox/DirectQuote_Creation/Verify_PaymentMethod'), null)
		WebUI.verifyElementPresent(findTestObject('Object Repository/QA Sandbox/DirectQuote_Creation/btn_EditLines'), 20)
	}


	@Keyword
	def static void EditQuoteLine(String Product, String Quantity) {
		WebUI.verifyElementPresent(findTestObject('Object Repository/QA Sandbox/DirectQuote_Creation/btn_EditLines'), 20)
		WebUI.click(findTestObject('Object Repository/QA Sandbox/DirectQuote_Creation/btn_EditLines'), FailureHandling.STOP_ON_FAILURE)
		WebUI.switchToFrame(findTestObject('Object Repository/QA Sandbox/EditQuoteLine/Iframe'), 20, FailureHandling.STOP_ON_FAILURE)
		WebUI.verifyElementPresent(findTestObject('Object Repository/QA Sandbox/EditQuoteLine/VerifyTxt_EditQuote'), 20, FailureHandling.STOP_ON_FAILURE)
		WebUI.verifyElementPresent(findTestObject('Object Repository/QA Sandbox/EditQuoteLine/btn_AddProduct'), 20, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/QA Sandbox/EditQuoteLine/btn_AddProduct'), FailureHandling.STOP_ON_FAILURE)
		WebUI.verifyElementPresent(findTestObject('Object Repository/QA Sandbox/EditQuoteLine/VerifyTxt_ProductSelection'), 20, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/QA Sandbox/EditQuoteLine/input_SearchProductBar'), FailureHandling.STOP_ON_FAILURE)
		WebUI.setText(findTestObject('Object Repository/QA Sandbox/EditQuoteLine/input_SearchProductBar'), Product, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/QA Sandbox/EditQuoteLine/btn_Search'), FailureHandling.STOP_ON_FAILURE)
		WebUI.verifyElementPresent(findTestObject('Object Repository/QA Sandbox/EditQuoteLine/Verify_ProductCode', [('value') : Product]),	20, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/QA Sandbox/EditQuoteLine/chkbox_SelectProduct', [('value') : Product]), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/QA Sandbox/EditQuoteLine/btn_SelectSelectionProduct'), FailureHandling.STOP_ON_FAILURE)
		WebUI.verifyElementPresent(findTestObject('Object Repository/QA Sandbox/EditQuoteLine/VerifyTxt_EditQuote'), 20, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/QA Sandbox/EditQuoteLine/input_EditQuantity'),FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/QA Sandbox/EditQuoteLine/input_EditQuantity'),FailureHandling.STOP_ON_FAILURE)
		WebUI.sendKeys(findTestObject('Object Repository/QA Sandbox/EditQuoteLine/input_Quantity'), Quantity, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/QA Sandbox/EditQuoteLine/Txt_ProductName'), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/QA Sandbox/EditQuoteLine/btn_Save'), FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForElementVisible(findTestObject('Object Repository/QA Sandbox/DirectQuote_Creation/btn_EditLines'), 20, FailureHandling.STOP_ON_FAILURE)

		WebUI.comment('Quote Assistant message and button visibility')
		if(WebUI.verifyElementPresent(findTestObject('Object Repository/QA Sandbox/EditQuoteLine/btn_Revalidate'), 20, FailureHandling.OPTIONAL))
		{
		//WebUI.verifyElementPresent(findTestObject('Object Repository/QA Sandbox/EditQuoteLine/Verify_QuoteReadyForSigning'), 20, FailureHandling.STOP_ON_FAILURE)
		WebUI.verifyElementText(findTestObject('Object Repository/QA Sandbox/EditQuoteLine/Verify_QuoteReadyForSigning'), 'This quote is ready to send for signing.')
		}
		
		WebUI.verifyElementPresent(findTestObject('Object Repository/QA Sandbox/EditQuoteLine/btn_SendQuoteforSigning'), 20, FailureHandling.STOP_ON_FAILURE)
		WebUI.comment('Verification of the QuoteLine and Product Quantity')
		WebUI.scrollToPosition(99999, 99999)
		WebUI.verifyElementPresent(findTestObject('Object Repository/QA Sandbox/EditQuoteLine/Section_QuoteLine'), 20, FailureHandling.STOP_ON_FAILURE)
		WebUI.verifyNotEqual(findTestObject('Object Repository/QA Sandbox/EditQuoteLine/Field_LineName'), null)
		//WebUI.verifyElementText(findTestObject('Object Repository/QA Sandbox/EditQuoteLine/Verify_Quantity',[('value') : Quantity]), Quantity)
	}


	@Keyword
	def static void LogoutUser(String URL) {
		//String URL = WebUI.getUrl()
		WebUI.verifyElementPresent(findTestObject('Object Repository/QA Sandbox/LogoutUser/Link_LogoutUser'), 20, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/QA Sandbox/LogoutUser/Link_LogoutUser'), FailureHandling.STOP_ON_FAILURE)
		WebUI.navigateToUrl(URL, FailureHandling.STOP_ON_FAILURE)
	}


	@Keyword
	def static void QuoteSigningandAccepting() {
		WebUI.scrollToPosition(0,10)
		WebUI.verifyElementPresent(findTestObject('Object Repository/QA Sandbox/Quote/Quote_SystemTab/Tab_QuoteSystem'), 20)
		WebUI.click(findTestObject('Object Repository/QA Sandbox/Quote/Quote_SystemTab/Tab_QuoteSystem'),FailureHandling.STOP_ON_FAILURE)
		if(WebUI.verifyElementPresent(findTestObject('Object Repository/QA Sandbox/Quote/Quote_SystemTab/Verify_SignedDocumentValidation'), 20, FailureHandling.OPTIONAL))
		{
			WebUI.verifyElementPresent(findTestObject('Object Repository/QA Sandbox/Quote/Quote_SystemTab/Chkbox_OverrideSignedDocumentValidation'), 20, FailureHandling.STOP_ON_FAILURE)
			WebUI.click(findTestObject('Object Repository/QA Sandbox/Quote/Quote_SystemTab/btn_EditOverride'), FailureHandling.STOP_ON_FAILURE)
			WebUI.scrollToPosition(0, 40, FailureHandling.STOP_ON_FAILURE)
			WebUI.click(findTestObject('Object Repository/QA Sandbox/Quote/Quote_SystemTab/chkbox_OverrideSigned'), FailureHandling.STOP_ON_FAILURE)
			WebUI.click(findTestObject('Object Repository/QA Sandbox/Quote/Quote_SystemTab/btn_Save'), FailureHandling.STOP_ON_FAILURE)
		}

		WebUI.click(findTestObject('Object Repository/QA Sandbox/Quote/Quote_DetailsTab/Tab_QuoteDetails'), FailureHandling.STOP_ON_FAILURE)
	}
}



