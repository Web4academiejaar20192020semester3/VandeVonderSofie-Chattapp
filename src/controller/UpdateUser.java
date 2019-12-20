/*
package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;
import domain.PersonService;
import domain.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class UpdateUser extends AsyncRequestHandler {
        @Override
        public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
                response.setHeader("Access-Control-Allow-Origin", "*");
                response.setHeader("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
                response.setHeader("Content-Type", "application/json");
              //  response.setHeader("Access-Control-Allow-Methods", "PUT");

                System.out.println("hello?");

                PersonService service = super.getPersonService();
                String id = request.getParameter("userId");
                System.out.println(id);
                Person person = service.getPerson(id);

                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String roleString = request.getParameter("role");

                person.setFirstName(firstName);
                person.setLastName(lastName);
                if (roleString.equals("BIB")) {

                        person.setRole(Role.BIB);
                } else {
                        person.setRole(Role.LID);
                }
                service.updatePersons(person);
                return toJSON(person);
        }

        private String toJSON(List<Person> users) throws JsonProcessingException {
                ObjectMapper mapper = new ObjectMapper();
                return mapper.writeValueAsString(users);
        }

        private String toJSON(Person person) throws JsonProcessingException {
                ObjectMapper mapper = new ObjectMapper();
                System.out.println("json; " + mapper.writeValueAsString(person));
                return mapper.writeValueAsString(person);
        }

}*/

