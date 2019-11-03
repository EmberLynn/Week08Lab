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
                    <th colspan="2">Title</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${notes}" var="note">
                <tr>
                <form method="post" action="">
                    <td>${note.datecreated}</td>
                    <td>${note.title}</td>
                    <td><input type="submit" value="Edit" /></td>
                    <input type="hidden" name="action" value="edit">
                    <input type="hidden" name="noteid" value="${note.noteid}">
                </form>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        <c:if test="${edit eq null}">
            <form method="post" action="">
            <h2>Add Note</h2>
            <input type="text" name="title" value="" placeholder="Title"/><br>
            <textarea name="contents"  rows ="10" cols="50" placeholder="type a note..."></textarea>
            <input type="submit" value="Add"/>
            <input type="hidden" name="action" value="add">
            </form>
        </c:if>
        <c:if test="${edit ne null}">
            <h2>Edit Note</h2>
            <form method="post" action="">
                <input type="submit" value="Delete Note" name="delete" /> 
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="noteid" value="${note.noteid}">
            </form>
            <form method="post" action="">
            <input type="text" name="title" value="${note.title}" placeholder="Title"/><br>
            <textarea name="contents"  rows ="10" cols="50" placeholder="type a note...">${note.contents}</textarea>
            <input type="submit" value="Save"/>
            <input type="hidden" name="action" value="save">
            <input type="hidden" name="noteid" value="${note.noteid}">
            </form>
        </c:if>
    </body>
</html>
