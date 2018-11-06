package app.dao;

import app.models.Customer;
import org.hibernate.SessionFactory;
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

@Repository("customerDao")
public class CustomerDaoImpl implements ICustomerDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> listAll() {
//        return jdbcTemplate.query("select * from Customer", new RowMapper<Customer>() {
//
//            @Override
//            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
//                Customer c = new Customer();
//                c.setId(rs.getInt("id"));
//                c.setEmail(rs.getString("email"));
//                c.setPassword(rs.getString("password"));
//                c.setFirstName(rs.getString("firstName"));
//                c.setLastName(rs.getString("lastName"));
//                return c;
//            }
//        });

        return sessionFactory.getCurrentSession().createQuery("from Customer").list();
    }

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

    /**
     * Function checks if a customer is already in the database and returns their information
     *
     * @param email
     * @param password
     * @return customer object
     */
    @Override
    public Customer queryCustomer(String email, String password) {
        System.out.println("querying customer");
        String query = "select id, firstName, lastName, statusID, enrolledForPromotions from Customer where email = ? and password = ?";
        Customer customer = this.jdbcTemplate.queryForObject(query, new Object[]{email, password}, new RowMapper<Customer>() {
            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                Customer customer = new Customer();
                customer.setFirstName(rs.getString("firstName"));
                customer.setLastName(rs.getString("lastName"));
                customer.setEmail(email);
                customer.setId(rs.getInt("id"));
                customer.setEnrolledForPromotions(rs.getInt("enrolledForPromotions"));
                customer.setPassword(password);
                return customer;
            }

        });
        System.out.println("done querying customer");
        return customer;
    }
}
