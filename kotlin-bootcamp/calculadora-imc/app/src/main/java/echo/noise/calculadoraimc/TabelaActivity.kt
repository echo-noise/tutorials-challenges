package echo.noise.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableRow
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_tabela.*

class TabelaActivity : AppCompatActivity() {
    private val tamanhoTextoP = 14F
    private val margemP = 5
    private val margemG = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabela)
        criarTabela()
    }

    fun criarTabela() {
        var cont = 1

        Faixas.values().forEach {
            val faixaParams = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT)
            faixaParams.setMargins(margemP, 0, margemG, 0)

            val faixaTXT = TextView(this)
            faixaTXT.textSize = tamanhoTextoP
            faixaTXT.layoutParams = faixaParams

            when {
                it.minimo == 0.0 -> faixaTXT.text = ">".plus(" ").plus(it.minimo.toString())
                it.maximo == 0.0 -> faixaTXT.text = it.minimo.toString().plus("+")
                else -> faixaTXT.text = it.minimo.toString().plus(" - ").plus(it.maximo.toString())
            }

            val textoParams = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT)
            textoParams.setMargins(margemG, 0, margemG, 0)

            val textoTXT = TextView(this)
            textoTXT.textSize = tamanhoTextoP
            textoTXT.text = getString(it.texto)
            textoTXT.layoutParams = faixaParams

            val sintomasParams = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 3f)
            sintomasParams.setMargins(margemG, 0, margemP, 0)

            val sintomasTXT = TextView(this)
            sintomasTXT.textSize = tamanhoTextoP
            sintomasTXT.text = getString(it.sintomas)
            sintomasTXT.layoutParams = sintomasParams

            if (cont %2 == 0) {
                faixaTXT.setBackgroundColor(ContextCompat.getColor(this, R.color.cinza1))
                sintomasTXT.setBackgroundColor(ContextCompat.getColor(this, R.color.cinza1))
            } else {
                faixaTXT.setBackgroundColor(ContextCompat.getColor(this, R.color.cinza2))
                textoTXT.setBackgroundColor(ContextCompat.getColor(this, R.color.cinza1))
                sintomasTXT.setBackgroundColor(ContextCompat.getColor(this, R.color.cinza2))
            }

            val linha = TableRow(this)
            linha.id = 100 + cont
            linha.addView(faixaTXT)
            linha.addView(textoTXT)
            linha.addView(sintomasTXT)

            tabela.addView(linha)
            ++cont
        }
    }
}