import internal.GlobalVariable as GlobalVariable
import configs.HIIConstants as HIIConstants
import core.Browser as Browser
import pages.LoginPageSteps as LoginPageSteps
import pages.ProviderPayRequestSteps as ProviderPayRequestSteps

'Step 1: Launch Application'
Browser.start(GlobalVariable.URL)

'Step 2: Login with Compensation Administrator'
LoginPageSteps.Login(GlobalVariable.ORGADMIN_USER, GlobalVariable.PASSWORD)

'Step 3: get expected Termination Date'
String expectedTerminationDate = null

expectedTerminationDate = ProviderPayRequestSteps.getExpectedTerminationDate(ProviderName)

'Step 4: Go to Provider Pay Request'
ProviderPayRequestSteps.gotoProviderPayRequest()

'Step 5: set Provider Name'
ProviderPayRequestSteps.setProviderName(ProviderName)

'Step 6: verify Provider Termination Date'
ProviderPayRequestSteps.verifyProviderTerminationDate(expectedTerminationDate)