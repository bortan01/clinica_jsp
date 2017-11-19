package com.clinica.dao;

import com.clinica.entidad.Paciente;
import java.io.Serializable;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

@Component("pacienteDaoImpl")
public class pacienteDaoImpl extends GenericDaoImpl<Paciente, Integer> implements pacienteDao, Serializable {

    public List<Paciente> listarVuelos() throws Exception {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            String hql = "select v from Paciente v";
            System.out.println("este es el sql utilizado " + hql);
            Query query = session.createQuery(hql);
            List<Paciente> entities = query.list();
            session.getTransaction().commit();

            return entities;
        } catch (Exception ex) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
            }
            throw new RuntimeException(ex);
        } finally {
            session.close();
        }
    }

}
