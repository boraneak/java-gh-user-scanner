package com.example.githubuserscanner.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class NoInternetErrorHandling {

    @SuppressWarnings("unused")
    public static boolean isInternetAvailable() {
        try {
            URL url = new URL("http://www.google.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            connection.setConnectTimeout(3000);
            connection.connect();
            return connection.getResponseCode() == 200;
        } catch (IOException e) {
            return false;
        }
    }
}
