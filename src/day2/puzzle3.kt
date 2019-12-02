package day2

import java.io.File

const val OPCODE_ADD = 1
const val OPCODE_MULTIPLY = 2
const val OPCODE_HALT = 99

fun main() {
    val filePath = "src/day2/input_puzzle3.txt"
    val intCodes = File(filePath).readText(Charsets.UTF_8)
        .split(",")
        .map { it.toInt() }
        .toIntArray()

    // "before running the program, replace position 1 with the value 12 and replace position 2 with the value 2"
    intCodes[1] = 12
    intCodes[2] = 2

    var i = 0;

    while (true) {
        if (intCodes[i] == OPCODE_HALT)
            break
        else {
            val firstValuePos = intCodes[i + 1]
            val secondValuePos = intCodes[i + 2]
            val resultPos = intCodes[i + 3]

            if (intCodes[i] == OPCODE_ADD) {
                intCodes[resultPos] = intCodes[firstValuePos] + intCodes[secondValuePos]
            } else if (intCodes[i] == OPCODE_MULTIPLY) {
                intCodes[resultPos] = intCodes[firstValuePos] * intCodes[secondValuePos]
            }

            i += 4
        }
    }
    print(intCodes[0])
}