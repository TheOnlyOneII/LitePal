package com.example.litepaltest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.litepal.LitePal;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LitePal.initialize(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创建数据库按钮
        Button create_database = findViewById(R.id.create_database);
        create_database.setOnClickListener(this);
        //增加数据按钮
        Button add_data = findViewById(R.id.add_data);
        add_data.setOnClickListener(this);
        //修改数据按钮
        Button update_data = findViewById(R.id.update_data);
        update_data.setOnClickListener(this);
        //删除数据按钮
        Button delete_data = findViewById(R.id.delete_data);
        delete_data.setOnClickListener(this);
        //查询数据按钮
        Button query_data = findViewById(R.id.query_data);
        query_data.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.create_database:
                LitePal.getDatabase();
                break;
            case R.id.add_data:
                Book bookToAdd = new Book();
                bookToAdd.setName("LitePal测试");
                bookToAdd.setAuthor("周梁");
                bookToAdd.setPages(100);
                bookToAdd.setPrice(22.22);
                bookToAdd.setPress("Unknown");
                bookToAdd.save();
                break;
            case R.id.update_data:
                Book bookToUpdate = new Book();
                bookToUpdate.setPrice(22.23);
                bookToUpdate.updateAll("name = ?" , "更新测试");
                break;
        }
    }
}
