package cc.emotion.features.managers;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class URLManager {
    public static final String serverAccountAddress = "http://127.0.0.1:20166/emotionclient/auth.php";

    public String getResponse(String address) {
        try {
            URL url = new URL(new String(address.toString()));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                Scanner scanner = new Scanner(connection.getInputStream());
                String response = scanner.useDelimiter("\\A").next();
                scanner.close();
                return response.trim();
            } else {
                return null;
            }
        } catch (Exception _E) {
            return null;
        }
    }

    public boolean getResponse(String address, String variationString) {
        try {
            URL url = new URL(new String(address.toString()));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                Scanner scanner = new Scanner(connection.getInputStream());
                String response = scanner.useDelimiter("\\A").next();
                scanner.close();
                if (variationString.equals("*")) {
                    return true;
                }
                return response.trim().equals(variationString);
            } else {
                return false;
            }
        } catch (Exception _E) {
            return false;
        }
    }

    public boolean postRequest(String address, String apiValue) {
        return postRequest(address, apiValue, "*");
    }

    public boolean postRequest(String address, String data, String variationString) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(address);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = data.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }
            int responseCode = connection.getResponseCode();
            if (variationString.equals("*")) {
                return (responseCode == HttpURLConnection.HTTP_OK);
            }
            return (responseCode == HttpURLConnection.HTTP_OK) && connection.getResponseMessage().trim().equals(variationString);
        } catch (Exception e) {
            return false;
        }
    }

    public String getPostRequestResponse(String address, String apiValue) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(address);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = apiValue.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }
            int responseCode = connection.getResponseCode();
            if (!(responseCode == HttpURLConnection.HTTP_OK)) {
                return "";
            }
            return connection.getResponseMessage().trim();
        } catch (Exception e) {
            return "";
        }
    }
}
