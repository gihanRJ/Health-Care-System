package Model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DoctorModel {

	private int doc_id;
	private String fname;
	private String DOB;
	private String NIC;
	private String e_mail;
	private String contact_num;
	private String Gender;
	private String specialization;

	public DoctorModel() {
		super();
	}

	public DoctorModel(int doc_id, String fname, String dOB, String nIC, String e_mail, String contact_num,
			String gender, String specialization) {
		super();
		this.doc_id = doc_id;
		this.fname = fname;
		DOB = dOB;
		NIC = nIC;
		this.e_mail = e_mail;
		this.contact_num = contact_num;
		Gender = gender;
		this.specialization = specialization;
	}

	public int getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(int doc_id) {
		this.doc_id = doc_id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getNIC() {
		return NIC;
	}

	public void setNIC(String nIC) {
		NIC = nIC;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public String getContact_num() {
		return contact_num;
	}

	public void setContact_num(String contact_num) {
		this.contact_num = contact_num;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	@Override
	public String toString() {
		return "DoctorModel [doc_id=" + doc_id + ", fname=" + fname + ", DOB=" + DOB + ", NIC=" + NIC + ", e_mail="
				+ e_mail + ", contact_num=" + contact_num + ", Gender=" + Gender + ", specialization=" + specialization
				+ "]";
	}

}
