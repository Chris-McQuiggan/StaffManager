package com.bae.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.bae.buisness.service.StaffService;

@Path("/Staff")
public class StaffController {
	@Inject
	private StaffService service;

	@Path("/getAllStaff")
	@GET
	@Produces({ "application/json" })
	public String getAllStaff() {
		return service.getAllStaff();
	}

	@Path("/getAStaffMember/{id}")
	@GET
	@Produces({ "application/json" })
	public String getAStaffMember(@PathParam("id") int id) {
		return service.getAStaffMember(id);
	}

	@Path("/addStaffMember")
	@POST
	@Produces({ "application/json" })
	public String addStaffMember(String checkIn) {
		return service.addStaffMember(checkIn);
	}

	@Path("/updateStaff/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateStaff(String checkOut, @PathParam("id") int id) {
		return service.updateStaff(checkOut, id);
	}

	@Path("/deleteStaffMember/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteStaffMember(String checkOut, @PathParam("id") int id) {
		return service.deleteStaffMember(id);
	}

}
