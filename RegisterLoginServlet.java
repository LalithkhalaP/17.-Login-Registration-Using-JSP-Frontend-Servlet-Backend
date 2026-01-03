package register;
import java.io.IOException;
import java.sql.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({"/register", "/login"})
public class RegisterLoginServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getServletPath();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/authdb", "root", "lalli@2007");

            if (path.equals("/register")) {
                String uname = request.getParameter("username");
                String pwd = request.getParameter("password");

                PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO users(username, password) VALUES (?, ?)");
                ps.setString(1, uname);
                ps.setString(2, pwd);
                ps.executeUpdate();

                request.setAttribute("msg", "Registration Successful!");
                RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
                rd.forward(request, response);
            }

            else if (path.equals("/login")) {
                String uname = request.getParameter("username");
                String pwd = request.getParameter("password");

                PreparedStatement ps = con.prepareStatement(
                        "SELECT * FROM users WHERE username=? AND password=?");
                ps.setString(1, uname);
                ps.setString(2, pwd);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    request.setAttribute("msg", "Login Successful!");
                } else {
                    request.setAttribute("msg", "Invalid Username or Password");
                }

                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            }

            con.close();
        } catch (SQLIntegrityConstraintViolationException e) {
     
            request.setAttribute("msg", "Username already exists!");
            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
