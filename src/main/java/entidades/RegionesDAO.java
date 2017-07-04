package entidades;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class RegionesDAO {
	
	private SessionFactory sf;
	
	public RegionesDAO (SessionFactory sf)
	{
		this.sf = sf;
	}
	
	
	//CREAR
	public boolean create(Regions region)
	{
		Regions region_nueva = new Regions();
		
		Session sesion = this.sf.openSession();
		Transaction tx = sesion.beginTransaction();
		region_nueva.setRegionId(new BigDecimal(231));
		region_nueva.setRegionName("Lugar");
		sesion.save(region_nueva);
		tx.commit();
		sesion.close();
		
		return true;
	}
	
	//UPDATE
	public boolean update (Regions region_nueva)
	{
		Session sesion = this.sf.openSession();
		Transaction tx = sesion.beginTransaction();
		region_nueva.getRegionId();
		region_nueva.getRegionName();
		region_nueva.setRegionId(new BigDecimal(212));
		region_nueva.setRegionName("Lugar Modificado");
		sesion.save(region_nueva);
		tx.commit();
		sesion.close();
		
		return false;
	}
	
	//READ
	public Regions read(BigDecimal id_region)
	{
		Regions region = null;
		
			Session sesion = this.sf.openSession();
			Transaction tx = sesion.beginTransaction();
			sesion.get(Regions.class, id_region);
			tx.commit();
			sesion.close();
			
		return region;
	}
	
	//DELETE
	public boolean delete (BigDecimal id_region)
	{
		return false;
	}
	
}
