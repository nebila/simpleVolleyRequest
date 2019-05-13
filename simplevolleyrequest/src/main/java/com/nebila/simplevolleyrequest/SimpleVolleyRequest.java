package com.nebila.simplevolleyrequest;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SimpleVolleyRequest {

    public String error;

    private String sResponse;
    private JSONObject joResponse;
    private JSONArray jaResponse;

    public SimpleVolleyRequest(){

    }

    public String stringRequest(Context context, String requestMethod, String url, final HashMap<String, String> dataToSend){

        error=null;
        RequestQueue queue = Volley.newRequestQueue( context);

        int reqMethod;
        if (requestMethod.toUpperCase().trim().equals("POST") || requestMethod.toUpperCase().trim().contains("POST")){
            reqMethod=Request.Method.POST;

        }else if (requestMethod.toUpperCase().trim().equals("GET") || requestMethod.toUpperCase().trim().contains("GET")){
            reqMethod=Request.Method.GET;

        }else {
            Log.e("SimpleVolleyRequest", "requestMethod must be \"GET\" or \"POST\" ");
            return null;
        }

        StringRequest StringReq = new StringRequest(reqMethod,url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                sResponse= response;

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError err) {
                error=err.toString();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                return dataToSend;

            }
        };

        queue.add(StringReq);

        return sResponse;

    }

    public JSONObject jsonObjectRequest(Context context, String requestMethod, String url, JSONObject dataToSend){

        error=null;
        RequestQueue queue = Volley.newRequestQueue( context);

        int reqMethod;
        if (requestMethod.toUpperCase().trim().equals("POST") || requestMethod.toUpperCase().trim().contains("POST")){
            reqMethod=Request.Method.POST;

        }else if (requestMethod.toUpperCase().trim().equals("GET") || requestMethod.toUpperCase().trim().contains("GET")){
            reqMethod=Request.Method.GET;

        }else {
            Log.e("SimpleVolleyRequest", "requestMethod must be \"GET\" or \"POST\" ");
            return null;
        }

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(reqMethod,url, dataToSend, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                joResponse=response;
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError err) {
                error=err.toString();

            }
        }) {


            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }
        };

        queue.add(jsonObjReq);

        return joResponse;
    }

    public JSONArray jsonArrayRequest(Context context, String requestMethod, String url, JSONArray dataToSend){

        error=null;
        RequestQueue queue = Volley.newRequestQueue( context);

        int reqMethod;
        if (requestMethod.toUpperCase().trim().equals("POST") || requestMethod.toUpperCase().trim().contains("POST")){
            reqMethod=Request.Method.POST;

        }else if (requestMethod.toUpperCase().trim().equals("GET") || requestMethod.toUpperCase().trim().contains("GET")){
            reqMethod=Request.Method.GET;

        }else {
            Log.e("SimpleVolleyRequest", "requestMethod must be \"GET\" or \"POST\" ");
            return null;
        }

        JsonArrayRequest jsonArrReq = new JsonArrayRequest(reqMethod,url, dataToSend, new Response.Listener<JSONArray>()  {
            @Override
            public void onResponse(JSONArray response) {

                jaResponse=response;

            }

        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError err) {
                error=err.toString();
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }
        };

        queue.add(jsonArrReq);

        return jaResponse;
    }



    public String stringRequest(Context context, String requestMethod, String url, final HashMap<String, String> dataToSend,
                                int initialTimeoutMs, int maxRetries, float backoffMultiplier){

        error=null;
        RequestQueue queue = Volley.newRequestQueue( context);

        int reqMethod;
        if (requestMethod.toUpperCase().trim().equals("POST") || requestMethod.toUpperCase().trim().contains("POST")){
            reqMethod=Request.Method.POST;

        }else if (requestMethod.toUpperCase().trim().equals("GET") || requestMethod.toUpperCase().trim().contains("GET")){
            reqMethod=Request.Method.GET;

        }else {
            Log.e("SimpleVolleyRequest", "requestMethod must be \"GET\" or \"POST\" ");
            return null;
        }

        StringRequest StringReq = new StringRequest(reqMethod,url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                sResponse= response;

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError err) {
                error=err.toString();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                return dataToSend;

            }
        };

        StringReq.setRetryPolicy(new DefaultRetryPolicy(
                initialTimeoutMs,
                maxRetries,
               backoffMultiplier));

        queue.add(StringReq);

        return sResponse;

    }

    public JSONObject jsonObjectRequest(Context context, String requestMethod, String url, JSONObject dataToSend,
                                        int initialTimeoutMs, int maxRetries, float backoffMultiplier){

        error=null;
        RequestQueue queue = Volley.newRequestQueue( context);

        int reqMethod;
        if (requestMethod.toUpperCase().trim().equals("POST") || requestMethod.toUpperCase().trim().contains("POST")){
            reqMethod=Request.Method.POST;

        }else if (requestMethod.toUpperCase().trim().equals("GET") || requestMethod.toUpperCase().trim().contains("GET")){
            reqMethod=Request.Method.GET;

        }else {
            Log.e("SimpleVolleyRequest", "requestMethod must be \"GET\" or \"POST\" ");
            return null;
        }

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(reqMethod,url, dataToSend, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                joResponse=response;
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError err) {
                error=err.toString();

            }
        }) {


            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }
        };

        jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(
                initialTimeoutMs,
                maxRetries,
                backoffMultiplier));

        queue.add(jsonObjReq);

        return joResponse;
    }

    public JSONArray jsonArrayRequest(Context context, String requestMethod, String url, JSONArray dataToSend,
                                      int initialTimeoutMs, int maxRetries, float backoffMultiplier){

        error=null;
        RequestQueue queue = Volley.newRequestQueue( context);

        int reqMethod;
        if (requestMethod.toUpperCase().trim().equals("POST") || requestMethod.toUpperCase().trim().contains("POST")){
            reqMethod=Request.Method.POST;

        }else if (requestMethod.toUpperCase().trim().equals("GET") || requestMethod.toUpperCase().trim().contains("GET")){
            reqMethod=Request.Method.GET;

        }else {
            Log.e("SimpleVolleyRequest", "requestMethod must be \"GET\" or \"POST\" ");
            return null;
        }

        JsonArrayRequest jsonArrReq = new JsonArrayRequest(reqMethod,url, dataToSend, new Response.Listener<JSONArray>()  {
            @Override
            public void onResponse(JSONArray response) {

                jaResponse=response;

            }

        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError err) {
                error=err.toString();
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }
        };

        jsonArrReq.setRetryPolicy(new DefaultRetryPolicy(
                initialTimeoutMs,
                maxRetries,
               backoffMultiplier));

        queue.add(jsonArrReq);

        return jaResponse;
    }

}

