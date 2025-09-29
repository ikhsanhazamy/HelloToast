package com.devkit.hellotoast

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devkit.hellotoast.ui.theme.HelloToastTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloToastTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(
                        onShowToast = { message ->
                            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(onShowToast: (String) -> Unit) {
    // ganti mCount dengan state biar UI bisa update otomatis
    var mCount by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // TextView untuk menampilkan angka
        Text(
            text = mCount.toString(),
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Baris untuk dua tombol: Count dan Toast
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Button Count (tambah angka)
            Button(onClick = { mCount++ }) {
                Text("COUNT")
            }

            // Button Toast (tampilkan toast)
            Button(onClick = {
                onShowToast("Angka yang dimunculkan: $mCount")
            }) {
                Text("TOAST")
            }
        }
    }
}