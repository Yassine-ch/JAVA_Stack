package com.yassine.java;

import java.sql.Date;
import java.util.ArrayList;

public class Physician extends User implements HIPAACompliantUser{
	private ArrayList<String> patientNotes;
	
	public Physician(Integer id) {
		this.id = id;
		// TODO Auto-generated constructor stub
		this.patientNotes = new ArrayList<String>();
	}
	
	public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

	@Override
	public boolean assignPin(int pin) {
		// TODO Auto-generated method stub
		String strPin=String.valueOf(pin);
		if (strPin.length() < 4){
			return false;
		}
		super.pin = pin;
		return true;
		
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		// TODO Auto-generated method stub
		if( this.id == confirmedAuthID) {
			return true;
		}
		return false;
	}

}