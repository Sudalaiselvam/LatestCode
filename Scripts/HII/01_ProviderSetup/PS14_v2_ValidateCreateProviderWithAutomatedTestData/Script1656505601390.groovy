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

import core.Browser
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.ProviderSetupSteps

import org.openqa.selenium.Keys as Keys

'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application with Global Variables - USERNAME,PASSWORD,ROLE defined in Profile'
LoginPageSteps.Login(GlobalVariable.USERNAME, GlobalVariable.PASSWORD, GlobalVariable.ROLE)

'Step 03 : Go to Provider Setup'
ProviderSetupSteps.gotoProviderSetup()

'Step 04 : Click Create Provider'
ProviderSetupSteps.clickCreateProvider()

'Step 05 : Set Personal Details - First Name'
ProviderSetupSteps.setAutomatedFirstName()

'Step 06 : Set Personal Details - Last Name'
ProviderSetupSteps.setAutomatedLastName()

'Step 07 : Set Personal Details - E-mail'
ProviderSetupSteps.setAutomatedEmail()

'Step 08 : Select First Eligible Region'
ProviderSetupSteps.selectFirstEligibleRegion(2)

'Step 09 : Select First Eligible Location'
ProviderSetupSteps.selectFirstEligibleLocation(1)

'Step 10 : Select First Eligible Primary Cost Center'
ProviderSetupSteps.selectFirstEligiblePrimaryCostCenter(1)

'Step 11 : Select Position Level as Provider'
ProviderSetupSteps.selectPositionLevelAsProvider()

'Step 12 : Select First Eligible Primary Specialty'
ProviderSetupSteps.selectFirstEligiblePrimarySpecialty(1)

'Step 13 : Select First Eligible Specialty Group'
ProviderSetupSteps.selectFirstEligibleSpecialtyGroup(1)

'Step 14 : Set Professional Details - Payroll ID'
ProviderSetupSteps.setAutomatedPayrollID()

'Step 15 : Set Employee Status as Hired'
ProviderSetupSteps.selectEmployeeStatusAsHired()

'Step 16 : Click Save Button'
ProviderSetupSteps.clickSave()

'Step 17 : Verify Provider Creation'
ProviderSetupSteps.verifyProvideCreation()