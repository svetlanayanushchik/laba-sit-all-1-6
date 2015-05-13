package controller;


import service.RequestManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

public class Controller extends HttpServlet {


    private static final String SELECT_ALL_COMMAND = "Select * from Author";
    private static final String SELECT_NEWS_BY_ID = "Select * from News by Id";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String receiveCommand = request.getParameter("command");
        String forwardPage = null;
        if (receiveCommand.equals(SELECT_ALL_COMMAND)) {
            forwardPage = RequestManager.getInstance().selectAll(request, response);
        } else if (receiveCommand.equals(SELECT_NEWS_BY_ID)) {
            forwardPage = RequestManager.getInstance().selectNewsById(request, response);
        }
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(forwardPage);
        requestDispatcher.forward(request, response);
    }
}
