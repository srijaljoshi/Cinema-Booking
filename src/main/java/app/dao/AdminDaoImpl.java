package app.dao;

import app.models.Admin;
import app.models.Customer;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("adminDao")
public class AdminDaoImpl implements IAdminDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SessionFactory sessionFactory;
    
    /**
     * This function save a customer into the database
     *
     * @param customer object
     */
    @Transactional
    @Override
    public int save(Customer customer) {
        System.out.println("insert a customer into DB");
        //        sessionFactory.getCurrentSession().persist(customer);
        String INSERT_SQL = "insert into Customer (statusID, firstName, lastName, email, password, enrolledForPromotions) values(?,?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(java.sql.Connection connection) throws SQLException {
                        PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[]{"id"});
                        ps.setInt(1, 1);
                        ps.setString(2, customer.getFirstName());
                        ps.setString(3, customer.getLastName());
                        ps.setString(4, customer.getEmail());
                        ps.setString(5, customer.getPassword());
                        ps.setInt(6, 0);
                        return ps;
                    }
                },
                keyHolder);
        System.out.println(keyHolder.getKey());
        return keyHolder.getKey().intValue();
    }

    @Override
    public Customer findById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void update(Customer customer) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeById(int id) {
        // TODO Auto-generated method stub

    }

    @Override
    public Admin getAdmin(String email, String password) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Admin where email= :admin_email and password= :admin_password");
        query.setParameter("admin_email", email);
        query.setParameter("admin_password", password);
        Admin admin = (Admin) query.list().get(0);
        return admin;

    }

}
