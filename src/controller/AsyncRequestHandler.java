package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AsyncRequestHandler extends RequestHandler {

    public abstract String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
