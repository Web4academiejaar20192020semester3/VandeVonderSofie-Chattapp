package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Status extends AsyncRequestHandler {


        @Override
        public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {

                Person person = (Person) request.getSession().getAttribute("user");
                person.setStatus("online");
                response.setContentType("application/json");
                //System.out.println("default status: " + statusResponseText);
                // response.getWriter().write(status));  staat nu in controller
                return person.getStatus().toUpperCase();
        }
}


// 2 soorten requesthandlers -> synchroon en asynchroon;
// 2 subclasses van requesthandler
// sync geeft jsp terug
// async geeft status terug