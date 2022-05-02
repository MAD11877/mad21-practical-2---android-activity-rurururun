package sg.edu.np.practical_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    public User test = new User("Guo Heng", "Plays games, watches anime, likes to code", 1, false);

    private String Tag = "Main Activity";
    final String[] condition = {"UNFOLLOW", "FOLLOW"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent receiving = getIntent();
        int num = receiving.getIntExtra("Random", 0);
        if(num == 0){
            num += 1;
            Intent listActivity = new Intent(MainActivity.this, ListActivity.class);
            startActivity(listActivity);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(Tag, "On Create!");
        Button myButton = findViewById(R.id.button);
        Button myButton2 = findViewById(R.id.button2);
        TextView text = (TextView) findViewById(R.id.textView);
        TextView text1 = (TextView) findViewById(R.id.textView2);
        String name = test.Name + " " + num;

        text.setText(name);
        text1.setText(test.Description);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(test.Followed == false) {
                    myButton.setText(condition[0]);
                    test.Followed = true;
                    Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();
                }
                else {
                    myButton.setText(condition[1]);
                    test.Followed = false;
                    Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();
                }

            }
        });

        myButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent messageActivity = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(messageActivity);
            }
        });
    }
}

