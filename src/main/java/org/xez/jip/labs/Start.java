package org.xez.jip.labs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

/**
 * WebServlet
 * @param user - filter by user in table
 */
@WebServlet("/orders")
public class Start extends HttpServlet {

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

        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head><title></title></head>"); out.println("<body>");

            out.println("<h1>Список заказов пользователей: " + String.join(", ", users) + "</h1>");
            out.println("<table border='1'>");
            out.println("<tr><td><b>Номер заказа</b></td>" +
                    "<td><b>Пользователь</b></td>" +
                    "<td><b>ФИО</b></td>" +
                    "<td><b>Коды товаров</b>" +
                    "</td><td><b>Количество</b>" +
                    "</td><td><b>Цена</b></td>" +
                    "</td><td><b>Итого</b></td>" +
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
}
