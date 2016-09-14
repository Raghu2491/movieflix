package io.egen.repository;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import io.egen.entity.Comments;

@Repository
public class CommentsRepositoryImp implements CommentsRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Comments> findByArguments(Map<String, String> params) {
		TypedQuery<Comments> query;
		if(params.get("movieId")!=null)
		{	
			query = em.createNamedQuery("Comment.findCommentByMovieId", Comments.class);
			query.setParameter("pMovieId", params.get("movieId")); 
		}
		else
			query = em.createNamedQuery("Comment.findAllComments", Comments.class);
		return query.getResultList();
	}

	@Override
	public Comments findById(String id) {
		return em.find(Comments.class, id);
	}

	@Override
	public Comments create(Comments comment) {
		em.persist(comment);
		return comment;
	}

	@Override
	public Comments update(Comments emp) {
		return em.merge(emp);
	}

	@Override
	public void delete(Comments emp) {
		em.remove(emp);
	}
}
