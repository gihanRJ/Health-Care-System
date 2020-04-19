package Controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DBConnector.Connector;
import Model.AppointModel;

public class AppointController {

	Connector con = Connector.getInstance();

	private AppointController() {

	}

	private static final AppointController obj = new AppointController();

	public static AppointController getInstance() {
		return obj;
	}

	public void save(AppointModel obj) throws Exception {
		con.getConnection();
		con.aud("INSERT INTO appoint(doc_id,PatientID,date,time) VALUES ('" + obj.getDoc_id() + "', " + "'"
				+ obj.getPatientID() + "', '" + obj.getDate() + "', '" + obj.getTime() + "')");
	}

	public void update(AppointModel obj) throws Exception {
		con.getConnection();
		con.aud("UPDATE appoint SET doc_id = '" + obj.getDoc_id() + "', PatientID = '" + obj.getPatientID()
				+ "', date = '" + obj.getDate() + "'," + "time = '" + obj.getTime() + "' " + "WHERE appoint_id='"
				+ obj.getAppoint_id() + "'");
	}

	public void delete(AppointModel obj) throws Exception {
		con.getConnection();
		con.aud("DELETE FROM appoint WHERE appoint_id='" + obj.getAppoint_id() + "'");
	}

	public List<AppointModel> searchAll() throws Exception {
		List<AppointModel> list = new ArrayList<AppointModel>();
		con.getConnection();
		ResultSet rset = con.srh("SELECT * FROM appoint");
		while (rset.next()) {
			AppointModel obj = new AppointModel();
			obj.setAppoint_id(rset.getInt(1));
			obj.setDoc_id(rset.getInt(2));
			obj.setPatientID(rset.getInt(3));
			obj.setDate(rset.getString(4));
			obj.setTime(rset.getString(5));

			list.add(obj);
		}
		return list;
	}

	public AppointModel search(int appoint_id) throws Exception {
		con.getConnection();
		AppointModel obj = null;
		ResultSet rset = con.srh("SELECT * FROM appoint WHERE Stock_id='" + appoint_id + "'");
		while (rset.next()) {
			obj = new AppointModel();
			obj.setAppoint_id(rset.getInt(1));
			obj.setDoc_id(rset.getInt(2));
			obj.setPatientID(rset.getInt(3));
			obj.setDate(rset.getString(4));
			obj.setTime(rset.getString(5));

		}
		return obj;
	}

}
