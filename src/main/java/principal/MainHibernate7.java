package principal;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

import entidades.Countries;
import entidades.Employees;
import entidades.Regions;

public class MainHibernate7 {

	public static void main(String[] args) {
		
		StandardServiceRegistry registry = 
				new StandardServiceRegistryBuilder().configure().build(); 
		
		SessionFactory sf = 
		new MetadataSources(registry).buildMetadata().buildSessionFactory();
		
		
		Session sesion = sf.openSession();
		Transaction tx = null;
		
		try {
			tx = sesion.beginTransaction();
			Employees emp_aux = null;
			
			SQLQuery query = sesion.createSQLQuery("select * from employees");
			query.addEntity(Employees.class);
			List<Employees> lista_emp = query.list();
			
			for (Employees e : lista_emp){
				System.out.println(e.getFirstName() + " " + e.getEmployeeId());
				e.setFirstName(e.getFirstName() + "_mod");
			}
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
				
		
		sesion.close();
		sf.close();
		
		
	}
}