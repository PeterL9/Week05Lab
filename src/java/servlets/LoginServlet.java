package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AccountService;
import models.User;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        String message = "";
        String logout = request.getParameter("logout");

        if (logout != null) {
            session.invalidate();
            session = request.getSession();
            message = "Successfully logged out";
            request.setAttribute("message", message);
        }

        if (user != null) {
            response.sendRedirect("home");
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        String message = "";

        if (username == null || username.equals("") || password == null || password.equals("")) {
            message = "Invalid username or password";
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        } else {
            AccountService as = new AccountService();
            user = as.login(username, password);
        }

        session.setAttribute("user", user);

        if (user != null) {
            response.sendRedirect("home");
        } else {
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.setAttribute("message", "Invalid username or password");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }
}
