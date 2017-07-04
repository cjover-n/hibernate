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
import entidades.RegistroUuid;

public class MainHibernate4 {
	public static void main(String[] args) {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		Session sesion = sf.openSession();
		Transaction tx= sesion.beginTransaction();
		
		try{
			tx= sesion.beginTransaction();
			RegistroUuid r1 = new RegistroUuid();
			RegistroUuid r2 = new RegistroUuid();
			RegistroUuid r3 = new RegistroUuid();
			
			sesion.save(r1);
			sesion.save(r2);
			sesion.save(r3);
			
			tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}

		
		sesion.close();
		sf.close();
	
	}
}
