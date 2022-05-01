package sg.edu.np.practical_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    public User test = new User("Guo Heng", "Plays games, watches anime, likes to code", 1, false);

    private String Tag = "Main Activity";
    final String[] condition = {"UNFOLLOW", "FOLLOW"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(Tag, "On Create!");
        Button myButton = findViewById(R.id.button);
        Button myButton2 = findViewById(R.id.button2);
        TextView text = (TextView) findViewById(R.id.textView);
        TextView text1 = (TextView) findViewById(R.id.textView2);

        text.setText(test.Name);
        text1.setText(test.Description);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(test.Followed == false) {
                    myButton.setText(condition[0]);
                    test.Followed = true;
                }
                else {
                    myButton.setText(condition[1]);
                    test.Followed = false;
                }

            }
        });
    }
}

