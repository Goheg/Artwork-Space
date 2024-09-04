package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    ArtworkAppLayout()
                }
            }
        }
    }
}

@Composable
fun ArtDetails(title: String, artist: String){
    Column(
        modifier = Modifier
            .background(color = Color.Gray)
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = title)
        Text(text = artist)
    }
}

@Composable
fun ArtSpaceApp(){
    var currentArtwork by remember { mutableStateOf(1) }
    val firstArtwork = R.drawable.deadpool_and_wolverine_panic_at_every_turn_p3
    val secondArtwork = R.drawable.ryan_reynolds_is_wade_o3
    val thirdArtwork = R.drawable.wade_wilson_in_deadpool_3_zd
    val lastArtwork = R.drawable.deadpool_and_wolverine_come_back_of



    when(currentArtwork) {
        1 -> {
            ArtSpaceLayout(
            artworkId = firstArtwork,
            artworkTitle = R.string.deadpool_Wolverine_panic,
            artworkArtist = R.string.Artwork_artist,
            onNextClick = { currentArtwork = 2 },
            onPreviousClick = { currentArtwork = 4 }
        )
        }
        2 -> {
            ArtSpaceLayout(
                artworkId = secondArtwork,
                artworkTitle = R.string.deadpool_Wolverine_panic,
                artworkArtist = R.string.Artwork_artist,
                onNextClick = { currentArtwork = 3 },
                onPreviousClick = { currentArtwork = 1 }
            )
        }
        3 -> {
            ArtSpaceLayout(
                artworkId = thirdArtwork,
                artworkTitle = R.string.deadpool_Wolverine_panic,
                artworkArtist = R.string.Artwork_artist,
                onNextClick = { currentArtwork = 4 },
                onPreviousClick = { currentArtwork = 2 }
            )
        }
        4 -> {
            ArtSpaceLayout(
                artworkId = lastArtwork,
                artworkTitle = R.string.deadpool_Wolverine_panic,
                artworkArtist = R.string.Artwork_artist,
                onNextClick = { currentArtwork = 1 },
                onPreviousClick = { currentArtwork = 3 }
            )
        }

    }
}


//@Preview(showBackground = true)
@Composable
fun ArtSpaceLayout(
    artworkId: Int,
    artworkTitle: Int,
    artworkArtist: Int,
    onNextClick: () -> Unit,
    onPreviousClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(12.dp)
    ) {
        Box(
            modifier = Modifier.shadow(10.dp, spotColor = Color.Black, shape = RoundedCornerShape(8.dp))
        ) {
            Image(
                painter = painterResource(artworkId),
                contentDescription = "Deadpool pic",
                modifier = Modifier
                    .padding(16.dp)
            )
        }
        Spacer(modifier = Modifier.height(50.dp))
        ArtDetails(title = stringResource(artworkTitle), artist = stringResource(artworkArtist))
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick =  onPreviousClick ) {
                Text(text = "Previous")
            }
            Button(onClick =  onNextClick ) {
                Text(text = "Next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtworkAppLayout(){
    ArtSpaceApp()
}

