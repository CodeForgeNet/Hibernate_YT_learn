package com.tut;

import java.util.Date;

import org.hibernate.Session;

// Hibernate using xml file...

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Project Started ..." );
//        SessionFactory factory = new Configuration().configure().buildSessionFactory();
//        or 
        Configuration cfgn = new Configuration();
        cfgn.configure("hibernate.cfg.xml");
        SessionFactory sf = cfgn.buildSessionFactory();
        
//        System.out.println(sf);
//        System.out.println(sf.isClosed());
        
//        Creating Student object
        Student st = new Student();
        st.setId(103);
        st.setName("Rin");
        st.setCity("LEAFvlg");
        
        System.out.println(st);
        
        
//        Creating Address object
        Address ad = new Address();
        ad.setStreet("street1");
        ad.setCity("delhi");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(123.456);  // This value didn't go to DB bcoz we ignore the column 
        
        
        
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(st); //Save student object
        // Then go to hibernate.cfg.xml file and change the hbm2ddl value 'update' to 'create'. After applying 'create' it will delete the old table and create both the new table.
        // And map the Address class to hibernate.cfg.xml
        session.save(ad); // Save address object 
        tx.commit();
        
        
        
        session.close();
        
    }
}
