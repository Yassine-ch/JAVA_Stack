package com.yassine.java;


	import java.util.ArrayList;
	import java.util.Date;

	public class AdminUser extends User implements HIPAACompliantAdmin, HIPAACompliantUser{

	    private Integer employeeID;
	    private String role;
	    private ArrayList<String> securityIncidents;

		public AdminUser(Integer id) {
			// TODO Auto-generated constructor stub
			this.employeeID = id;
		}
		
		public AdminUser(Integer id, String role) {
			// TODO Auto-generated constructor stub
			this.employeeID = id;
			this.role=role;
			this.securityIncidents = new ArrayList<String>();
		}
		

		@Override
		public boolean assignPin(int pin) {
			// TODO Auto-generated method stub
			String strPin=String.valueOf(pin);
			if (strPin.length() < 6){
				return false;
			}
			super.pin = pin;
			return true;
		}

		@Override
		public boolean accessAuthorized(Integer confirmedAuthID) {
			// TODO Auto-generated method stub
			if(this.id == confirmedAuthID) {
				return true;
			}
			this.authIncident();
			return false;
		}
		
		public void newIncident(String notes) {
	        String report = String.format(
	            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
	            new Date(), this.id, notes
	        );
	        securityIncidents.add(report);
	    }
	    public void authIncident() {
	        String report = String.format(
	            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
	            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
	        );
	        securityIncidents.add(report);
	    }

		@Override
		public ArrayList<String> reportSecurityIncidents() {
			// TODO Auto-generated method stub
			return securityIncidents;
		}

		@Override
		public void printSecurityIncidents() {
			// TODO Auto-generated method stub
			HIPAACompliantAdmin.super.printSecurityIncidents();
		}

		@Override
		public boolean adminQATest(ArrayList<String> expectedIncidents) {
			// TODO Auto-generated method stub
			return HIPAACompliantAdmin.super.adminQATest(expectedIncidents);
		}
		
		public Integer getEmployeeID() {
			return employeeID;
		}

		public void setEmployeeID(Integer employeeID) {
			this.employeeID = employeeID;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

	}