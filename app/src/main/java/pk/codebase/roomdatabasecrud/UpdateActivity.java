package pk.codebase.roomdatabasecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import pk.codebase.roomdatabasecrud.Room.UserDao;
import pk.codebase.roomdatabasecrud.Room.UserDatabase;
import pk.codebase.roomdatabasecrud.Room.Users;

public class UpdateActivity extends AppCompatActivity {
    private EditText nameEd,emailEd;
    private Button update;

    private Users users;

    private UserDatabase userDatabase;
    private UserDao userDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        userDatabase = UserDatabase.getInstance(this);
        userDao= userDatabase.getDao();

        nameEd = findViewById(R.id.name);
        emailEd = findViewById(R.id.email);
        update = findViewById(R.id.update);

        users = (Users) getIntent().getSerializableExtra("model");

        nameEd.setText(users.getName());
        emailEd.setText(users.getEmail());

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Users userModel = new Users(users.getId(),nameEd.getText().toString(),emailEd.getText().toString());
             userDao.update(userModel);
             finish();
            }
        });
    }
}