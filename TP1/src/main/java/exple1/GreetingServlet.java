package exple1;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class GreetingServlet extends HttpServlet {

    private final String URL = "jdbc:mysql://localhost:3306/loterie";
    private final String USER = "root";
    private final String PASSWORD = "";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String votreNom = request.getParameter("nom");
        String nomPrenom = (votreNom != null) ? votreNom.toUpperCase() : "ANONYMOUS";
        double gain = Math.random() * 10;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            String sql = "INSERT INTO gains (nom, montant) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nomPrenom);
            ps.setDouble(2, gain);
            ps.executeUpdate();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT nom, montant, date_jeu FROM gains ORDER BY date_jeu DESC LIMIT 5");

          
            out.println("<html><head><title>Résultat Loterie</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; background-color: #f9f9f9; text-align: center; }");
            out.println("h1 { color: #2e8b57; }");
            out.println("p { font-size: 18px; }");
            out.println("ul { list-style-type: none; padding: 0; }");
            out.println("li { margin: 5px; padding: 8px; border-radius: 5px; }");
            out.println("</style>");
            out.println("</head><body>");

            out.println("<h1>Bonjour " + nomPrenom + " !</h1>");
            out.println("<p>Vous avez gagné : <strong>" + String.format("%.2f", gain) + "</strong> millions de dollars !</p>");

            out.println("<h3>Derniers résultats :</h3>");
            out.println("<ul>");
            while (rs.next()) {
                out.println("<li>" + rs.getString("nom") + " - " + String.format("%.2f", rs.getDouble("montant"))
                        + " millions (" + rs.getTimestamp("date_jeu") + ")</li>");
            }
            out.println("</ul>");

            out.println("</body></html>");

            rs.close();
            stmt.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
