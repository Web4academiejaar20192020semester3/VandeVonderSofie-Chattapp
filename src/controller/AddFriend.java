package controller;

import domain.Person;
import domain.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class AddFriend extends AsyncRequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {



        response.setContentType("application/json");
        response.setHeader("Access-Control-Allow-Origin", "*");


        PersonService service = super.getPersonService();
        Person person = (Person) request.getSession().getAttribute("user");

        String friendToAdd = request.getParameter("friend");
        Person friend = service.getPerson(friendToAdd);

        System.out.print(person.getFirstName() + " wants to add " + friend.getFirstName()+"\n");

        if (friend != null) {
            if (!(person.getFriends().contains(friend)&&(friend.equals(person)))) {
                person.addFriend(friend);
                friend.addFriend(person);
                service.updatePersons(person);
                service.updatePersons(friend);
            }
            else{
                System.out.print(person + " and " + friend +"are already friends");
            }
        }
        return friendToAdd;
}




        // see if person to add exists
     /*   PersonService service = super.getPersonService();

        for (Person p : service.getPersons()) {
            if (p.getUserId().equals(friendToAdd)) { // person found

                System.out.println(person.getFriends().size());
                // they need to add each other
                p.addFriend(person);
                person.addFriend(p);
                service.updatePersons(p);
                service.updatePersons(person);
                System.out.println(person.getFriends().size());
            }
        }
            response.setContentType("application/json");
        return friendToAdd;
    }*/
}
