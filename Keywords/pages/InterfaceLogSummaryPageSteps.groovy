package pages

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.assertj.core.util.FailureMessages
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import utils.ExcelUtilities
import utils.Utilities
import core.AssertSteps
import core.BaseSteps
import core.ControlFactory
import core.Logger
import groovy.inspect.swingui.BytecodeCollector

import com.kms.katalon.core.model.FailureHandling
import com.sun.org.apache.bcel.internal.generic.RETURN
import com.sun.xml.internal.ws.policy.AssertionSet
import com.thoughtworks.selenium.webdriven.commands.GetValue
import com.thoughtworks.selenium.webdriven.commands.WaitForCondition
import configs.HIIConstants
import configs.PageLocatorReader as pageName

public class InterfaceLogSummaryPageSteps {
	protected static BaseSteps getBaseSteps(){
		return new BaseSteps(new ControlFactory());
	}

	private static final String tableDetails='tableDetails'

	public static void VerifyFileName(String EMRInt,String EMRFileName,String EMRDate) {
		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		String expEMRIntName,expEMRFileName, EMRProDate


		if(EMRFileName.contains('.txt')) {

			if(getBaseSteps().WebElementDisplayed(tableDetails, pageName.InterfaceLogSummary)) {
				String noofRequests=getBaseSteps().getRowTableCounts(tableDetails, pageName.InterfaceLogSummary)
				for(int i=1;i<Integer.parseInt(noofRequests);i++) {
					expEMRIntName=getBaseSteps().getCellTableText(tableDetails,(i+1).toString() , 'Interface', pageName.InterfaceLogSummary)
					expEMRFileName=getBaseSteps().getCellTableText(tableDetails,(i+1).toString() , 'Input File Name', pageName.InterfaceLogSummary)
					EMRProDate=getBaseSteps().getCellTableText(tableDetails,(i+1).toString() , 'Processed Date', pageName.InterfaceLogSummary)
					String expEMRDate = EMRProDate.split(' ').getAt(0)

					if(expEMRIntName.contains(EMRInt) && expEMRFileName.contains(EMRFileName) && expEMRDate.contains(EMRDate)) {
						println('FileName : '+EMRFileName)
						println('Present in '+i+' Row')

						break
					}
				}
			}
		}else {

			AssertSteps.verifyActualResult(EMRFileName.contains('.txt'), 'File Format match '+EMRFileName, 'File Format does not match '+EMRFileName, FailureHandling.STOP_ON_FAILURE)
		}
	}



	/**
	 * @param 
	 */
	private static final String ddlInterface='ddlInterface'
	private static final String chkboxEMR='chkboxEMR'
	private static final String btnSubmit='btnSubmit'
	private static final String grdInterfaceLogSummaryHeader='grdInterfaceLogSummaryHeader'
	private static final String lnkErrorRecord='lnkErrorRecord'
	private static final String grdEMRErrorRecords='grdEMRErrorRecords'
	private static final String btnExportErrorRecords='btnExportErrorRecords'
	private static final String btnbacktosummary='btnbacktosummary'
	private static final String DwnFileName='DwnFileName'
	private static final String ddlFileName='ddlFileName'
	private static final String txtFileNameSearch='txtFileNameSearch'

	public static void selectInterfaceEMR() {

		getBaseSteps().clickToControl(ddlInterface, pageName.InterfaceLogSummary)
		getBaseSteps().clickToControl(chkboxEMR, pageName.InterfaceLogSummary)
	}

	public static void clickSubmit() {

		getBaseSteps().clickToControl(btnSubmit, pageName.InterfaceLogSummary)
		getBaseSteps().waitforLoadingComplete('imgLoading', 10, pageName.CMN)
	}

	public static void verifyErrorRecords(String InputFileName, String ProcessedDate) {
		selectInterfaceEMR()
		clickSubmit()

		String grdInputFileName,grdErrorRecords,grdProcessedDate,grdTXID,grdReason
		if(InputFileName.contains('.txt')) {
			AssertSteps.verifyActualResult(InputFileName.contains('.txt'), 'File Format match '+InputFileName, 'File Format does not match '+InputFileName, FailureHandling.CONTINUE_ON_FAILURE)
			if(getBaseSteps().WebElementDisplayed(tableDetails, pageName.InterfaceLogSummary)) {
				if(getBaseSteps().WebElementDisplayed('ddlPageSize', pageName.CMN)) {
					getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
					getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)

					String noofRecords=getBaseSteps().getRowTableCounts(tableDetails, pageName.InterfaceLogSummary)

					for(int i=1;i<Integer.parseInt(noofRecords);i++) {

						grdInputFileName=getBaseSteps().getCellTableText(tableDetails, (i+1).toString(), 'Input File Name', pageName.InterfaceLogSummary)
						grdProcessedDate=getBaseSteps().getCellTableText(tableDetails, (i+1).toString(), 'Processed Date', pageName.InterfaceLogSummary)


						String grdProcDate= grdProcessedDate.split(' ').getAt(0)
						if(InputFileName.contains(grdInputFileName) && ProcessedDate.contains(grdProcDate)) {
							println('FileName : '+grdInputFileName)
							println('Present in '+i+' Row')
							grdErrorRecords=getBaseSteps().getCellTableText(tableDetails, (i+1).toString(), 'Error Records', pageName.InterfaceLogSummary)

							if(!grdErrorRecords.isEmpty()) {

								Logger.logWARNING('Error Record Found : '+grdErrorRecords)

								getBaseSteps().clickToControl(lnkErrorRecord, pageName.InterfaceLogSummary)
								getBaseSteps().waitForControlDisplay(btnExportErrorRecords, 20,  pageName.InterfaceLogSummary)
								getBaseSteps().clickToControl(btnExportErrorRecords, pageName.InterfaceLogSummary)

								if(Utilities.checkFileExists(HIIConstants.ErrorRecordsExcelName))

									Utilities.waitForFileDownloaded(HIIConstants.ErrorRecordsExcelName, 2000)

								AssertSteps.verifyActualResult(Utilities.checkFileExists(HIIConstants.ErrorRecordsExcelName), 'Error Records Export Excel File: '+HIIConstants.ErrorRecordsExcelName+' exported successfully', 'Error Records Export Excel File: '+HIIConstants.ProviderEMRProcessedExportExcelName+' export failed', FailureHandling.CONTINUE_ON_FAILURE)

								getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
								getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)

								ExcelUtilities.getExcelData('ErrorRecords.xlsx')

								//	String NoofRecords=getBaseSteps().getRowTableCounts(grdEMRErrorRecords, pageName.InterfaceLogSummary)
								//	for(int j=1;j<Integer.parseInt(NoofRecords);j++) {
								//grdTXID=getBaseSteps().getCellTableText(grdEMRErrorRecords, (i+1).toString(), 'TX ID', pageName.InterfaceLogSummary)
								//grdReason=getBaseSteps().getCellTableText(grdEMRErrorRecords, (i+1).toString(), 'Reason', pageName.InterfaceLogSummary)

								//if(grdReason.contains('Duplicate')) {
								//AssertSteps.verifyActualResult(grdReason.contains('Duplicate'), grdReason+ ' is Exist in TX ID : '+grdTXID, grdReason+ ' is not Exist in TX ID : '+grdTXID, FailureHandling.CONTINUE_ON_FAILURE)
								//break
								//}
								//	}




								break
							}else {
								println('Error Record not Found')
								break
							}
						}

						//	getBaseSteps().clickToControl(lnkErrorRecord, pageName.InterfaceLogSummary)
					}
				}
			}
		}else {

			AssertSteps.verifyActualResult(InputFileName.contains('.txt'), 'File Format match '+InputFileName, 'File Format does not match '+InputFileName, FailureHandling.STOP_ON_FAILURE)
		}
	}
	private static final String colInterface='colInterface'
	private static final String colInputFileName='colInputFileName'
	private static final String colProcessedDate='colProcessedDate'
	private static final String colJobStatus='colJobStatus'
	private static final String colTotalCount='colTotalCount'
	private static final String colCreatedRecords='colCreatedRecords'
	private static final String colUpdatedRecords='colUpdatedRecords'
	private static final String colErrorRecords='colErrorRecords'
	private static final String colExcludedRecords='colExcludedRecords'
	private static final String colLOAWarnings='colLOAWarnings'

	public static List<String> InterfaceLogSummaryGridHeader() {

		List<String> header = new ArrayList <String>()
		header.add(getBaseSteps().getTextFromControl(colInterface, pageName.InterfaceLogSummary))
		header.add(getBaseSteps().getTextFromControl(colInputFileName, pageName.InterfaceLogSummary))
		header.add(getBaseSteps().getTextFromControl(colProcessedDate, pageName.InterfaceLogSummary))
		header.add(getBaseSteps().getTextFromControl(colJobStatus, pageName.InterfaceLogSummary))
		header.add(getBaseSteps().getTextFromControl(colTotalCount, pageName.InterfaceLogSummary))
		header.add(getBaseSteps().getTextFromControl(colCreatedRecords, pageName.InterfaceLogSummary))
		header.add(getBaseSteps().getTextFromControl(colUpdatedRecords, pageName.InterfaceLogSummary))
		header.add(getBaseSteps().getTextFromControl(colErrorRecords, pageName.InterfaceLogSummary))
		//header.add(getBaseSteps().getTextFromControl(colExcludedRecords, pageName.InterfaceLogSummary))
		//header.add(getBaseSteps().getTextFromControl(colLOAWarnings, pageName.InterfaceLogSummary))
		return header

		//AssertSteps.verifyActualResult(HIIConstants.InterfaceLogSummaryGridHeader().contains(header), 'Header is equal as expected', 'Header is not equal as expected', FailureHandling.CONTINUE_ON_FAILURE)

	}
	public static void verifyInterfacegridColumnHeader() {
		selectInterfaceEMR()
		clickSubmit()


		List<String> gridHeadings=new ArrayList<String>()
		gridHeadings=InterfaceLogSummaryGridHeader()
		List<String> expGridHeadings=new ArrayList<String>()
		expGridHeadings=HIIConstants.InterfaceLogSummaryGridHeader()
		for(String gridHeading:expGridHeadings)
			AssertSteps.verifyActualResult(gridHeadings.contains(gridHeading), gridHeading+' - heading contains in ProviderEMRData Details Grid', gridHeading+' - heading is expected in ProviderEMRData Details Grid', FailureHandling.CONTINUE_ON_FAILURE)
	}
	public static void verifyEMRRecords(String InputFileName, String ProcessedDate) {
		selectInterfaceEMR()
		clickSubmit()

		String grdInputFileName,grdErrorRecords,grdProcessedDate,grdTXID,grdReason,grdTotalCount,grdCreatedRecords,grdUpdatedRecords
		int congrdTotalCount,congrdCreatedRecords,congrdUpdatedRecords,CongrdErrorRecords,sumofcount
		if(InputFileName.contains('.txt')) {
			AssertSteps.verifyActualResult(InputFileName.contains('.txt'), 'File Format match '+InputFileName, 'File Format does not match '+InputFileName, FailureHandling.CONTINUE_ON_FAILURE)
			if(getBaseSteps().WebElementDisplayed(tableDetails, pageName.InterfaceLogSummary)) {
				if(getBaseSteps().WebElementDisplayed('ddlPageSize', pageName.CMN)) {
					getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
					getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)

					String noofRecords=getBaseSteps().getRowTableCounts(tableDetails, pageName.InterfaceLogSummary)

					for(int i=1;i<Integer.parseInt(noofRecords);i++) {

						grdInputFileName=getBaseSteps().getCellTableText(tableDetails, (i+1).toString(), 'Input File Name', pageName.InterfaceLogSummary)
						grdProcessedDate=getBaseSteps().getCellTableText(tableDetails, (i+1).toString(), 'Processed Date', pageName.InterfaceLogSummary)
						grdTotalCount=getBaseSteps().getCellTableText(tableDetails, (i+1).toString(), 'Total Count', pageName.InterfaceLogSummary)
						grdCreatedRecords=getBaseSteps().getCellTableText(tableDetails, (i+1).toString(), 'Created Records', pageName.InterfaceLogSummary)
						grdUpdatedRecords=getBaseSteps().getCellTableText(tableDetails, (i+1).toString(), 'Updated Records', pageName.InterfaceLogSummary)
						grdErrorRecords=getBaseSteps().getCellTableText(tableDetails, (i+1).toString(), 'Error Records', pageName.InterfaceLogSummary)
						String grdProcDate= grdProcessedDate.split(' ').getAt(0)
						if(InputFileName.contains(grdInputFileName) && ProcessedDate.contains(grdProcDate)) {
							println('FileName : '+grdInputFileName)
							println('Present in '+i+' Row')

							if(!grdTotalCount.isEmpty()) {
								congrdTotalCount =Integer.parseInt(grdTotalCount)
								Logger.logINFO('File Total Count : '+congrdTotalCount)
							}
							if(!grdCreatedRecords.isEmpty()) {
								congrdCreatedRecords =Integer.parseInt(grdCreatedRecords)
								Logger.logINFO('File Created records Count : '+grdCreatedRecords)
							}
							if(!grdUpdatedRecords.isEmpty()) {
								congrdUpdatedRecords =Integer.parseInt(grdUpdatedRecords)
								Logger.logINFO('File Updated records Count : '+grdUpdatedRecords)
							}


							if(!grdErrorRecords.isEmpty()) {

								CongrdErrorRecords=Integer.parseInt(grdErrorRecords)

								Logger.logWARNING('Error Record Found : '+CongrdErrorRecords)

								getBaseSteps().clickToControl(lnkErrorRecord, pageName.InterfaceLogSummary)
								getBaseSteps().waitForControlDisplay(btnExportErrorRecords, 20,  pageName.InterfaceLogSummary)
								getBaseSteps().clickToControl(btnExportErrorRecords, pageName.InterfaceLogSummary)

								if(Utilities.checkFileExists(HIIConstants.ErrorRecordsExcelName))

									Utilities.waitForFileDownloaded(HIIConstants.ErrorRecordsExcelName, 2000)

								AssertSteps.verifyActualResult(Utilities.checkFileExists(HIIConstants.ErrorRecordsExcelName), 'Error Records Export Excel File: '+HIIConstants.ErrorRecordsExcelName+' exported successfully', 'Error Records Export Excel File: '+HIIConstants.ProviderEMRProcessedExportExcelName+' export failed', FailureHandling.CONTINUE_ON_FAILURE)

								getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
								getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)

								ExcelUtilities.getExcelData('ErrorRecords.xlsx')
								sumofcount = congrdCreatedRecords+congrdUpdatedRecords+CongrdErrorRecords
								AssertSteps.verifyActualResult(congrdTotalCount.equals(sumofcount), 'Successfulluy all the records are present',' Successfulluy all the records are not present', FailureHandling.CONTINUE_ON_FAILURE)
								break
							}else {
								println('Error Record not Found')
								break
							}
							sumofcount = congrdCreatedRecords+congrdUpdatedRecords+CongrdErrorRecords
							AssertSteps.verifyActualResult(congrdTotalCount.equals(sumofcount), 'Successfulluy all the records are present',' Successfulluy all the records are not present', FailureHandling.CONTINUE_ON_FAILURE)
						}
					}
				}
			}
		}else {

			AssertSteps.verifyActualResult(InputFileName.contains('.txt'), 'File Format match '+InputFileName, 'File Format does not match '+InputFileName, FailureHandling.STOP_ON_FAILURE)
		}
	}

	public static void VerifyFinalEMRFile(String InputFileName, String ProcessedDate) {
		selectInterfaceEMR()
		clickSubmit()


		String grdInputFileName,grdErrorRecords,grdProcessedDate,grdTXID,grdReason,grdTotalCount,grdCreatedRecords,grdUpdatedRecords,grdProcDate
		int congrdTotalCount,congrdCreatedRecords,congrdUpdatedRecords,CongrdErrorRecords,sumofcount

		if(InputFileName.contains('.txt')) {
			AssertSteps.verifyActualResult(InputFileName.contains('.txt'), 'File Format match '+InputFileName, 'File Format does not match '+InputFileName, FailureHandling.CONTINUE_ON_FAILURE)
			if(getBaseSteps().WebElementDisplayed(tableDetails, pageName.InterfaceLogSummary)) {
				getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
				getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)

				String noofRecords=getBaseSteps().getRowTableCounts(tableDetails, pageName.InterfaceLogSummary)

				for(int i=1;i<Integer.parseInt(noofRecords);i++) {
					grdInputFileName=getBaseSteps().getCellTableText(tableDetails, (i+1).toString(), 'Input File Name', pageName.InterfaceLogSummary)
					grdProcessedDate=getBaseSteps().getCellTableText(tableDetails, (i+1).toString(), 'Processed Date', pageName.InterfaceLogSummary)
					grdProcDate= grdProcessedDate.split(' ').getAt(0)
					grdTotalCount=getBaseSteps().getCellTableText(tableDetails, (i+1).toString(), 'Total Count', pageName.InterfaceLogSummary)
					grdCreatedRecords=getBaseSteps().getCellTableText(tableDetails, (i+1).toString(), 'Created Records', pageName.InterfaceLogSummary)
					grdUpdatedRecords=getBaseSteps().getCellTableText(tableDetails, (i+1).toString(), 'Updated Records', pageName.InterfaceLogSummary)
					grdErrorRecords=getBaseSteps().getCellTableText(tableDetails, (i+1).toString(), 'Error Records', pageName.InterfaceLogSummary)

					if(InputFileName.contains(grdInputFileName) && ProcessedDate.contains(grdProcDate)) {
						println('FileName : '+grdInputFileName)
						println('Present in '+i+' Row')


						getBaseSteps().clickToControl(ddlFileName, pageName.InterfaceLogSummary)
						getBaseSteps().setTextToControl(txtFileNameSearch, grdInputFileName+' ('+grdProcessedDate+')', pageName.InterfaceLogSummary)
						getBaseSteps().ClickDynamicCheckbox(grdInputFileName+' ('+grdProcessedDate+')')
						clickSubmit()

						if(!grdTotalCount.isEmpty()) {
							congrdTotalCount =Integer.parseInt(grdTotalCount)
							Logger.logINFO('File Total Count : '+congrdTotalCount)
						}
						if(!grdCreatedRecords.isEmpty()) {
							congrdCreatedRecords =Integer.parseInt(grdCreatedRecords)
							Logger.logINFO('File Created records Count : '+grdCreatedRecords)
						}
						if(!grdUpdatedRecords.isEmpty()) {
							congrdUpdatedRecords =Integer.parseInt(grdUpdatedRecords)
							Logger.logINFO('File Updated records Count : '+grdUpdatedRecords)
						}

						if(!grdErrorRecords.isEmpty()) {

							CongrdErrorRecords=Integer.parseInt(grdErrorRecords)

							Logger.logWARNING('Error Record Found : '+CongrdErrorRecords)

							getBaseSteps().clickToControl(lnkErrorRecord, pageName.InterfaceLogSummary)
							getBaseSteps().waitForControlDisplay(btnExportErrorRecords, 20,  pageName.InterfaceLogSummary)
							getBaseSteps().clickToControl(btnExportErrorRecords, pageName.InterfaceLogSummary)

							if(Utilities.checkFileExists(HIIConstants.ErrorRecordsExcelName))

								Utilities.waitForFileDownloaded(HIIConstants.ErrorRecordsExcelName, 2000)

							AssertSteps.verifyActualResult(Utilities.checkFileExists(HIIConstants.ErrorRecordsExcelName), 'Error Records Export Excel File: '+HIIConstants.ErrorRecordsExcelName+' exported successfully', 'Error Records Export Excel File: '+HIIConstants.ErrorRecordsExcelName+' export failed', FailureHandling.CONTINUE_ON_FAILURE)

							ExcelUtilities.getExcelData('ErrorRecords.xlsx')

							getBaseSteps().clickToControl(btnbacktosummary, pageName.InterfaceLogSummary)
							sumofcount = congrdCreatedRecords+congrdUpdatedRecords+CongrdErrorRecords
							AssertSteps.verifyActualResult(congrdTotalCount.equals(sumofcount), 'Successfulluy all the records are present',' Successfulluy all the records are not present', FailureHandling.CONTINUE_ON_FAILURE)
							getBaseSteps().waitForControlClickable(DwnFileName, 20, pageName.InterfaceLogSummary)
							getBaseSteps().clickToControl(DwnFileName, pageName.InterfaceLogSummary)

							break
						}

						sumofcount = congrdCreatedRecords+congrdUpdatedRecords+CongrdErrorRecords
						AssertSteps.verifyActualResult(congrdTotalCount.equals(sumofcount), 'Successfulluy all the records are present',' Successfulluy all the records are not present', FailureHandling.CONTINUE_ON_FAILURE)
						getBaseSteps().waitForControlClickable(DwnFileName, 20, pageName.InterfaceLogSummary)
						getBaseSteps().clickToControl(DwnFileName, pageName.InterfaceLogSummary)

						break
					}
				}
			}else {
				Logger.logWARNING('Grid is not displayed')
			}
		}else {
			AssertSteps.verifyActualResult(InputFileName.contains('.txt'), 'File Format match '+InputFileName, 'File Format does not match '+InputFileName, FailureHandling.STOP_ON_FAILURE)
		}
	}
}

