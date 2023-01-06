package com.example.movie_app.screen.homeScreen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.movie_app.model.Movie
import com.example.movie_app.model.getMovies
import com.example.movie_app.navigation.MovieScreens
import com.example.movie_app.witgets.MovieRow


@Composable
fun HomeScreen(navController: NavController){
    Scaffold(topBar = {
        TopAppBar(modifier= Modifier.height(80.dp),
            backgroundColor = Color.LightGray,
            elevation = 5.dp
        ) {
            Text(text = "Movies", fontWeight = FontWeight.Bold, fontSize =30.sp)

        }
    }) {
        MainContent(navController=navController)

    }

}


@Composable
fun MainContent(navController: NavController,
    movieList : List<Movie> = getMovies())
{
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn{
            items(items=movieList){

                MovieRow(movie = it){movie->
                    navController.navigate(route = MovieScreens.DetailsScreen.name+"/$movie")
                    Log.d("movie","MainContent: Movie name is -> ${movie}")
                }
            }


        }

    }


}



