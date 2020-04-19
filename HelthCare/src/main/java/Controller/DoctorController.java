package Controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.DoctorModel;

import DBConnector.Connector;

public class DoctorController {
	Connector con = Connector.getInstance();

	private DoctorController() {
	}

	private static final DoctorController obj = new DoctorController();

	public static DoctorController getInstance() {
		return obj;
	}

	public void save(DoctorModel obj) throws Exception {
		con.getConnection();
		con.aud("INSERT INTO doctor(fname,DOB,NIC,e_mail,contact_num,Gender,specialization) VALUES ('" + obj.getFname()
				+ "', " + "'" + obj.getDOB() + "', '" + obj.getNIC() + "', '" + obj.getE_mail() + "', '"
				+ obj.getContact_num() + "', " + "'" + obj.getGender() + "', '" + obj.getSpecialization() + "')");
	}

	public void update(DoctorModel obj) throws Exception {
		con.getConnection();
		con.aud("UPDATE doctor SET fname = '" + obj.getFname() + "', DOB = '" + obj.getDOB() + "', NIC = '"
				+ obj.getNIC() + "'," + "e_mail = '" + obj.getE_mail() + "', contact_num='" + obj.getContact_num()
				+ "', Gender='" + obj.getGender() + "', specialization = '" + obj.getSpecialization() + "' "
				+ "WHERE doc_id='" + obj.getDoc_id() + "'");
	}

	public void delete(DoctorModel obj) throws Exception {
		con.getConnection();
		con.aud("DELETE FROM doctor WHERE doc_id='" + obj.getDoc_id() + "'");
	}

	public List<DoctorModel> searchAll() throws Exception {
		List<DoctorModel> list = new ArrayList<DoctorModel>();
		con.getConnection();
		ResultSet rset = con.srh("SELECT * FROM doctor");
		while (rset.next()) {
			DoctorModel obj = new DoctorModel();
			obj.setDoc_id(rset.getInt(1));
			obj.setFname(rset.getString(2));
			obj.setDOB(rset.getString(3));
			obj.setNIC(rset.getString(4));
			obj.setE_mail(rset.getString(5));
			obj.setContact_num(rset.getString(6));
			obj.setGender(rset.getString(7));
			obj.setSpecialization(rset.getString(8));

			list.add(obj);
		}
		return list;
	}

	public DoctorModel search(int doc_id) throws Exception {
		con.getConnection();
		DoctorModel obj = null;
		ResultSet rset = con.srh("SELECT * FROM doctor WHERE doc_id='" + doc_id + "'");
		while (rset.next()) {
			obj = new DoctorModel();
			obj.setDoc_id(rset.getInt(1));
			obj.setFname(rset.getString(2));
			obj.setDOB(rset.getString(3));
			obj.setNIC(rset.getString(4));
			obj.setE_mail(rset.getString(5));
			obj.setContact_num(rset.getString(6));
			obj.setGender(rset.getString(7));
			obj.setSpecialization(rset.getString(8));

		}
		return obj;
	}
}
