package com.example.css.register;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {


    Button add, view, update, delete;
    EditText roll_no, name, markT, markE, markM, markS, markSoc;
    EditText editText;
    TextView text;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        add = findViewById(R.id.add);
        view = findViewById(R.id.view);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);

        roll_no = findViewById(R.id.roll_no);
        name = findViewById(R.id.name);
        markT = findViewById(R.id.markT);
        markE = findViewById(R.id.markE);
        markM = findViewById(R.id.markM);
        markS = findViewById(R.id.markS);
        markSoc = findViewById(R.id.markSoc);
        text = findViewById(R.id.text);

        Realm.init(this);
        realm = Realm.getDefaultInstance();

    }//onCreate close

    public void clickAction(View view){
        switch (view.getId()){
            case R.id.add:
                addRecord();
                break;
            case R.id.view:
                viewRecord();
                break;
            case R.id.update:
                updateRecord();
                break;
            case R.id.delete:
                deleteRecord();
        }
    }

    public void addRecord(){
        realm.beginTransaction();

        Student student = realm.createObject(Student.class);
        student.setRoll_no(Integer.parseInt(roll_no.getText().toString()));
        student.setName(name.getText().toString());
        student.setTamil(Integer.parseInt(markT.getText().toString()));
        student.setEnglish(Integer.parseInt(markE.getText().toString()));
        student.setMaths(Integer.parseInt(markM.getText().toString()));
        student.setScience(Integer.parseInt(markS.getText().toString()));
        student.setSocial(Integer.parseInt(markSoc.getText().toString()));

        realm.commitTransaction();
        Toast.makeText(MainActivity.this, "Added Sucessfully", Toast.LENGTH_SHORT).show();

    }

    public void viewRecord(){
        RealmResults<Student> results = realm.where(Student.class).findAll();

        text.setText("");

        for(Student student : results){
            text.append("____________________" + " \n " + "| Roll NO:" + student.getRoll_no()  + " \n " + "| Name:" +  student.getName() + " \n " + "| Tamil:"  +
                    student.getTamil() + " \n "+ "| English:" + student.getEnglish() + " \n " + "| Maths:" + student.getMaths() + " \n " + "| Science:"
                    + student.getScience() + " \n " + "| Social" + student.getSocial() + " \n " + " ____________________" +"\n" );
        }
    }

    public void updateRecord(){
        RealmResults<Student> results = realm.where(Student.class).equalTo("roll_no", Integer.parseInt(roll_no.getText().toString())).findAll();


        realm.beginTransaction();

        for(Student student : results){
            student.setName(name.getText().toString());
        }

        for(Student student : results){
            student.setTamil(Integer.parseInt(markT.getText().toString()));
        }
        for(Student student : results){
            student.setEnglish(Integer.parseInt(markE.getText().toString()));
        }
        for(Student student : results){
            student.setMaths(Integer.parseInt(markM.getText().toString()));
        }
        for(Student student : results){
            student.setScience(Integer.parseInt(markS.getText().toString()));
        }
        for(Student student : results){
            student.setSocial(Integer.parseInt(markSoc.getText().toString()));
        }
        realm.commitTransaction();
        Toast.makeText(MainActivity.this, "Update Done Sucessfully", Toast.LENGTH_SHORT).show();

    }

    public void deleteRecord(){
        RealmResults<Student> results = realm.where(Student.class).equalTo("roll_no", Integer.parseInt(roll_no.getText().toString())).findAll();

        realm.beginTransaction();

        results.deleteAllFromRealm();

        realm.commitTransaction();
    }
    @Override
    protected void onDestroy() {
        realm.close();
        super.onDestroy();
    }


}//MainActivity Close
