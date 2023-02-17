package ru.smak.interfacetest

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.smak.interfacetest.ui.theme.InterfaceTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InterfaceTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Greeting(
                            "Android",
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                        MainButton(
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier,
        text = "Hello $name!"
    )
}

@Composable
fun MainButton(
    modifier: Modifier = Modifier,
){
    val timesPressed = rememberSaveable{ mutableStateOf(0) }
    Button(
        onClick = {
            timesPressed.value++
            Log.d("MB", "${timesPressed}")
        },
        modifier = modifier.wrapContentSize(),
        shape = RoundedCornerShape(10.dp)
    ){
        Text(
            text = if (timesPressed.value == 0) stringResource(id = R.string.btnText1)
            else stringResource(id = R.string.btnText2, timesPressed.value)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    InterfaceTestTheme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonPreview(){
    InterfaceTestTheme{
        MainButton()
    }
}