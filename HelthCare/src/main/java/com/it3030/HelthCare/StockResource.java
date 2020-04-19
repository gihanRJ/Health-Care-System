package com.it3030.HelthCare;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Model.StockModel;

import Controller.StockController;

@Path("stockResources")
public class StockResource {
	@GET
	@Path("stocks")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<StockModel> getAllStocks() throws Exception {
		return StockController.getInstance().searchAll();
	}

	@GET
	@Path("stock/{Stock_id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public StockModel getStock(@PathParam("Stock_id") int Stock_id) throws Exception {
		return StockController.getInstance().search(Stock_id);
	}

	@POST
	@Path("stock")
	public String saveStock(StockModel obj) throws Exception {
		StockController.getInstance().save(obj);
		return "stock Saved";
	}

	@PUT
	@Path("stock")
	public String updateStock(StockModel obj) throws Exception {
		StockController.getInstance().update(obj);
		return "stock Updated";
	}

	@DELETE
	@Path("stock/{Stock_id}")
	public String deleteStock(@PathParam("Stock_id") int Stock_id) throws Exception {
		StockModel obj = new StockModel();
		obj.setStock_id(Stock_id);
		StockController.getInstance().delete(obj);
		return "stock Deleted";
	}
}
