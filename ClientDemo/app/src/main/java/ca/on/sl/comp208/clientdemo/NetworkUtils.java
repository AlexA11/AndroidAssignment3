package ca.on.sl.comp208.clientdemo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by alexash on 2017-03-27.
 */

public class NetworkUtils {


    public static String getNetworkData(String address) {
        InputStream iStream = null;

        try{
            URL url = new URL(address);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(10000);
            connection.setConnectTimeout(15000);
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
//            connection.connect();
            int responseCode = connection.getResponseCode();
            Log.i("URL", "response code = " + responseCode);

            if(responseCode == 200) {
                InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
                BufferedReader bReader = new BufferedReader(inputStreamReader);
                String line = bReader.readLine();
                return line;
            }
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean networkAvailable(Context context) {
        ConnectivityManager cm =
        (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo network = cm.getActiveNetworkInfo();

        try{
            if(network != null) {
                return network.isConnectedOrConnecting();
            }
        }
        catch (Exception e) {
            Log.i("Network", e.getMessage());
        }
        return false;
    }
}
