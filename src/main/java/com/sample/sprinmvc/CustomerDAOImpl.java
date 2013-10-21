package com.sample.sprinmvc;

import java.util.ArrayList;
import java.util.UUID;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class CustomerDAOImpl implements CustomerDAO{

	private Cluster cluster;
	private Session session;

	private String host;
	private String port;
	
	public CustomerDAOImpl(String host, String port){
		this.host = host;
		this.port = port;
	}
	
	public CustomerDAOImpl() {
		
	}
	
	public void connect(String node) 
	{
		cluster = Cluster.builder()
				.addContactPoint(node).build();
		Metadata metadata = cluster.getMetadata();
		System.out.printf("Connected to cluster: %s\n", 
				metadata.getClusterName());

		for ( Host host : metadata.getAllHosts()) 
		{
			System.out.printf("Datatacenter: %s; Host: %s; Rack: %s\n",
					host.getDatacenter(), host.getAddress(), host.getRack());
		}
		session = cluster.connect();

	}

	public Session getSession()
	{
		return session;
	}

	public UUID insertData(CustomerDTO CustomerDTO) 
	{ 
		System.out.println(host);
		System.out.println(port);
		
		connect(host);
		//session.execute("use testdemo");
		PreparedStatement statement = getSession().prepare(
				"INSERT INTO testdemo.Customer " +
						"(id, firstname, lastname, dob, address) " +
				"VALUES (?, ?, ?, ?, ?);");

		BoundStatement boundStatement = new BoundStatement(statement);
		CustomerDTO.setFriendid(UUID.randomUUID());

		getSession().execute(boundStatement.bind(
				CustomerDTO.getFriendid(),
				CustomerDTO.getFirstname(),
				CustomerDTO.getLastname(),
				CustomerDTO.getDateofbirth(),
				CustomerDTO.getAddress()
				) );

		return CustomerDTO.getFriendid();
	}

	public ArrayList<CustomerDTO> getAllCustomers() 
	{ 
		connect(host);
		ResultSet results;
		ArrayList<CustomerDTO>friends = new ArrayList<CustomerDTO>();

		PreparedStatement statement = getSession().prepare(
				"SELECT * FROM testdemo.Customer ");

		BoundStatement boundStatement = new BoundStatement(statement);

		results = getSession().execute(boundStatement.bind());

		for (Row row : results)
		{
			CustomerDTO CustomerDTO = new CustomerDTO();

			CustomerDTO.setFriendid(row.getUUID("id"));
			CustomerDTO.setAddress(row.getString("address"));
			CustomerDTO.setDateofbirth(row.getString("dob"));
			CustomerDTO.setFirstname(row.getString("firstname"));
			CustomerDTO.setLastname(row.getString("lastname"));

			friends.add(CustomerDTO);
		}

		return friends;
	}

	public CustomerDTO getCustomer(UUID uuid) 
	{ 
		connect(host);
		CustomerDTO friend = new CustomerDTO();
		friend.setFriendid(null);
		ResultSet results; 
		PreparedStatement statement = getSession().prepare(
				"SELECT * FROM testdemo.Customer WHERE id = ?");

		BoundStatement boundStatement = new BoundStatement(statement);

		results = getSession().execute(boundStatement.bind(uuid));

		Row row = results.one();

		if(row == null)
			return null;

		friend.setFriendid(row.getUUID("id"));
		friend.setAddress(row.getString("address"));
		friend.setDateofbirth(row.getString("dob"));
		friend.setFirstname(row.getString("firstname"));
		friend.setLastname(row.getString("lastname"));

		return friend;
	}

	public void deleteCustomer(UUID uuid)
	{
		connect(host);
		PreparedStatement statement = getSession().prepare(
				"DELETE FROM testdemo.Customer WHERE id = ?");

		BoundStatement boundStatement = new BoundStatement(statement);

		getSession().execute(boundStatement.bind(uuid));
	}

	public boolean UpdateCustomer(CustomerDTO friend)
	{
		connect(host);
		PreparedStatement statement = getSession().prepare(
				"INSERT INTO testdemo.Customer " +
						"(id, firstname, lastname, dob, address) " +
				"VALUES (?, ?, ?, ?, ?);");

		BoundStatement boundStatement = new BoundStatement(statement);

		getSession().execute(boundStatement.bind(
				friend.getFriendid(),
				friend.getFirstname(),
				friend.getLastname(),
				friend.getDateofbirth(),
				friend.getAddress()));
		return true;
	}

	public void close() 
	{
		cluster.shutdown();
	}
}
