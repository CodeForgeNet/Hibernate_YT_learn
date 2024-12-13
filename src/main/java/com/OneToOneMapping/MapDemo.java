package com.OneToOneMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		
//		Creating question
		Question q1 = new Question();
		q1.setQuestionId(1212);
		q1.setQuestions("What is java ?");
		
		
//		Creating Answer
		Answer ans1 = new Answer();
		ans1.setAnswerId(343);
		ans1.setAnswers("Java is a programming language.");
		
		q1.setAnswer(ans1); //Setting answer in question table.
		
//		After making bidirectional oneToOne mapping
		ans1.setQ(q1);
		
		
		
//		Creating question
		Question q2 = new Question();
		q2.setQuestionId(242);
		q2.setQuestions("What is collection framework ?");
		
		
//		Creating Answer
		Answer ans2 = new Answer();
		ans2.setAnswerId(344);
		ans2.setAnswers("API to work with objects in java.");
		
		q2.setAnswer(ans2); //Setting answer in question table.
		
//		After making bidirectional oneToOne mapping
		ans1.setQ(q2);
		
		
		
//		Session
		Session s = sf.openSession();
		
//		Transaction begin
		Transaction ts = s.beginTransaction();
		
		
//		save
		 s.save(ans1);	// Save ans1 before using its reference in q1
		 s.save(q1);
		 s.save(ans2);	// Save ans2 before using its reference in q2
		 s.save(q2);
		
		
		
		ts.commit();
		
		
//		Data Fetch (after applying mapped by in answer class)
		Question disQ = (Question)s.get(Question.class, 1212);
		System.out.println(disQ.getQuestions());
		System.out.println(disQ.getAnswer().getAnswers());
		
		
		
		
		
		s.close();
		sf.close();
	}

}
