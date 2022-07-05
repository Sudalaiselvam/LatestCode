import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import configs.HIIConstants as HIIConstants
import pages.LoginPageSteps as LoginPageSteps
import pages.ProviderPayRequestSteps as ProviderPayRequestSteps
import java.text.SimpleDateFormat as SimpleDateFormat
import java.time.temporal.ChronoUnit as ChronoUnit
import java.time.LocalDate as LocalDate

'Step 1: Launch Application'
Browser.start(GlobalVariable.URL)

'Step 2: Login with Compensation Administartor'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

'Step 3: Get Request Date validity'
boolean blnRequestDateValidity
blnRequestDateValidity=ProviderPayRequestSteps.getSingleRequestDateValidity(ProviderName,RequestDate)

'Step 4: Go to Provider Pay Request'
ProviderPayRequestSteps.gotoProviderPayRequest()

'Step 5: set Provider Name'
ProviderPayRequestSteps.setProviderName(ProviderName)

'Step 6: verify Request Date fields validations'
ProviderPayRequestSteps.verifySingleRequestDatefunctionality(RequestDate, blnRequestDateValidity)

