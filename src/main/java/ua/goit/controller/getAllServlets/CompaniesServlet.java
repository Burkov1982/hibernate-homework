package ua.goit.controller.getAllServlets;

import ua.goit.service.HibernateCompanyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/companies")
public class CompaniesServlet extends HttpServlet {
    private CompanyService companyService = new CompanyService();
    private final HibernateCompanyService service = new HibernateCompanyService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
            List<CompanyDTO> companies = companyService.getAll();
            req.setAttribute("companies", companies);
        */

        req.setAttribute("result", service.getAll());
        req.getRequestDispatcher("/view/print/printMessage.jsp").forward(req, resp);
    }
}
