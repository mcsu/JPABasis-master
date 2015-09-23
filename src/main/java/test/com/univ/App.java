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

import com.univ.Car;
import com.univ.Person;
import com.univ.Rent;
import com.univ.Van;

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
		
			
		tx.begin();
		
		Car car = new Car();
		car.setPlateNumber("AA 11 BB");	// clef primaire
		car.setNumberOfSeats(5);
		
		Van van = new Van();			
		van.setMaxWeight(1000);
		van.setPlateNumber("CC 22 DD");	// clef primaire
		
		try{
			entityManager.persist(van);
			tx.commit();
			
			Van van1 = entityManager.find(Van.class, "CC 22 DD");
			
			tx.begin();
			entityManager.persist(car);
			tx.commit();
		}catch(Exception e){
				// ici si clef primaire existe déjà
			try{
				tx.rollback();	// annule les persit
			}catch(Exception e1){
				// recapture l'excdeption générée par le rollback
			}
		}
				
		try{
			tx = entityManager.getTransaction();
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
			
			List<Rent> rents = person.getRents();
			rents.add(rent);	// mise  à jour du côté many de l'association
			
			rent.setPerson(person);	// mise à jour du côté one de l'association
				
			tx.commit();
			
			List<Person> liste = entityManager.createQuery("select p from Person p where p.name like 'Tintin'").getResultList();
			for(Person p : liste){
				System.out.println("person = " + p);
			}
		}catch(Exception e){
			tx.rollback();
		}
		
	}
}
