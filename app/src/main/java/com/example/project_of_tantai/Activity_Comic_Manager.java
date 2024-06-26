package com.example.project_of_tantai;

import static android.app.ProgressDialog.show;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Activity_Comic_Manager extends AppCompatActivity {
    List<Comic> data = new ArrayList<>();
    ListView listView;
    ComicAdapter adapter;
    ArrayList<Comic> Comiclist;
    @SuppressLint("SuspiciousIndentation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);
        DBHelper.createDB(this);
        listView = findViewById(R.id.listviewcomic);
        data = Database_Manager.getALL();
        adapter = new ComicAdapter(this, data);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);

        // Set an item click listener for short clicks
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Handle the click event, you can navigate to another activity here
                Intent intent = new Intent(Activity_Comic_Manager.this, ComicDetailsActivity.class);
                String namecomic = data.get(position).getNamecomic();
                String imagecomic = data.get(position).getImagecomic();
                String artistcomic = data.get(position).getArtistcomic();
                String contentcomic = data.get(position).getContentcomic();
                intent.putExtra("namesong", namecomic);
                intent.putExtra("image", imagecomic);
                intent.putExtra("nameartist", artistcomic);
                intent.putExtra("content", contentcomic);
                startActivity(intent);
            }
        });

        // Set a long click listener for handling context menu (if needed)
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // Handle long click events here if needed
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuoption,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menucontext,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.exit) {
            finish();
        } else if (itemId == R.id.count) {
            Toast.makeText(this, "In App have: " + data.size(), Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.add) {
            add_comic();
        }
        return super.onOptionsItemSelected(item);
    }

    public void add_comic()
    {
        View v = LayoutInflater.from(this).inflate(R.layout.addadd_comic ,null);
      EditText ednamesong = v.findViewById(R.id.nameSong);
      EditText edimagesong = v.findViewById(R.id.imageSong);
      EditText edartistsong = v.findViewById(R.id.artistSong);
      EditText edcontentsong =  v.findViewById(R.id.contentSong);
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setView(v);
        b.setPositiveButton("ADD", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String snamesong = ednamesong.getText().toString();
                String simagesong = edimagesong.getText().toString();
                String sartistsong = edartistsong.getText().toString();
                String scontentsong = edcontentsong.getText().toString();
                Comic comic = new Comic(snamesong,simagesong,sartistsong,scontentsong);
                data.add(comic);
                adapter.notifyDataSetChanged();
                Database_Manager.insert(comic);
            }
        }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).show();

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int index = info.position;

        if (item.getItemId() == R.id.delete) {
            deleteComic(index);
            return true;
        } else if (item.getItemId() == R.id.edit) {
            edit_comic(index);
            return true;
        } else {
            return super.onContextItemSelected(item);
        }
    }

    private void deleteComic(int index) {
        // Get the corresponding Comic object to get its ID
        Comic comicToDelete = data.get(index);

        // Create a confirmation dialog
        AlertDialog.Builder confirmationDialog = new AlertDialog.Builder(this);
        confirmationDialog.setTitle("Confirm Delete");
        confirmationDialog.setMessage("Are you sure you want to delete this comic?");
        confirmationDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Remove the item from the list
                data.remove(index);

                // Update the adapter
                adapter.notifyDataSetChanged();

                // Delete the Comic from the database using its ID
                Database_Manager.delete(comicToDelete.getId());
            }
        });
        confirmationDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Do nothing if the user clicks "No"
            }
        });

        // Show the confirmation dialog
        confirmationDialog.show();
    }


    @SuppressLint("MissingInflatedId")
    public void edit_comic(int index) {
        View v = LayoutInflater.from(this).inflate(R.layout.editedit_comic, null);
        EditText editnameSong = v.findViewById(R.id.edednameSong);
        EditText editnameArtist = v.findViewById(R.id.ededartistSong);
        EditText editImageComic = v.findViewById(R.id.ededimage);
        EditText editContentComic = v.findViewById(R.id.ededcontent);

        // Populate the EditText fields with existing data
        Comic selectedComic = data.get(index);
        editnameSong.setText(selectedComic.getNamecomic());
        editnameArtist.setText(selectedComic.getArtistcomic());
        editImageComic.setText(selectedComic.getImagecomic());
        editContentComic.setText(selectedComic.getContentcomic());

        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setView(v);
        b.setPositiveButton("EDIT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String newName = editnameSong.getText().toString();
                String newArtist = editnameArtist.getText().toString();
                String newImage = editImageComic.getText().toString();
                String newContent = editContentComic.getText().toString();

                // Update the selected Comic's data
                selectedComic.setNamecomic(newName);
                selectedComic.setArtistcomic(newArtist);
                selectedComic.setImagecomic(newImage);
                selectedComic.setContentcomic(newContent);

                // Update the adapter and database
                adapter.notifyDataSetChanged();
                Database_Manager.update(selectedComic);
            }
        }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).show();
    }


}
