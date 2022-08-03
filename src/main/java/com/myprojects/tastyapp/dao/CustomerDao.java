package com.myprojects.tastyapp.dao;

import com.myprojects.tastyapp.entity.Authorities;
import com.myprojects.tastyapp.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//@Repository
//public class CustomerDao {
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    /*
//    * 1. assign an authority for the new customer
//    * 2. get session from SessionFactory
//    * 3. define unit of work by Transaction
//    * 4. save in db
//    * */
//    public void signUp(Customer customer) {
//        Authorities authorities = new Authorities();
//        authorities.setAuthorities("ROLE_USER");
//        authorities.setEmail(customer.getEmail());
//
//        Session session = null;
//        try{
//            session = sessionFactory.openSession();
//            session.beginTransaction();
//            session.save(authorities);
//            session.save(customer);
//            session.getTransaction().commit();
//
//        } catch(Exception ex) {
//            ex.printStackTrace();
//            session.getTransaction().rollback();
//
//        } finally {
//            if(session != null) {
//                session.close();
//            }
//        }
//
//    }
//
//    public Customer getCustomer(String email) {
//        Customer customer = null;
//        try(Session session = sessionFactory.openSession()) {
//            customer = session.get(Customer.class, email);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return customer;
//    }
//
//}



@Repository
public class CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void signUp(Customer customer) {
        System.out.println("DAO layer");
        System.out.println(customer);
        Authorities authorities = new Authorities();
        authorities.setAuthorities("ROLE_USER");
        authorities.setEmail(customer.getEmail());

        Customer customer1 = new Customer();
        customer1.setEmail(customer.getEmail());

        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(authorities);
            session.save(customer);
            session.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            if (session != null) session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Customer getCustomer(String email) {
//        Customer customer = null;
//        try (Session session = sessionFactory.openSession()) {
//            customer = session.get(Customer.class, email);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return customer;
        Customer customer = null;
        Session session = null;

        try {//读的时候，不考虑多线程（多个操作同时对一个data进行读和写）我们就不用开transaction
            session = sessionFactory.openSession();//这里如果没有
            customer = session.get(Customer.class, email); //get(class, primary key:identifier)
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
        return customer;
    }
}
