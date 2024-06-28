package com.example.superheroapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroapp.models.Hero

@Composable
fun HeroImage(id:Int , string: String){
    Box(
        Modifier
            .size(72.dp)
            .clip(RoundedCornerShape(8.dp))){
      Image(painter = painterResource(id =id ), contentDescription = string , contentScale = ContentScale.Crop)
    }
}

@Composable
fun HeroCard(hero: Hero){
    Card(
        Modifier
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
            .clip(RoundedCornerShape(16.dp))) {
        Row(
            Modifier
                .padding(16.dp)
                .height(72.dp)) {
            Column(
                Modifier
                    .padding(end = 16.dp)
                    .weight(1f)) {
                Text(text = stringResource(id = hero.nameRes) , style = MaterialTheme.typography.headlineSmall
                )
                Text(text = stringResource(id = hero.descriptionRes) , style = MaterialTheme.typography.bodyLarge)
            }
            Spacer(Modifier.width(16.dp))
            HeroImage(id = hero.imageRes, string = stringResource(id = hero.nameRes))
        }
    }

}
@Preview
@Composable
fun HeroPrev(){
   HeroCard(hero =  Hero(
       nameRes = R.string.hero1,
       descriptionRes = R.string.description1,
       imageRes = R.drawable.android_superhero1
   )
   )
}

@Composable
fun heroLIST(hero: List<Hero>){

    Scaffold(topBar = { topBar() }) {  it ->


    LazyColumn(Modifier.statusBarsPadding() , contentPadding = it) {

        items(hero) { heri ->
            HeroCard(hero = heri)
        }
    }}
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun topBar(){
    CenterAlignedTopAppBar(title = { Row {
    Text(text = "SuperHeroes    " , style = MaterialTheme.typography.displayLarge)
}})

}