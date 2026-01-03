# 17.-Login-Registration-Using-JSP-Frontend-Servlet-Backend
Objective:
To build a complete authentication system using JSP forms and a central Servlet.
Description:
register.jsp → collects username & password
login.jsp → collects login details
Servlet receives data via request parameters
Performs JDBC insert (for register) and JDBC select (for login)
Servlet returns response messages back to JSP
Requirements:
register.jsp + login.jsp
One Servlet (RegisterLoginServlet)
JDBC for validation
proper routing based on req.getServletPath()
connect jar and server to run it..
