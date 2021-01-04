package no.bibsys.overdueNotices;

	import org.apache.commons.dbcp.ConnectionFactory;
	import org.apache.commons.dbcp.DriverManagerConnectionFactory;
	import org.apache.commons.dbcp.PoolableConnectionFactory;
	import org.apache.commons.dbcp.PoolingDataSource;
	import org.apache.commons.pool.ObjectPool;
	import org.apache.commons.pool.impl.GenericObjectPool;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	import javax.sql.DataSource;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	public class OverdueConnectionManagerSQL {

		private DataSource dataSource = null;
		private GenericObjectPool<?> pool = null;
		private final static transient Logger log = LoggerFactory.getLogger(OverdueConnectionManagerSQL.class);

		private static int maxActiveConnections = 25;
		
		private static OverdueConnectionManagerSQL INSTANCE;
		
		private static final String DIGITALTSHADOW_URL= OverdueConfig.getProperty("DIGITALTSHADOW_URL", "jdbc:mysql://mysql-utvikle:3306/digitaltshadow?autoReconnect=true"); 
		private static final String DIGITALTSHADOW_USER=OverdueConfig.getProperty("DIGITALTSHADOW_USER", "shadow");
		private static final String  DIGITALTSHADOW_PASSWORD=OverdueConfig.getProperty("DIGITALTSHADOW_PASSWORD", "shadow");

		private OverdueConnectionManagerSQL() {
			this(DIGITALTSHADOW_URL, DIGITALTSHADOW_USER, DIGITALTSHADOW_PASSWORD, maxActiveConnections);
		}
		
		private OverdueConnectionManagerSQL(String uri, String user, String password, int maxActiveConnections)
		{
	        if(uri == null || uri.isEmpty() || user == null || user.isEmpty() || password == null || password.isEmpty()) {
	            throw new IllegalArgumentException("uri, user, pass cannot be null (Missing in overdue.properties?)");
	        }
	        dataSource = setupDataSource(uri.trim(), user.trim(), password.trim(), maxActiveConnections);
		}

		/**
		 *
		 * @param connectURI - JDBC Connection URI
		 * @param username - JDBC Connection username
		 * @param password - JDBC Connection password
		 * @throws Exception
		 */
		private  DataSource setupDataSource(String connectURI, String username, String password, int maxActiveConnections) {
			GenericObjectPool<?> connectionPool = new GenericObjectPool<>(null,maxActiveConnections);
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				log.error("",e);
			}
            log.debug("--------------------------------------------------------------------------");
            log.debug("uri = {}, user = {}, password = {}", connectURI, username, password);
            log.debug("--------------------------------------------------------------------------");
			pool = connectionPool; 
			ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(connectURI, username, password);
			new PoolableConnectionFactory(connectionFactory, connectionPool, null, "SELECT 1", 2, false, true); // Puts PoolableCOnnectionFactory as factory into connectionPool 

			return new PoolingDataSource(connectionPool);
		}

		public void printDriverStats(){
			ObjectPool<?> connectionPool = pool;
			log.info("NumActive: " + connectionPool.getNumActive());
			log.info("NumIdle: " + connectionPool.getNumIdle());
		}

		/**
		 *  getNumLockedProcesses - gets the 
		 *  number of currently locked processes on the MySQL db
		 *
		 *  @return Number of locked processes
		 */
		public int getNumLockedProcesses()
		{
			int numLockedConnections = 0;
			try(Connection con = dataSource.getConnection(); PreparedStatement preparedStatement = con.prepareStatement("SHOW PROCESSLIST"); ResultSet result = preparedStatement.executeQuery()){
				while(result.next())
				{
					if(result.getString("State") != null && result.getString("State").equals("Locked"))
					{
						numLockedConnections++;
					}
				}
			} catch (SQLException e) {
				log.error("", e);
			}
			return numLockedConnections;
		}
	    
		/**
		 * checkConnection - 
	     * a simple query that validates the connection
	     * used to warm up connections
		 *
	     * @param conn
		 * @return true if the connection is valid
		 */
		public static boolean checkConnection(Connection conn){
			try(
	                PreparedStatement preparedStatement = conn.prepareStatement("SELECT 1"); 
	                ResultSet result = preparedStatement.executeQuery()){
				while(result.next()) {
					if("1".equals(result.getString(1))) {
						return true;
					}
				}
			} catch (SQLException e) {
				log.debug("", e);
			}
			return false;
		}
		
		public static Connection getConnection() throws SQLException {
			long startTime = System.currentTimeMillis();
			try {
			if (INSTANCE == null) {
				INSTANCE = new OverdueConnectionManagerSQL();
			}
	        Connection conn = INSTANCE.dataSource.getConnection();
	        //A workaround for connection "timeout"/"expired" errors
	        //"The last packet successfully received from the server was 1 281 601 219 milliseconds ago.  The last packet sent successfully to the server was 1 281 601 219 milliseconds ago. is longer than the server configured value of 'wait_timeout'. You should consider either expiring and/or testing connection validity before use in your application, increasing the server configured values for client timeouts, or using the Connector/J connection property 'autoReconnect=true' to avoid this problem."
	        checkConnection(conn);
			return conn;
			} finally {
				long timeUsed = System.currentTimeMillis() - startTime;
				log.trace("TimeUsed getting connection {} ms.", timeUsed);
			}
		}
		
		
		public static void shutdown() {
			if (INSTANCE != null) {
				try {
					INSTANCE.pool.close();
				} catch (Exception e) {
					log.error("",e);
				}
			}
		}


		

}
