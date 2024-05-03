<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*" %>
<html>
<head>
<style>
body {
    background-color: balck;
    color: white;
    padding-left: 100px;
    padding-right: 100px;
    padding-top: 100px;
}

table {
    text-align: center;
    align-items: center;
    background-color: white;
    border: 2px solid black;
    border-collapse:collapse;
     margin: 0 auto;
     color:black;
}

th, td {
    padding: 10px;
    text-align:center;
border:2px solid black;
border-collapse:collapse;
}
</style>
</head>
<body>
<table border="10">
<%! 
Connection con;

public void jspInit() {
    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "DOG", "CAT");
    } catch(Exception e) {
        e.printStackTrace();
    }
}
%>

<%
String s = request.getParameter("cityname");
Statement st = con.createStatement();
ResultSet rs = st.executeQuery("SELECT * FROM mumbai");

// 
out.println("<h1 style='text-align:center;'><u>MUMBAI</u></h1>");
ResultSetMetaData rsmd = rs.getMetaData();
int columnCount = rsmd.getColumnCount();
out.println("<tr>");
for (int i = 1; i <= columnCount; i++) {
    out.println("<th>" + rsmd.getColumnName(i) + "</th>");
}
out.println("</tr>");

// Display table data
while (rs.next()) 
{
    out.println("<tr>");
    for (int i = 1; i <= columnCount; i++) {
        out.println("<td>" + rs.getString(i) + "</td>");
    }
    out.println("</tr>");
}


%>


<jsp:include page="mumbai.html"/>

</table>
</body>
</html>