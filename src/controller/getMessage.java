package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Message;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class getMessage extends AsyncRequestHandler {

        @Override
        public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
                response.setContentType("application/json");

                Person currentUser = (Person) request.getSession().getAttribute("user");

                //System.out.println("current user" + currentUser);
                ArrayList<Message> messages = currentUser.getMessages();

                //  System.out.println("messages for " + currentUser.getFirstName() +" " + messages.size());


                // System.out.println(messageToJson(messages));
                return messageToJson(messages);


        }

        private String messageToJson(ArrayList<Message> messages) throws JsonProcessingException {
                ObjectMapper mapper = new ObjectMapper();
                return mapper.writeValueAsString(messages);
        }
}
