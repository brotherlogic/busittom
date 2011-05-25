package uk.co.brotherlogic.busittom;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/stops/")
public class GetStops
{
   @GET
   @Produces("test/plain")
   public String sayHello(String name)
   {
      return "Hello, " + name;
   }

   public static void main(String[] args) throws IOException
   {

      final String baseUri = "http://localhost:9998/";
      final Map<String, String> initParams = new HashMap<String, String>();

      initParams.put("com.sun.jersey.config.property.packages",
            "com.sun.jersey.samples.helloworld.resources");

      System.out.println("Starting grizzly...");
      SelectorThread threadSelector = GrizzlyWebContainerFactory.create(baseUri, initParams);
      System.out.println(String.format(
            "Jersey app started with WADL available at %sapplication.wadl\n"
                  + "Try out %shelloworld\nHit enter to stop it...", baseUri, baseUri));
      System.in.read();
      threadSelector.stopEndpoint();
      System.exit(0);
   }
}
