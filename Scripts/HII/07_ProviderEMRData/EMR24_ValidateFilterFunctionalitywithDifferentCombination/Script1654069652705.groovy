import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import javax.xml.bind.annotation.XmlElementDecl.GLOBAL

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
import pages.LoginPageSteps
import pages.ProviderEMRDataPageSteps

import org.openqa.selenium.Keys as Keys

'Step 01: Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02: Login to Application'
LoginPageSteps.Login(GlobalVariable.ORGADMIN_USERNAME, GlobalVariable.ORGADMIN_PWD,HIIConstants.ROLE_OrganizationAdmin)


'Step 03: Navigate to Provider EMR Data'
HeaderPageSteps.verifyNavigationToProviderEMRData()

'Step 04: Verfiy CostCenter'
ProviderEMRDataPageSteps.VerifyProviderIndividualSearchByCostCenter(CostCenter)

'Step 05:  Click Search Clear Button'
ProviderEMRDataPageSteps.VerifyClearData()

'Step 06: Verify Year'
ProviderEMRDataPageSteps.VerifyProviderIndividualSearchByYear(Year)


'Step 07: Verify Month'
ProviderEMRDataPageSteps.VerifyProviderIndividualSearchByMonth(Month)

'Step 08:  Click Clear Button'
ProviderEMRDataPageSteps.VerifyClearData()


'Step 09: Verify ProviderName'
ProviderEMRDataPageSteps.VerifyProviderIndividualSearchByName(ProviderName)

'Step 10:  Click Clear Button'
ProviderEMRDataPageSteps.VerifyClearData()

'Step 11: Verify Combination of CostCenter,Year and Month'
ProviderEMRDataPageSteps.VerifyProviderCombinationCostCenterYearMonth(CostCenter, Year, Month)

'Step 12:  Click Clear Button'
ProviderEMRDataPageSteps.VerifyClearData()

'Step 13: Verify Combination of Year and Month'
ProviderEMRDataPageSteps.VerifyProviderCombinationYearMonth(Year, Month)

'Step 14:  Click Clear Button'
ProviderEMRDataPageSteps.VerifyClearData()

'Step 15: Verify Combination of ProviderName and Year'
ProviderEMRDataPageSteps.VerifyProviderCombinationProviderNameYear(ProviderName, Year)

'Step 16:  Click Clear Button'
ProviderEMRDataPageSteps.VerifyClearData()

'Step 17: Verify Combination of ProviderName,Month & Year'
ProviderEMRDataPageSteps.VerifyProviderCombinationProviderNameMonthYear(ProviderName, Month, Year)

'Step 18:  Click Clear Button'
ProviderEMRDataPageSteps.VerifyClearData()

'Step 19 : Enter Universal Search'
ProviderEMRDataPageSteps.setUniveralSearch(UniversalSearch)

'Step 20 : Click Search'
ProviderEMRDataPageSteps.clickSearch()

'Step 21 : Verify Universal Search Functionality'
ProviderEMRDataPageSteps.verifyUniversalSearchFunctionality()



