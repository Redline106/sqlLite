package com.example.ali_j.sqllite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    Button add;
    EditText nameT,surnameT,marksT;
    TextView listeT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb=new DatabaseHelper(this);
        listeT=(TextView)findViewById(R.id.listeetudiant);
        nameT=(EditText)findViewById(R.id.name);
        surnameT=(EditText)findViewById(R.id.surname);
        marksT=(EditText)findViewById(R.id.marks);
    }

    public void AddData(View v){
        boolean isinserted=myDb.ajouter(nameT.getText().toString(),surnameT.getText().toString(),marksT.getText().toString());
        if (isinserted=true){
            Toast.makeText(this,"data inserted ",Toast.LENGTH_LONG).show();

        }else
            Toast.makeText(this,"data not  inserted ",Toast.LENGTH_LONG).show();
    }
    public  void AffcheData(View v){
        String result=myDb.Affiche();
        listeT.setText(result);


    }


}
