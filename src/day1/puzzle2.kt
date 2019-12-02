import java.io.File

fun main() {
    val filePath = "src/Day1/input_puzzle2.txt"
    val massValues = File(filePath).useLines { it.toList() }

    val totalFuel = massValues
        .map { mass -> calculateFuel(mass.toInt()) }
        .sum()

    print(totalFuel)
}

tailrec fun calculateFuel(mass: Int): Int {
    val fuel = mass / 3 - 2;
    return if (fuel <= 0)
        0
    else
        fuel + calculateFuel(fuel)
}

