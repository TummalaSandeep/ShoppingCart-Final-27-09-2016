package com.niit.ShoppingCart.DAO;

import java.util.List;

import javax.persistence.TableGenerator;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ShoppingCart.model.Supplier;
@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO {
@Autowired


private SessionFactory sessionFactory;
public SupplierDAOImpl(SessionFactory sessionFactory ){
	this.sessionFactory=sessionFactory;
	
	
}
@Transactional
public boolean save(Supplier supplier){
	
	try {
		sessionFactory.getCurrentSession().save(supplier);
		return true;
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	
}
@Transactional
		public boolean update(Supplier supplier){
			try {
				sessionFactory.getCurrentSession().update(supplier);
				return true;
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		
		
/*@Transactional
		public boolean delete(int id){
			try {
				sessionFactory.getCurrentSession().delete();
				return true;
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}*/
		@Transactional
		public void delete(int id){
			Supplier SupplierToDelete=new Supplier();
			SupplierToDelete.setId(id);
			sessionFactory.getCurrentSession().delete(SupplierToDelete);
		
		}
@Transactional
public Supplier get(int id){
			
			String hql="from Supplier where id ="+id+"";
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			List<Supplier> list=query.list();
			
			if(list==null){
				return null;
			}
			else{
				return list.get(0);
			}
		}
@Transactional	
		public List<Supplier>list(){
		
			
			String hql="from Supplier";
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			return query.list();
}


		

public boolean update1(Supplier supplier)
{
try {
	sessionFactory.getCurrentSession().update(supplier);
	return true;
} catch (HibernateException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return false;
}

	
}
