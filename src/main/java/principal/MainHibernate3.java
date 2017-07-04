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
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

import entidades.Countries;
import entidades.Employees;
import entidades.Regions;

public class MainHibernate3 {

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
			BigDecimal salario_antiguo = null;
			BigDecimal salario_nuevo = null;
			
			for (int n_empleado = 100; n_empleado<=206; n_empleado++)
			{
				emp_aux = sesion.get(Employees.class, n_empleado);
				salario_antiguo = emp_aux.getSalary();
				salario_nuevo = salario_antiguo.multiply(new BigDecimal(1.07));
				emp_aux.setSalary(salario_nuevo);
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