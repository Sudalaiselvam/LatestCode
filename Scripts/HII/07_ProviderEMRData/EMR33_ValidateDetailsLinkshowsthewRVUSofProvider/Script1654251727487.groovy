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

'Step 04: Verify the wRUVS details shown'
ProviderEMRDataPageSteps.verifywRVUSDetails(Region)

