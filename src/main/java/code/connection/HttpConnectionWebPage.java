package code.connection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnectionWebPage {

    public static void main(String[] args) throws Exception {
        //The next line of code creates the object and then stores the data we need to access a web page.
        URL aWebPage = new URL("http://promsawatprofile.azurewebsites.net");

        //Now we will communicate with the page by opening a connection.
        HttpURLConnection lestSee = (HttpURLConnection) aWebPage.openConnection();

        //This line of code reads in our above object as it goes into the buffer using our connection.
        BufferedReader BringItIn = new BufferedReader(new InputStreamReader(lestSee.getInputStream()));

        //Now let's go ahead and print out the values. We will start by creating an string variable for a while loop.
        String httpCode; //We make this code so that we can read the code in from the buffer and print it out on our site.

        //IE as long as there is code to bring in, run this starting
        while ((httpCode = BringItIn.readLine()) != null) {
            //The following codes can check to see if the httpCode holds anything.
            //This would be helpful in printing a string before doing the work. For our if statement, We will use .isEmpty() four our
//            System.out.println(httpCode.equals(httpCode)); // This prints true because we are reading lines into here.
//            System.out.println(httpCode.equals(BringItIn)); // This prints false because we are not reading anything into it.

            //Commented out because in defeats the puprose of the if statement below, But you coudl print this in debugging.
//            System.out.println(httpCode.isEmpty()); // This code can also be used to create a simpler statement making sure that the
            /*
             * The above code can be used to produce an if statement that will only print the code if
             */
            if (!httpCode.isEmpty()) {
                System.out.println(httpCode);
            } else {
                System.out.println("");
            }
            //As this prints out we will be able to see the HTML code for a web site including the head information and
            //any scripts loaded on the page. However, it will not print external style and coding sheets.
        }

        //After we've got all the code, we close our session.
        BringItIn.close(); //Notice you can close what you started in letsSee with the variable we stored it in.
    }
}
