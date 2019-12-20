package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Message;
import domain.Person;
import domain.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class sendMessage extends AsyncRequestHandler {
        @Override
        public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {

                PersonService service = super.getPersonService();

                //   System.out.println("sendmessage " + "\n");
                Person currentUser = (Person) request.getSession().getAttribute("user");
                //System.out.println("message from : " +currentUser.getFirstName() +"\n");

                //System.out.println("nr of messages" + currentUser.getMessages().size());

                String receiverString = request.getParameter("receiver");

                Person receiver = service.getPerson(receiverString);
                //System.out.println("message to : " +receiver.getFirstName() +"\n");
                // System.out.println("nr of messages receiver: " + receiver.getMessages().size() + "\n");
                String messageContent = request.getParameter("messageContent");
                //    System.out.println("message content parameter " + messageContent +"\n");
                response.setContentType("text/plain");
                //  return messageToJson(message);

                Message message = new Message(currentUser, receiver, messageContent);

                currentUser.addMessage(message);
                //      System.out.print("messages current user: "  + currentUser.getMessages().toString());
                //System.out.println("nr of messages when message added current user: " + currentUser.getMessages().size() +"\n");

                receiver.addMessage(message);
                //System.out.println("nr of messages when message added receiver : " + receiver.getMessages().size() +"\n");
                //System.out.print("messages receiver: " + receiver.getMessages().toString());
                //String messageString = messageToJson(message);

                //System.out.print(" message.getmessage: " + message.getContent()+"\n");

                // System.out.print(" message.tostring: " + message.toString()+"\n");
                //System.out.println("json message: " + messageToJson(message));
                return messageToJson(message);

        }

        private String messageToJson(Message message) throws JsonProcessingException {
                ObjectMapper mapper = new ObjectMapper();
                return mapper.writeValueAsString(message);
        }
}