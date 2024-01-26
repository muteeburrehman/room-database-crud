package pk.codebase.roomdatabasecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import pk.codebase.roomdatabasecrud.Room.UserDao;
import pk.codebase.roomdatabasecrud.Room.UserDatabase;
import pk.codebase.roomdatabasecrud.Room.Users;

public class MainActivity extends AppCompatActivity {

    EditText nameEd,emailEd;
    Button insertBtn;

    private UserDatabase userDatabase;
    private UserDao userDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userDatabase=UserDatabase.getInstance(this);
        userDao = userDatabase.getDao();

        nameEd = findViewById(R.id.name);
        emailEd = findViewById(R.id.email);
        insertBtn = findViewById(R.id.insert);

        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = nameEd.getText().toString();
                String email = emailEd.getText().toString();

                Users users = new Users(0,name,email);
                userDao.insert(users);
                nameEd.setText("");
                emailEd.setText("");
                Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_SHORT).show();
            }
        });
    }
}