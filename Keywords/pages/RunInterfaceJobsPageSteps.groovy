package pages

import internal.GlobalVariable
import core.AssertSteps
import core.BaseSteps
import core.ControlFactory
import com.kms.katalon.core.model.FailureHandling
import com.sun.org.apache.bcel.internal.generic.RETURN
import com.sun.xml.internal.ws.policy.AssertionSet
import com.thoughtworks.selenium.webdriven.commands.WaitForCondition
import configs.HIIConstants
import configs.PageLocatorReader as pageName

public class RunInterfaceJobsPageSteps {

	protected static BaseSteps getBaseSteps(){
		return new BaseSteps(new ControlFactory());
	}

	private static final String ddlJobName='ddlJobName'
	private static final String btnStart='btnStart'
	private static String msgSuccess='msgSuccess'
	private static String msgError='msgError'
	private static String smryValidation='smryValidation'



	/**
	 * @param JobName
	 */
	public static void VerifyJobExecutionStatus(String JobName) {
		getBaseSteps().selectByVisibleText(ddlJobName, JobName, pageName.RunInterfaceJobs)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().clickToControl(btnStart, pageName.RunInterfaceJobs)
		getBaseSteps().waitforLoadingComplete('imgLoading',25, pageName.CMN)
		String successMsg, ErrorMsg
		if(getBaseSteps().WebElementDisplayed(msgSuccess, pageName.RunInterfaceJobs)) {

			successMsg=getBaseSteps().getTextFromControl(msgSuccess, pageName.RunInterfaceJobs)
			AssertSteps.verifyActualResult(successMsg.equals(HIIConstants.RIJ_expSuccessMSG), 'Job executed successfully with message: '+successMsg, 'Job execution failed with message:'+successMsg, FailureHandling.CONTINUE_ON_FAILURE)
		}else if(getBaseSteps().WebElementDisplayed(msgError, pageName.RunInterfaceJobs)) {

			ErrorMsg=getBaseSteps().getTextFromControl(msgError, pageName.RunInterfaceJobs)
			AssertSteps.verifyActualResult(ErrorMsg.equals(successMsg), 'Job execution failed with expected Error message: '+ErrorMsg, 'Job execution failed with unexpected Error message:'+ErrorMsg, FailureHandling.CONTINUE_ON_FAILURE)
			//	AssertSteps.verifyActualResult(ErrorMsg.equals(HIIConstants.RIJ_expErrorMSG), 'Job execution failed with expected Error message: '+ErrorMsg, 'Job execution failed with unexpected Error message:'+ErrorMsg, FailureHandling.STOP_ON_FAILURE)

		}
	}

	public static void selectJob(String JobName) {
		getBaseSteps().selectByVisibleText(ddlJobName, JobName, pageName.RunInterfaceJobs)
	}

	public static void clickStart() {

		getBaseSteps().clickToControl(btnStart, pageName.RunInterfaceJobs)
	}


	public static void verifyJobExecutionStatusFail (String JobName) {
		selectJob(JobName)
		getBaseSteps().waitforLoadingComplete('imgLoading', 30, pageName.CMN)
		clickStart()

		getBaseSteps().WebElementDisplayed('msgError', pageName.RunInterfaceJobs)
		getBaseSteps().waitforLoadingComplete('imgLoading', 30, pageName.CMN)
		String ErrorMsg
		ErrorMsg=getBaseSteps().getTextFromControl('msgError', pageName.RunInterfaceJobs)
		AssertSteps.verifyActualResult(ErrorMsg.equals(HIIConstants.JobExecutedFailureMessage), 'Job execution failed with expected Error message: '+ErrorMsg, 'Job execution failed with unexpected Error message:'+ErrorMsg, FailureHandling.CONTINUE_ON_FAILURE)
	}
	
	
	public static void VerifyJobExecutionStatus() {
		getBaseSteps().selectByVisibleText(ddlJobName, 'EMR Process', pageName.RunInterfaceJobs)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().clickToControl(btnStart, pageName.RunInterfaceJobs)
		getBaseSteps().waitforLoadingComplete('imgLoading',25, pageName.CMN)
		String successMsg, ErrorMsg
		if(getBaseSteps().WebElementDisplayed(msgSuccess, pageName.RunInterfaceJobs)) {

			successMsg=getBaseSteps().getTextFromControl(msgSuccess, pageName.RunInterfaceJobs)
			AssertSteps.verifyActualResult(successMsg.equals(HIIConstants.RIJ_expSuccessMSG), 'Job executed successfully with message: '+successMsg, 'Job execution failed with message:'+successMsg, FailureHandling.CONTINUE_ON_FAILURE)
		}else if(getBaseSteps().WebElementDisplayed(msgError, pageName.RunInterfaceJobs)) {

			ErrorMsg=getBaseSteps().getTextFromControl(msgError, pageName.RunInterfaceJobs)
			AssertSteps.verifyActualResult(ErrorMsg.equals(successMsg), 'Job execution failed with expected Error message: '+ErrorMsg, 'Job execution failed with unexpected Error message:'+ErrorMsg, FailureHandling.CONTINUE_ON_FAILURE)
			//	AssertSteps.verifyActualResult(ErrorMsg.equals(HIIConstants.RIJ_expErrorMSG), 'Job execution failed with expected Error message: '+ErrorMsg, 'Job execution failed with unexpected Error message:'+ErrorMsg, FailureHandling.STOP_ON_FAILURE)

		}
	}
	
}

