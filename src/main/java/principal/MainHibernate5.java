package principal;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entidades.Countries;
import entidades.Regions;
import entidades.RegistroSecuencia;

public class MainHibernate5 {
	public static void main(String[] args) {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		Session sesion = sf.openSession();
		Transaction tx= null;
		
		try{
			tx= sesion.beginTransaction();
			RegistroSecuencia s1 = new RegistroSecuencia();
			RegistroSecuencia s2 = new RegistroSecuencia();
			RegistroSecuencia s3 = new RegistroSecuencia();
			
			sesion.save(s1);
			sesion.save(s2);
			sesion.save(s3);
			
			tx.commit();
			
		}catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}

		
		sesion.close();
		sf.close();
	
	}
}
