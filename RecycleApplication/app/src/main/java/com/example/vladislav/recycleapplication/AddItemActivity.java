package com.example.vladislav.recycleapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.vladislav.recycleapplication.Data.Item;

public class AddItemActivity extends AppCompatActivity {
    EditText name;
    EditText price;
    Button btnAdd;
    String type;
    static final String TYPE_KEY = "type";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        name = findViewById(R.id.nameAddView);
        price = findViewById(R.id.priceAddView);
        btnAdd = findViewById(R.id.btnAdd);
        TextWatcher watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                btnAdd.setEnabled(!name.getText().toString().isEmpty()
                        && !price.getText().toString().isEmpty());
            }
        };
        name.addTextChangedListener(watcher);
        price.addTextChangedListener(watcher);
        type = getIntent().getStringExtra(TYPE_KEY);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Item newItem = new Item();
                newItem.setName(name.getText().toString());
                newItem.setPrice(Integer.parseInt(price.getText().toString()));
                newItem.setType(type);
                Intent intent = new Intent();
                intent.putExtra("item",newItem);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
