package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;
import domain.PersonService;
import jdk.nashorn.internal.parser.JSONParser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserApp extends AsyncRequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PersonService service = super.getPersonService();


        List<Person> users = service.getPersons();


        response.setContentType("application/json");
        response.setHeader("Access-Control-Allow-Origin", "*");


        //System.out.println(toJSON(people));
        //  return toJSON(people);
        //System.out.println(users);
        return toJSON(users);
    }


    private String toJSON(List<Person> users) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
                return mapper.writeValueAsString(users);
    }


     //   System.out.println(allPersons.size());

     /*  String users = "[";

        for (int i = 0; i < allPersons.size(); i++) {

            String id = Integer.toString(i + 1);
            String userID = allPersons.get(i).getUserId();
            String firstName = allPersons.get(i).getFirstName();
            String lastName = allPersons.get(i).getLastName();
            String role = allPersons.get(i).getRole().toString();



            if (i == allPersons.size() - 1) {

                users += "{\"" + "id\": \"" + id + "\", \"userId\": \"" + userID + "\", \"firstName\": \"" + firstName + "\", \"lastName\": \"" + lastName + "\", \"role\": \"" + role + "\"}" + "]";
            } else {


             users += "{\"" + "id\": \"" + id + "\", \"userId\": \"" + userID + "\", \"firstName\": \"" + firstName + "\", \"lastName\": \"" + lastName + "\", \"role\": \"" + role  + "\"},";

            }
        }*/
        //System.out.println(users);
     //   return users;

}
