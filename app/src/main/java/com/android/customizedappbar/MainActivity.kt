package com.android.customizedappbar



import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.customizedappbar.ui.theme.CustomizedAppbarTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomizedAppbarTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Test()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Test() {


        val vm = TViewModel()
        val context = LocalContext.current.applicationContext

        val image = (R.drawable.image_on_appbar)
        val myLogo = BitmapFactory.decodeResource(context.resources, image)

        val dominantColorTextColor = vm.createPaletteSync(myLogo).dominantSwatch?.titleTextColor
        val variantColorTextColor = vm.createPaletteSync(myLogo).vibrantSwatch?.titleTextColor
        val mutedColorTextColor = vm.createPaletteSync(myLogo).mutedSwatch?.titleTextColor

        val dominantColor = vm.createPaletteSync(myLogo).dominantSwatch?.rgb
        val variantColor = vm.createPaletteSync(myLogo).vibrantSwatch?.rgb
        val mutedColor = vm.createPaletteSync(myLogo).mutedSwatch?.rgb


    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                    title = {
                        Text(text = "Appbar", color = Color.White)
                    }  ,
                    navigationIcon = {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
                    },
                    actions = {
                        Icon(imageVector = Icons.Default.MoreVert, contentDescription = "")
                    },
                    colors  = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = Color(mutedColor!!)
                    )

            )
        },
        content = {
            Column(modifier = Modifier.fillMaxSize()) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround ) {
                    //primary/dominant
                    Box(modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .background(color = Color(dominantColor!!))){
                        Text(text = "dominant",  modifier = Modifier.fillMaxSize().wrapContentSize(), color = Color(dominantColorTextColor!!))
                    }


                    //variant/secondary
                    Box(modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .background(Color(variantColor!!))) {
                        Text(text = "variant",   modifier = Modifier.fillMaxSize().wrapContentSize(), color = Color(variantColorTextColor!!))
                    }

                    //muted/light
                    Box(modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .background(Color(mutedColor!!))) {
                        Text(text = "muted", modifier = Modifier.fillMaxSize().wrapContentSize(), color = Color(mutedColorTextColor!!))
                    }

                }
                Image(painter = painterResource(id = R.drawable.image_on_appbar), contentDescription ="" )
            }
        }
    )

}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CustomizedAppbarTheme {

    }
}