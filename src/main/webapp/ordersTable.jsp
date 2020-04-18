<%@ page import="org.xez.jip.labs.locale.LocaleConfig" %>
<%@ page import="org.xez.jip.labs.locale.LocaleProvider" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.Vector" %><%--
  Created by IntelliJ IDEA.
  User: xez
  Date: 18/04/2020
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%!
    //private static final String LANGUAGE = "lang";

    /** Resource Bundle properties Keys */
    private static final String ORDER_NUMBER= "orderNumber";
    private static final String USER        = "user";
    private static final String FULL_NAME   = "fullName";
    private static final String PRODUCT_ID  = "productId";
    private static final String AMOUNT      = "amount";
    private static final String PRICE       = "price";
    private static final String COST        = "cost";
%>
<table border='1'>
    <tr>
        <td><b><%=locale.getUi(ORDER_NUMBER)%></b></td>
        <td><b><%=locale.getUi(USER)        %></b></td>
        <td><b><%=locale.getUi(FULL_NAME)   %></b></td>
        <td><b><%=locale.getUi(PRODUCT_ID)  %></b></td>
        <td><b><%=locale.getUi(AMOUNT)      %></b></td>
        <td><b><%=locale.getUi(PRICE)       %></b></td>
        <td><b><%=locale.getUi(COST)        %></b></td>
    </tr>
    <%
        if(users.contains("00000000")) { %>
            <tr>
                <td>1_030_203_023_000</td>
                <td>00000000</td>
                <td>Василий Пупкин Виссарионович</td>
                <td>423098,432445</td>
                <td>1,2</td>
                <td>39900,79900</td>
                <td>199700</td>
            </tr>
        <%}
        if(users.contains("00000001")){ %>
            <tr>
                <td>1_030_203_023_001</td>
                <td>00000001</td>
                <td>Иванов Иван Иванович</td>
                <td>423099,432446</td>
                <td>2,2</td>
                <td>69900,19900</td>
                <td>109700</td>
            </tr>

        <% } %>
</table>