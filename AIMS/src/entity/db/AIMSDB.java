package entity.db;

import java.sql.DriverManager;
import java.util.logging.Logger;

import java.sql.Connection;
import utils.*;
/**
 * Thực hiện đúng Single Responsibility:
 * Thực hiện các chức năng kết nối Database
 */
public class AIMSDB {

	private static Logger LOGGER = Utils.getLogger(Connection.class.getName());
	private static Connection connect;

    /**
     * Functional cohesion
     *
     */
    public static Connection getConnection() {
        if (connect != null) return connect;
        try {
			Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:assets/db/aims.db";
            connect = DriverManager.getConnection(url);
            LOGGER.info("Connect database successfully");
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        } 
        return connect;
    }

}
