/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Note;

/**
 *
 * @author 738634
 */
public class NoteDB {
    
    public void insert(Note note) throws Exception
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            em.persist(note);
            et.commit();
        }catch(Exception e)
        {
            et.rollback();
        }finally
        {
            em.close();
        }
    }
    
    public void update(Note note) throws Exception
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            em.merge(note);
            et.commit();
        }catch(Exception e)
        {
            et.rollback();
        }finally
        {
            em.close();
        }
    }
    
    public List<Note> getAll() throws Exception
    {
       EntityManager em = DBUtil.getEmFactory().createEntityManager(); 
       try{
           List<Note> note = em.createNamedQuery("Note.findAll", Note.class).getResultList();
           return note;
       }finally{
           em.close();
       }
    }
    
    public Note get(int noteid) throws Exception
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager(); 
        try{
            Note note = em.find(Note.class, noteid);
            return note;
        }finally{
            em.close();
        }
    }
    
    public void delete(Note note) throws Exception
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction et= em.getTransaction();
        try{
            et.begin();
            em.remove(em.merge(note));
            et.commit();
        }catch(Exception e){
            et.rollback();
        }finally{
            em.close();
        }
    }
    
}
