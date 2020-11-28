package br.com.Innaval.icmaplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.math.RoundingMode
import java.text.DecimalFormat

class ImcActivity : AppCompatActivity() {

    private lateinit var editTextPeso: EditText
    private lateinit var editTextAltura: EditText
    private lateinit var buttonCalcular: Button
    private lateinit var textViewResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)

        editTextPeso = findViewById(R.id.edit_text_peso)
        editTextAltura = findViewById(R.id.edit_text_altura)
        buttonCalcular = findViewById(R.id.button_calcular)
        textViewResultado = findViewById(R.id.text_view_resultado)



        // *** Testar se o formulário está preenchido corretamente
        buttonCalcular.setOnClickListener {
            val isValido = validaForm()
            if(isValido){
                val peso = editTextPeso.text.toString().toDouble()
                val altura = editTextAltura.text.toString().toDouble()
                val imc = (peso/(altura*altura))
                val df = DecimalFormat("#")
                df.roundingMode = RoundingMode.CEILING

                val resultadoImc = "Seu Imc é : " + df.format(imc) + "Kg/m²"
                textViewResultado.text =  resultadoImc

            }
        }
    }

    private fun validaForm():Boolean {

        var isValid = true
        if(editTextPeso.text.toString().toDoubleOrNull() == null){
            editTextPeso.error = "Digite seu Peso!"
            isValid = false
        }

        if(editTextAltura.text.toString().toDoubleOrNull() == null){
            editTextAltura.error = "Digite sua Altura!"
            isValid = false
        }

        return isValid

    }
}