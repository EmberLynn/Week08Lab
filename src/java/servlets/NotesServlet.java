/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Services.NoteService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author 738634
 */
public class NotesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        NoteService ns = new NoteService();
        
        try {
            List<Note> notes = ns.getAll();
            request.setAttribute("notes", notes);
        } catch (Exception ex) {
            ex.getMessage();
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/notes.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       NoteService ns = new NoteService();
       String action = request.getParameter("action");
       String title = request.getParameter("title");
       String contents = request.getParameter("contents");
       int noteid;
       
       try {
       if(action.equals("add"))
       {
            ns.insert(contents, title);
       }
       if(action.equals("edit"))
       {
           noteid = Integer.parseInt(request.getParameter("noteid"));
           Note note = ns.get(noteid);
           request.setAttribute("note", note);
           request.setAttribute("edit", action);
       }
       if(action.equals("save"))
       {
           noteid = Integer.parseInt(request.getParameter("noteid"));
           ns.update(noteid, title, contents);
       }
       if(action.equals("delete"))
       {
           noteid = Integer.parseInt(request.getParameter("noteid"));
           ns.delete(noteid);
       }
       } catch (Exception ex) {
                ex.getMessage();
            }
       
       
       try {
            List<Note> notes = ns.getAll();
            request.setAttribute("notes", notes);
        } catch (Exception ex) {
            ex.getMessage();
        }
       getServletContext().getRequestDispatcher("/WEB-INF/notes.jsp").forward(request, response);
    }

}
