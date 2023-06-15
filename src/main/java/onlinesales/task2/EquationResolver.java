package onlinesales.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class EquationResolver {

    public static void main(String[] args) {
        /**
         * Declared an input list
         * */
        String[] expressions = {
                "2 * 4 * 4",
                "5 / (7 - 5)",
                "sqrt(5^2 - 4^2)",
                "sqrt(-3^2 - 4^2)"
        };

        /**
         * Running a for loop on the input list
         * */

        for (String expression : expressions) {
            try {
                String result = evaluateExpression(expression);
                System.out.println(expression + " = " + result);
            } catch (IOException e) {
                System.out.println("An error occurred while evaluating the expression: " + expression);
                e.printStackTrace();
            }
        }
    }

    public static String evaluateExpression(String expression) throws IOException {

        /**
         * Using api.mathjs.org api to resolve the equation
         * */

        String url = "https://api.mathjs.org/v4/?expr=" + getEncodeString(expression);
        System.out.println("Calling URL " + url);

        /**
         * Creating HTTP Connection to the URL using the GET method as suggested by the documentation of api.mathjs.org
         * */

        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {

            /**
             * Using buffer reader to buffer the input received from the HTTP connection
             * */
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String response = reader.readLine();
            reader.close();

            return response;
        } else {
            throw new IOException("Error response: " + responseCode);
        }
    }

    /**
     * Encoding string using URL encored to make it compatible with the URL standards
     * */
    private static String getEncodeString(String expression) throws UnsupportedEncodingException {
        return URLEncoder.encode(expression, "UTF-8");
    }

}

