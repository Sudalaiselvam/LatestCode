package pages

import core.AssertSteps
import core.BaseSteps
import core.ControlFactory
import testDataTypes.ContractData

import com.kms.katalon.core.model.FailureHandling
import com.sun.org.apache.bcel.internal.generic.RETURN
import com.sun.xml.internal.ws.policy.AssertionSet
import com.thoughtworks.selenium.webdriven.commands.WaitForCondition

import configs.HIIConstants
import configs.PageLocatorReader as pageName

import internal.GlobalVariable

/**
 * @author Ponsukumar
 *
 */

public class WRVUSOverridePageSteps {
	
	
	protected static BaseSteps getBaseSteps(){
		return new BaseSteps(new ControlFactory());
	}

	private static final String txtUniversalSearch='txtUniversalSearch'
	private static final String linkEditCptModifier='linkEditCptModifier'
	private static final String txtAdjustment='txtAdjustment'
	private static final String txtCharges='txtCharges'
	private static final String btnSearch='btnSearch'
	private static boolean blnRule=false
	


	/**
	 * @param CPT Code
	 */
	
	public static void editWRVUS() {
		getBaseSteps().waitForControlDisplay('linkEditCptModifier',10,pageName.WRVUSOverride)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForControlClickable('linkEditCptModifier', pageName.ManageProviderContract)
		getBaseSteps().clickToControl('linkEditCptModifier',pageName.ManageProviderContract)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForProgressBarDisappear()
	}
	
	public static getRule (String CPTCode) {

		getBaseSteps().gotoCascadingMenu('mnuAdmin', 'mnuCPT', 'mnuwRVUstRVUsOverride', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)		
		getBaseSteps().setTextToControl('txtUniversalSearch',CPTCode, pageName.WRVUSOverride)
		getBaseSteps().clickToControl('btnSearch', pageName.WRVUSOverride)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		
		if (blnRule)
		
			getBaseSteps().getTextFromControl('txtAdjustment', pageName.WRVUSOverride)
			getBaseSteps().getTextFromControl('txtCharges', pageName.WRVUSOverride)
			println(txtAdjustment)	
			println(txtCharges)	
			
		
		
	}
		

}