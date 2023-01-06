package com.example.movie_app.screen.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.movie_app.model.Movie
import com.example.movie_app.model.getMovies
import com.example.movie_app.witgets.MovieRow

@Composable
fun DetailsScreen(navController: NavController,
                  movieId: String?){
    val newMovieList= getMovies().filter { movie ->
        movie.id==movieId
    }
    Scaffold(topBar = {
        TopAppBar(
            modifier= Modifier.height(80.dp),
            backgroundColor = Color.LightGray,
            elevation = 5.dp
        ){
            Row(horizontalArrangement = Arrangement.Start) {
                Icon(imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Arraow Back",
                modifier = Modifier.clickable{
                    navController.popBackStack()
                })
                Spacer(modifier = Modifier.width(100.dp ))


                Text(text = "Movies",fontWeight = FontWeight.Bold, fontSize =30.sp)
            }

        }}) {

    Surface(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()) {

        Column(verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
            MovieRow(movie = newMovieList.first())

            Spacer(modifier = Modifier.height(23.dp))
            
            Divider()
            HorizontalScrollableImageView(newMovieList)

        }

    }



    }






    
}

@Composable
private fun HorizontalScrollableImageView(newMovieList: List<Movie>) {
    LazyRow {
        items(1) { image ->
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .size(240.dp),
                elevation = 5.dp
            ) {
                Image(
                    painter = rememberImagePainter(data = newMovieList.first().poster),
                    contentDescription = "movie poster"
                )

            }

        }
    }
}
