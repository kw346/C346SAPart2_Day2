package sg.edu.rp.c346.id20022735.c346sapart2_day2;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;

public class SecondActivity extends AppCompatActivity {
   Button btn;
    ListView lv;
    ArrayList<Expenditure> exList;
    CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        lv = (ListView) this.findViewById(R.id.lv);

        btn = findViewById(R.id.add);
        adapter = new CustomAdapter(this, R.layout.row, exList);
        lv.setAdapter(adapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input,null);
                final EditText etInput = viewDialog.findViewById(R.id.editTextamt);
                final EditText etInput2 = viewDialog.findViewById(R.id.editTextplace);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(SecondActivity.this);

                myBuilder.setTitle("Add log");
                myBuilder.setView(viewDialog);
                myBuilder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                myBuilder.setNegativeButton("Cancel",null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });
    }
}
