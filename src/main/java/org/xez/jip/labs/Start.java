package org.xez.jip.labs;

import org.xez.jip.labs.locale.LocaleConfig;
import org.xez.jip.labs.locale.LocaleProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * WebServlet
 * @QueryParams user - filter by user in table
 * @QueryParams lang - use specific locale if supported
 */
@WebServlet("/orders")
public class Start extends HttpServlet {

    private static final String LANGUAGE = "lang";

    /** Resource Bundle properties Keys */
    private static final String ORDER_LIST  = "orderList";
    private static final String ORDER_NUMBER= "orderNumber";
    private static final String USER        = "user";
    private static final String FULL_NAME   = "fullName";
    private static final String PRODUCT_ID  = "productId";
    private static final String AMOUNT      = "amount";
    private static final String PRICE       = "price";
    private static final String COST        = "cost";

    /**
     * Auxiliary method for returnig Http page with orders
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs */
    protected void processRequest(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {


        List<String> users = Arrays.asList(request.getParameterMap().getOrDefault("user", new String[0]));
        response.setContentType("text/html;charset=UTF-8"); // Получение потока для вывода ответа

        LocaleProvider locale = initLocale(request);

        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head><title></title></head>"); out.println("<body>");

            out.println("<h1>" + locale.getUi(ORDER_LIST) + String.join(", ", users) + "</h1>");
            out.println("<table border='1'>");
            out.println("<tr><td><b>" + locale.getUi(ORDER_NUMBER) + "</b></td>" +
                    "<td><b>" + locale.getUi(USER)      + "</b></td>" +
                    "<td><b>" + locale.getUi(FULL_NAME) +"</b></td>" +
                    "<td><b>" + locale.getUi(PRODUCT_ID)+"</b></td>" +
                    "<td><b>" + locale.getUi(AMOUNT)    +"</b></td>" +
                    "<td><b>" + locale.getUi(PRICE)     +"</b></td></td>" +
                    "<td><b>" + locale.getUi(COST)      +"</b></td>" +
                    "</tr>");
            if (users.isEmpty() || users.contains("00000000"))
                out.println("<tr><td>1_030_203_023_000</td>" +
                        "<td>00000000</td>" +
                        "<td>Василий Пупкин Виссарионович</td>" +
                        "<td>423098,432445</td>" +
                        "<td>1,2</td>" +
                        "<td>39900,79900</td>" +
                        "<td>199700</td>" +
                        "</tr>");
            if (users.isEmpty() || users.contains("00000001"))
                out.println("<tr><td>1_030_203_023_001</td>" +
                        "<td>00000001</td>" +
                        "<td>Иванов Иван Иванович</td>" +
                        "<td>423099,432446</td>" +
                        "<td>2,2</td>" +
                        "<td>69900,19900</td>" +
                        "<td>109700</td>" +
                        "</tr>");
            out.println("</table>"); out.println("</body>"); out.println("</html>");
        }
    }
    /**
     * Handles the HTTP <code>GET</code> method.<p>
     *     Get order table for user/users (use Query param "user" for 1 or multiple users). If no user Query params, display all user orders.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
    18
     */
    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.<p> Do the same as GET method {@link #doGet(HttpServletRequest, HttpServletResponse) doGet}
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs */
    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private LocaleProvider initLocale(HttpServletRequest request) throws IOException {
        String lang = request.getParameter(LANGUAGE);
        if (lang != null){
            Vector<Locale> vector = new Vector<>();
            vector.add(Locale.forLanguageTag(lang));
            return LocaleConfig.getLocaleProvider(vector.elements());
        } else {
            return LocaleConfig.getLocaleProvider(request.getLocales());
        }
    }
}
