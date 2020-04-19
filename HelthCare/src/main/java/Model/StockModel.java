package Model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StockModel {

	private int Stock_id;
	private int Quantity;
	private String Rec_date;
	private String Stock_name;
	private String Exp_date;

	public StockModel() {
		super();
	}

	public StockModel(int stock_id, int quantity, String rec_date, String stock_name, String exp_date) {
		super();
		Stock_id = stock_id;
		Quantity = quantity;
		Rec_date = rec_date;
		Stock_name = stock_name;
		Exp_date = exp_date;
	}

	public int getStock_id() {
		return Stock_id;
	}

	public void setStock_id(int stock_id) {
		Stock_id = stock_id;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public String getRec_date() {
		return Rec_date;
	}

	public void setRec_date(String rec_date) {
		Rec_date = rec_date;
	}

	public String getStock_name() {
		return Stock_name;
	}

	public void setStock_name(String stock_name) {
		Stock_name = stock_name;
	}

	public String getExp_date() {
		return Exp_date;
	}

	public void setExp_date(String exp_date) {
		Exp_date = exp_date;
	}

	@Override
	public String toString() {
		return "StockModel [Stock_id=" + Stock_id + ", Quantity=" + Quantity + ", Rec_date=" + Rec_date
				+ ", Stock_name=" + Stock_name + ", Exp_date=" + Exp_date + "]";
	}

}
