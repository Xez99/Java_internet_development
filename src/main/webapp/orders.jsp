<%--
  Created by IntelliJ IDEA.
  User: xez
  Date: 18/04/2020
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>


<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" errorPage="noUserSelected.jsp"%>
<%!
    private static final String LANGUAGE= "lang";
    //private static final String USER    = "user";

    private static final String ORDER_LIST  = "orderList";
%>
<%
    List<String> users = Arrays.asList(request.getParameterMap().getOrDefault("user", new String[0]));
    if (users.isEmpty())
        throw new IllegalArgumentException("User expected");

    LocaleProvider locale;
    String lang = request.getParameter(LANGUAGE);

    if (lang != null){
        Vector<Locale> vector = new Vector<>();
        vector.add(Locale.forLanguageTag(lang));
        locale = LocaleConfig.getLocaleProvider(vector.elements());
    } else {
        locale = LocaleConfig.getLocaleProvider(request.getLocales());
    }

%>
<html>
    <head>
        <title>
            <%=locale.getUi(ORDER_LIST)%>
        </title>
    </head>
    <body>
        <h1>
            <%=locale.getUi(ORDER_LIST)%>
            <%=String.join(", ", users)%>
        </h1>
        <%@include file="ordersTable.jsp"%>
        <h6>
            JSP
        </h6>
    </body>
</html>