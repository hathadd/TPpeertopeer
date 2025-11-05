package exple1;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class BlacklistFilter implements Filter {
    private String[] blacklist = {"BADNAME1", "BADNAME2"};

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String nom = request.getParameter("nom");
        if (nom != null) {
            for (String bad : blacklist) {
                if (nom.equalsIgnoreCase(bad)) {
                    response.getWriter().println("Accès refusé : nom dans la liste noire !");
                    return;
                }
            }
        }
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {}
    public void destroy() {}
}
