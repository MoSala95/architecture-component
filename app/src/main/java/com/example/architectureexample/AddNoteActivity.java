package com.example.architectureexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {

    private EditText editTextTitle;
    private EditText editTextDescription;
    private NumberPicker editTextPriority;
    public static final String EXTRA_TITLE="com.example.architectureexample.EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION="com.example.architectureexample.EXTRA_DESCRIPTION";
    public static final String EXTRA_PRIORITY="com.example.architectureexample.EXTRA_PRIORITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        editTextTitle = findViewById(R.id.edit_text_title);
        editTextDescription = findViewById(R.id.edit_text_decription);
        editTextPriority = findViewById(R.id.number_picker_priority);

        editTextPriority.setMaxValue(10);
        editTextPriority.setMinValue(1);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("insert note");

    }
    private void saveNote(){
        String title=editTextTitle.getText().toString();
        String description =editTextDescription.getText().toString();
        int priority=editTextPriority.getValue();

        if(title.trim().isEmpty()||description.trim().isEmpty()){
            Toast.makeText(this, "title and description can not be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent data=new Intent();
        data.putExtra(EXTRA_TITLE,title);
        data.putExtra(EXTRA_DESCRIPTION,description);
        data.putExtra(EXTRA_PRIORITY,priority);

        setResult(RESULT_OK,data);
        finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_note_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_note:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }
}
