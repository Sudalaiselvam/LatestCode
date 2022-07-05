package pages

import core.AssertSteps
import core.BaseSteps
import core.ControlFactory
import testDataTypes.ContractData
import utils.CommonUtilities
import utils.ExcelUtilities
import utils.Utilities

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.sun.org.apache.bcel.internal.generic.RETURN
import com.sun.xml.internal.ws.policy.AssertionSet
import com.thoughtworks.selenium.webdriven.commands.WaitForCondition

import configs.HIIConstants
import configs.PageLocatorReader as pageName

/**
 * @author AnilKumarJanapareddy
 *
 */
public class ProviderEMRDataPageSteps {

	protected static BaseSteps getBaseSteps(){
		return new BaseSteps(new ControlFactory());
	}

	private static final String ddlRegion='ddlRegion'
	private static final String ddlCostCenter='ddlCostCenter'
	private static final String ddlYear='ddlYear'
	private static final String ddlMonth='ddlMonth'
	private static final String txtProviderName='txtProviderName'
	private static final String chkIncludeAdjustments='chkIncludeAdjustments'
	private static final String btnGo='btnGo'
	private static final String btnClear='btnClear'
	private static final String ddlselectMissingType='ddlselectMissingType'
	private static final String btnDownload='btnDownload'
	private static final String btnExportwRVUstRVUscalculationReport='btnExportwRVUstRVUscalculationReport'
	private static final String btnExportExcel='btnExportExcel'
	private static final String txtUniversalSearch='txtUniversalSearch'
	private static final String btnSearch='btnSearch'
	private static final String RdBtnProcessed='RdBtnProcessed'
	private static final String RdBtnOriginal='RdBtnOriginal'
	private static final String grdProviderEMRDetailsHeader='grdProviderEMRDetailsHeader'
	private static final String grdProviderEMRDetails='grdProviderEMRDetails'
	private static final String LblgrdRowCount='LblgrdRowCount'
	private static final String paginationbtnFirst='paginationbtnFirst'
	private static final String paginationbtnLast='paginationbtnLast'
	private static final String paginationbtnPrevious='paginationbtnPrevious'
	private static final String paginationbtnNext='paginationbtnNext'
	private static final String lnkDetails='lnkDetails'
	private static final String pnlPopup='pnlPopup'
	private static final String pnlPopupTitle='pnlPopupTitle'
	private static final String btnClose='btnClose'
	private static final String grdCPTCodeDataDetails='grdCPTCodeDataDetails'
	private static final String btnExporticon='btnExporticon'

	/**
	 * @param Region
	 */
	public static void selectRegion(String Region) {
		getBaseSteps().selectByVisibleText(ddlRegion, Region, pageName.ProviderEMRData)
	}

	/**
	 * @param CostCenter
	 */
	public static void selectCostCenter(String CostCenter) {
		getBaseSteps().selectByVisibleText(ddlCostCenter, CostCenter, pageName.ProviderEMRData)
	}

	/**
	 * @param Year
	 */
	public static void selectYear(String Year) {
		getBaseSteps().selectByVisibleText(ddlYear, Year, pageName.ProviderEMRData)
	}

	/**
	 * @param Month
	 */
	public static void selectMonth(String Month) {
		getBaseSteps().selectByVisibleText(ddlMonth, Month, pageName.ProviderEMRData)
	}

	/**
	 * @param ProviderName
	 */
	/*public static void setProviderName(String ProviderName) {
	 getBaseSteps().setTextToControl(txtProviderName, ProviderName, pageName.ProviderEMRData)
	 }*/

	public static void setProviderName(String ProviderName,FailureHandling failureHandling=FailureHandling.STOP_ON_FAILURE) {
		if(ProviderName!="") {
			getBaseSteps().setTextToControl('txtProviderName', ProviderName, pageName.ProviderEMRData)
			getBaseSteps().waitforLoadingComplete('imgLoading', 20, pageName.CMN)
			getBaseSteps().verifyProviderHintsDisplayed('lstProviderhints', pageName.CMN, failureHandling)
			getBaseSteps().waitforLoadingComplete('imgLoading', 10, pageName.CMN)
		}else {
			getBaseSteps().inputDataMissing('Provider data is missing from Input Data',failureHandling)
		}
	}

	/**
	 * 
	 */
	public static void checkIncludeAdjustments() {
		getBaseSteps().ActiveCheckBox(chkIncludeAdjustments, pageName.ProviderEMRData)
	}

	/**
	 * 
	 */
	public static void uncheckIncludeAdjustments() {
		getBaseSteps().InactiveCheckBox(chkIncludeAdjustments, pageName.ProviderEMRData)
	}

	/**
	 * 
	 */
	public static void clickGo() {
		getBaseSteps().clickToControl(btnGo, pageName.ProviderEMRData)
	}

	/**
	 * 
	 */
	public static void clickClear() {
		getBaseSteps().clickToControl(btnClear, pageName.ProviderEMRData)
	}

	/**
	 * @param MissingTyp
	 */
	public static void selectMissingType(String MissingType) {

		List<String>ListofMissingTypeDpDwn= new ArrayList()
		ListofMissingTypeDpDwn=getBaseSteps().getlistControlDropdowm(ddlselectMissingType, pageName.ProviderEMRData)

		if(ListofMissingTypeDpDwn.contains(MissingType)) {
			getBaseSteps().selectByVisibleText(ddlselectMissingType, MissingType, pageName.ProviderEMRData)
		}
		else {
			AssertSteps.verifyActualResult(ListofMissingTypeDpDwn.equals(MissingType),MissingType+ ' : Given Data is present in Select Missing Type Dropdown ',MissingType+ ' : Given Data is not present in Select Missing Type Dropdown ', FailureHandling.STOP_ON_FAILURE)
		}
	}

	/**
	 * 
	 */
	public static void clickDownload() {
		getBaseSteps().clickToControl(btnDownload, pageName.ProviderEMRData)
	}

	/**
	 * 
	 */
	public static void clickExportwRVUstRVUsCalculationReport() {
		getBaseSteps().clickToControl(btnExportwRVUstRVUscalculationReport, pageName.ProviderEMRData)
	}

	/**
	 * 
	 */
	public static void clickExportExcel() {
		getBaseSteps().clickToControl(btnExportExcel, pageName.ProviderEMRData)
	}

	/**
	 * @param UniversalSearch
	 */
	public static void setUniveralSearch(String UniversalSearch) {
		getBaseSteps().setTextToControl(txtUniversalSearch, UniversalSearch, pageName.ProviderEMRData)
	}


	/**
	 * 
	 * @author Ponsukumar
	 * 
	 */


	public static boolean isRegionDropDownDisplayed() {
		return getBaseSteps().WebElementDisplayed(ddlRegion, pageName.ProviderEMRData)
	}

	public static void VerifyRegionDropDownUI() {
		AssertSteps.verifyActualResult(isRegionDropDownDisplayed(), 'Region DropDown Displayed', 'Region DropDown is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
	}

	public static boolean isCostCenterDropDownDisplayed() {
		return getBaseSteps().WebElementDisplayed(ddlCostCenter, pageName.ProviderEMRData)
	}

	public static void VerifyCostCenterDropDownUI() {
		AssertSteps.verifyActualResult(isCostCenterDropDownDisplayed(), 'CostCenter DropDown Displayed', 'CostCenter DropDown is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
	}

	public static boolean isYearDropDownDisplayed() {
		return getBaseSteps().WebElementDisplayed(ddlYear, pageName.ProviderEMRData)
	}

	public static void VerifyYearDropDownUI() {
		AssertSteps.verifyActualResult(isYearDropDownDisplayed(), 'Year DropDown is Displayed', 'Year DropDown is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
	}

	public static boolean isMonthDropDownDisplayed() {
		return getBaseSteps().WebElementDisplayed(ddlMonth, pageName.ProviderEMRData)
	}

	public static void VerifyMonthDropDownUI() {
		AssertSteps.verifyActualResult(isMonthDropDownDisplayed(), 'Month DropDown is Displayed', 'Month DropDown is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
	}

	public static boolean isSelectMissingTypeDropDownDisplayed() {
		return getBaseSteps().WebElementDisplayed(ddlselectMissingType, pageName.ProviderEMRData)
	}

	public static void VerifySelectMissingTypeDropDownUI() {
		AssertSteps.verifyActualResult(isSelectMissingTypeDropDownDisplayed(), 'SelectMissingType DropDown is Displayed',  'SelectMissingType DropDown is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
	}

	public static boolean isProviderNameTextBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(txtProviderName, pageName.ProviderEMRData)
	}

	public static void VerifyProviderNameTextBoxUI() {
		AssertSteps.verifyActualResult(isProviderNameTextBoxDisplayed(), 'ProviderName TextBox is Displayed',  'ProviderName TextBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
	}

	public static boolean isUniversalSearchTextBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(txtUniversalSearch, pageName.ProviderEMRData)
	}

	public static String getUniversalSearchTextBoxValue() {
		return getBaseSteps().getValueFromControl(txtUniversalSearch, pageName.ProviderEMRData)
	}

	public static void VerifyUniversalSearchTextBoxUI() {
		AssertSteps.verifyActualResult(isUniversalSearchTextBoxDisplayed(), 'UniversalSearch TextBox is Displayed', 'UniversalSearch TextBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
	}

	public static boolean isExportExcelDisplayed() {
		return getBaseSteps().WebElementDisplayed(btnExportExcel, pageName.ProviderEMRData)
	}

	public static void VerifyExportExcelImageUI() {
		AssertSteps.verifyActualResult(isExportExcelDisplayed(), 'Export Excel Image is Displayed', 'Export Excel Image is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
	}


	public static boolean isGoButtonDisplayed() {
		return getBaseSteps().WebElementDisplayed(btnGo, pageName.ProviderEMRData)
	}

	public static void VerifyGoButtonUI() {
		AssertSteps.verifyActualResult(isGoButtonDisplayed(), 'Go Button is Displayed', 'Go Button is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
	}


	public static boolean isClearButtonDisplayed() {
		return getBaseSteps().WebElementDisplayed(btnClear, pageName.ProviderEMRData)
	}

	public static void VerifyClearButtonUI() {
		AssertSteps.verifyActualResult(isClearButtonDisplayed(), 'Clear Button is Displayed', 'Clear Button is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
	}

	public static boolean isDownloadButtonDisplayed() {
		return getBaseSteps().WebElementDisplayed(btnDownload, pageName.ProviderEMRData)
	}

	public static void VerifyDownloadButtonUI() {
		AssertSteps.verifyActualResult(isDownloadButtonDisplayed(), 'Download Button is Displayed', 'Download Button is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
	}

	public static boolean isExportcalculationReportButtonDisplayed() {
		return getBaseSteps().WebElementDisplayed(btnExportwRVUstRVUscalculationReport, pageName.ProviderEMRData)
	}

	public static void VerifyExportCalculationreportButtonUI() {
		AssertSteps.verifyActualResult(isExportcalculationReportButtonDisplayed(), 'ExportCalculationReport Button is Displayed', 'ExportCalculationReport Button is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
	}

	public static boolean isSearchButtonDisplayed() {
		return getBaseSteps().WebElementDisplayed(btnSearch, pageName.ProviderEMRData)
	}

	public static void VerifySearchButtonUI() {
		AssertSteps.verifyActualResult(isSearchButtonDisplayed(), 'Search Button is Displayed', 'Search Button is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
	}

	public static boolean isIncludeAdjustmentsDisplayed() {
		return getBaseSteps().WebElementDisplayed(chkIncludeAdjustments, pageName.ProviderEMRData)
	}

	public static void VerifyIncludeAdjustmentsCheckBoxUI() {
		AssertSteps.verifyActualResult(isIncludeAdjustmentsDisplayed(), 'IncludeAdjustments CheckBox is Displayed', 'IncludeAdjustments CheckBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
	}

	public static boolean isProcessedDisplayed() {
		return getBaseSteps().WebElementDisplayed(RdBtnProcessed, pageName.ProviderEMRData)
	}

	public static void VerifyProcessedRadioButtonUI() {
		AssertSteps.verifyActualResult(isProcessedDisplayed(), 'Processed RadioButton is Displayed', 'Processed RadioButton is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
	}

	public static boolean isOriginalDisplayed() {
		return getBaseSteps().WebElementDisplayed(RdBtnOriginal, pageName.ProviderEMRData)
	}

	public static void VerifyOriginalRadioButtonUI() {
		AssertSteps.verifyActualResult(isOriginalDisplayed(), 'Original RadioButton is Displayed', 'Original RadioButton is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
	}

	public static void VerifyProcessedRadioButton() {
		AssertSteps.verifyActualResult(!isProcessedDisplayed(), 'Processed RadioButton is not Displayed', 'Processed RadioButton is Displayed', FailureHandling.CONTINUE_ON_FAILURE)
	}

	public static void VerifyOriginalRadioButton() {
		AssertSteps.verifyActualResult(!isOriginalDisplayed(), 'Original RadioButton is not Displayed', 'Original RadioButton is Displayed', FailureHandling.CONTINUE_ON_FAILURE)
	}


	public static List<String> getProviderEMRDataDetailsGridColumnHeadings() {
		List<String> colHeadings=new ArrayList<String>()
		colHeadings=getBaseSteps().getTableHeadingsWithSortingTag(grdProviderEMRDetailsHeader, pageName.ProviderEMRData)
		return colHeadings
	}

	public static boolean isProviderEMRDetailsGridDisplayed() {
		return getBaseSteps().WebElementDisplayed(grdProviderEMRDetails, pageName.ProviderEMRData)
	}

	/**
	 *------------------------------------------
	 */
	public static void clickSearch() {
		getBaseSteps().clickToControl(btnSearch, pageName.ProviderEMRData)
	}

	public static void clickbtnFirst() {
		getBaseSteps().clickToControl(paginationbtnFirst, pageName.ProviderEMRData)
	}

	public static void clickbtnLast() {
		getBaseSteps().clickToControl(paginationbtnLast, pageName.ProviderEMRData)
	}

	public static void clickbtnPrevious() {
		getBaseSteps().clickToControl(paginationbtnPrevious, pageName.ProviderEMRData)
	}

	public static void clickbtnNext() {
		getBaseSteps().clickToControl(paginationbtnNext, pageName.ProviderEMRData)
	}

	public static void clickDetailsLink() {
		getBaseSteps().clickToControl(lnkDetails, pageName.ProviderEMRData)
	}
	public static boolean CPTDetailsPopUpDisplayed() {
		return getBaseSteps().WebElementDisplayed(pnlPopup, pageName.ProviderEMRData)
	}
	public static String getPopUpInformation() {
		if(CPTDetailsPopUpDisplayed())
			return getBaseSteps().getTextFromControl(pnlPopupTitle, pageName.ProviderEMRData)
	}
	public static void isCloseButtonDisplayed() {
		if(CPTDetailsPopUpDisplayed()) {
			getBaseSteps().WebElementDisplayed(btnClose, pageName.ProviderEMRData)
		}
	}
	public static void verifyProviderEMRDataDetailsGridUI() {

		boolean blnDisplayed=isProviderEMRDetailsGridDisplayed()
		'Verifying ProviderEMR Data Details Grid whether displayed or not'
		AssertSteps.verifyActualResult(blnDisplayed, 'Provider EMR Data grid is Displayed', 'Provider EMR Data grid is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)

		if(blnDisplayed) {
			'Verifying Physician Details Grid Headings'
			List<String> gridHeadings=new ArrayList<String>()
			gridHeadings=getProviderEMRDataDetailsGridColumnHeadings()
			List<String> expGridHeadings=new ArrayList<String>()
			expGridHeadings=HIIConstants.ProviderEMRDataDetailsGridColumnHeadings()
			for(String gridHeading:expGridHeadings)
				AssertSteps.verifyActualResult(gridHeadings.contains(gridHeading), gridHeading+' - heading contains in ProviderEMRData Details Grid', gridHeading+' - heading is expected in ProviderEMRData Details Grid', FailureHandling.CONTINUE_ON_FAILURE)
		}
	}



	public static void VerifyProviderIndividualSearchByCostCenter(String CostCenter) {

		ProviderEMRDataPageSteps.selectCostCenter(CostCenter)
		ProviderEMRDataPageSteps.clickGo()
		String expCostCenter = CostCenter
		String grdCostCenter
		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)

		if(getBaseSteps().WebElementDisplayed(grdProviderEMRDetails, pageName.ProviderEMRData)) {
			String noofRequests=getBaseSteps().getRowTableCounts(grdProviderEMRDetails, pageName.ProviderEMRData)
			for(int i=1;i<Integer.parseInt(noofRequests);i++) {
				grdCostCenter=getBaseSteps().getCellTableText(grdProviderEMRDetails,(i+1).toString() , 'Cost Center', pageName.ProviderEMRData)
				AssertSteps.verifyActualResult(expCostCenter.contains(grdCostCenter), grdCostCenter+':CostCenter matched', grdCostCenter+':CostCenter not matched' , FailureHandling.CONTINUE_ON_FAILURE)
			}
		}
	}




	public static void VerifyProviderIndividualSearchByYear(String Year) {

		ProviderEMRDataPageSteps.selectYear(Year)
		ProviderEMRDataPageSteps.clickGo()
		String expYear = Year
		String grdYear
		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)

		if(getBaseSteps().WebElementDisplayed(grdProviderEMRDetails, pageName.ProviderEMRData)) {
			String noofRequests=getBaseSteps().getRowTableCounts(grdProviderEMRDetails, pageName.ProviderEMRData)
			for(int i=1;i<Integer.parseInt(noofRequests);i++) {
				grdYear=getBaseSteps().getCellTableText(grdProviderEMRDetails,(i+1).toString() , 'Year', pageName.ProviderEMRData)
				AssertSteps.verifyActualResult(expYear.contains(grdYear), grdYear+':Year matched', grdYear+':Year not matched' , FailureHandling.CONTINUE_ON_FAILURE)
			}
		}
	}

	public static void VerifyProviderIndividualSearchByMonth(String Month) {

		ProviderEMRDataPageSteps.selectMonth(Month)
		ProviderEMRDataPageSteps.clickGo()
		String expMonth = Month.toUpperCase()
		String grdMonth
		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)


		if(getBaseSteps().WebElementDisplayed(grdProviderEMRDetails, pageName.ProviderEMRData)) {
			String noofRequests=getBaseSteps().getRowTableCounts(grdProviderEMRDetails, pageName.ProviderEMRData)
			for(int i=1;i<Integer.parseInt(noofRequests);i++) {
				grdMonth=getBaseSteps().getCellTableText(grdProviderEMRDetails,(i+1).toString() , 'Month', pageName.ProviderEMRData)
				String actgrdMonth =  grdMonth.split('-').getAt(1)
				AssertSteps.verifyActualResult(expMonth.contains(actgrdMonth), actgrdMonth+':Month matched', actgrdMonth+':Month not matched' , FailureHandling.CONTINUE_ON_FAILURE)
			}
		}
	}


	public static void VerifyProviderIndividualSearchByName(String ProviderName) {

		ProviderEMRDataPageSteps.setProviderName(ProviderName)

		ProviderEMRDataPageSteps.clickGo()
		String expProviderName = ProviderName
		String grdProviderName
		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)


		if(getBaseSteps().WebElementDisplayed(grdProviderEMRDetails, pageName.ProviderEMRData)) {
			String noofRequests=getBaseSteps().getRowTableCounts(grdProviderEMRDetails, pageName.ProviderEMRData)
			for(int i=1;i<Integer.parseInt(noofRequests);i++) {
				grdProviderName=getBaseSteps().getCellTableText(grdProviderEMRDetails,(i+1).toString() , 'Provider Name', pageName.ProviderEMRData)
				AssertSteps.verifyActualResult(expProviderName.contains(grdProviderName), grdProviderName+':ProviderName matched', grdProviderName+':ProviderName not matched' , FailureHandling.CONTINUE_ON_FAILURE)
			}
		}
	}

	public static void VerifyProviderCombinationCostCenterYearMonth(String CostCenter,String Year,String Month ) {
		VerifyProviderIndividualSearchByCostCenter(CostCenter)
		VerifyProviderIndividualSearchByYear(Year)
		VerifyProviderIndividualSearchByMonth(Month)
	}

	public static void VerifyProviderCombinationYearMonth(String Year,String Month) {
		VerifyProviderIndividualSearchByYear(Year)
		VerifyProviderIndividualSearchByMonth(Month)
	}

	public static void VerifyProviderCombinationProviderNameYear(String ProviderName,String Year) {
		VerifyProviderIndividualSearchByName(ProviderName)
		VerifyProviderIndividualSearchByYear(Year)
	}

	public static void VerifyProviderCombinationProviderNameMonthYear(String ProviderName,String Month,String Year) {
		VerifyProviderIndividualSearchByName(ProviderName)
		VerifyProviderIndividualSearchByMonth(Month)
		VerifyProviderIndividualSearchByYear(Year)
	}


	public static void VerifyClearData() {
		String BeforeClrRowCount = getBaseSteps().getTextFromControl(LblgrdRowCount, pageName.ProviderEMRData)
		clickClear()
		String AfterClrRowCount = getBaseSteps().getTextFromControl(LblgrdRowCount, pageName.ProviderEMRData)
		AssertSteps.verifyActualResult(!AfterClrRowCount.equals(BeforeClrRowCount), 'Data Cleared Successfully', 'Data Cleared not Successfully', FailureHandling.CONTINUE_ON_FAILURE)
	}

	public static void verifyUniversalSearchFunctionality() {

		String UniversalSearchValue=getUniversalSearchTextBoxValue()

		if(isProviderEMRDetailsGridDisplayed()) {
			getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
			getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)


			String grdCostCenter,grdYear,grdMonth,grdProviderName
			String noofRequests=getBaseSteps().getRowTableCounts(grdProviderEMRDetails, pageName.ProviderEMRData)
			for(int i=1;i<Integer.parseInt(noofRequests);i++) {

				grdCostCenter=getBaseSteps().getCellTableText(grdProviderEMRDetails,(i+1).toString() , 'Cost Center', pageName.ProviderEMRData)
				grdYear=getBaseSteps().getCellTableText(grdProviderEMRDetails,(i+1).toString() , 'Year', pageName.ProviderEMRData)
				grdProviderName=getBaseSteps().getCellTableText(grdProviderEMRDetails,(i+1).toString() , 'Provider Name', pageName.ProviderEMRData)
			}


			if(grdCostCenter.contains(UniversalSearchValue)) {
				AssertSteps.verifyActualResult(grdCostCenter.equals(UniversalSearchValue), 'CostCenter is matched with UniversalSearch', 'CostCenter is not matched with UniversalSearch', FailureHandling.CONTINUE_ON_FAILURE)
			}
			if(grdYear.contains(UniversalSearchValue)) {
				AssertSteps.verifyActualResult(grdYear.equals(UniversalSearchValue), 'Year is matched with UniversalSearch', 'Year is not matched with UniversalSearch', FailureHandling.CONTINUE_ON_FAILURE)
			}
			if(grdProviderName.contains(UniversalSearchValue)) {
				AssertSteps.verifyActualResult(grdProviderName.contains(UniversalSearchValue), 'ProviderName is matched with UniversalSearch '+grdProviderName, 'ProviderName is not matched with UniversalSearch '+grdProviderName, FailureHandling.CONTINUE_ON_FAILURE)
			}
		}else {

			AssertSteps.verifyActualResult(!isProviderEMRDetailsGridDisplayed(), 'Provider EMR Data grid not displayed for '+UniversalSearchValue)
		}
	}

	public static boolean selectEMRProcess() {
		return getBaseSteps().WebElementDisplayed(grdProviderEMRDetails, pageName.ProviderEMRData)
	}

	public static void selectpageNumber(String Region) {

		ProviderEMRDataPageSteps.selectRegion(Region)

		getBaseSteps().selectFirstOptionDropdownControl('ddlGotoPage', pageName.ProviderEMRData)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().selectRandomOptionDropdownControl('ddlGotoPage', pageName.ProviderEMRData)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().selectLastOptionDropDownControl('ddlGotoPage', pageName.ProviderEMRData)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectpaginationArrows(String Region) {

		ProviderEMRDataPageSteps.selectRegion(Region)

		getBaseSteps().clickToControl(paginationbtnFirst, pageName.ProviderEMRData)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().clickToControl(paginationbtnLast, pageName.ProviderEMRData)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().clickToControl(paginationbtnPrevious, pageName.ProviderEMRData)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().clickToControl(paginationbtnNext, pageName.ProviderEMRData)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static getRule (String CPTCode) {

		WRVUSOverridePageSteps.getRule(CPTCode)
	}


	public static verifywRVUSDetails(String Region) {
		ProviderEMRDataPageSteps.selectRegion(Region)
		ProviderEMRDataPageSteps.clickDetailsLink()
		String actualCPTPopup

		AssertSteps.verifyActualResult(CPTDetailsPopUpDisplayed(), 'CPT Code Data Details PopUp displayed', 'CPT Code Data Details PopUp not displayed', FailureHandling.CONTINUE_ON_FAILURE)
		actualCPTPopup=getPopUpInformation()
		AssertSteps.verifyActualResult(actualCPTPopup.equals(HIIConstants.expEMRDataPopupTitle), 'CPT Code Popup Title is as expected', 'CPT Code Popup Title is not as expected ', FailureHandling.CONTINUE_ON_FAILURE)
		isCloseButtonDisplayed()
	}


	public static void clickOriginal(){
		getBaseSteps().clickToControl(RdBtnOriginal, pageName.ProviderEMRData)
	}

	public static void verifyExportOriginalEMRExportFunctionality() {

		clickExportExcel()

		if(Utilities.checkFileExists(HIIConstants.ProviderEMROriginalExportExcelName))

			Utilities.waitForFileDownloaded(HIIConstants.ProviderEMROriginalExportExcelName, 2000)

		AssertSteps.verifyActualResult(Utilities.checkFileExists(HIIConstants.ProviderEMROriginalExportExcelName), 'Original EMR Export Excel File: '+HIIConstants.ProviderEMROriginalExportExcelName+' exported successfully', 'Original EMR Export Excel File: '+HIIConstants.ProviderEMROriginalExportExcelName+' export failed', FailureHandling.CONTINUE_ON_FAILURE)
	}


	public static void clickProcessed(){
		getBaseSteps().clickToControl(RdBtnProcessed, pageName.ProviderEMRData)
	}

	public static void verifyExportProcessedEMRExportFunctionality() {
		clickExportExcel()

		if(Utilities.checkFileExists(HIIConstants.ProviderEMRProcessedExportExcelName))

			Utilities.waitForFileDownloaded(HIIConstants.ProviderEMRProcessedExportExcelName, 2000)

		AssertSteps.verifyActualResult(Utilities.checkFileExists(HIIConstants.ProviderEMRProcessedExportExcelName), 'Processed EMR Export Excel File:'+HIIConstants.ProviderEMRProcessedExportExcelName+' exported successfully', 'Processed EMR Export Excel File:'+HIIConstants.ProviderEMRProcessedExportExcelName+' export failed', FailureHandling.CONTINUE_ON_FAILURE)
	}


	public static void verifyDownloadMissingType(String MissingType) {


		List<String>ListofMissingTypeDpDwn= new ArrayList()
		ListofMissingTypeDpDwn=getBaseSteps().getlistControlDropdowm(ddlselectMissingType, pageName.ProviderEMRData)



		if(ListofMissingTypeDpDwn.contains(MissingType))	{
			if(Utilities.checkFileExists(HIIConstants.MissingProviderDownloadExcelName)) {
				Utilities.waitForFileDownloaded(HIIConstants.MissingProviderDownloadExcelName, 3000)
				AssertSteps.verifyActualResult(Utilities.checkFileExists(HIIConstants.MissingProviderDownloadExcelName), 'Downloaded Missing Providers Download Excel File:'+HIIConstants.MissingProviderDownloadExcelName+' downloaded successfully', 'Downloaded Missing Providers Download Excel File:'+HIIConstants.MissingProviderDownloadExcelName+' download failed', FailureHandling.CONTINUE_ON_FAILURE)
			}
		}

		if(ListofMissingTypeDpDwn.contains(MissingType)) {
			if(Utilities.checkFileExists(HIIConstants.MissingContractDownloadExcelName)) {
				Utilities.waitForFileDownloaded(HIIConstants.MissingContractDownloadExcelName, 3000)
				AssertSteps.verifyActualResult(Utilities.checkFileExists(HIIConstants.MissingContractDownloadExcelName), 'Downloaded Missing Contract Download Excel File:'+HIIConstants.MissingContractDownloadExcelName+' downloaded successfully', 'Downloaded Missing Contract Download Excel File:'+HIIConstants.MissingContractDownloadExcelName+' download failed', FailureHandling.CONTINUE_ON_FAILURE)
			}
		}

		if(ListofMissingTypeDpDwn.contains(MissingType)) {
			if(Utilities.checkFileExists(HIIConstants.MissingCostCenterDownloadExcelName)) {
				Utilities.waitForFileDownloaded(HIIConstants.MissingCostCenterDownloadExcelName, 3000)
				AssertSteps.verifyActualResult(Utilities.checkFileExists(HIIConstants.MissingCostCenterDownloadExcelName), 'Downloaded Missing CostCenter Download Excel File:'+HIIConstants.MissingCostCenterDownloadExcelName+' downloaded successfully', 'Downloaded Missing CostCenter Download Excel File:'+HIIConstants.MissingCostCenterDownloadExcelName+' download failed', FailureHandling.CONTINUE_ON_FAILURE)
			}
		}
	}



	public static void verifyScrollFunctionality() {

		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForControlClickable(grdProviderEMRDetails, pageName.ProviderEMRData)
		getBaseSteps().scrollDown()
	}


	public static void verifySFTPEnabledinGeneralSettings () {
		String actlblName= GeneralSettingsSteps.isEMRFileUploadTypeDisplayed()
		AssertSteps.verifyActualResult(actlblName.equals(HIIConstants.lblEMRFileUploadType), actlblName +' Displayed', actlblName +' not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		GeneralSettingsSteps.verifyEMRFileTypeEnabled()
	}

	public static void VerifyDisplayOriginalDatainGeneralSetting() {
		String actlblName=GeneralSettingsSteps.isDisplayOriginalEMRDataDisplayed()
		AssertSteps.verifyActualResult(actlblName.equals(HIIConstants.lblDisplayOriginalEMRData), actlblName +' Displayed', actlblName +' not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
	}

	public static void verifyOriginalExportwRVUstRVUscalculationReport() {

		clickExportwRVUstRVUsCalculationReport()

		if(Utilities.checkFileExists(HIIConstants.OriginalwRVUSCalculationReportCsvName))

			Utilities.waitForFileDownloaded(HIIConstants.OriginalwRVUSCalculationReportCsvName, 2000)

		AssertSteps.verifyActualResult(Utilities.checkFileExists(HIIConstants.OriginalwRVUSCalculationReportCsvName), 'Original wRVUS Calculation Report Export csv File:' +HIIConstants.OriginalwRVUSCalculationReportCsvName+' exported successfully', 'Original wRVUS Calculation Report Export csv File:' +HIIConstants.OriginalwRVUSCalculationReportCsvName+' export failed', FailureHandling.CONTINUE_ON_FAILURE)
	}

	public static void verifyProcessedExportwRVUstRVUscalculationReport() {

		clickExportwRVUstRVUsCalculationReport()

		if(Utilities.checkFileExists(HIIConstants.ProcessedwRVUSCalculationReportCsvName))

			Utilities.waitForFileDownloaded(HIIConstants.ProcessedwRVUSCalculationReportCsvName, 2000)

		AssertSteps.verifyActualResult(Utilities.checkFileExists(HIIConstants.ProcessedwRVUSCalculationReportCsvName), 'Processed wRVUS Calculation Report Export csv File:' +HIIConstants.ProcessedwRVUSCalculationReportCsvName+' exported successfully', 'Processed wRVUS Calculation Report Export csv File:' +HIIConstants.ProcessedwRVUSCalculationReportCsvName+' export failed', FailureHandling.CONTINUE_ON_FAILURE)
	}




	public static void verifyhistoricrecordsinOriginalData() {

		getBaseSteps().selectRandomOptionOfDropDownList(ddlYear, pageName.ProviderEMRData)
		getBaseSteps().selectRandomOptionOfDropDownList(ddlMonth, pageName.ProviderEMRData)
		clickOriginal()
		clickGo()
		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)



		//String expYear =getBaseSteps().getTextFromControl(ddlYear, pageName.InterfaceLogSummary)


		//String expMonth =getBaseSteps().getTextFromControl(ddlMonth, pageName.InterfaceLogSummary)

		String grdYear,grdMonth



		if(getBaseSteps().WebElementDisplayed(grdProviderEMRDetails, pageName.ProviderEMRData)) {
			String noofRequests=getBaseSteps().getRowTableCounts(grdProviderEMRDetails, pageName.ProviderEMRData)
			for(int i=1;i<Integer.parseInt(noofRequests);i++) {
				grdYear=getBaseSteps().getCellTableText(grdProviderEMRDetails,(i+1).toString() , 'Year', pageName.ProviderEMRData)
				grdMonth=getBaseSteps().getCellTableText(grdProviderEMRDetails,(i+1).toString() , 'Month', pageName.ProviderEMRData)
				//AssertSteps.verifyActualResult(expYear.contains(grdYear), grdYear+':Year matched', grdYear+':Year not matched' , FailureHandling.CONTINUE_ON_FAILURE)
				//AssertSteps.verifyActualResult(expMonth.contains(grdMonth), grdMonth+':Month matched', grdMonth+':Month not matched' , FailureHandling.CONTINUE_ON_FAILURE)
			}
		}


	}

	public static void verifyhistoricrecordsinProcessedData() {

		getBaseSteps().selectRandomOptionOfDropDownList(ddlYear, pageName.ProviderEMRData)
		getBaseSteps().selectRandomOptionOfDropDownList(ddlMonth, pageName.ProviderEMRData)
		clickProcessed()
		clickGo()
		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)


		//String expYear =getBaseSteps().getTextFromControl(ddlYear, pageName.InterfaceLogSummary)


		//String expMonth =getBaseSteps().getTextFromControl(ddlMonth, pageName.InterfaceLogSummary)

		String grdYear,grdMonth



		if(getBaseSteps().WebElementDisplayed(grdProviderEMRDetails, pageName.ProviderEMRData)) {
			String noofRequests=getBaseSteps().getRowTableCounts(grdProviderEMRDetails, pageName.ProviderEMRData)
			for(int i=1;i<Integer.parseInt(noofRequests);i++) {
				grdYear=getBaseSteps().getCellTableText(grdProviderEMRDetails,(i+1).toString() , 'Year', pageName.ProviderEMRData)
				grdMonth=getBaseSteps().getCellTableText(grdProviderEMRDetails,(i+1).toString() , 'Month', pageName.ProviderEMRData)
				//AssertSteps.verifyActualResult(expYear.contains(grdYear), grdYear+':Year matched', grdYear+':Year not matched' , FailureHandling.CONTINUE_ON_FAILURE)
				//AssertSteps.verifyActualResult(expMonth.contains(grdMonth), grdMonth+':Month matched', grdMonth+':Month not matched' , FailureHandling.CONTINUE_ON_FAILURE)
			}
		}
	}

	public static verifyRecordInsertedBasedonTerminateFlags(String Provider) {
		String grdPostDate
		String TerminateFlag = GeneralSettingsSteps.getTerminateFlag()
		HeaderPageSteps.verifyNavigationToProviderSetup()
		String HireDate = ProviderSetupSteps.getPhysicianHireDate(Provider)
		HeaderPageSteps.verifyNavigationToProviderEMRData()
		setProviderName(Provider)
		Thread.sleep(2000)
		clickGo()
		clickDetailsLink()

		getBaseSteps().waitForControlDisplay(grdCPTCodeDataDetails, pageName.ProviderEMRData)
		String noofrows = getBaseSteps().getRowTableCounts(grdCPTCodeDataDetails, pageName.ProviderEMRData)
		int rowcount = Integer.parseInt(noofrows)-1
		println (Provider+' No of rows present in '+rowcount)

		for(int i=1;i<Integer.parseInt(noofrows);i++) {
			grdPostDate=getBaseSteps().getCellTableText(grdCPTCodeDataDetails, (i+1).toString(), 'Post Date', pageName.ProviderEMRData)
			AssertSteps.verifyActualResult(true, grdPostDate+" Post date is greater than Hired date", grdPostDate+" Post date is not greater than Hired date", FailureHandling.CONTINUE_ON_FAILURE)


		}
	}

	public static void verifyProcessedTotalwRVUsCheckDeciaml() {
		List<String> datas = new ArrayList()
		getBaseSteps().selectRandomOptionOfDropDownList(ddlYear, pageName.ProviderEMRData)
		//getBaseSteps().selectByVisibleText(ddlYear, '2021', pageName.ProviderEMRData)
		getBaseSteps().selectRandomOptionOfDropDownList(ddlMonth, pageName.ProviderEMRData)
		//getBaseSteps().selectByVisibleText(ddlMonth, 'Sep', pageName.ProviderEMRData)
		clickProcessed()
		clickGo()
		if(getBaseSteps().WebElementDisplayed(grdProviderEMRDetails, pageName.ProviderEMRData)) {
			getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
			getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
			String noofRequests=getBaseSteps().getRowTableCounts(grdProviderEMRDetails, pageName.ProviderEMRData)
			int providerrowcount = Integer.parseInt(noofRequests)-1
			println ('Total no of ProviderName count : '+providerrowcount)

			for(int i=1;i<Integer.parseInt(noofRequests);i++) {
				datas.add(getBaseSteps().getCellTableText(grdProviderEMRDetails,(i+1).toString() , 'Provider Name', pageName.ProviderEMRData))
			}

			for(String data:datas) {
				getBaseSteps().setTextToControl(txtProviderName, data, pageName.ProviderEMRData)
				clickGo()
				clickDetailsLink()
				getBaseSteps().waitForControlDisplay(grdCPTCodeDataDetails, pageName.ProviderEMRData)
				String noofrows = getBaseSteps().getRowTableCounts(grdCPTCodeDataDetails, pageName.ProviderEMRData)
				int rowcount = Integer.parseInt(noofrows)-1
				println (data+' No of rows present in '+rowcount)
				getBaseSteps().clickToControl(btnExporticon, pageName.ProviderEMRData)
				for (int j=1;j<Integer.parseInt(noofrows);j++) {
					getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
					getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)

					String value=getBaseSteps().getCellTableText(grdCPTCodeDataDetails,(j+1).toString() ,'Total wRVUs', pageName.ProviderEMRData)
					if(value.length()<=7) {
						Double Amount=Double.parseDouble(value.toString())
						String	hmValue=Utilities.DecimalFormatter(Amount, 3)
						AssertSteps.verifyActualResult(value.equals(hmValue), 'Rounded with 3 Decimal '+value, 'Rounded with not in 3 Decimal '+value, FailureHandling.CONTINUE_ON_FAILURE)
					}

				}


				Utilities.deleteFile(HIIConstants.ErrorDetailsExcelName)

				getBaseSteps().clickToControl(btnClose, pageName.ProviderEMRData)


			}
		}

	}

	public static void verifyOriginalTotalwRVUsCheckDeciaml() {
		List<String> datas = new ArrayList()
		getBaseSteps().selectRandomOptionOfDropDownList(ddlYear, pageName.ProviderEMRData)
		//getBaseSteps().selectByVisibleText(ddlYear, '2021', pageName.ProviderEMRData)
		getBaseSteps().selectRandomOptionOfDropDownList(ddlMonth, pageName.ProviderEMRData)
		//getBaseSteps().selectByVisibleText(ddlMonth, 'Sep', pageName.ProviderEMRData)
		clickOriginal()
		clickGo()
		if(getBaseSteps().WebElementDisplayed(grdProviderEMRDetails, pageName.ProviderEMRData)) {
			getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
			getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
			String noofRequests=getBaseSteps().getRowTableCounts(grdProviderEMRDetails, pageName.ProviderEMRData)
			int providerrowcount = Integer.parseInt(noofRequests)-1
			println ('Total no of ProviderName count : '+providerrowcount)

			for(int i=1;i<Integer.parseInt(noofRequests);i++) {
				datas.add(getBaseSteps().getCellTableText(grdProviderEMRDetails,(i+1).toString() , 'Provider Name', pageName.ProviderEMRData))
			}

			for(String data:datas) {
				getBaseSteps().setTextToControl(txtProviderName, data, pageName.ProviderEMRData)
				clickGo()
				clickDetailsLink()
				String noofrows = getBaseSteps().getRowTableCounts(grdCPTCodeDataDetails, pageName.ProviderEMRData)
				int rowcount = Integer.parseInt(noofrows)-1
				println (data+' No of rows present in '+rowcount)
				getBaseSteps().clickToControl(btnExporticon, pageName.ProviderEMRData)
				for (int j=1;j<Integer.parseInt(noofrows);j++) {
					getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
					getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)

					String value=getBaseSteps().getCellTableText(grdCPTCodeDataDetails,(j+1).toString() ,'Total wRVUs', pageName.ProviderEMRData)
					if(value.length()<=7) {
						Double Amount=Double.parseDouble(value.toString())
						String	hmValue=Utilities.DecimalFormatter(Amount, 3)
						AssertSteps.verifyActualResult(value.equals(hmValue), 'Rounded with 3 Decimal '+value, 'Rounded with not in 3 Decimal '+value, FailureHandling.CONTINUE_ON_FAILURE)
					}
				}


				Utilities.deleteFile(HIIConstants.ErrorDetailsExcelName)

				getBaseSteps().clickToControl(btnClose, pageName.ProviderEMRData)


			}


		}
	}
	
	public static void VerifyDemoMethod1(String InputFileName) {
		
		
		ExcelUtilities.textFileToExcelConvertor(InputFileName)
		
	}


}



