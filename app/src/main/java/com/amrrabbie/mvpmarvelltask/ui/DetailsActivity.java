package com.amrrabbie.mvpmarvelltask.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.amrrabbie.mvpmarvelltask.R;
import com.amrrabbie.mvpmarvelltask.model.Result;
import com.amrrabbie.mvpmarvelltask.model.Thumbnail;
import com.squareup.picasso.Picasso;

import java.io.Serializable;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {

    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.desc)
    TextView desc;
    Result result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        result = (Result) getIntent().getSerializableExtra("result");

        fillCtrls();
    }

    private void fillCtrls() {
        name.setText(result.getName());
        desc.setText(result.getDescription());

        Thumbnail thumbnail = result.getThumbnail();

        String imgurl=thumbnail.getPath() + "/" + "portrait_uncanny" + "." + thumbnail.getExtension();

        Picasso.get()
                .load(imgurl)
                .resize(50, 50)
                .centerCrop()
                .into(img);
    }
}
