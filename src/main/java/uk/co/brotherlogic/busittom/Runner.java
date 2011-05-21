package uk.co.brotherlogic.busittom;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uk.co.brotherlogic.busit.BusStop;
import uk.co.brotherlogic.busit.BusTime;
import uk.co.brotherlogic.busit.sheffield.SheffieldBusStop;

public class Runner extends HttpServlet
{

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
         IOException
   {
      String ret = "hello";

      String request = req.getPathInfo();

      try
      {
         if (request.startsWith("/stop/"))
            ret = getStopStuff(request.subSequence("/stop/".length(), request.length()));
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }

      OutputStream os = resp.getOutputStream();
      PrintStream ps = new PrintStream(os);
      ps.print(ret);
      os.close();
   }

   private String getStopStuff(CharSequence stopNumber) throws IOException
   {
      BusStop stop = new SheffieldBusStop(stopNumber.toString());
      String retString = "";

      for (BusTime time : stop.getArrivalTimes())
      {
         retString += time.getDescriptor() + "|" + time.getTime() + "\n";
      }

      return retString;
   }
}
