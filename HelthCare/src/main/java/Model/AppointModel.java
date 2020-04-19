package Model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AppointModel {

	private int appoint_id;
	private int doc_id;
	private int PatientID;
	private String date;
	private String time;

	public AppointModel() {
		super();
	}

	public AppointModel(int appoint_id, int doc_id, int patientID, String date, String time) {
		super();
		this.appoint_id = appoint_id;
		this.doc_id = doc_id;
		PatientID = patientID;
		this.date = date;
		this.time = time;
	}

	public int getAppoint_id() {
		return appoint_id;
	}

	public void setAppoint_id(int appoint_id) {
		this.appoint_id = appoint_id;
	}

	public int getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(int doc_id) {
		this.doc_id = doc_id;
	}

	public int getPatientID() {
		return PatientID;
	}

	public void setPatientID(int patientID) {
		PatientID = patientID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "AppointModel [appoint_id=" + appoint_id + ", doc_id=" + doc_id + ", PatientID=" + PatientID + ", date="
				+ date + ", time=" + time + "]";
	}

}
