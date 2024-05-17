package com.telusko;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;


public class App {
    public static void main(String[] args) {

        // creating session object

        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);

        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sessionfactory = con.buildSessionFactory(reg);
        System.out.println(sessionfactory);
        Session session = sessionfactory.openSession();

        Transaction tx = session.beginTransaction();


        //these types of hql query gives you array of object
        //to get a unique result
//        Query<Object[]> query = session.createQuery(
//                "select rollNo, marks, sname from Student where rollNo = 7", Object[].class
//        );
//        Object[] student = query.getSingleResult();
//
//        for (Object o : student) {
//            System.out.println(o);
//        }
//        System.out.println(student[0] +" "+ student[1] +" "+student[2]);


//-------------------------------------------------------------------------------------------------


        //to get a list of  student
//        Query<Object[]> query = session.createQuery(
//                "select rollNo, marks, sname from Student", Object[].class
//        );
//        List<Object[]> students = query.list();
//
//        for (Object[] student : students) {
//            System.out.println(student[0] + " " + student[1] + " " + student[2]);
//        }


//-------------------------------------------------------------------------------------------------


        //to get a list of  students with particular case i.e marks>60
//        Query<Object[]> query = session.createQuery(
//                "select rollNo, marks, sname from Student where marks>60", Object[].class
//        );
//        List<Object[]> students = query.list();
//
//        for (Object[] student : students) {
//            System.out.println(student[0] + " " + student[1] + " " + student[2]);
//        }


//-------------------------------------------------------------------------------------------------


        //to get addition of all the marks
//        Query<Long> query = session.createQuery(
//                "select sum(marks) from Student s where s.marks>60 ", Long.class
//        );
//      Object marks = query.uniqueResult();
//
//        System.out.println(marks);


//-------------------------------------------------------------------------------------------------


        //to get addition of all the marks
        int b=60;
        Query<Long> query = session.createQuery(
                "select sum(marks) from Student s where s.marks>:b", Long.class
        );
        query.setParameter("b",b);
      Object marks = query.uniqueResult();

        System.out.println(marks);

        tx.commit();

        session.close();
    }
}
