import java.sql.*;

public class Quote {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String BBDD = ""; //jbbc:mysql://host/database
    private static final String USER = ""; //mysql user
    private static final String PASSWORD = ""; //mysql user password
    public final String QUOTE;
    public final String AUTHOR;
    private int amountOfId;
    private int randomId;

    public Quote() {

        Connection dbConnection = connectDB(); //dbConnection open

        //getting the amount of quotes in the DB and generating a random id
        amountOfId = getAmountOfId(dbConnection);
        randomId = randomId(amountOfId);

        //getting the quote and the author from the BBDD
        Connection queryConnection = connectDB();
        QUOTE = queryQuote(queryConnection, randomId);

        Connection authorConnection = connectDB();
        AUTHOR = queryAuthor(authorConnection, randomId);

    }

    //BBDD Connection functions

    public Connection connectDB(){
        Connection connection = null;

        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(BBDD, USER, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Database error connection.\n" + e);
        }

        return connection;

    }

    //Generating random ID (Call to Mysql to get the amount of id and generating it

    public static int getAmountOfId(Connection connection){

        PreparedStatement ps = null;
        ResultSet rs = null;
        int amountOfId = 0;

        try(connection){
            String query = "SELECT COUNT(id) FROM quotes";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                amountOfId= rs.getInt(1);
            }

        } catch(SQLException e){
            System.out.println("Error getting the amount of id from the database");
            System.out.println(e);
        }

        return amountOfId;
    }

    private static int randomId(int amountOfId) {
        int id =  (int)(Math.random() * amountOfId+1);
        return id;
    }

    // BBDD functions to get the quote and author

    public String queryQuote(Connection connection, int id){
        String queryQuote = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try (connection){
            String query = "SELECT * FROM quotes WHERE ID = "+id;
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()){
                queryQuote = rs.getString("quote");
            }


        } catch (SQLException e) {
            System.out.println("Error getting the quote from the BBDD");
            System.out.println(e);
        }

        return queryQuote;
    }

    public String queryAuthor(Connection connection, int id){
        String queryAuthor = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try(connection){

            String query ="SELECT * FROM quotes WHERE ID = " + id;
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()){
                queryAuthor = rs.getString("Author");
            }
        } catch (SQLException e){
            System.out.println("Error getting the author from the BBDD");
            System.out.println(e);
        }

        return queryAuthor;
    }

    // Getters and setters for the quote and the author
    public String getQuote() {
        return QUOTE;
    }

    public String getAuthor() {
        return AUTHOR;
    }

}