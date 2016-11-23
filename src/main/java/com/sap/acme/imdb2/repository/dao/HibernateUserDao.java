package com.sap.acme.imdb2.repository.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sap.acme.imdb2.entity.Movie;
import com.sap.acme.imdb2.entity.User;
import com.sap.acme.imdb2.repository.interfaces.UserDao;

@Repository
public class HibernateUserDao implements UserDao{

	private SessionFactory sessionFactory;
	
	@Autowired
	public HibernateUserDao(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findUsers() {
		try(Session session = sessionFactory.openSession()){
			return session.createQuery("from User").getResultList();
		}
	}
	
	@Override
	public User findByUsername(String username) {
		try(Session session = sessionFactory.openSession()){
			DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
			criteria.add(Restrictions.eq("username", username));
			return (User) criteria.getExecutableCriteria(session).uniqueResult();
		}
	}

	@Override
	public User findUserById(Long id) {
		try(Session session = sessionFactory.openSession()){
			return session.get(User.class, id);
		}
	}
	
	@Override
	public void save(User user) {
		Transaction transaction = null;
		try(Session session = sessionFactory.openSession()){
			transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
		}catch(Exception e){
			transaction.rollback();
		}
	}

	@Override
	public void update(User user) {
		Transaction transaction = null;
		try(Session session = sessionFactory.openSession()){
			transaction = session.beginTransaction();
			session.update(user);
			transaction.commit();
		}catch(Exception e){
			transaction.rollback();
		}
	}

	@Override
	public boolean haveMovieOnWishlist(Long userId, Long movieId) {
		return findWishlist(userId).stream().anyMatch(movie -> movie.getId().equals(movieId));
	}

	@Override
	public List<Movie> findWishlist(Long userId) {
		if(userId == 0){
			return new ArrayList<Movie>();
		}
		return new ArrayList<Movie>(findUserById(userId).getWishlist());
	}
}
