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

import Model.PatientModel;

import Controller.PatientController;

@Path("patientResources")
public class PatientResource {
	@GET
	@Path("patients")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<PatientModel> getAllPatients() throws Exception {
		return PatientController.getInstance().searchAll();
	}

	@GET
	@Path("patient/{PatientID}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public PatientModel getPatient(@PathParam("PatientID") int PatientID) throws Exception {
		return PatientController.getInstance().search(PatientID);
	}

	@POST
	@Path("patient")
	public String savePatient(PatientModel obj) throws Exception {
		PatientController.getInstance().save(obj);
		return "patient Saved";
	}

	@PUT
	@Path("patient")
	public String updatePatient(PatientModel obj) throws Exception {
		PatientController.getInstance().update(obj);
		return "patient Updated";
	}

	@DELETE
	@Path("patient/{PatientID}")
	public String deletePatient(@PathParam("PatientID") int PatientID) throws Exception {
		PatientModel obj = new PatientModel();
		obj.setPatientID(PatientID);
		PatientController.getInstance().delete(obj);
		return "patient Deleted";
	}
}
