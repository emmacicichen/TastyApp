package com.myprojects.tastyapp.dao;

import com.myprojects.tastyapp.entity.Authorities;
import com.myprojects.tastyapp.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {
    @Autowired
    private SessionFactory sessionFactory;

    /*
    * 1. assign an authority for the new customer
    * 2. get session from SessionFactory
    * 3. define unit of work by Transaction
    * 4. save in db
    * */
    public void signUp(Customer customer) {
        Authorities authorities = new Authorities();
        authorities.setAuthorities("ROLE_USER");
        authorities.setEmail(customer.getEmail());

        Session session = null;
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(authorities);
            session.save(customer);
            session.getTransaction().commit();

        } catch(Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();

        } finally {
            if(session != null) {
                session.close();
            }
        }

    }

    public Customer getCustomer(String email) {
        Customer customer = null;
        try(Session session = sessionFactory.openSession()) {
            customer = session.get(Customer.class, email);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return customer;
    }

}
