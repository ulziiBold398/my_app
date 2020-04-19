package com.example.diplom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

public class addQuestion extends AppCompatActivity {
    private Spinner spinnerCategory;
    private Spinner spinnerDifficulty;
    EditText question,option1,option2,option3;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);


        spinnerCategory = findViewById(R.id.spinner_category);
        spinnerDifficulty = findViewById(R.id.spinner_difficulty);
        question = (EditText)findViewById(R.id.text_view_question);
        option1=(EditText)findViewById(R.id.a);
        option2=(EditText)findViewById(R.id.b);
        option3=(EditText)findViewById(R.id.c);
        save = (Button)findViewById(R.id.btn_save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String question2 = question.getText().toString();
                String op1 = option1.getText().toString();

                String op2 = option2.getText().toString();

                String op3 = option3.getText().toString();
                Category selectedCategory = (Category) spinnerCategory.getSelectedItem();
                int categoryID = selectedCategory.getId();
                String categoryName = selectedCategory.getName();
                String difficulty = spinnerDifficulty.getSelectedItem().toString();


            }
        });

        loadCategories();
        loadDifficultyLevels();
    }
    private void loadCategories() {
        QuizDbHelper dbHelper = QuizDbHelper.getInstance(this);
        List<Category> categories = dbHelper.getAllCategories();

        ArrayAdapter<Category> adapterCategories = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, categories);
        adapterCategories.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(adapterCategories);
    }

    private void loadDifficultyLevels() {
        String[] difficultyLevels = Question.getAllDifficultyLevels();

        ArrayAdapter<String> adapterDifficulty = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, difficultyLevels);
        adapterDifficulty.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDifficulty.setAdapter(adapterDifficulty);
    }
}
