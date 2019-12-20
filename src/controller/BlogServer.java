package controller;

//import javax.websocket.*;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint("/echo")
public class BlogServer {


        private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());


        @OnOpen
        public void onOpen(Session session) {
                sessions.add(session);
        }

        @OnMessage
        public void onMessage(String message, Session session) {
                System.out.println(message);
                sendMessageToAll(message);
        }

        private void sendMessageToAll(String message) {
                for (Session session : sessions) {
                        try {
                                session.getBasicRemote().sendText(message);
                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                }
        }


        @OnClose
        public void onClose(Session session) {
                sessions.remove(session);
        }


}
