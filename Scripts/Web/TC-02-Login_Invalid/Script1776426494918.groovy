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

WebUI.openBrowser('https://parabank.parasoft.com')

WebUI.setText(findTestObject('Web/Login/txt_username'),'john')
WebUI.setText(findTestObject('Web/Login/txt_password'),'demo1')
WebUI.click(findTestObject('Web/Login/btn_login'))

WebUI.waitForElementPresent(findTestObject('Web/Login/lbl_faillogin'),5)
WebUI.verifyElementVisible(findTestObject('Web/Login/lbl_faillogin'))
WebUI.verifyElementText(findTestObject('Web/Login/lbl_faillogin'),'The username and password could not be verified.')

def currentUrl = WebUI.getUrl()
assert currentUrl.contains('login') : "Tetap dihalaman login!"
WebUI.takeScreenshot(GlobalVariable.screenshotPath + 'TC-02-Login Invalid.png')

WebUI.closeBrowser()
println "TC-02-Login_Invalid Pass - Login Invalid berhasil!"