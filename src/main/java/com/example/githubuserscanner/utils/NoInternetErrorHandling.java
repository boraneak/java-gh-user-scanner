package com.example.githubuserscanner.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Utility class for handling scenarios related to internet connectivity.
 */
public class NoInternetErrorHandling {

    /**
     * Checks if the internet connection is available by attempting to connect
     * to a known reliable URL (e.g., Google).
     *
     * <p>
     * This method sends a HEAD request to the specified URL and checks if
     * the response code is 200 (OK). If the response code is 200, it assumes
     * that the internet connection is available. If there is an IOException,
     * the method returns {@code false}, indicating no internet connection.
     * </p>
     *
     * @return {@code true} if the internet connection is available, {@code false}
     *         otherwise.
     */
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
