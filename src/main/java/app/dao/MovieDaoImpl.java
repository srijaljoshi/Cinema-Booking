package app.dao;

import app.models.Movie;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieDaoImpl implements IMovieDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Movie> listAll() {
        return sessionFactory.getCurrentSession().createQuery("from Movie").list();
    }

    @Override
    public void delete(int id) {
        sessionFactory.getCurrentSession().createQuery("delete from Movie where id=:mid").setInteger("mid", id).executeUpdate();
    }

    @Override
    public void save(Movie m) {
        sessionFactory.getCurrentSession().persist(m);
    }
}
