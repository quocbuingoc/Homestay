package com.quocbn.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.quocbn.model.Comment;

@Transactional
public class CommentDAOImpl implements CommentDAO {
	
	private SessionFactory sessionFactory;
	
	public CommentDAOImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> listCommentByHomestayId(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Comment where HomestayId = :homestayId");
		query.setParameter("homestayId", id);
		return query.list();
	}

	@Override
	public void addComment(Comment cm) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(cm);
	}
	
	

}
