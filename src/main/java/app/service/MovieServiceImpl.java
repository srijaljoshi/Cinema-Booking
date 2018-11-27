package app.service;

import app.dao.IAddressDao;
import app.dao.IAdminDao;
import app.dao.ICustomerDao;
import app.dao.IMovieDao;
import app.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MovieServiceImpl implements IMovieService {

    @Autowired
    private IMovieDao movieDao;

    @Transactional
    @Override
    public List<Movie> listMovies() {
        return movieDao.listAll();
    }

    @Transactional
    @Override
    public int deleteMovie(int id) {
        try {
            movieDao.delete(id);
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }



    @Transactional
    @Override
    public void saveMovie(Movie m) {
        movieDao.save(m);
    }

    @Transactional
    @Override
    public List<Movie> findByTitle(String title) {
        return movieDao.findByTitle(title);
    }

    @Transactional
    @Override
    public Movie findById(Integer id) {
        return movieDao.findById(id);
    }


}
