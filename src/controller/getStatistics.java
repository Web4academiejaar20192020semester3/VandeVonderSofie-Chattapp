package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class getStatistics extends AsyncRequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int online = 0;
        int offline = 0;


        Person person = (Person) request.getSession().getAttribute("user");
        ArrayList<Person> friends = person.getFriends();
        ArrayList<Integer> statistics = new ArrayList<>();

        response.setContentType("application/json");


        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).getStatus().equals("Offline") || friends.get(i).getStatus().equals("OFFLINE")) {
                offline++;
            } else {
                online++;
            }
        }

        statistics.add(online);
        statistics.add(offline);
        String json = "{\"online\":" + "\"" + String.valueOf(online) + "\"" + ",\"offline\":" + "\"" + String.valueOf(offline) + "\"" + "}";

    return json;

       // return toJSON(statistics);

    }

  /*  public String toJSON(ArrayList<Integer> statistics) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(statistics);
    }*/
}
