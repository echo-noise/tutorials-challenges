package echo.noise.calculadoraimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import echo.noise.calculadoraimc.Faixas

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        calcularBTN?.setOnClickListener {
            calcularIMC(pesoEDT.text.toString(), alturaEDT.text.toString())
        }
        verTabelaBTN?.setOnClickListener{
            val intent = Intent(this, TabelaActivity::class.java)
            startActivity(intent)
        }
    }

    private fun calcularIMC(peso: String, altura: String) {
        val peso = peso.toFloatOrNull()
        var altura = altura.toFloatOrNull()
        if (altura != null) {
            // conversao automatica de medida
            if (altura >= 100) { altura /= 100 }
            val pesoIdealMin = Faixas.IDEAL.minimo * (altura * altura)
            val pesoIdealMax = Faixas.IDEAL.maximo * (altura * altura)
            pesoIdealTXT.text = getString(R.string.peso_ideal, pesoIdealMin, pesoIdealMax)

            if (peso != null) {
                val imc = peso / (altura * altura)
                val significado: String

                when {
                    imc < Faixas.MABAIXO.maximo -> {
                        significado = getString(Faixas.MABAIXO.texto)
                        sintomasTXT.text = getString(R.string.resultado_sintomas, getString(Faixas.MABAIXO.sintomas))
                    }
                    imc < Faixas.ABAIXO.maximo -> {
                        significado = getString(Faixas.ABAIXO.texto)
                        sintomasTXT.text = getString(R.string.resultado_sintomas, getString(Faixas.ABAIXO.sintomas))
                    }
                    imc < Faixas.IDEAL.maximo -> {
                        significado = getString(Faixas.IDEAL.texto)
                        sintomasTXT.text = " "
                    }
                    imc < Faixas.ACIMA.maximo -> {
                        significado = getString(Faixas.ACIMA.texto)
                        sintomasTXT.text = getString(R.string.resultado_sintomas, getString(Faixas.ACIMA.sintomas))
                    }
                    imc < Faixas.OBESIDADE1.maximo -> {
                        significado = getString(Faixas.OBESIDADE1.texto)
                        sintomasTXT.text = getString(R.string.resultado_sintomas, getString(Faixas.OBESIDADE1.sintomas))
                    }
                    imc < Faixas.OBESIDADE2.maximo -> {
                        significado = getString(Faixas.OBESIDADE2.texto)
                        sintomasTXT.text = getString(R.string.resultado_sintomas, getString(Faixas.OBESIDADE2.sintomas))
                    }
                    else -> {
                        significado = getString(Faixas.OBESIDADE3.texto)
                        sintomasTXT.text = getString(R.string.resultado_sintomas, getString(Faixas.OBESIDADE3.sintomas))
                    }
                }
                resultadoTXT.text = getString(R.string.resultado, imc, significado)
            }
        } else {
            Toast.makeText(this, getString(R.string.erro), Toast.LENGTH_SHORT).show()
        }
    }
}