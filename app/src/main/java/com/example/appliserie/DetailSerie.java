package com.example.appliserie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailSerie extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_serie);
        Intent intent =getIntent();
        int position = intent.getIntExtra("pos",0);

        //JSONHelper jsonSerie = new JSONHelper(DetailSerie.this);
        //Serie laSerie = jsonSerie.getSerie(position);

        SerieSqlHelper dbHelper = new SerieSqlHelper(DetailSerie.this);
        Serie laSerie = dbHelper.getSerie(position);

        TextView titre = findViewById(R.id.titre);
        titre.setText(laSerie.getTitre());
        TextView resume = findViewById(R.id.resume);
        resume.setText(laSerie.getResume());
        resume.setMovementMethod(new ScrollingMovementMethod());

        TextView diffduree = findViewById(R.id.diffduree);
        diffduree.setText("1ere diffusion : "+laSerie.getPremiereDiffusion()+" duree : "+laSerie.getDuree());

        ImageView image = findViewById(R.id.imageView);
        Picasso.get().load(laSerie.getImage()).into(image);

    }
}