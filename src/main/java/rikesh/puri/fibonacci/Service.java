package rikesh.puri.fibonacci;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/")
public class Service {
	
	int x; 
	
	@Path("/current")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getCurrent(@Context HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if (session == null) {
		    session = req.getSession();
		    session.setAttribute("index", "0");
		    x = 0;
		} else {
			x = Integer.parseInt((String) session.getAttribute("index"));
		}
		return "Current fibonacci number is " + Factory.getFib(x);
	}
	
	@Path("/next")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getNext(@Context HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if (session == null) {
		    session = req.getSession();
		    session.setAttribute("index", "0");
		    x = 1;
		} else {
			x = Integer.parseInt((String) session.getAttribute("index"));
		    session.setAttribute("index", Integer.toString(++x));
		}
		return "Next fibonacci number is " + Factory.getFib(x);
	}
	
	@Path("/previous")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getPrevious(@Context HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if (session == null) {
		    session = req.getSession();
		    session.setAttribute("index", "0");
		    x = -1;
		} else {
			x = Integer.parseInt((String) session.getAttribute("index"));
		    session.setAttribute("index", Integer.toString(--x));
		}
		if (x < 0) {
			return "No previous number";
		}
		return "Previous fibonacci number is " + Factory.getFib(x);
	}
}
