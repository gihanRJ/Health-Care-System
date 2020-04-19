package Controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.PatientModel;

import DBConnector.Connector;

public class PatientController {

	Connector con = Connector.getInstance();

	private PatientController() {
	}

	private static final PatientController obj = new PatientController();

	public static PatientController getInstance() {
		return obj;
	}

	public void save(PatientModel obj) throws Exception {
		con.getConnection();
		con.aud("INSERT INTO patient(name,age,email,address,phoneNo,Stock_id) VALUES ('" + obj.getName() + "', " + "'"
				+ obj.getAge() + "', '" + obj.getEmail() + "', '" + obj.getAddress() + "', '" + obj.getPhoneNo() + "','"
				+ obj.getStock_id() + "')");
	}

	public void update(PatientModel obj) throws Exception {
		con.getConnection();
		con.aud("UPDATE patient SET name = '" + obj.getName() + "', age = '" + obj.getAge() + "', email = '"
				+ obj.getEmail() + "'," + "address = '" + obj.getAddress() + "', phoneNo='" + obj.getPhoneNo()
				+ "', Stock_id='" + obj.getStock_id() + "'" + "WHERE PatientID='" + obj.getPatientID() + "'");
	}

	public void delete(PatientModel obj) throws Exception {
		con.getConnection();
		con.aud("DELETE FROM patient WHERE PatientID='" + obj.getPatientID() + "'");
	}

	public List<PatientModel> searchAll() throws Exception {
		List<PatientModel> list = new ArrayList<PatientModel>();
		con.getConnection();
		ResultSet rset = con.srh("SELECT * FROM patient");
		while (rset.next()) {
			PatientModel obj = new PatientModel();
			obj.setPatientID(rset.getInt(1));
			obj.setName(rset.getString(2));
			obj.setAge(rset.getString(3));
			obj.setEmail(rset.getString(4));
			obj.setAddress(rset.getString(5));
			obj.setPhoneNo(rset.getString(6));
			obj.setStock_id(rset.getInt(7));

			list.add(obj);
		}
		return list;
	}

	public PatientModel search(int PatientID) throws Exception {
		con.getConnection();
		PatientModel obj = null;
		ResultSet rset = con.srh("SELECT * FROM patient WHERE PatientID='" + PatientID + "'");
		while (rset.next()) {
			obj = new PatientModel();
			obj.setPatientID(rset.getInt(1));
			obj.setName(rset.getString(2));
			obj.setAge(rset.getString(3));
			obj.setEmail(rset.getString(4));
			obj.setAddress(rset.getString(5));
			obj.setPhoneNo(rset.getString(6));
			obj.setStock_id(rset.getInt(7));

		}
		return obj;
	}
	public boolean chekPatientIdAvailability(int PatientID) throws Exception {
		con.getConnection();
		boolean idAvaliabillity = true;
		ResultSet rset = con.srh("SELECT * FROM patient WHERE PatientID='" + PatientID + "'");
		while (rset.next()) {
			idAvaliabillity = false;
		}
		return idAvaliabillity;
	}

}
