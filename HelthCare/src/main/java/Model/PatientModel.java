package Model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PatientModel {

	private int PatientID;
	private String name;
	private String age;
	private String email;
	private String address;
	private String phoneNo;
	private int Stock_id;

	public PatientModel() {
		super();
	}

	public PatientModel(int patientID, String name, String age, String email, String address, String phoneNo,
			int stock_id) {
		super();
		PatientID = patientID;
		this.name = name;
		this.age = age;
		this.email = email;
		this.address = address;
		this.phoneNo = phoneNo;
		Stock_id = stock_id;
	}

	public int getPatientID() {
		return PatientID;
	}

	public void setPatientID(int patientID) {
		PatientID = patientID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getStock_id() {
		return Stock_id;
	}

	public void setStock_id(int stock_id) {
		Stock_id = stock_id;
	}

	@Override
	public String toString() {
		return "PatientModel [PatientID=" + PatientID + ", name=" + name + ", age=" + age + ", email=" + email
				+ ", address=" + address + ", phoneNo=" + phoneNo + "]";
	}

}
