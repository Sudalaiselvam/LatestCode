import core.Browser
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.HeaderPageSteps
import pages.ReportsPageSteps
import utils.ExcelUtilities


'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.USERNAME, GlobalVariable.PASSWORD, GlobalVariable.ROLE)


//ReportsPageSteps.validateDiscrepancyReport()



'Step 03 : '
//Completed
ReportsPageSteps.validateUserEventLogReport()

//Completed
ReportsPageSteps.validateActivityLogReport()

//Completed
ReportsPageSteps.validateMessageHistoryReport()

//Completed
ReportsPageSteps.validateProviderListReport()

//Completed
//ReportsPageSteps.validatePayElementsReport()

//Completed-erred in pipeline on excel row verification
ReportsPageSteps.validateCPTSummaryReport()

//Completed
ReportsPageSteps.validateProviderwRVUstRVUsReport()

//Completed 
ReportsPageSteps.validateProductivityIncentiveReport()

//Completed
ReportsPageSteps.validateMonthEndProductivityReport()

//No report is generate for this screen
ReportsPageSteps.validateProductivityGroupReport()

//Completed- No menu option in website
//ReportsPageSteps.validateProductivityIncentiveFacilityWiseReport()

//ReportsPageSteps.validateDiscrepancyReport()

//Completed
ReportsPageSteps.validatePayRequestStatusReport()

//Completed
ReportsPageSteps.validateYTDCompensationReport()

ReportsPageSteps.validateProviderCompensationStatementReport()

ReportsPageSteps.validateCompensationSummaryReport()

//Completed
ReportsPageSteps.validatePTOLTSHoursReport()

//Completed
ReportsPageSteps.validateProviderSchedulingReport()

//commenting it out since it has issues. After Kumar's fix, will push it back
//ReportsPageSteps.validateReasonablenessReport()

//Completed
ReportsPageSteps.validateFFSCompensationReport()

//Completed
ReportsPageSteps.validateNonFFSCompensationReport()

//Completed
ReportsPageSteps.validatePTORateReport()

//Completed
ReportsPageSteps.validateProviderSchedulingStatsReport()

//Completed
ReportsPageSteps.validateCMEandPTOATOHoursReport()

//Completed
ReportsPageSteps.validateSummaryofHoursandShiftsReport()
