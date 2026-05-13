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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.Select


CustomKeywords.'common.WebHelper.login'('Haryadi01','qwerty123')

WebUI.click(findTestObject('Web/Home/link_createAccount'))

WebUI.selectOptionByValue(findTestObject('Web/OpenAccount/drp_typeAccount'),'1',false)
//WebUI.selectOptionByLabel(findTestObject('Web/OpenAccount/drp_toAccount'),'SAVINGS',false) digunakan jika menggunakan value

def driver = DriverFactory.getWebDriver()
def selectElement = new Select(driver.findElement(By.cssSelector('#fromAccountId')))

List<WebElement> options = selectElement.getOptions()
options.each{ option->
	println "Value:${option.getAttribute('value')} - Label: ${option.getText()}"
}

def firstValue= options.get(0).getAttribute('value')
selectElement.selectByValue(firstValue)

WebUI.click(findTestObject('Web/OpenAccount/btn_submit'))

WebUI.verifyElementText(findTestObject('Web/OpenAccount/lbl_successCreateAccount'),'Account Opened!')

WebUI.takeScreenshot(GlobalVariable.screenshotPath +'TC CreateAccount.png')

WebUI.closeBrowser()
println "Test Case Create Account success!"
