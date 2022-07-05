
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

'Step 04: Verfiy Pagination using pagenumber dropdown'
ProviderEMRDataPageSteps.selectpageNumber(Region)

'Step 05: Verify pagination using Previous, Next, First and Last page navigation arrows'
ProviderEMRDataPageSteps.selectpaginationArrows(Region)





