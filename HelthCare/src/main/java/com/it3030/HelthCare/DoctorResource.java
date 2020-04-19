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

import Model.DoctorModel;

import Controller.DoctorController;

@Path("doctorResources")
public class DoctorResource {

	@GET
	@Path("doctors")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<DoctorModel> getAllDoctors() throws Exception {
		return DoctorController.getInstance().searchAll();
	}

	@GET
	@Path("doctor/{doc_id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public DoctorModel getDoctor(@PathParam("doc_id") int doc_id) throws Exception {
		return DoctorController.getInstance().search(doc_id);
	}

	@POST
	@Path("doctor")
	public String saveDoctor(DoctorModel obj) throws Exception {
		DoctorController.getInstance().save(obj);
		return "doctor Saved";
	}

	@PUT
	@Path("doctor")
	public String updateDoctor(DoctorModel obj) throws Exception {
		DoctorController.getInstance().update(obj);
		return "doctor Updated";
	}

	@DELETE
	@Path("doctor/{doc_id}")
	public String deleteDoctor(@PathParam("doc_id") int doc_id) throws Exception {
		DoctorModel obj = new DoctorModel();
		obj.setDoc_id(doc_id);
		DoctorController.getInstance().delete(obj);
		return "doctor Deleted";
	}
}
