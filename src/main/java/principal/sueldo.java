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
import entidades.Employees;
import entidades.Regions;

public class sueldo {
	public static void main(String[] args) {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		Session sesion = sf.openSession();
		Transaction tx= sesion.beginTransaction();
		
		BigDecimal salario = new BigDecimal(50);
		BigDecimal salario_nuevo = salario.multiply(new BigDecimal(1.07));
		
		
		for (int i= 0; i <= 206 ; i++){
			Employees empleado = sesion.get(Employees.class, i);
			empleado.setSalary(salario_nuevo);
		}
			
		
		tx.commit();
		sesion.close();
		sf.close();
	
	}
}
