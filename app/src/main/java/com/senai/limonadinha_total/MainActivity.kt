package com.senai.limonadinha_total

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.senai.limonadinha_total.ui.theme.Limonadinha_TotalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Limonadinha_TotalTheme {
                LimonadaApp()
            }
        }
    }
}

@Composable
fun TelasLimonada(modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)
) {
    var cliques by remember { mutableStateOf(0) }
    val gerenteImagens = when (cliques){
        1 -> R.drawable.lemon_tree
        (1..6).random() -> R.drawable.lemon_squeeze
        2 -> R.drawable.lemon_drink
        3 -> R.drawable.lemon_restart
        else -> R.drawable.lemon_tree
    }

    Column (
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(onClick = { if (cliques < 3){
            cliques += 1
        }
        }) {
            Image(
                painter = painterResource(gerenteImagens),
                contentDescription = "Árvore de limões"
            )
        }

        when (gerenteImagens){
            0 -> R.string.textoArvore
            (1..6).random() -> R.string.textoLimao
            2 -> R.string.textoCopoCheio
            3 -> R.string.textoCopoVazio
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LimonadaApp() {
    Limonadinha_TotalTheme {
        TelasLimonada()
    }
}