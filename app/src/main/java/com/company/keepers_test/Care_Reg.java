package com.company.keepers_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class Care_Reg extends AppCompatActivity {

    private EditText edt_c_name, edt_c_address, edt_c_birth, edt_c_memo, edt_c_phone;
    private Button btn_reg;
    private RequestQueue requestQueue;
    private StringRequest stringRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care_reg);

        edt_c_address = findViewById(R.id.edt_c_address);
        edt_c_name = findViewById(R.id.edt_c_name);
        edt_c_birth = findViewById(R.id.edt_c_birth);
        edt_c_phone = findViewById(R.id.edt_c_phone);
        btn_reg = findViewById(R.id.btn_reg);

        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reg_sendRequest();
                Log.v("Test", "Reg_Test");
            }
        });
    }

    public void reg_sendRequest() {
        // RequestQueue 객체 생성
        requestQueue = Volley.newRequestQueue(this); // 현재 어플 정보 넘겨주기 -> this또는 getApplicationContext()
        //서버에 요청할 주소
        String url = "http://211.63.240.71/keepers/careInsert.do";


        //stringRequest -> 요청시 필요한 문자열 객체
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            // 응답데이터를 받아오는 곳
            @Override
            public void onResponse(String response) {
                Log.v("resultValue", response);

                Intent intent = new Intent(getApplicationContext(), CareList.class);
                startActivity(intent);

                // Log.v("resultValue", response.length() + "");

//                if (response.length() > 0 ) {
//                    // 로그인 성공
//                    try {
//                        JSONObject jsonObject = new JSONObject(response);
//                        String m_id = jsonObject.getString("m_id");
//                        String m_pw = jsonObject.getString("m_pw");
//                        String m_name = jsonObject.getString("m_name");
//                        String m_phone = jsonObject.getString("m_phone");
//
//                        Log.v("resultValue", m_id+"/"+m_pw+"/"+m_name+"/"+m_phone);
//                        // 로그인 성공시 id, pw, nick, phone 데이터를 LoginSuccess로 전달해서
//                        // TextView에 보여주게 하시오
//                        // 단, MemverVO를 만들어서 활용할 것
//
//                        Toast.makeText(getApplicationContext(), m_id+"님 환영합니다", Toast.LENGTH_SHORT).show();
//
//                        LoginCheck.info = new k_memberVO();
//                        Intent intent = new Intent(getApplicationContext(), LoginSuccess.class);
////                        intent.putExtra("info", info);
//
//                        startActivity(intent);
//
//
//
//
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//
//                } else {
//                    // 로그인 실패
//                    Toast.makeText(getApplicationContext(), "로그인실패", Toast.LENGTH_SHORT).show();
//                }

            }
        }, new Response.ErrorListener() {
            // 서버와의 연동 에러시 출력
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }) {
            @Override //response를 UTF8로 변경해주는 소스코드
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                try {
                    String utf8String = new String(response.data, "UTF-8");
                    return Response.success(utf8String, HttpHeaderParser.parseCacheHeaders(response));
                } catch (UnsupportedEncodingException e) {
                    // log error
                    return Response.error(new ParseError(e));
                } catch (Exception e) {
                    // log error
                    return Response.error(new ParseError(e));
                }
            }

            // 보낼 데이터를 저장하는 곳
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();

                String c_name = edt_c_name.getText().toString();
                String c_address = edt_c_address.getText().toString();
                String c_birth = edt_c_birth.getText().toString();
                String c_phone = edt_c_phone.getText().toString();
//                String c_manager_id = "checker";
                //
                String c_manager_id = SharedPreference.getAttribute(getApplicationContext(), "m_id");


//                String c_manager_id = LoginCheck.info.getM_id();

                params.put("c_name", c_name);
                params.put("c_address", c_address);
                params.put("c_birth", c_birth);
                params.put("c_phone", c_phone);

                return params;
            }
        };
        stringRequest.setTag("main");
        requestQueue.add(stringRequest);

    }


}
