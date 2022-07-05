package pages

import core.BaseSteps
import core.ControlFactory
import configs.PageLocatorReader as pageName
import com.kms.katalon.core.model.FailureHandling
import utils.Utilities
import utils.ExcelUtilities
import configs.HIIConstants
import core.AssertSteps
import  java.time.Instant
import java.time.Duration
import core.Logger

/**
 * @author Ponsukumar
 *
 */
public class MessageHistoryPageSteps {

	protected static BaseSteps getBaseSteps(){
		return new BaseSteps(new ControlFactory());
	}

	private static final String btnGetDetails='btnGetDetails'
	private static final String grdEmail='grdEmail'
	private static final String grdMessageHistory='grdMessageHistory'
	private static final String grdframe='//*[@id="frameset"]'

	public static void clickGetDetails() {

		getBaseSteps().clickToControl(btnGetDetails, pageName.MessageHistory)
	}

	public static String verifyIsEmailReceived(String To, String Subject, String SentOn, String Message) {

		clickGetDetails()

		String grdTo, grdSubject, grdMessage, grdSentOn
		String AssertMsg='Email Message'

		if(getBaseSteps().WebElementDisplayed(grdMessageHistory, pageName.MessageHistory)) {

			getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)

			String noofMails=getBaseSteps().getRowTableCounts(grdMessageHistory, pageName.MessageHistory)
			for(int i=1;i<Integer.parseInt(noofMails);i++) {
				grdTo=getBaseSteps().getCellTableText(grdMessageHistory, (i+1).toString(), 'To', pageName.MessageHistory)
				grdSubject=getBaseSteps().getCellTableText(grdMessageHistory, (i+1).toString(), 'Subject', pageName.MessageHistory)
				grdSentOn=getBaseSteps().getCellTableText(grdMessageHistory, (i+1).toString(), 'Sent On', pageName.MessageHistory)

				if(grdTo.contains(To) && grdSubject.contains(Subject) && grdSentOn.contains(SentOn)) {
					//grdMessage = getBaseSteps().getCellTableText(grdEmail, 'Message', pageName.MessageHistory)
					grdMessage=getBaseSteps().getCellTableText(grdMessageHistory, (i+1).toString(), 'Message', pageName.MessageHistory)
					if(grdMessage.contains(Message)) {
						println('Message is displayed in '+i+' Row')
						AssertSteps.verifyActualResult(grdMessage.contains(Message), ' Email received :'+grdMessage,' Email not received', FailureHandling.CONTINUE_ON_FAILURE)
						break
					}else {
						println('Message not displayed')
					}
				}
			}
		}else {
			//println('Grid not displayed')
		}
	}
}






