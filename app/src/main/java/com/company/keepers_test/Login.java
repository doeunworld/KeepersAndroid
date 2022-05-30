package com.company.keepers_test;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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

public class Login extends AppCompatActivity {

    private Button btn_login;
    private EditText edt_id;
    private EditText edt_pw;
    private RequestQueue requestQueue;
    private StringRequest stringRequest;
    private ImageView logo;
    private CheckBox cb_id;

    //로그인 저장기능
    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mContext = this; //로그인저장기능

        logo = findViewById(R.id.logo);
        btn_login = findViewById(R.id.btn_login);
        edt_id = findViewById(R.id.edt_id);
        edt_pw = findViewById(R.id.edt_pw);
        //체크박스 로그인저장
        cb_id = findViewById(R.id.cb_id);

        boolean boo = PreferenceManager.getBoolean(mContext, "check"); //로그인 정보 기억하기 체크 유무 확인
        if (boo) { // 체크가 되어있다면 아래 코드를 수행
            //저장된 아이디와 암호를 가져와 셋팅한다.
            edt_id.setText(PreferenceManager.getString(mContext, "id"));
            edt_pw.setText(PreferenceManager.getString(mContext, "pw"));
            cb_id.setChecked(true); //체크박스는 여전히 체크 표시 하도록 셋팅
        }


        SharedPreferences auto = getSharedPreferences("autoLogin", Activity.MODE_PRIVATE);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendRequest();
                Log.v("Test", "Test");

            }
        });

        //로그인 기억하기 체크박스 유무에 따른 동작 구현
        cb_id.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) { // 체크박스 체크 되어 있으면
                    //editText에서 아이디와 암호 가져와 PreferenceManager에 저장한다.
                    PreferenceManager.setString(mContext, "id", edt_id.getText().toString()); //id 키값으로 저장
                    PreferenceManager.setString(mContext, "pw", edt_pw.getText().toString()); //pw 키값으로 저장
                    PreferenceManager.setBoolean(mContext, "check", cb_id.isChecked()); //현재 체크박스 상태 값 저장
                } else { //체크박스가 해제되어있으면
                    PreferenceManager.setBoolean(mContext, "check", cb_id.isChecked()); //현재 체크박스 상태 값 저장
                    PreferenceManager.clear(mContext); //로그인 정보를 모두 날림
                }
            }
        });

    }

    public void sendRequest() {
        // RequestQueue 객체 생성
        requestQueue = Volley.newRequestQueue(this); // 현재 어플 정보 넘겨주기 -> this또는 getApplicationContext()
        //서버에 요청할 주소
        // String url = "http://211.63.240.71:8081/keepers/andLogin.do";
        String url = "http://211.63.240.71:8081/keepers/andLogin.do";


        //stringRequest -> 요청시 필요한 문자열 객체
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            // 응답데이터를 받아오는 곳
            @Override
            public void onResponse(String response) {
                Log.v("resultValue", response);

                // Log.v("resultValue", response.length() + "");

                if (response.length() > 0) {
                    // 로그인 성공
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        String m_id = jsonObject.getString("m_id");
                        String m_pw = jsonObject.getString("m_pw");
                        String m_name = jsonObject.getString("m_name");
                        String m_phone = jsonObject.getString("m_phone");

                        Log.v("resultValue", m_id + "/" + m_pw + "/" + m_name + "/" + m_phone);
                        // 로그인 성공시 id, pw, nick, phone 데이터를 LoginSuccess로 전달해서
                        // TextView에 보여주게 하시오
                        // 단, MemverVO를 만들어서 활용할 것

                        Toast.makeText(getApplicationContext(), m_id + "님 환영합니다", Toast.LENGTH_SHORT).show();

                        SharedPreference.setAttribute(getApplicationContext(), "m_id", m_id);

                        LoginCheck.info = new k_memberVO();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                        intent.putExtra("info", info);

                        startActivity(intent);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                } else {
                    // 로그인 실패
                    Toast.makeText(getApplicationContext(), "로그인실패", Toast.LENGTH_SHORT).show();
                }

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
                String m_id = edt_id.getText().toString();
                String m_pw = edt_pw.getText().toString();
                params.put("m_id", m_id);
                params.put("m_pw", m_pw);
                return params;
            }
        };
        stringRequest.setTag("main");
        requestQueue.add(stringRequest);

    }


}
