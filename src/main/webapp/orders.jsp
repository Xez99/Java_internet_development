<%--
  Created by IntelliJ IDEA.
  User: xez
  Date: 18/04/2020
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.time.Instant" %>
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
    String bgcolor = "white";
    Cookie[] cookies = request.getCookies();
    if (cookies != null)
        for(Cookie cookie: cookies){
            if(cookie.getName().equals("bgcolor"))
                bgcolor = cookie.getValue();
        }
    //Integer visitCounter = 1;
    Integer visitCounter = (Integer) session.getAttribute("visitCounter");
    if(visitCounter == null)
        visitCounter = 1;
    else
        visitCounter++;


    Instant instant = (Instant) session.getAttribute("lastVisit");
    session.setAttribute("lastVisit", Instant.now());


    session.setAttribute("visitCounter", visitCounter);

%>
<html>
    <head>
        <title>
            <%=locale.getUi(ORDER_LIST)%>
        </title>
    </head>
    <body id="body" bgcolor=<%=bgcolor%>>
        <h1>
            <%=locale.getUi(ORDER_LIST)%>
            <%=String.join(", ", users)%>
        </h1>
        <%@include file="ordersTable.jsp"%>
        <p>
        <form name="filterForm" action="orders.jsp">
            Filter by user: <input type="text" name="user">
            <%-- For saving language attribute while redirecting --%>
            <% if(lang != null) {%>
                <input type="hidden" name="lang" value=<%=lang%>>
            <% } %>
            <input type="submit" value="filter">
        </form>

        <h6>
            JSP
        </h6>
        <h3>You watch this page <%=visitCounter%> times</h3>
        <h4><%=instant==null ? "" : "Last visit was at " + instant.toString() %></h4>
        <form name="colorForm" method="post">
            Background color: <input type="color" placeholder="color" id="color" value=<%=bgcolor%>>
            <input type=button value="Set background color" onclick="setColor()" />
        </form>
    </body>
</html>

<script language="JavaScript">
    function setColor() {
        // set runtime bgcolor
        document.getElementById("body").style.backgroundColor = document.getElementById("color").value;
        // store color in cookies
        document.cookie = "bgcolor=" + document.getElementById("color").value;
        //alert(document.getElementById("color").value);
    }
</script>