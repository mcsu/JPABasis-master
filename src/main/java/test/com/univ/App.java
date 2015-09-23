package test.com.univ;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.univ.Person;
import com.univ.Rent;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	// manager1 voir fichier persistence.xml
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
		EntityManager entityManager = emf.createEntityManager();
		
		EntityTransaction tx = entityManager.getTransaction();
		
		try{
			
			tx.begin();
			
			Person person = new Person();
			person.setName("Tintin");
			
			entityManager.persist(person);
			
			Rent rent = new Rent();
			
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date beginDate = dateFormat.parse("23/09/2015");
			rent.setBeginRent(beginDate);
			
			Date endDate = dateFormat.parse("25/09/2015");
			rent.setEndRent(endDate);
	
			entityManager.persist(rent);
			
			tx.commit();
			
		}catch(Exception e){
			tx.rollback();
		}
		
	}
}
