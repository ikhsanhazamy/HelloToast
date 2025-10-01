    package com.devkit.hellotoast

    import android.content.Intent
    import android.net.Uri
    import androidx.appcompat.app.AppCompatActivity
    import android.os.Bundle
    import android.util.Log
    import android.view.View
    import android.widget.Button
    import android.widget.TextView
    import android.widget.Toast

    class MainActivity : AppCompatActivity() {
        private var mCount = 0

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val mShowCount = findViewById<TextView>(R.id.show_count)
            val buttonCountUp = findViewById<Button>(R.id.button_count)
            val buttonToast = findViewById<Button>(R.id.button_toast)
            val buttonSwitchPage = findViewById<Button>(R.id.button_switchpage)
            val buttonBrowser = findViewById<Button>(R.id.button_browser)

            // Tombol Count
            buttonCountUp.setOnClickListener {
                mCount++
                Log.d("mCount", mCount.toString())
                mShowCount.text = mCount.toString()
            }

            // Tombol Toast
            buttonToast.setOnClickListener {
                val tulisan: String = mShowCount.text.toString()
                Toast.makeText(this, "Angka yang dimunculkan $tulisan", Toast.LENGTH_LONG).show()
            }

            // Tombol Pindah Halaman (Explicit Intent)
            buttonSwitchPage.setOnClickListener {
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
            }

            // Tombol Browser (Implicit Intent)
            buttonBrowser.setOnClickListener {
                val intentbrowse = Intent(Intent.ACTION_VIEW)
                intentbrowse.data = Uri.parse("https://www.google.com/")
                startActivity(intentbrowse)
            }
        }
    }
