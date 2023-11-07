import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.comment('Login to Salesforce')
CustomKeywords.'vipreQA.CommonMethods.LoginToSalesforce'(GlobalVariable.URL,GlobalVariable.Username,GlobalVariable.Password)

//Declaring Local Variable
int a = ((Math.random() * 1000) as int)
def format = 'yyyyMMdd'
def date = new Date()
def formattedDate = date.format(format)
String AccountName = 'QA_TestAccount_Direct'+'_'+GlobalVariable.EXM_SalesTerritory+'_'+formattedDate
GlobalVariable.AccountName = AccountName
String URL
String Acc_Name

WebUI.comment('Search if the Account already exists')
CustomKeywords.'vipreQA.CommonMethods.ClickNewObj'(findTestObject('Object Repository/QA Sandbox/HomePage/btn_Searchbox'),20)
WebUI.sendKeys(findTestObject('Object Repository/QA Sandbox/HomePage/input_Searchbox'), 'QA_TestAccount_Direct', FailureHandling.STOP_ON_FAILURE)
WebUI.sendKeys(findTestObject('Object Repository/QA Sandbox/HomePage/input_Searchbox'), Keys.chord(Keys.ENTER))

if(WebUI.verifyElementPresent(findTestObject('Object Repository/QA Sandbox/AccountRecordPresent/Verify_NoRecordPresent'), 20, FailureHandling.OPTIONAL))
{
WebUI.comment('Creating Account Record')
WebUI.verifyElementPresent(findTestObject('Object Repository/QA Sandbox/Account/Tab_Account'), 20)
CustomKeywords.'vipreQA.CommonMethods.ClickNewObj'(findTestObject('Object Repository/QA Sandbox/Account/Tab_Account'),20)
CustomKeywords.'vipreQA.CommonMethods.AccountCreation'(GlobalVariable.ExcelMicro_AccountType,GlobalVariable.AccountName,GlobalVariable.BillingCountry, GlobalVariable.BillingStreet,GlobalVariable.BillingCity,GlobalVariable.PostalCode,GlobalVariable.RegNo,GlobalVariable.EXM_SalesTerritory)
URL = WebUI.getUrl()
println (URL)
Acc_Name = WebUI.getText(findTestObject('Object Repository/QA Sandbox/Account/getTxt_AccountName'), FailureHandling.STOP_ON_FAILURE)
}

else
{
	WebUI.verifyElementPresent(findTestObject('Object Repository/QA Sandbox/AccountRecordPresent/Verify_AccountPresent'), 20)
	CustomKeywords.'vipreQA.CommonMethods.ClickNewObj'(findTestObject('Object Repository/QA Sandbox/AccountRecordPresent/Select_Account'),20)
	WebUI.verifyElementPresent(findTestObject('Object Repository/QA Sandbox/Account/Verify_Account_HomePage'), 20, FailureHandling.STOP_ON_FAILURE)
	URL = WebUI.getUrl()
	println (URL)
	Acc_Name = WebUI.getText(findTestObject('Object Repository/QA Sandbox/Account/getTxt_AccountName'), FailureHandling.STOP_ON_FAILURE)
}

WebUI.comment('Login as Excel-Micro User')
CustomKeywords.'vipreQA.CommonMethods.LoginasUser'(GlobalVariable.ExcelMicro_User)
WebUI.switchToWindowIndex(0)
WebUI.verifyElementPresent(findTestObject('Object Repository/QA Sandbox/HomePage/App_Verify_ExcelMicro'), 30)

WebUI.navigateToUrl(URL, FailureHandling.STOP_ON_FAILURE)

WebUI.comment('Contact Creation')
WebUI.scrollToPosition(0, 0, FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementClickable(findTestObject('Object Repository/QA Sandbox/Contact/Link_ContactonAccount'))
CustomKeywords.'vipreQA.CommonMethods.ClickNewObj'(findTestObject('Object Repository/QA Sandbox/Contact/Link_ContactonAccount'),20)

WebUI.verifyElementPresent(findTestObject('Object Repository/QA Sandbox/Contact/Title_Contact'), 20)
CustomKeywords.'vipreQA.CommonMethods.ClickNewObj'(findTestObject('Object Repository/QA Sandbox/Contact/btn_New'),20)

String LastName = 'Clark'+'_'+formattedDate
GlobalVariable.LastName = LastName

CustomKeywords.'vipreQA.CommonMethods.ContactCreation'(GlobalVariable.Salutation,GlobalVariable.FirstName,GlobalVariable.LastName, GlobalVariable.Email,GlobalVariable.Phone,GlobalVariable.Title, Acc_Name)

