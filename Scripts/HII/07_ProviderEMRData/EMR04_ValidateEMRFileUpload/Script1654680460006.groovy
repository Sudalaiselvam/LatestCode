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

import configs.HIIConstants
import core.Browser
import internal.GlobalVariable
import pages.HeaderPageSteps
import pages.InterfaceLogSummaryPageSteps
import pages.LoginPageSteps
import pages.RunInterfaceJobsPageSteps
import utils.ExcelUtilities

import org.openqa.selenium.Keys as Keys

'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.ORGADMIN_USERNAME, GlobalVariable.ORGADMIN_PWD, HIIConstants.ROLE_OrganizationAdmin)

'Step 03: Navigate to Provider EMR Data'
HeaderPageSteps.verifyNavigationToRunInterfaceJobs()

'Step 04: Run the Interface Job'
RunInterfaceJobsPageSteps.VerifyJobExecutionStatus(JobName)

'Step 05: Verify Interface Log Summary'
HeaderPageSteps.verifyNavigationToInterfaceLogSummary()

'Step 06: Verify the fileName'
InterfaceLogSummaryPageSteps.VerifyFileName(EMRInt, EMRFileName,EMRDate)