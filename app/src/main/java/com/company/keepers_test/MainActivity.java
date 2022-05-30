package com.company.keepers_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tv_logout, tv_reg, tv_list, tv_monitor, tv_board;
    private ImageView img_reg, img_list, img_monitor, img_board;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_logout = findViewById(R.id.tv_logout);

        tv_reg = findViewById(R.id.tv_reg);
        tv_list = findViewById(R.id.tv_list);
        tv_monitor = findViewById(R.id.tv_monitor);
        tv_board = findViewById(R.id.tv_board);

        img_reg = findViewById(R.id.img_reg);
        img_list = findViewById(R.id.img_list);
        img_monitor = findViewById(R.id.img_monitor);
        img_board = findViewById(R.id.img_board);


        tv_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, Login.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(i);
            }
        });

        // 사용자 등록 이미지, 텍스트 클릭시 넘어감
        tv_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Care_Reg.class);
                startActivity(intent);
            }
        });

        img_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Care_Reg.class);
                startActivity(intent);
            }
        });

        // 사용자 조회 이미지, 텍스트 클릭시 넘어감
        tv_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CareList.class);
                startActivity(intent);
            }
        });

        img_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CareList.class);
                startActivity(intent);
            }
        });

        // 모니터링 이미지, 텍스트 클릭시 넘어감
        tv_monitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Monitor.class);
                startActivity(intent);
            }
        });

        img_monitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Monitor.class);
                startActivity(intent);
            }
        });

        // 공지사항 이미지, 텍스트 클릭시 넘어감
        tv_board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Board.class);
                startActivity(intent);
            }
        });

        img_board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Board.class);
                startActivity(intent);
            }
        });


    }

}