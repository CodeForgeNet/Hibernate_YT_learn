package com.OneToManyMapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo2 {
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		
//		Creating question
		Question2 q1 = new Question2();
		q1.setQuestionId(1212);
		q1.setQuestions("What is java ?");
		
		
//		Creating Answer
		Answer2 ans1 = new Answer2();
		ans1.setAnswerId(343);
		ans1.setAnswers("Java is a programming language.");
		ans1.setQuest(q1);
		
//		Creating Another Answer
		Answer2 ans2 = new Answer2();
		ans2.setAnswerId(33);
		ans2.setAnswers("With the help of java we can create softwares.");
		ans2.setQuest(q1);
		
//		Creating Another Answer
		Answer2 ans3 = new Answer2();
		ans3.setAnswerId(363);
		ans3.setAnswers("Java has different types of framework.");
		ans3.setQuest(q1);
		
		  
		List<Answer2> list = new ArrayList<Answer2>();
		list.add(ans1);
		list.add(ans2);
		list.add(ans3);
		
		q1.setAnswers(list);
		
		
		
		
//		Session
		Session s = sf.openSession();
		
//		Transaction begin
		Transaction ts = s.beginTransaction();
		
		
//		save
		 s.save(q1);
		 s.save(ans1);
		 s.save(ans2);
		 s.save(ans3);

		
		
		ts.commit();
		
		
//		Data Fetch (after applying mapped by in answer class)
//		Question disQ = (Question)s.get(Question.class, 1212);
//		System.out.println(disQ.getQuestions());
//		System.out.println(disQ.getAnswer().getAnswers());
		
		
		
		
		
		s.close();
		sf.close();
	}

}
