package app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import app.models.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

	@Override
	public void save(Customer customer) {
//        System.out.println("Going to save the user!");
//        sessionFactory.getCurrentSession().persist(customer);
//        System.out.println(">> User " + customer.getEmail() + " saved to database successfully!!!");

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

}
