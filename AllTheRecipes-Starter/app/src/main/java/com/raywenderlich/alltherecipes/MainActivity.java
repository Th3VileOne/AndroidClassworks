package com.raywenderlich.alltherecipes;


import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
  private ListView myListView;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    myListView = (ListView) findViewById(R.id.recipe_list_view);

    final ArrayList<Recipe> recipeList = Recipe.getRecipesFromFile("recipes.json", this);

    RecipeAdapter adapter = new RecipeAdapter(this, recipeList);
    myListView.setAdapter(adapter);

    final Context context = this;
    myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Recipe selectedRecipe = recipeList.get(position);
        Intent detailIntent = new Intent(context, RecipeDetailActivity.class);

        detailIntent.putExtra("title", selectedRecipe.title);
        detailIntent.putExtra("url", selectedRecipe.instructionUrl);
        startActivity(detailIntent);
      }
    });

  }

}