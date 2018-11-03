package app.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import app.models.Address;

@Repository("addressDao")
public class AddressDaoImpl implements IAddressDao{
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SessionFactory sessionFactory;

	@Override
	public List<Address> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(Address address, int customerId) {
		System.out.println("saving address with customerId: "  + customerId);
		String INSERT_SQL = "insert into Address (customerID, street, city, state, zipCode) values(?,?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(
				new PreparedStatementCreator() {
	    			public PreparedStatement createPreparedStatement(java.sql.Connection connection) throws SQLException {
	    				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] {"id"});
	    				ps.setInt(1, customerId);
	    				ps.setString(2, address.getStreet());
	    				ps.setString(3, address.getCity());
	    				ps.setString(4, address.getState());
	    				ps.setInt(5, address.getZipCode());
	    				return ps;
	    			}
				},
				keyHolder);
		System.out.println("done printing address: " + keyHolder.getKey());
		return keyHolder.getKey().intValue();
	}

	@Override
	public Address findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Address address) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeById(int id) {
		// TODO Auto-generated method stub
		
	}
    
    
}
