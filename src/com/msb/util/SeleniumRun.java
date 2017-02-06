package com.msb.util;

import java.io.IOException;
import java.util.Date;

import org.junit.runner.JUnitCore;
 
import com.msb.account.*;
import com.msb.admin.dashboard.DashboardProject;
import com.msb.dashboard.RequirementDashboard;
import com.msb.home.EditProfile;
import com.msb.home.TaskDetails;
import com.msb.home.Timesheet;
import com.msb.login.*;
import com.msb.utilities.*;


import org.junit.runner.Result;

public class SeleniumRun {
	 
	public static void main(String args[]) throws IOException {
		try {
			MSBUtils.writeLog("Start Time : " + new Date());
			JUnitCore junit = new JUnitCore();
 

			junit.run(AccountSearch.class);//done
		    //junit.run(AddAccount.class);//done
//			junit.run(EditAccount.class);//done	
//			junit.run(EditProfile.class); //done 
//			junit.run(AssignAccount.class);//done
//			junit.run(RequirementDashboard.class);//done
//			junit.run(DashboardProject.class);//done
//			junit.run(ResetUserPassword.class);	//done
//			junit.run(ChangeMyPassword.class);//done
//			junit.run(ActionAuthorization.class); //done
//			junit.run(HomeRedirect.class);//done
//			junit.run(AccountUpload.class);//done
			
//			junit.run(ContactUpload.class);	//done
//			junit.run(ContactDetails.class);//done
//			junit.run(AttachmentDetails.class);//done
//			junit.run(LocationDetails.class);
			 //done 
//	        junit.run(Timesheet.class); //done
//			junit.run(TaskDetails.class); //done
//			junit.run(CostCenter.class);//done
//			junit.run(EmployeeGrouping.class);//done
//			junit.run(Budget.class);     //done
//			junit.run(SearchRequirement.class);//done
//			junit.run(AddRequirement.class);//done
//			junit.run(EditRequirement.class);//done
//			junit.run(TechReview.class);//done
//			junit.run(AddConsultant.class);
//			junit.run(EditConsultant.class);
//			junit.run(Invoice.class);
//			junit.run(Contract.class);
//			junit.run(ProjectDetails.class); //done
//			junit.run(VendorRequirement.class);//done
//			junit.run(Question.class);         //issue
//			junit.run(UploadQuestion.class);   // issue
//			junit.run(AdminLogin.class);
//			junit.run(CustomerAdmin.class);	
//			junit.run(CustomerEmployee.class);
//			junit.run(CustomerTeamLead.class);
//			junit.run(Director.class);
//			junit.run(Manager.class);
//			junit.run(ProjectManager.class);
//			junit.run(VendorAdmin.class);
//			junit.run(VendorEmployee.class);
//			junit.run(VendorTeamLead.class);
//			junit.run(LoggerSearch.class);	
//			junit.run(CSRSearch.class); //done
			
			MSBUtils.writeLog("End Time : " + new Date());
			MSBUtils.displayTableReport();
			MSBUtils.browserClose();

			// MSBUtils.sendMail();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
