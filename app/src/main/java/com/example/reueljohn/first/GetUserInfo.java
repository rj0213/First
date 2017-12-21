package com.example.reueljohn.first;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by reueljohn on 21/12/2017.
 */

public class GetUserInfo extends AsyncTask<String, Void, String> {

    private TextView nameText, usernameText, addressText, companyText;

    public GetUserInfo (TextView nameText, TextView usernameText, TextView addressText, TextView companyText){
        this.nameText = nameText;
        this.usernameText = usernameText;
        this.addressText = addressText;
        this.companyText = companyText;
    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        String name = null, username = null, street = null, city = null, company = null;

        try {
            JSONArray usersArray = new JSONArray(s);
            for(int i = 0; i < usersArray.length(); i++){
                JSONObject user = usersArray.getJSONObject(i);
                JSONObject jAddress = user.getJSONObject("address");
                JSONObject jCompany = user.getJSONObject("company");


                try {
                    name =user.getString("name");
                    username = user.getString("username" );
                    street = jAddress.getString("street");
                    city = jAddress.getString("city");
                    company = jCompany.getString("name");

                }catch (Exception e){
                    e.printStackTrace();
                }

                nameText.setText(name);
                usernameText.setText(username);
                addressText.setText(street + " " + city);
                companyText.setText(company);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected String doInBackground(String... strings) {
        return NetworkConnect.getUsers();
    }
}
