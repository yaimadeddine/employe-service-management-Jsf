/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import beans.Service;
import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author yoaim
 */
public class ServiceService extends AbstractService<Service> {

    @Override
    public List<Service> getAll() {
        List<Service> services = null;
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        services = session.createQuery("from Service").list();
        session.getTransaction().commit();
        return services; 
    }

    @Override
    public Service getById(int id) {
        Service service = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        service = (Service) session.get(Service.class, id);
        session.getTransaction().commit();
        return service;
    }

    @Override
    public boolean delete(Service o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(o);
        session.flush();
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean update(Service o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean create(Service o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    protected Class<Service> getEntityClass() {
        return Service.class;
    }

}
