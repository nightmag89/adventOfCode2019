import java.io.File

fun main() {
    val filePath = "src/Day1/input_puzzle1.txt"
    val massValues = File(filePath).useLines { it.toList() }

    val totalFuel = massValues
        .map { mass -> calculateModuleFuel(mass.toInt()) }
        .sum()

    print(totalFuel)
}

private fun calculateModuleFuel(mass: Int): Int {
    return mass / 3 - 2
}
