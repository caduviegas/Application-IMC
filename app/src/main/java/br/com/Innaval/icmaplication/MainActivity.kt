package br.com.Innaval.icmaplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

               val buttonImc = findViewById<Button>(R.id.button_imc)

        buttonImc.setOnClickListener {

            val abrirImc = Intent(this, ImcActivity::class.java)
            startActivity(abrirImc)
        }

    }
}