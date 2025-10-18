package com.example.duongthanhlong_ktgk;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {

    private Button btnThemSV;
    private ListView listView;
    private ArrayList<Student> studentList;
    private ArrayAdapter<Student> adapter;
    private ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnThemSV = findViewById(R.id.button);
        listView = findViewById(R.id.listView);
        studentList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, studentList);
        listView.setAdapter(adapter);
         launcher = registerForActivityResult(
                 new ActivityResultContracts.StartActivityForResult(),
                 new ActivityResultCallback<ActivityResult>() {
                     @Override
                     public void onActivityResult(ActivityResult o) {
                         if (result.getResultCode() == RESULT_OK) {
                             Intent data = result.getData();
                             if (data != null) {
                                 String name = data.getStringExtra("name");
                                 String mssv = data.getStringExtra("mssv");
                                 Student newStudent = new Student(name, mssv);
                                 studentList.add(newStudent);
                                 adapter.notifyDataSetChanged();
                                 Toast.makeText(MainActivity.this,
                                         "Đã thêm: " + name,
                                         Toast.LENGTH_SHORT.show();
                             }
                             }
                     }
                 }
    }
}