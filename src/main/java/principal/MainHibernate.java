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

public class MainHibernate {
	public static void main(String[] args) {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		Session sesion = sf.openSession();
		Transaction tx= sesion.beginTransaction();
		
		Regions region = sesion.get(Regions.class, new BigDecimal(1));
		System.out.println(region.getRegionName());
		System.out.println(region.getRegionId());
		
		System.out.println("ACCEDIENDO A LISTA PAISES");
		Set<Countries> conjunto_paises = region.getCountrieses();
		//recorro cojunto
		Iterator<Countries> it = conjunto_paises.iterator();
		while(it.hasNext())
		{
			Countries pais = it.next();
			System.out.println(pais.getCountryName() + " " + pais.getCountryId());
		}
		
		tx.commit();
		sesion.close();
		sf.close();
	}
}
