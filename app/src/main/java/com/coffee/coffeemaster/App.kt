package com.coffee.coffeemaster

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.coffee.coffeemaster.ui.theme.CoffeeMasterTheme
import com.coffee.coffeemaster.ui.theme.Primary
import com.coffee.coffeemaster.ui.theme.Secondary


@Preview()
@Composable
fun AppPreview() {
    CoffeeMasterTheme {
        App()
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    var selectedRoute = remember {
        mutableStateOf(Routes.MenuPage.route)
    }

    Scaffold (
        topBar = {
            TopAppBar(title = {
                AppTitle()
            },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Primary,
                    titleContentColor = Secondary
                )
            )
        },
        content = {
                  when(selectedRoute.value){
                      Routes.OfferPage.route -> OfferPage()
                  }
        },
        bottomBar = {
            NavBar(
                selectedRoute = selectedRoute.value,onChange = {
                newRoute-> selectedRoute.value = newRoute
            })
        }
    )
}

@Preview()
@Composable
fun AppTitle() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth()
    ){
        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription = "Coffee Master Logo")
    }

}