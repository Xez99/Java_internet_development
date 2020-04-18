<%@ page import="org.xez.jip.labs.locale.LocaleConfig" %>
<%@ page import="org.xez.jip.labs.locale.LocaleProvider" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.Vector" %><%--
  Created by IntelliJ IDEA.
  User: xez
  Date: 18/04/2020
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>

<%!
    private static final String LANGUAGE= "lang";
%>
<%  request.setCharacterEncoding("UTF-8");
    LocaleProvider locale;
    String lang = request.getParameter(LANGUAGE);
    if (lang != null){
        Vector<Locale> vector = new Vector<>();
        vector.add(Locale.forLanguageTag(lang));
        locale = LocaleConfig.getLocaleProvider(vector.elements());
    } else {
        locale = LocaleConfig.getLocaleProvider(request.getLocales());
    }
    List<String> users = Arrays.asList(request.getParameterMap().getOrDefault("user", new String[0]));
%>
<html>
<head>
    <title>
        <%=locale.getUi("noUserSelected")%>
    </title>
</head>
<body>
    <h1>
        <%=locale.getUi("noUserSelected")%>
    </h1>
</body>
</html>
