package com.example.dl.drawer;

import android.drm.DrmStore;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    // 1-on déclare le drawerLayout créé dans le XML
    private DrawerLayout mDrawerLayout;
    // 2- on déclare un actionBarDrawerToggle. c'est le bouton sur lequel on appuiera pour afficher le drawer
    private ActionBarDrawerToggle mToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //3- on récupère le DrawerLayout
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        //4- on crée l'ActionBarDrawerToggle
        //on passe en paramètre l'activité, ici this, le drawerLayout, ici mDrawerLayout, et une string open et close qu'on a créées dans les ressources
        //(je sais pas à quoi elles servent encore)
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        //5- on crée un DrawerListener auquel on passe le toggle en paramètre
        mDrawerLayout.addDrawerListener(mToggle);
        //6- on synchronise (sert à savoir dans quel position est le drawer (sorti ou rentré))
        mToggle.syncState();

        // 7- on récupère la supportActionBar et on setDisplayHomeAsUpEnabled (cette méthode rend l'icone et le titre de l'action bar clickable)
        //attention, ca rend le bouton clickable mais ca ne fait pas pour autant apparaitre le drawer
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    // 8- cette méthode sera appelée a chaque fois qu'on appuiera sur un des éléments de l'actionBar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // 9- si le bouton sur lequel on a cliqué est mToggle, on retourne true
        //ca va permettre de lier le drawer au bouton
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
