//package com.lti.daos;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertNull;
//
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//import org.h2.tools.RunScript;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.MockedStatic;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import com.lti.daos.EmployeeDao;
//import com.lti.daos.EmployeePostgres;
//import com.lti.uitl.ConnectionUtil;
//
//@ExtendWith(MockitoExtension.class)
//public class EmployeeDaoTest {
//	
//	private EmployeeDao ed = new EmployeePostgres();
//	private static MockedStatic<ConnectionUtil> mockedConnectionUtil;
//	private static Connection connection;
//	
//	@BeforeAll
//	public static void init() throws SQLException{
//		/*
//		 * Mocking the ConnectionUtil class for the getConnectionFromEnv method to return
//		 * a connection to the H2 while the mock is "open".
//		 */
//		mockedConnectionUtil = Mockito.mockStatic(ConnectionUtil.class);
//		mockedConnectionUtil.when(ConnectionUtil::getConnectionFromEnv)
//				.then(I -> getH2Connection());
//	}
//	@AfterAll
//	public static void end() {
//		/*
//		 * Closing resource, mocked behavior ends.
//		 */
//		mockedConnectionUtil.close();
//	}
//
//	@BeforeEach
//	public void setUp() {
//		try (Connection c = ConnectionUtil.getConnectionFromEnv()) {
//			RunScript.execute(c, new FileReader("setup.sql"));
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@AfterEach
//	public void tearDown() {
//		try (Connection c = ConnectionUtil.getConnectionFromEnv()) {
//			RunScript.execute(c, new FileReader("teardown.sql"));
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void getByIdExists() {
//		/*
//		 * Probably should test for that the fields are the same as well
//		 */
//		assertNotNull(ed.getEmployeeByID(1));
//	}
//
//	@Test
//	public void getIdNotExists() {
//		assertNull(ed.getEmployeeByID(10));
//	}
//	
//	/*
//	 * Used to create a connection to our H2/ in memory db instead of "production" database
//	 */
//	public static Connection getH2Connection() {
//		try {
//			if (connection == null || connection.isClosed()) {
//				connection = DriverManager.getConnection("jdbc:h2:~/test");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return connection;
//	}
//}
//
