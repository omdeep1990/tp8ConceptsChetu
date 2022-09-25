package com.chetu.demotp8.javaConcepts.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.chetu.demotp8.R;
import com.chetu.demotp8.databinding.ActivityMenuBinding;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //TODO: To create context menu we need a view so we can take view from the OnclickListener method or directly: -
        //TODO: Directly giving the view: -
//        registerForContextMenu(binding.contextMenu);


        binding.contextMenu.setOnClickListener(this);
        binding.popupMenu.setOnClickListener(this);

    }

    //TODO: Options Menu
    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.options_context_menu, menu);
        //TODO: To add icon with options_menu display list using menu code: -
        if (menu instanceof MenuBuilder) {
            MenuBuilder menuBuilder = (MenuBuilder) menu;
            menuBuilder.setOptionalIconsVisible(true);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_settings:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;

            case R.id.item_about_us:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_app_version:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_about_app:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //TODO: //TODO: Giving the view by using the method, Context Menu: -
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.options_context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_settings:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;

            case R.id.item_about_us:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_app_version:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_about_app:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.context_menu:
                registerForContextMenu(view);
                break;

            case R.id.popup_menu:
                PopupMenu popupMenu = new PopupMenu(this, view);
                MenuInflater menuInflater= getMenuInflater();
                menuInflater.inflate(R.menu.options_context_menu, popupMenu.getMenu());
                popupMenu.show();

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.item_settings:
                                Toast.makeText(MenuActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.item_about_us:
                                Toast.makeText(MenuActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.item_app_version:
                                Toast.makeText(MenuActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.item_about_app:
                                Toast.makeText(MenuActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return false;
                    }
                });
                break;
        }
    }
}