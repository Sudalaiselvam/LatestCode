package pages

import core.AssertSteps
import core.BaseSteps
import core.ControlFactory

import com.kms.katalon.core.model.FailureHandling
import com.thoughtworks.selenium.webdriven.commands.Click

import ch.qos.logback.core.joran.conditional.ElseAction
import configs.HIIConstants
import configs.PageLocatorReader as pageName
import utils.CommonUtilities


/**
 * @author AnilKumarJanapareddy
 *
 */
public class GeneralSettingsSteps {


	protected static BaseSteps getBaseSteps(){
		return new BaseSteps(new ControlFactory());
	}

	public static void gotoGeneralSettings() {
		getBaseSteps().gotoCascadingMenu('mnuAdmin', 'mnuOrganizationalHierarchy', 'mnuGeneralSettings', pageName.Header)
	}

	public static void gotoGeneralSettings_newTab() {
		getBaseSteps().openCascadingMenu_newTab('mnuAdmin', 'mnuOrganizationalHierarchy', 'mnuGeneralSettings', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void setSettingDescription(String SettingDescription) {

		getBaseSteps().selectByVisibleText('ddlSettingDescription', SettingDescription, pageName.GeneralSettings)
	}

	public static void setRegion(String Region) {
		getBaseSteps().selectByVisibleText('ddlRegion', Region, pageName.GeneralSettings)
	}

	public static void setLocation(String Location) {
		getBaseSteps().selectByVisibleText('ddlLocation', Location, pageName.GeneralSettings)
	}

	public static void setSettingDescription_ApplicableFlags() {
		setSettingDescription('Applicable Flags')
	}

	public static void setSettingDescription_ApplicableSettings() {
		setSettingDescription('Applicable Settings')
	}

	public static void setSettingDescription_ApplicationSettings() {
		setSettingDescription('Application Settings')
	}

	public static void setSettingDescription_ApprovalProcess() {
		setSettingDescription('Approval Process')
	}

	public static String getAllowtoGroupContractPayElementsbasedonCostCenter() {
		String sFlag
		GeneralSettingsSteps.gotoGeneralSettings_newTab()
		GeneralSettingsSteps.setSettingDescription_ApplicationSettings()
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		sFlag=getBaseSteps().getCellTableText('grdSettings', 'Allow to Group Contract Pay Elements based on Cost Center', pageName.GeneralSettings)
		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		return sFlag
	}

	public static String getAllowAdjHoldAmountInProviderPayApprovalsScreen() {
		String sFlag
		GeneralSettingsSteps.gotoGeneralSettings_newTab()
		GeneralSettingsSteps.setSettingDescription_ApplicationSettings()
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		sFlag=getBaseSteps().getCellTableText('grdSettings', 'Allow Adj/Hold Amount in Provider Pay Approvals Screen', pageName.GeneralSettings)
		println sFlag
		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		return sFlag
	}

	public static String getAllowPayElementsDatesoutsideContractDates(String Region,String Location) {

		String sRegion,sLocation,sFlag,fRL,fRAll,fAllL,fAllAll

		//gotoGeneralSettings()
		gotoGeneralSettings_newTab()

		setSettingDescription_ApplicableFlags()

		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		int RowCount=getBaseSteps().getRowTableCounts('grdSettings', pageName.GeneralSettings).toInteger()
		for(int i=2;i<=RowCount;i++) {

			sRegion=getBaseSteps().getCellTableText('grdSettings', i.toString(), 'Region', pageName.GeneralSettings)
			sLocation=getBaseSteps().getCellTableText('grdSettings', i.toString(),'Location', pageName.GeneralSettings)


			/*if(sRegion.equals(Region) && sLocation.equals(Location))
			 {
			 sFlag=getBaseSteps().getCellTableText('grdSettings', i.toString(),'Allow Pay Elements Dates outside Contract Dates', pageName.GeneralSettings)
			 break 
			 }else if(sRegion.equals('All') && sLocation.equals(Location)) {
			 }	
			 */


			switch(sRegion) {
				case Region:
					switch(sLocation) {
						case Location:
						fRL=getBaseSteps().getCellTableText('grdSettings', i.toString(),'Allow Pay Elements Dates outside Contract Dates', pageName.GeneralSettings)
						break
						case 'All':
						fRAll=getBaseSteps().getCellTableText('grdSettings', i.toString(),'Allow Pay Elements Dates outside Contract Dates', pageName.GeneralSettings)
						break

					}
				case 'All':
					switch(sLocation) {
						case Location:
						fAllL=getBaseSteps().getCellTableText('grdSettings', i.toString(),'Allow Pay Elements Dates outside Contract Dates', pageName.GeneralSettings)
						break
						case 'All':
						fAllAll=getBaseSteps().getCellTableText('grdSettings', i.toString(),'Allow Pay Elements Dates outside Contract Dates', pageName.GeneralSettings)
						break
					}
			}







			/*if((sRegion.equals(Region)) || (sRegion.equals('All'))) {
			 if((sLocation.equals(Location)) || (sLocation.equals('All'))) {
			 sFlag=getBaseSteps().getCellTableText('grdSettings', i.toString(),'Allow Pay Elements Dates outside Contract Dates', pageName.GeneralSettings)
			 }
			 }*/
		}


		if(fRL==null) {
			if(fRAll==null) {
				if(fAllL==null) {
					if(fAllAll!=null) {
						sFlag=fAllAll
					}
				}else {
					sFlag=fAllL
				}
			}else {
				sFlag=fRAll
			}
		}else {
			sFlag=fRL
		}



		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()

		return sFlag
	}

	public static String getAllowContractDatesoutsideMasterContractDates(String Region,String Location) {
		String sRegion,sLocation,sFlag='No'
		gotoGeneralSettings()

		setSettingDescription_ApplicableFlags()

		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		int RowCount=getBaseSteps().getRowTableCounts('grdSettings', pageName.GeneralSettings).toInteger()
		for(int i=2;i<=RowCount;i++) {

			sRegion=getBaseSteps().getCellTableText('grdSettings', i.toString(), 'Region', pageName.GeneralSettings)
			sLocation=getBaseSteps().getCellTableText('grdSettings', i.toString(),'Location', pageName.GeneralSettings)

			if((sRegion.equals(Region)) || (sRegion.equals('All'))) {
				if((sLocation.equals(Location)) || (sLocation.equals('All'))) {
					sFlag=getBaseSteps().getCellTableText('grdSettings', i.toString(),'Allow Contract Dates outside Master Contract Dates', pageName.GeneralSettings)
				}
			}
			return sFlag
		}
	}

	public static String getAPOutboundProcessRequired(String Region,String Location) {
		String sRegion,sLocation,sFlag='No'
		gotoGeneralSettings()

		setSettingDescription_ApplicableFlags()

		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		int RowCount=getBaseSteps().getRowTableCounts('grdSettings', pageName.GeneralSettings).toInteger()
		for(int i=2;i<=RowCount;i++) {

			sRegion=getBaseSteps().getCellTableText('grdSettings', i.toString(), 'Region', pageName.GeneralSettings)
			sLocation=getBaseSteps().getCellTableText('grdSettings', i.toString(),'Location', pageName.GeneralSettings)

			if((sRegion.equals(Region)) || (sRegion.equals('All'))) {
				if((sLocation.equals(Location)) || (sLocation.equals('All'))) {
					sFlag=getBaseSteps().getCellTableText('grdSettings', i.toString(),'AP Outbound Process Required', pageName.GeneralSettings)
				}
			}
			return sFlag
		}
	}

	public static String getAllowPaymentsProcessingByProvider(String Region,String Location) {
		String sRegion,sLocation,sFlag='No'
		gotoGeneralSettings()

		setSettingDescription_ApplicableFlags()

		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		int RowCount=getBaseSteps().getRowTableCounts('grdSettings', pageName.GeneralSettings).toInteger()
		for(int i=2;i<=RowCount;i++) {

			sRegion=getBaseSteps().getCellTableText('grdSettings', i.toString(), 'Region', pageName.GeneralSettings)
			sLocation=getBaseSteps().getCellTableText('grdSettings', i.toString(),'Location', pageName.GeneralSettings)

			if((sRegion.equals(Region)) || (sRegion.equals('All'))) {
				if((sLocation.equals(Location)) || (sLocation.equals('All'))) {
					sFlag=getBaseSteps().getCellTableText('grdSettings', i.toString(),'Allow Payments Processing by Provider', pageName.GeneralSettings)
				}
			}
			return sFlag
		}
	}

	public static String getAllowtoraisePayRequestonexceedingThresholdLimit(String Region,String Location) {

		String sRegion,sLocation,sFlag
		gotoGeneralSettings()

		setSettingDescription_ApplicableSettings()

		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		int RowCount=getBaseSteps().getRowTableCounts('grdSettings', pageName.GeneralSettings).toInteger()
		println RowCount
		for(int i=2;i<=RowCount;i++) {

			sRegion=getBaseSteps().getCellTableText('grdSettings', i.toString(), 'Region', pageName.GeneralSettings)
			sLocation=getBaseSteps().getCellTableText('grdSettings', i.toString(),'Location', pageName.GeneralSettings)

			if((sRegion.equals(Region)) || (sRegion.equals('All'))) {
				if((sLocation.equals(Location)) || (sLocation.equals('All'))) {
					sFlag=getBaseSteps().getCellTableText('grdSettings', i.toString(),'Allow to raise Pay Request on exceeding Threshold Limit', pageName.GeneralSettings)
				}
			}
		}
		return sFlag
	}

	public static String getEnableStartandEndDatesforthePaymentsSetting() {

		String sFlag
		//gotoGeneralSettings()
		gotoGeneralSettings_newTab()

		setSettingDescription_ApplicationSettings()

		getBaseSteps().setWindowsSize(60)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)

		sFlag= getBaseSteps().getCellTableText('grdSettings', 'Enable Start and End Dates for the Payments', pageName.GeneralSettings)

		getBaseSteps().setWindowsSize(100)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)

		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		getBaseSteps().clickToControl('imgOrganization', pageName.CMN)

		return sFlag
	}

	public static String getPayApprovalDenialLimit() {

		String sFlag
		//gotoGeneralSettings()
		gotoGeneralSettings_newTab()

		setSettingDescription('Pay Approval Denial Limit')
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)

		sFlag= getBaseSteps().getCellTableText('grdSettings', 'Pay Approval Denial Limit', pageName.GeneralSettings)

		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		getBaseSteps().clickToControl('imgOrganization', pageName.CMN)

		return sFlag
	}

	public static String getProviderGroupHierarchyFlagSetting() {
		String sFlag
		gotoGeneralSettings_newTab()
		setSettingDescription_ApplicationSettings()
		getBaseSteps().setWindowsSize(60)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		sFlag= getBaseSteps().getCellTableText('grdSettings', 'Provider Group Hierarchy', pageName.GeneralSettings)
		getBaseSteps().setWindowsSize(100)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		return sFlag
	}

	public static String getDisplayEncryptedDataFlagSetting() {
		String sFlag
		gotoGeneralSettings_newTab()
		setSettingDescription_ApplicationSettings()
		getBaseSteps().setWindowsSize(60)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		sFlag= getBaseSteps().getCellTableText('grdSettings', 'Display Encrypted Data', pageName.GeneralSettings)
		getBaseSteps().setWindowsSize(100)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		return sFlag
	}

	public static String getAllowsameNPISSNEmailEMRformultipleProviderProfiles() {
		String sFlag
		GeneralSettingsSteps.gotoGeneralSettings_newTab()
		GeneralSettingsSteps.setSettingDescription_ApplicationSettings()
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		sFlag=getBaseSteps().getCellTableText('grdSettings', 'Allow same NPI/SSN/Email/EMR for multiple Provider Profiles', pageName.GeneralSettings)
		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		return sFlag
	}
	
	public static String isEMRFileUploadTypeDisplayed() {
		return getBaseSteps().getTextFromControl('lblEMRFileUploadType', pageName.GeneralSettings)
	}
	
	public static String chkSFTPlbl() {
		return getBaseSteps().getTextFromControl('gridlblSFTP', pageName.GeneralSettings)
	}

	public static void verifyEMRFileTypeEnabled() {
		if(chkSFTPlbl().equals('SFTP')) {
			AssertSteps.verifyActualResult(chkSFTPlbl().equals('SFTP'), chkSFTPlbl()+' Radio button is already selected', chkSFTPlbl()+' Radio Button is not selected', FailureHandling.CONTINUE_ON_FAILURE)
		}else {
			getBaseSteps().clickToControl('editlink', pageName.GeneralSettings)
			getBaseSteps().waitForControlDisplay('radiobtnEMRFileUploadType', pageName.GeneralSettings)
			getBaseSteps().clickToControl('radiobtnEMRFileUploadType', pageName.GeneralSettings)
			getBaseSteps().waitForControlDisplay('btnsave', pageName.GeneralSettings)
			getBaseSteps().clickToControl('btnsave', pageName.GeneralSettings)
			getBaseSteps().waitForControlDisplay('validationSummary', pageName.GeneralSettings)
			String actValidation = getBaseSteps().getTextFromControl('validationSummary', pageName.GeneralSettings)
			String expValidation = HIIConstants.expValidation
			AssertSteps.verifyActualResult(actValidation.equals(expValidation),actValidation+ ' is equal to '+expValidation,actValidation+ ' is not equal to '+expValidation, FailureHandling.CONTINUE_ON_FAILURE)
		}
			
	}
	
	public static String isDisplayOriginalEMRDataDisplayed() {
		return getBaseSteps().getTextFromControl('lblDisplayOriginalEMRData', pageName.GeneralSettings)
	}
	
	public static void ClicknobtninOriginalEMRData() {
		
		getBaseSteps().clickTableLink('grdSettings', 'Edit', pageName.GeneralSettings)
		getBaseSteps().clickToControl('editlink', pageName.GeneralSettings)
		getBaseSteps().clickToControl('RadioBtnOriginalEMRdataNo', pageName.GeneralSettings)
		
	}
	
	public static void VerifyDisplayOrginalEMRDatainGeneralSettings() {
		String actlblName=getBaseSteps().getTextFromControl('grdlblDisplayOriginalEMRData', pageName.GeneralSettings)
		if(actlblName.equals('Yes')) {
			AssertSteps.verifyActualResult(actlblName.equals('Yes'), actlblName+' is selected on Display Original EMR File', actlblName+' is selected on Display Original EMR File', FailureHandling.CONTINUE_ON_FAILURE)
			HeaderPageSteps.verifyNavigationToProviderEMRData()
			ProviderEMRDataPageSteps.VerifyProcessedRadioButtonUI()
			ProviderEMRDataPageSteps.VerifyOriginalRadioButtonUI()
		}
		if (actlblName.equals('No')) {
			AssertSteps.verifyActualResult(actlblName.equals('No'), actlblName+' is selected on Display Original EMR File', actlblName+' is selected on Display Original EMR File', FailureHandling.CONTINUE_ON_FAILURE)
			HeaderPageSteps.verifyNavigationToProviderEMRData()
			ProviderEMRDataPageSteps.VerifyProcessedRadioButton()
			ProviderEMRDataPageSteps.VerifyOriginalRadioButton()
			
		}
		
		
	}
	

	public static getTerminateFlag() {
		
		String sFlag
			GeneralSettingsSteps.gotoGeneralSettings_newTab()
			GeneralSettingsSteps.setSettingDescription_ApplicableFlags()
			getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
			sFlag=getBaseSteps().getCellTableText('grdSettings', 'Pay Quality Bonus If Terminated', pageName.GeneralSettings)
			getBaseSteps().closeWindow()
			getBaseSteps().switchtoMainWindow()
			return sFlag
		
	}
	
}
