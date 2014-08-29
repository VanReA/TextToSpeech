package dataBase;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySQL {
	private String jdbcDRIVER;  
	
	private String dbURL;
	private String dbUser;
	private String dbPassword;
	
	private Connection connection;
	private Statement statement;
	private DatabaseMetaData metaData;
	
	public MySQL(){
		setJdbcDRIVER("com.mysql.jdbc.Driver");
		
		setDbURL("jdbc:mysql://198.23.57.16:3306/vanrea5_java");
		setDbUser("vanrea5_java");
		setDbPassword("1234");
		
		setConnection(null);
		setStatement(null);
		
		
		connect();
	}
	
	public void connect(){
		try {
			Class.forName(getJdbcDRIVER());
			setConnection(DriverManager.getConnection(getDbURL(), getDbUser(), getDbPassword()));
			setMetaData(getConnection().getMetaData());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<String> dispalyAllTables(){
		List<String> tablesList = new ArrayList<String>();
		try {
			ResultSet rs = getMetaData().getTables(null, null, "%", null);
			while (rs.next()) {
				  tablesList.add(rs.getString(3));
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tablesList;
	}
	
	public String createTable(String tableName, String fieldName, String fieldType){
		String status = "Error while creating a new table " + tableName + "!";
		
		try {
			setStatement(getConnection().createStatement());
			String sql = "CREATE TABLE " + tableName +
	                   "(" + fieldName +  fieldType + " not NULL, " +
	                   " first VARCHAR(255), " + 
	                   " last VARCHAR(255), " + 
	                   " age INTEGER, " + 
	                   " PRIMARY KEY ( id ))"; 
			getStatement().executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				getStatement().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		status = "Table " + tableName + "was created successfully!" ;
		return status;
	}
	
	public String insertRecord(String tableName, String value){
		String status = "Error while inserting a record into table " + tableName + "!";

		try {
			setStatement(getConnection().createStatement());
			String sql = "INSERT INTO " + tableName +
					"VALUES (" + value + ")";
			getStatement().executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				getStatement().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		status = "Insertion successfully completed!" ;
		return status;
	}
	

	
	//Getters and Setters
	public String getJdbcDRIVER() {
		return jdbcDRIVER;
	}

	public void setJdbcDRIVER(String jdbcDRIVER) {
		this.jdbcDRIVER = jdbcDRIVER;
	}

	public String getDbURL() {
		return dbURL;
	}

	public void setDbURL(String dbURL) {
		this.dbURL = dbURL;
	}

	public String getDbUser() {
		return dbUser;
	}

	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public DatabaseMetaData getMetaData() {
		return metaData;
	}

	public void setMetaData(DatabaseMetaData metaData) {
		this.metaData = metaData;
	}
}
