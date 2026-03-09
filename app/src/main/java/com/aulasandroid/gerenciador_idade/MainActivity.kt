package com.aulasandroid.gerenciador_idade

import android.R
import android.R.attr.name
import android.R.attr.text
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aulasandroid.gerenciador_idade.ui.theme.Gerenciador_idadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Gerenciador_idadeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ScreenGerenciadorIdade(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ScreenGerenciadorIdade(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Qual é a sua idade?",
            color = Color.Blue,
            fontSize = 32.sp,
            textAlign = TextAlign.Center
        )

        Text(
            text = "Aperte os botões para informar a sua idade",

            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )

        var idade by remember {
            mutableStateOf(1)
        }

        var maioridade by remember {
            mutableStateOf("")
        }

        Text(
            text = "$idade",
            fontSize = 26.sp,
            modifier = Modifier.padding(20.dp)
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Button(
                onClick = {
                    idade = idade - 1
                },
                modifier = Modifier.size(70.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue
                )
            ) {
                Text(
                    text = "-",
                    fontSize = 32.sp,
                    color = Color.White
                )
            }

            Button(
                onClick = {
                    idade = idade + 1
                },
                modifier = Modifier.size(70.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue
                )
            ) {
                Text(
                    text = "+",
                    fontSize = 32.sp,
                    color = Color.White
                )
            }
        }

        when (idade){
            in 1 .. 17 -> maioridade = "MENOR"
            in 18 .. 180 -> maioridade = "MAIOR"
            else        ->  if(idade <= 0) {
                maioridade = "MENOR"
                idade++
            } else {
                maioridade = "MAIOR"
                idade--
            }
        }

        if(idade >= 18) {
            maioridade = "MAIOR"
        } else {
            maioridade = "MENOR"
        }


        Text(
            text = "Você é $maioridade de idade",
            color = Color.Blue,
            fontSize = 26.sp,
            modifier = Modifier.padding(20.dp)
        )

    }
}
