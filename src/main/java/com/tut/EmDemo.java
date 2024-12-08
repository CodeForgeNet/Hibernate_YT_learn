package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
	public static void main(String[] args) {
		
		Configuration cfgn = new Configuration();
        cfgn.configure("hibernate.cfg.xml");
        SessionFactory sf = cfgn.buildSessionFactory();
        
        //one data
        Student st1 = new Student();
        st1.setId(1232);
        st1.setName("karanSingh");
        st1.setCity("lucknow");
        
        Certificate ctft1 = new Certificate();
        ctft1.setCourse("Android");
        ctft1.setDuration("2 months");
        
        st1.setCerti(ctft1);
        
        //second data
        Student st2 = new Student();
        st2.setId(4564);
        st2.setName("Luffy");
        st2.setCity("eastBlue");
        
        
        Certificate ctft2 = new Certificate();
        ctft2.setCourse("OnePiece");
        ctft2.setDuration("10 year");
        
        st2.setCerti(ctft2);
        
//        
        Session s = sf.openSession();
        Transaction ts = s.beginTransaction();
        
//        Save Objects
        s.save(st1);
        s.save(st2);
        
        
        
        
        ts.commit();
        s.close();
        sf.close();
	}

}
