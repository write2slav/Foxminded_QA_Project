package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBase {

	Connection connection = null;
	Statement stmt = null;

	final String DB_URL = "jdbc:postgresql://185.86.76.216:5432/fm_accounting_qa_db";
	final String USER = "qa_user";
	final String PASS = "mX109inLvxD@5";

	public static void main(String[] args) {

		String sqlStatemant1 = "select contract.deal_id, first_name, last_name, consultancy.name, contract.created_date, contract.payment_type, deal.status\n"
				+ "from client\n" + "join deal\n" + "on client.id = deal.client_id\n" + "join consultancy\n"
				+ "on deal.consultancy_id = consultancy.id\n" + "join contract\n" + "on deal.id = contract.deal_id\n"
				+ "where contract.created_date \n" + "between date('2017-06-1') and date('2019-10-31')\n"
				+ "ORDER BY RANDOM() LIMIT 1;";
		String sqlStatemant2 = "select first_name, last_name\n" + "from employee\n" + "where max_clients > 2\n"
				+ "ORDER BY RANDOM() LIMIT 1;";

		String sqlStatemant3 = "select contract.deal_id, first_name, last_name, consultancy.name, contract.created_date, contract.payment_type, deal.status\n"
				+ "from client\n" + "join deal\n" + "on client.id = deal.client_id\n" + "join consultancy\n"
				+ "on deal.consultancy_id = consultancy.id\n" + "join contract\n" + "on deal.id = contract.deal_id\n"
				+ "where contract.created_date \n" + "between date('2017-06-1') and date('2019-10-31')\n"
				+ "ORDER BY RANDOM() LIMIT 1;";

		String sqlStatemant4 = "select deal.id, consultancy.name, last_name, first_name, deal_queue.queuing_date, deal_queue.priority\n"
				+ "from client\n" + "join deal\n" + "on client.id = deal.client_id\n" + "join consultancy\n"
				+ "on  deal.consultancy_id = consultancy.id\n" + "left join deal_queue\n"
				+ "on deal.id = deal_queue.deal_id\n" + "where EXTRACT(MONTH FROM deal_queue.queuing_date)=3;";

		String sqlStatemant5 = "select contract.deal_id, first_name, last_name, consultancy.name, contract.created_date, contract.payment_type, deal.status\n"
				+ " from client\n" + "		join deal\n" + "		on client.id = deal.client_id\n"
				+ "	join consultancy\n" + "		on  deal.consultancy_id = consultancy.id\n" + "		join contract\n"
				+ "	on deal.id = contract.deal_id\n"
				+ "	where first_name = 'Piotr' and last_name = 'Rasputin' and deal.status = 'ACTIVE'";

		DataBase dataBase = new DataBase().connect();
		// dataBase.getArrayListFromSQL(sqlStatemant1);
		// dataBase.getArrayListFromSQL(sqlStatemant2);
		// dataBase.getArrayListFromSQL(sqlStatemant3);

		System.out.println("Testing List and Map methods:");
		System.out.println(dataBase.getArrayListFromSQL(sqlStatemant5).get(0));
		System.out.println(dataBase.getHashMapFromSQL(sqlStatemant5).get("deal_id1"));

		dataBase.closeConnection();

	}

	public DataBase connect() {

		System.out.println("Testing connection to PostgreSQL JDBC");

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
			e.printStackTrace();

		}

		System.out.println("PostgreSQL JDBC Driver successfully connected");

		try {
			this.connection = DriverManager.getConnection(this.DB_URL, this.USER, this.PASS);

		} catch (SQLException e) {
			System.out.println("Connection Failed");
			e.printStackTrace();

		}

		if (this.connection != null) {
			System.out.println("You successfully connected to database now");
		} else {
			System.out.println("Failed to make connection to database");
		}
		return this;
	}

	public List<String> getArrayListFromSQL(String sqlStatement) {

		List<String> tableRows = new ArrayList<String>();
		String tableHeader = "";
		String queryResult = "";

		try {

			stmt = connection.createStatement();

			ResultSet rs = stmt.executeQuery(sqlStatement);
			ResultSetMetaData rsmd = rs.getMetaData();

			int columnsNumber = rsmd.getColumnCount();

			while (rs.next()) {

				for (int count = 1; count <= columnsNumber; count++) {

					tableHeader = tableHeader.concat(rsmd.getColumnName(count)).concat(" ");
					queryResult = queryResult.concat(rs.getString(count)).concat(" ");

				}

				tableRows.add(queryResult);

				System.out.println();
				System.out.println("Row added to List:");
				System.out.println(tableHeader);
				System.out.println(queryResult);
				tableHeader = "";
				queryResult = "";

			}

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			System.out.println("Connection Failed");
			e.printStackTrace();
		}
		return tableRows;
	}

	public Map<String, String> getHashMapFromSQL(String sqlStatement) {

		Map<String, String> tableRows = new HashMap<String, String>();

		try {

			stmt = connection.createStatement();

			ResultSet rs = stmt.executeQuery(sqlStatement);
			ResultSetMetaData rsmd = rs.getMetaData();
			// Saving columnd name+"rowNumber" for each row to the map key in order
			// to have unique keys for each value in different rows.

			int rowNumber = 1;

			while (rs.next()) {

				for (int count = 1; count <= rsmd.getColumnCount(); count++) {

					tableRows.put(rsmd.getColumnName(count).concat(String.valueOf(rowNumber)), rs.getString(count));
				}
				rowNumber++;
			}

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			System.out.println("Connection Failed");
			e.printStackTrace();
		}
		return tableRows;
	}

	public void closeConnection() {

		try {
			this.connection.close();
		} catch (Exception e) {

			e.printStackTrace();
			System.out.print(e);

		}
	}
}
