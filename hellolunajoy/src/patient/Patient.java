package src.patient;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import src.page_objects.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import src.common.baseTest;

public class Patient extends baseTest {
	@Test
	public void Register() throws InterruptedException, IOException {
		String firstName = "Rajesh";
		String lastName = "Kumar";
		String dob = "01/02/2001";
		String randomNumberForMobile = new SimpleDateFormat("HHmmss").format(new Date());
		String mobileNumber = "9654" + randomNumberForMobile;
		String randomNumberForEmail = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String email = "testuser" + randomNumberForEmail + "@gmail.com";
		String address = "Creek St, Ketchikan, AK 99901, USA";
		String treatment = "Therapy";
		String insurance = "Beacon";
		String gender = "Male";
		String policyNumber = "12345";
		String groupPolicyNumber = "54321";
		String insuranceCardImageFront = "card.jpeg";
		String insuranceCardImageBack = "card.jpeg";
		String confirmHeading = "Eligibility Status";
		String inprogressHeading = "Insurance Check In Progress";
		String inprogressMessage = "Thank you for your insurance information, we will let you know your insurance eligibility status within 48 business hours.";

		PatientInfo patientInfo = new PatientInfo(driver);

		//Patient Info
		patientInfo.enterFirstName(firstName);
		patientInfo.enterLastName(lastName);
		patientInfo.enterDOB(dob);
		patientInfo.enterMobileNumber(mobileNumber);
		patientInfo.enterEmail(email);
		patientInfo.clickNextButton();

		//Insurance Info
		InsuranceInfo insuranceInfo = new InsuranceInfo(driver);
		insuranceInfo.enterAddress(address);
		insuranceInfo.enterTreatment(treatment);
		insuranceInfo.enterInsurance(insurance);
		insuranceInfo.selectPrimaryPolicyHolder();
		insuranceInfo.selectGender(gender);
		insuranceInfo.enterPolicyNumber(policyNumber);
		insuranceInfo.enterGroupPolicyNumber(groupPolicyNumber);
		insuranceInfo.selectInsuranceCardFront(insuranceCardImageFront);
		insuranceInfo.selectInsuranceCardBack(insuranceCardImageBack);
		insuranceInfo.selectTermsAgreement();
		insuranceInfo.clickNextButton();
		 
		//Confirmation Info
	    ConfirmationInfo confirmationInfo = new ConfirmationInfo(driver);
		Assert.assertEquals(confirmationInfo.getHeading(), confirmHeading);
		src.common.Util.logInfo("Verify confirmation page heading");
		Assert.assertEquals(confirmationInfo.getInProgressHeading(), inprogressHeading);
		src.common.Util.logInfo("Verify confirmation page in-progress heading");
		Assert.assertEquals(confirmationInfo.getInProgressMessage(), inprogressMessage);
		src.common.Util.logInfo("Verify confirmation page in-progress message");
	}
}
