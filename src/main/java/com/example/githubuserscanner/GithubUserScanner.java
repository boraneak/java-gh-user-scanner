package com.example.githubuserscanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import com.example.githubuserscanner.utils.NoInternetErrorHandling;

public class GithubUserScanner {

    private static final String GITHUB_USERS_API_URL = "https://api.github.com/users";
    private static final Gson gson = new Gson();

    public static void main(String[] args) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            if (!NoInternetErrorHandling.isInternetAvailable()) {
                System.out.println("No internet connection detected. Please check your network and try again.");
                return;
            }
            // Fetch the first 20 users
            List<User> users = fetchUsers(httpClient);

            // Map to store user IDs and their details
            Map<Integer, User> userMap = new HashMap<>();
            for (User user : users) {
                userMap.put(user.getId(), user);
            }

            // Print 20 available IDs
            System.out.println("20 Available user IDs:");
            for (Integer id : userMap.keySet()) {
                System.out.println(id);
            }

            // Prompt user for an ID
            try (Scanner scanner = new Scanner(System.in)) {
                while (true) {
                    System.out.print("Enter a user ID (or type 'q' to quit): ");
                    String input = scanner.nextLine();

                    if (input.equalsIgnoreCase("q")) {
                        break;
                    }

                    try {
                        int inputId = Integer.parseInt(input);
                        User user = userMap.get(inputId);

                        if (user != null) {
                            fetchAndUpdateUserDetails(httpClient, user);
                            printUserDetails(user);
                        } else {
                            System.out.println("User ID not found. Please try again.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid number.");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<User> fetchUsers(CloseableHttpClient httpClient) throws Exception {
        String url = GITHUB_USERS_API_URL + "?per_page=20&page=1";
        HttpGet request = new HttpGet(url);
        // Todo: use execute methods with HttpClientResponseHandler
        try (@SuppressWarnings("deprecation")
        CloseableHttpResponse response = httpClient.execute(request)) {
            String json = EntityUtils.toString(response.getEntity());
            Type userListType = new TypeToken<List<User>>() {
            }.getType();
            return gson.fromJson(json, userListType);
        }
    }

    @SuppressWarnings("deprecation")
    private static void fetchAndUpdateUserDetails(CloseableHttpClient httpClient, User user) throws Exception {
        String userUrl = GITHUB_USERS_API_URL + "/" + user.getLogin();

        HttpGet request = new HttpGet(userUrl);
        // Todo: use execute methods with HttpClientResponseHandler
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            String json = EntityUtils.toString(response.getEntity());
            User fetchedUser = gson.fromJson(json, User.class);
            user.setNumberOfRepositories(fetchedUser.getNumberOfRepositories());
            user.setNumberOfFollowers(fetchedUser.getNumberOfFollowers());
            user.setNumberOfFollowings(fetchedUser.getNumberOfFollowings());
        }
    }

    private static void printUserDetails(User user) {
        System.out.println("User details:");
        System.out.println("Login name: " + user.getLogin());
        System.out.println("Profile link: " + "https://github.com/" + user.getLogin());
        System.out.println("Number of repos: " + user.getNumberOfRepositories());
        System.out.println("Number of followers: " + user.getNumberOfFollowers());
        System.out.println("Number of followings: " + user.getNumberOfFollowings());
    }
}
