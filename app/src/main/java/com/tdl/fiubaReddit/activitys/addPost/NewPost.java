package com.tdl.fiubaReddit.activitys.addPost;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tdl.fiubaReddit.R;
import com.tdl.fiubaReddit.requests.Requests;

public class NewPost extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);

        EditText postTitle = findViewById(R.id.post_title);
        EditText postBody = findViewById(R.id.post_description);
        EditText postImageURL = findViewById(R.id.post_image_url);

        Button uploadButton = findViewById(R.id.button);

        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = postTitle.getText().toString();
                String body = postBody.getText().toString();
                String image = postImageURL.getText().toString();

                if (isAnyStringNullOrEmpty(title, body, image)) {
                    Toast.makeText(NewPost.this,"Oops, you forgot to fill in some fields!", Toast.LENGTH_SHORT).show();
                } else {
                    Requests.createPost(title, body, image);

                    Toast.makeText(NewPost.this,"Uploaded king \uD83D\uDE09", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent();
                    setResult(RESULT_FIRST_USER, intent);
                    finish();
                }
            }
        });
    }

    public static boolean isAnyStringNullOrEmpty(String... strings) {
        for (String s : strings)
            if (s == null || s.isEmpty())
                return true;
        return false;
    }
}
