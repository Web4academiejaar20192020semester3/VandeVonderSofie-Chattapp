package db;

import domain.Message;
import domain.Person;

import java.util.List;

public interface MessageRepository {


    void addMessage(Message message);
  //  void addMessageToOtherPerson(Message message, Person person);
    List<Message> getMessages(Person person);



}
