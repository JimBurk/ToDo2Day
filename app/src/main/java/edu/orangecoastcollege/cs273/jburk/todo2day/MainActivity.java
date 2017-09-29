package edu.orangecoastcollege.cs273.jburk.todo2day;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Task> mAllTasksList = new ArrayList<>();

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        deleteDatabase(DBHelper.DATABASE_NAME);

        mAllTasksList.add(new Task("Study for midterm", false));
        mAllTasksList.add(new Task("Feed Mortimer", true));
        mAllTasksList.add(new Task("Sleep at some time", false));
        mAllTasksList.add(new Task("Complete IC #8", true));

        DBHelper db = new DBHelper(this);
        for (Task t : mAllTasksList)
            db.addTask(t);

        mAllTasksList.clear();

        mAllTasksList = db.getAllTasks();

        Log.i(TAG, "Showing all tasks:");
        for (Task t : mAllTasksList)
            Log.i(TAG, t.toString());

        Log.i(TAG, "After deleting task 4");
        db.deleteTask(mAllTasksList.get(3));
    }
}
