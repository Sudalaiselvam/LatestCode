import core.Browser
import configs.HIIConstants
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.ManageProviderContractSteps
import pages.ProviderSetupSteps
import pages.GeneralSettingsSteps
import pages.CompModelPayElementSettingsPageSteps
import pages.ModelWiseProfileTypeSettingsPageSteps
import pages.MiscellaneousProfileSettingsPageSteps

'Step 01 : Launch Application '
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

'Step 03 : Get Provider Details from Provider Setup'
HashMap<String,String> ProviderDetails=new HashMap<String,String>()
ProviderDetails=ProviderSetupSteps.getProviderDetails(Provider)

'Step 04 : Go to Manage Provider Contract'
ManageProviderContractSteps.gotoManageProviderContract()

'Step 05 : Click ADD CONTRACT'
ManageProviderContractSteps.clickADDCONTRACT()

'Step 06 : Enter Provider'
ManageProviderContractSteps.setProvider(Provider)

'Step 07 : Enter Master Contract Start Date'
ManageProviderContractSteps.setMasterContractStartDate(MasterContractStartDate)

'Step 08 : Enter Master Contract End Date'
ManageProviderContractSteps.setMasterContractEndDate(MasterContractEndDate)

'Step 09 : Click Add New Contract'
ManageProviderContractSteps.clickAddNewContract()

'Step 10 : Select Compensation Model'
ManageProviderContractSteps.selectCompModelPopup_MasterCompensationModel(MasterCompensationModel)

'Step 11 : Click Add Button'
ManageProviderContractSteps.clickCompModelPopup_AddButton()

'Step 12 : Select All Display Settings'
ManageProviderContractSteps.selectAllDisplaySettings()

'Step 13 : Verify Display Setting Profiles'
ManageProviderContractSteps.verifyDisplaySettingsDefaultProfiles(ProviderDetails)



