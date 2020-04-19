package Controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.StockModel;

import DBConnector.Connector;

public class StockController {

	Connector con = Connector.getInstance();

	private StockController() {
	}

	private static final StockController obj = new StockController();

	public static StockController getInstance() {
		return obj;
	}

	public void save(StockModel obj) throws Exception {
		con.getConnection();
		con.aud("INSERT INTO stock(Quantity,Rec_date,Stock_name,Exp_date) VALUES ('" + obj.getQuantity() + "', " + "'"
				+ obj.getRec_date() + "', '" + obj.getStock_name() + "', '" + obj.getExp_date() + "')");
	}

	public void update(StockModel obj) throws Exception {
		con.getConnection();
		con.aud("UPDATE stock SET Quantity = '" + obj.getQuantity() + "', Rec_date = '" + obj.getRec_date()
				+ "', Stock_name = '" + obj.getStock_name() + "'," + "Exp_date = '" + obj.getExp_date() + "' "
				+ "WHERE Stock_id='" + obj.getStock_id() + "'");
	}

	public void delete(StockModel obj) throws Exception {
		con.getConnection();
		con.aud("DELETE FROM stock WHERE Stock_id='" + obj.getStock_id() + "'");
	}

	public List<StockModel> searchAll() throws Exception {
		List<StockModel> list = new ArrayList<StockModel>();
		con.getConnection();
		ResultSet rset = con.srh("SELECT * FROM stock");
		while (rset.next()) {
			StockModel obj = new StockModel();
			obj.setStock_id(rset.getInt(1));
			obj.setQuantity(rset.getInt(2));
			obj.setRec_date(rset.getString(3));
			obj.setStock_name(rset.getString(4));
			obj.setExp_date(rset.getString(5));

			list.add(obj);
		}
		return list;
	}

	public StockModel search(int Stock_id) throws Exception {
		con.getConnection();
		StockModel obj = null;
		ResultSet rset = con.srh("SELECT * FROM stock WHERE Stock_id='" + Stock_id + "'");
		while (rset.next()) {
			obj = new StockModel();
			obj.setStock_id(rset.getInt(1));
			obj.setQuantity(rset.getInt(2));
			obj.setRec_date(rset.getString(3));
			obj.setStock_name(rset.getString(4));
			obj.setExp_date(rset.getString(5));

		}
		return obj;
	}

}
