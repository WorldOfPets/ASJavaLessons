package com.drinkertea.lesson1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Comments extends AppCompatActivity {

    LinearLayout mainLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        mainLinearLayout = findViewById(R.id.main_linear_layout);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/comments");

            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            int status_code = connection.getResponseCode();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder stringBuilder = new StringBuilder();

            while ((line = bufferedReader.readLine()) != null){
                stringBuilder.append(line + "\n");
            }
            bufferedReader.close();
            connection.disconnect();

            JSONArray jsonArray = new JSONArray(stringBuilder.toString());

            //System.out.println(jsonArray.getJSONObject(0).get("email"));

            for (int i = 0; i < 20; i++){
                JSONObject item = jsonArray.getJSONObject(i);
                //System.out.println(item.get("email"));
                create_comments(mainLinearLayout, item.get("email").toString(), item.get("body").toString());
            }
            //------------------


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void create_comments(LinearLayout mainLinear, String from_str, String from_body){
        LinearLayout container = new LinearLayout(this);
        TextView from = new TextView(this);
        TextView body = new TextView(this);
        Button button = new Button(this);

        container.setOrientation(LinearLayout.VERTICAL);
        from.setText("Ot: " + from_str);
        body.setText("Комментарий: " + from_body);
        button.setText("Удалить");

        button.setOnClickListener(view -> mainLinear.removeView(container));

        container.addView(from);
        container.addView(body);
        container.addView(button);

        mainLinear.addView(container);
    }

}