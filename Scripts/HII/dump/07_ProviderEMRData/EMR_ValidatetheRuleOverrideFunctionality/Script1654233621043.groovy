import configs.HIIConstants
import core.Browser
import internal.GlobalVariable
import pages.HeaderPageSteps
import pages.LoginPageSteps
import pages.ProviderEMRDataPageSteps


'Step 01: Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02: Login to Application'
LoginPageSteps.Login(GlobalVariable.ORGADMIN_USERNAME, GlobalVariable.ORGADMIN_PWD,HIIConstants.ROLE_OrganizationAdmin)


'Step 03: verify the rule applied successfully'
ProviderEMRDataPageSteps.getRule(CPTCode)





