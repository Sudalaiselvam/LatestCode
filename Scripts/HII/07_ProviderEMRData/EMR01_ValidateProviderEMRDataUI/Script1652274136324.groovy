import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import org.junit.After as After
import configs.HIIConstants as HIIConstants
import pages.LoginPageSteps as LoginPageSteps
import pages.HeaderPageSteps as HeaderPageSteps
import pages.ProviderEMRDataPageSteps as ProviderEMRDataPageSteps

'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.ORGADMIN_USERNAME, GlobalVariable.ORGADMIN_PWD, HIIConstants.ROLE_OrganizationAdmin)

'Step 03: Navigate to Provider EMR Data'
HeaderPageSteps.verifyNavigationToProviderEMRData()

//ProviderEMRDataPageSteps.selectRegion(Region)
'Step 04: verify Region DropDown '
ProviderEMRDataPageSteps.VerifyRegionDropDownUI()

'Step 05: Verify CostCenter DropDown'
ProviderEMRDataPageSteps.VerifyCostCenterDropDownUI()

'Step 06: Verify Processed RadioButton'
ProviderEMRDataPageSteps.VerifyProcessedRadioButtonUI()

'Step 07: Verify Original RadioButton'
ProviderEMRDataPageSteps.VerifyOriginalRadioButtonUI()

'Step 08: Verify Year DropDown'
ProviderEMRDataPageSteps.VerifyYearDropDownUI()

'Step 09: Verify Month DropDown'
ProviderEMRDataPageSteps.VerifyMonthDropDownUI()

'Step 10: Verify ProviderName TextBox'
ProviderEMRDataPageSteps.VerifyProviderNameTextBoxUI()

'Step 11: Verify IncludeAdjustments CheckBox'
ProviderEMRDataPageSteps.VerifyIncludeAdjustmentsCheckBoxUI()

'Step 12: Verify Go Button'
ProviderEMRDataPageSteps.VerifyGoButtonUI()

'Step 13: verify Clear Button'
ProviderEMRDataPageSteps.VerifyClearButtonUI()

'Step 14: Verify SelectMissingType DropDown'
ProviderEMRDataPageSteps.VerifySelectMissingTypeDropDownUI()

'Step 15: Verify Download Button'
ProviderEMRDataPageSteps.VerifyDownloadButtonUI()

'Step 16: Verify ExportCalculationReport Button'
ProviderEMRDataPageSteps.VerifyExportCalculationreportButtonUI()

'Step 17: Verify Export Excel Image'
ProviderEMRDataPageSteps.VerifyExportExcelImageUI()

'Step 18: Verify UniversalSearch TextBox'
ProviderEMRDataPageSteps.VerifyUniversalSearchTextBoxUI()

'Step 19: Verify Search Button'
ProviderEMRDataPageSteps.VerifySearchButtonUI()

