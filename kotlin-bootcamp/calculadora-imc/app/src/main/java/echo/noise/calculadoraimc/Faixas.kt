package echo.noise.calculadoraimc

enum class Faixas(val minimo: Double, val maximo: Double, val texto: Int, val sintomas: Int) {
    MABAIXO(0.0, 17.0, R.string.mabaixo_texto, R.string.mabaixo_sintomas),
    ABAIXO(17.0,18.5, R.string.abaixo_texto, R.string.abaixo_sintomas),
    IDEAL(18.5,24.99, R.string.ideal_texto, R.string.ideal_sintomas),
    ACIMA(25.0,29.99, R.string.acima_texto, R.string.acima_sintomas),
    OBESIDADE1(30.0,34.99, R.string.obesidade1_texto, R.string.obesidade1_sintomas),
    OBESIDADE2(35.0,39.99, R.string.obesidade2_texto, R.string.obesidade2_sintomas),
    OBESIDADE3(40.0,0.0, R.string.obesidade3_texto, R.string.obesidade3_sintomas);
}