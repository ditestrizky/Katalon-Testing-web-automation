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
WebUI.click(findTestObject('Web/Register/link_register'))

WebUI.setText(findTestObject('Web/Register/txt_firstname'),'haryadi')
WebUI.setText(findTestObject('Web/Register/txt_lastname'),'haryanto')
WebUI.setText(findTestObject('Web/Register/txt_address'),'terin 1')
WebUI.setText(findTestObject('Web/Register/txt_city'),'Depok')
WebUI.setText(findTestObject('Web/Register/txt_state'),'ina')
WebUI.setText(findTestObject('Web/Register/txt_zipcode'),'11450')
WebUI.setText(findTestObject('Web/Register/txt_phonenumber'),'628527323222')
WebUI.setText(findTestObject('Web/Register/txt_ssn'),'12321311')

WebUI.setText(findTestObject('Web/Register/txt_username'),'Haryadi01')
WebUI.setText(findTestObject('Web/Register/txt_password'),'qwerty123')
WebUI.setText(findTestObject('Web/Register/txt_confirmpassword'),'qwerty123')


WebUI.click(findTestObject('Web/Register/btn_register'))

WebUI.waitForElementPresent(findTestObject('Web/Register/lbl_registerberhasil'),5)
WebUI.verifyElementVisible(findTestObject('Web/Register/lbl_registerberhasil'))

def value = WebUI.getText(findTestObject('Web/Register/lbl_registerberhasil'))
assert value.contains('Welcome') : "Seharusnya kehalaman Pendaftaran berhasil!"

WebUI.takeScreenshot(GlobalVariable.screenshotPath + 'TC-03-Register Valid.png')

WebUI.closeBrowser()
println "TC-03-Register_Valid Pass - Register Valid berhasil!"