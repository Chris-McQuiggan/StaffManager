package com.bae.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.bae.buisness.service.CheckInService;

@Path("/CheckIn")
public class CheckInController {
	@Inject
	private CheckInService service;

	@Path("/getAllCheckIns")
	@GET
	@Produces({ "application/json" })
	public String getAllCheckIns() {
		return service.getAllCheckIns();
	}

	@Path("/getACheckIn/{id}")
	@GET
	@Produces({ "application/json" })
	public String getACheckIn(@PathParam("id") int id) {
		return service.getACheckIn(id);
	}

	@Path("/getCheckedIn")
	@GET
	@Produces({ "application/json" })
	public String getCheckedIn() {
		return service.getCheckedIn();
	}

	@Path("/newCheckIn")
	@POST
	@Produces({ "application/json" })
	public String newCheckIn(String checkIn) {
		return service.newCheckIn(checkIn);
	}

	@Path("/checkOut/{id}")
	@PUT
	@Produces({ "application/json" })
	public String checkOut(String checkOut, @PathParam("id") int id) {
		return service.checkOut(checkOut, id);
	}

	@Path("/deleteCheckIn/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteCheckIn(@PathParam("id") int id) {
		return service.deleteCheckIn(id);
	}

}
