package Controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DBConnector.Connector;
import Model.StockModel;
import Model.UserModel;

public class UserController {
	
	
	Connector con = Connector.getInstance();

	private UserController() {
	}

	private static final UserController obj = new UserController();

	public static UserController getInstance() {
		return obj;
	}
	
	public void save(UserModel obj) throws Exception {
		con.getConnection();
		con.aud("INSERT INTO user(name,email,username,password) VALUES ('" + obj.getName() + "', " + "'"
				+ obj.getEmail() + "', '" + obj.getUsername() + "', '" + obj.getPassword() + "')");
	}
	
	public void delete(UserModel obj) throws Exception {
		con.getConnection();
		con.aud("DELETE FROM user WHERE id='" + obj.getId() + "'");
	}
	

	public List<UserModel> getAll() throws Exception {
		List<UserModel> list = new ArrayList<UserModel>();
		con.getConnection();
		ResultSet rset = con.srh("SELECT * FROM user");
		while (rset.next()) {
			UserModel obj = new UserModel();
			obj.setId(rset.getInt(1));
			obj.setName(rset.getString(2));
			obj.setEmail(rset.getString(3));
			obj.setUsername(rset.getString(4));
			obj.setPassword(rset.getString(5));
			list.add(obj);
		}
		return list;
	}
	
	public void update(UserModel obj) throws Exception {
		con.getConnection();
		con.aud("UPDATE user SET name = '" + obj.getName() + "', email = '" + obj.getEmail()
				+ "', username = '" + obj.getUsername() + "'," + "password = '" + obj.getPassword() + "' "
				+ "WHERE id='" + obj.getId() + "'");
	}


}
