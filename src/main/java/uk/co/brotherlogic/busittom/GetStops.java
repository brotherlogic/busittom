package uk.co.brotherlogic.busittom;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/stops/")
public class GetStops
{
   @GET
   @Produces("text/plain")
   public String sayHello()
   {
      return "Hello there";
   }
}
