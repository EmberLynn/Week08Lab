<%-- 
    Document   : notes
    Created on : Oct 29, 2019, 7:10:59 PM
    Author     : 738634
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Note Page</title>
    </head>
    <body>
        <h1>Notes!</h1>
        <table border="1" cellpadding="6">
            <thead>
                <tr>
                    <th>Date Created</th>
                    <th>Title</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${notes}" var="note">
                <tr>
                <form method="post" action="">
                    <td>${note.datecreated}</td>
                    <td>${note.title}&nbsp;&nbsp;&nbsp;<input type="submit" value="Edit" /></td>
                    <input type="hidden" name="action" value="edit">
                </form>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        <form method="post" action="">
        <h2>Add Note</h2>
        <input type="text" name="title" value="" placeholder="Title"/><br>
        <textarea name="contents"  rows ="10" cols="50" placeholder="type a note..."></textarea>
        <input type="submit" value="Add" />
        </form>
        </form>
    </body>
</html>
