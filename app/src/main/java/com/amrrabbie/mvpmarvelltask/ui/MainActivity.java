package com.amrrabbie.mvpmarvelltask.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.amrrabbie.mvpmarvelltask.R;
import com.amrrabbie.mvpmarvelltask.model.Result;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MarvelView {


    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.spinner)
    Spinner spinner;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    MarvelPresenter marvelPresenter;
    MoviesListAdapter adapter;
    MovieSpinnerAdapter spadp;
    @BindView(R.id.pbar)
    ProgressBar pbar;
    @BindView(R.id.ll)
    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        btn.setOnClickListener(this);

        marvelPresenter = new MarvelPresenter(this);
        adapter = new MoviesListAdapter();


    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn) {

            pbar.setVisibility(View.VISIBLE);
            ll.setVisibility(View.GONE);

            marvelPresenter.getAllMovies();

        }
    }

    @Override
    public void getMovies(List<Result> results) {

        adapter.setList(results);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        spadp=new MovieSpinnerAdapter(MainActivity.this,results);
        spinner.setAdapter(spadp);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Result result = (Result) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, "Name: " + result.getName() + " - Description: " + result.getDescription(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        pbar.setVisibility(View.GONE);
        ll.setVisibility(View.VISIBLE);

    }
}
