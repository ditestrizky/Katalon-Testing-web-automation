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
//akses menu transfer
WebUI.click(findTestObject('Web/Home/link_transfer'))

def driver = DriverFactory.getWebDriver()
def selectElementFrom = new Select(driver.findElement(By.cssSelector('#fromAccountId')))
def selectElementTo = new Select(driver.findElement(By.cssSelector('#toAccountId')))

WebUI.setText(findTestObject('Web/Transfer/txt_amount'),'150')

List<WebElement> options = selectElementFrom.getOptions()
options.each { option ->
	println "Value: ${option.getAttribute('value')} — Label: ${option.getText()}"
}

def fromAccount = options.get(1).getAttribute('value')
selectElementFrom.selectByValue(fromAccount)

List<WebElement> optionsToAccount = selectElementTo.getOptions()
optionsToAccount.each { option ->
	println "Value: ${option.getAttribute('value')} — Label: ${option.getText()}"
}

def toAccount = optionsToAccount.get(2).getAttribute('value')
selectElementTo.selectByValue(toAccount)



//WebUI.selectOptionByValue(findTestObject('Web/Transfer/drp_fromAccount'),'13788',false) digunakan saat data hardcode
//WebUI.selectOptionByLabel(findTestObject('Web/Transfer/drp_toAccount'),'13899',false) digunakan saat data hardcode
WebUI.click(findTestObject('Web/Transfer/btn_submit'))

WebUI.waitForElementPresent(findTestObject('Web/Transfer/lbl_successTransfer'),5)
WebUI.verifyElementText(findTestObject('Web/Transfer/lbl_successTransfer'),'Transfer Complete!')
WebUI.takeScreenshot(GlobalVariable.screenshotPath + 'TC TRF-01.png')


WebUI.closeBrowser()
println "TC-TRF-01 -Transfer Pass!"