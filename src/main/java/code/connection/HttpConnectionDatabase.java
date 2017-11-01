package code.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class HttpConnectionDatabase {

    public static void main(String[] args) throws Exception {
        /*
         * Continued from httpCheckout
         * You can also use the HttpURLConnection to connect to a database.
         */
        try {
            //This is code that you would use to attempt access to a database with no password required to read data out.
//            URL urlD = new URL("http:https://www.lds.org/?lang-eng"); //Webiste is just for the example.
//            HttpURLConnection urlDcon = (HttpURLConnection) urlD.openConnection();
            //You should alread by familiar with the above two lines of code as they are talked about in the other code.

//            urlDcon.connect(); //This code seeks to connect to the defined URL above.

//            InputStream incoming = urlDcon.getInputStream(); //This line of code works to read the data in from the database.

//            System.out.println(incoming);

            //This is what in needed if your database has specific drivers.

            String serverName = "localhost"; //localHost, web site, or ip address of the database.
            String mydatabase = "mydatabase"; //Name of database you want to access.
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            //This combines the information above with the JDBC connection code for use below when accessing the database.

            String username = "username"; // Takes the user name for web-site above.
            String password = "password"; // Takes the password for the database above.
            Connection connection = DriverManager.getConnection(url, username, password);
            //Passes along the information to connect to the URL and long in, if it succeeds it prints out the connection.
            //If it passes it will tell you True or False based on if the connection is closed.
            //If it fails, it will go to the catch. Other methods include .create, .commit, etc. to pass information or interact with the ....
            System.out.println(connection.isClosed());
        } catch (Exception e) {
            System.out.println("You do not have access to the database.");
            //Bacause the URL I provided does not link to a database, it cannot print the information from it.
            //Even if it was a database, without the credentials it wouldn't work.
        }
    }
}
