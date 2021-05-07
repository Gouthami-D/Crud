package com.crud.Employee1.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crud.Employee1.Model.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	// define field for entitymanager :JPA EntityManager is used to access a
	// database in a particular application.
	private EntityManager entityManager;

	// constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override

	public List<Employee> findAll() {

		// get he current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// create a Query
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);

		List<Employee> employees = theQuery.getResultList();

		return employees;
	}

	@Override
	public Employee findById(int theId) {
		//get the current session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//get the Employee
		Employee theEmployee = currentSession.get(Employee.class, theId);
		
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		//get the current session
		Session currentSession= entityManager.unwrap(Session.class);
		
		//save Employee
		currentSession.saveOrUpdate(theEmployee);
		
	}

	@Override
	public void deleteById(int theId) {
		//get the current Hibernate Session
		Session currentSession = entityManager.unwrap(Session.class);
		Query theQuery= currentSession.createQuery
				("delete From Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
				
		
		
	}

}
