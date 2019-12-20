package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;
import domain.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class getFriends extends AsyncRequestHandler {
        @Override
        public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {


                PersonService service = getPersonService();
                Person person = (Person) request.getSession().getAttribute("user");
                ArrayList<Person> friends = service.getPerson(person.getUserId()).getFriends();
                String jsonString = toJSON(friends);
                response.setContentType("application/json");
                return jsonString;
        }

        private String toJSON(ArrayList<Person> friends) throws JsonProcessingException {
                ObjectMapper mapper = new ObjectMapper();
                //System.out.print("friends mapper: " + mapper.writeValueAsString(friends));
                return mapper.writeValueAsString(friends);
        }

}
