<%-- 
    Document   : pocResults
    Created on : Mar 27, 2023, 3:57:25 PM
    Author     : Dhananjay Kapar (dhirajdhananjay4@gmail.com)
--%>

 <%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
 <%@page import="data.Dao"
 %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>
             Found
            <%=session.getAttribute("productMapSize") %>
        </h2>
        <table>
            <th>
            <td>Product Map Size</td>
            <td>Nutrient Map Size</td>
            </th>
            <tr>
                <td><%=Dao.productMap.size()%></td>
                <td><%=Dao.nutrientMap.size()%></td>
            </tr>
        </table>
    </body>
</html>
