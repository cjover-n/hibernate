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

public class MainHibernate2 {
	public static void main(String[] args) {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		Session sesion = sf.openSession();
		Transaction tx= sesion.beginTransaction();
		
		//TODO CREAR UNA ENTIDAD
		//Regions region = new Regions();
		//region.setRegionId(new BigDecimal(50));
		//region.setRegionName("ADALID");
		for (int i=100; i<200; i++){
			Regions rg = new Regions();
			rg.setRegionName(i + "");
			rg.setRegionId(new BigDecimal(i));
			sesion.save(rg);
		}
		
		
		tx.commit();
		sesion.close();
		sf.close();
	}
}
