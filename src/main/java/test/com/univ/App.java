package test.com.univ;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.univ.Person;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
		EntityManager entityManager = emf.createEntityManager();
		
		EntityTransaction tx = entityManager.getTransaction();
		
		try{
			
			tx.begin();
			
			Person person = new Person();
			person.setName("Tintin");
			
			entityManager.persist(person);
			
			tx.commit();
			
		}catch(Exception e){
			tx.rollback();
		}
		
	}
}
