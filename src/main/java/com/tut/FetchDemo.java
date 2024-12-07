package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	public static void main(String[] args) {

//		get,load
		Configuration cfgn = new Configuration();
        cfgn.configure("hibernate.cfg.xml");
        SessionFactory sf = cfgn.buildSessionFactory();
        Session session = sf.openSession();
//        There is no need of transaction because we don't have to save any data. Transaction use where we have to save the data.
        
        
//        get-student 
//        Student st = (Student)session.load(Student.class, 104); //load is depricated.
//        or
        Student st = (Student)session.get(Student.class, 104); 
        System.out.println(st);
        
//        get-address 
        Address adr = (Address)session.get(Address.class, 2);
        System.out.println(adr.getCity()+" , "+adr.getStreet());
        
        
        
        
        
		session.close();
        sf.close();
	}
}
