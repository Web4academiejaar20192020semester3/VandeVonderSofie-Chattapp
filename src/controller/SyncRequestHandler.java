package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class SyncRequestHandler extends RequestHandler {

    public abstract String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException ;
}
