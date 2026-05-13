package common

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
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import com.kms.katalon.core.annotation.Keyword

import internal.GlobalVariable

public class WebHelper {
	@Keyword
	def login(String username,String password){
		WebUI.openBrowser('https://parabank.parasoft.com')
		WebUI.setText(findTestObject('Web/Login/txt_username'),username)
		WebUI.setText(findTestObject('Web/Login/txt_password'),password)
		WebUI.click(findTestObject('Web/Login/btn_login'))
	}
	def loginDummy(String username,String password){
		WebUI.openBrowser('https://para.testar.org/parabank/')
		WebUI.setText(findTestObject('Web/Login/txt_username'),username)
		WebUI.setText(findTestObject('Web/Login/txt_password'),password)
		WebUI.click(findTestObject('Web/Login/btn_login'))
	}
	String getCurrentDate (String format="MM-dd-yyyy") {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format)
		LocalDateTime now = LocalDateTime.now()
		return dtf.format(now)
	}
	def getFutureDate(int days,String format ="MM-dd-yyyy") {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format)
		LocalDateTime future = LocalDateTime.now().plusDays(days)
		return dtf.format(future)
	}
	def getPastDate(int days,String format="MM-dd-yyyy") {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format)
		LocalDateTime past = LocalDateTime.now().plusDays(days)
		return dtf.format(past)
	}
}
