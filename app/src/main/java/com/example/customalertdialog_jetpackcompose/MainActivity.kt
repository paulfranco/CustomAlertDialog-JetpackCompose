package com.example.customalertdialog_jetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.customalertdialog_jetpackcompose.ui.theme.CustomAlertDialogJetpackComposeTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomAlertDialogJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    AlertDialogComponent()
                }
            }
        }
    }
}


@Composable
fun AlertDialogComponent() {
    val isDialogOpen = remember { mutableStateOf(false) }
    val context = LocalContext.current
    if (!isDialogOpen.value) {
        AlertDialog(onDismissRequest = { isDialogOpen.value = true },
            title = { Text(text = "This license will govern any updates of the Application by the Company that replace, repair and/or supplement the first Application, unless a separate license is provided for such update") },
            text = {
                Row(
                    modifier = Modifier
                        .padding(5.dp)
                        .horizontalScroll(rememberScrollState())
                ) {
                    Card(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()
                            .shadow(2.dp), backgroundColor = Color.DarkGray
                    ) {
                        Column(modifier = Modifier.padding(5.dp)) {
                            listForCard1().forEach {
                                Row(Modifier.width(230.dp)) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_baseline_warning_24),
                                        contentDescription = null
                                    )
                                    Text(text = it, color = Color.White)
                                }
                            }
                        }
                    }
                    Card(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()
                            .shadow(2.dp), backgroundColor = Color.DarkGray
                    ) {
                        Column(modifier = Modifier.padding(5.dp)) {
                            listForCard2().forEach {
                                Row(Modifier.width(230.dp)) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_baseline_warning_24),
                                        contentDescription = null
                                    )
                                    Text(text = it, color = Color.White)
                                }
                            }
                        }
                    }
                }
            },
            confirmButton = {
                Button(onClick = {
                    isDialogOpen.value = true
                    Toast.makeText(
                        context,
                        "You have accepted the Terms and Conditions ",
                        Toast.LENGTH_LONG
                    ).show()
                }) {
                    Text(text = "I Understand")
                }
            },
            dismissButton = {
                TextButton(onClick = { isDialogOpen.value = true }) {
                    Text(text = "Cancel")

                }
            }
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CustomAlertDialogJetpackComposeTheme {
        AlertDialogComponent()
    }
}