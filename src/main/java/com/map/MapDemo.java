package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		
		
//		Session
		Session s = sf.openSession();
		
//		Transaction begin
		Transaction ts = s.beginTransaction();
		
		
//		Creating question
		Question q1 = new Question();
		q1.setQuestionId(1212);
		q1.setQuestions("What is java ?");
		
		
//		Creating Answer
		Answer ans1 = new Answer();
		ans1.setAnswerId(343);
		ans1.setAnswers("Java is a programming language.");
		
		q1.setAnswer(ans1); //Setting answer in question table.
		
		
		
//		Creating question
		Question q2 = new Question();
		q2.setQuestionId(242);
		q2.setQuestions("What is collection framework ?");
		
		
//		Creating Answer
		Answer ans2 = new Answer();
		ans2.setAnswerId(344);
		ans2.setAnswers("API to work with objects in java.");
		
		q1.setAnswer(ans2); //Setting answer in question table.
		
		
		

		
		
//		save
		 s.save(q1);
		 s.save(q2);
		
		
		
		ts.commit();
		s.close();
		sf.close();
	}

}
