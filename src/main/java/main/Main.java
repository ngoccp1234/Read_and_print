package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    private static final String GET_URL = "https://www.w3schools.com/js/json_demo_array.txt";

    public static void main(String[] args) throws IOException {
        senGET();
        System.out.println("GET DONE!");
    }
    private static void senGET() throws IOException {
        URL obj = new URL(GET_URL);
        HttpURLConnection urlConnection = (HttpURLConnection) obj.openConnection();
        urlConnection.setRequestMethod("GET");
        int reponseCode = urlConnection.getResponseCode();
        if (reponseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String inputLine;
            StringBuffer reponse = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                reponse.append(inputLine);
            }
            in.close();
            System.out.println(reponse.toString());
        } else {
            System.out.println("GET request not worked");
        }
    }
}
