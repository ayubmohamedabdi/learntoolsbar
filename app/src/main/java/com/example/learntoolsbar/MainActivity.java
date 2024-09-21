package com.example.learntoolsbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private BottomAppBar bottomAppBar;
    private FloatingActionButton fab, fabOption1, fabOption2, fabOption3, fabOption4, fabOption5, fabOption6;
    private SearchView searchView;
    private boolean isFabOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomAppBar = findViewById(R.id.bottom_app_bar);
        fab = findViewById(R.id.fab);
        fabOption1 = findViewById(R.id.fab_option_1);
        fabOption2 = findViewById(R.id.fab_option_2);
        fabOption3 = findViewById(R.id.fab_option_3);
        fabOption4 = findViewById(R.id.fab_option_4);
        fabOption5 = findViewById(R.id.fab_option_5);
        fabOption6 = findViewById(R.id.fab_option_6);
        searchView = findViewById(R.id.search_view);
        ImageButton searchIcon = findViewById(R.id.search_icon);

        setSupportActionBar(bottomAppBar);
        getSupportActionBar().setTitle("learn tools bar");

        // Initially hide all FAB options
        hideFabOptions();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleFab(); // Toggle FAB and show/hide other buttons
            }
        });

        searchIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleSearchView();
            }
        });
    }

    private void toggleFab() {
        if (isFabOpen) {
            fab.setImageResource(android.R.drawable.ic_input_add); // Change to '+'
            hideFabOptions(); // Hide additional buttons
        } else {
            fab.setImageResource(android.R.drawable.ic_menu_close_clear_cancel); // Change to 'X'
            showFabOptions(); // Show additional buttons
        }
        isFabOpen = !isFabOpen;
    }

    private void showFabOptions() {
        fabOption1.setVisibility(View.VISIBLE);
        fabOption2.setVisibility(View.VISIBLE);
        fabOption3.setVisibility(View.VISIBLE);
        fabOption4.setVisibility(View.VISIBLE);
        fabOption5.setVisibility(View.VISIBLE);
        fabOption6.setVisibility(View.VISIBLE);
    }

    private void hideFabOptions() {
        fabOption1.setVisibility(View.GONE);
        fabOption2.setVisibility(View.GONE);
        fabOption3.setVisibility(View.GONE);
        fabOption4.setVisibility(View.GONE);
        fabOption5.setVisibility(View.GONE);
        fabOption6.setVisibility(View.GONE);
    }

    private void toggleSearchView() {
        if (searchView.getVisibility() == View.GONE) {
            searchView.setVisibility(View.VISIBLE);
        } else {
            searchView.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.popup_menu, menu);
        return true;
    }

    @Override

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_menu) {
            showPopupMenu();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void showPopupMenu() {
        View view = findViewById(R.id.action_menu);
        PopupMenu popup = new PopupMenu(MainActivity.this, view);
        popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
        popup.show();
    }
}
