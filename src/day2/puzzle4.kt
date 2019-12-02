package day2

import java.io.File

private const val OPCODE_ADD = 1
private const val OPCODE_MULTIPLY = 2
private const val OPCODE_HALT = 99

fun main() {
    val filePath = "src/day2/input_puzzle4.txt"
    val intCodes = File(filePath).readText(Charsets.UTF_8)
        .split(",")
        .map { it.toInt() }
        .toIntArray()


    for (noun in 0..99) {
        for (verb in 0..99) {
            intCodes[1] = noun
            intCodes[2] = verb

            if (runIntCodeProgram(intCodes.copyOf()) == 19690720) {
                println("noun: $noun")
                println("verb: $verb")
                break
            }
        }
    }


}

fun runIntCodeProgram(intCodes: IntArray): Int {
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
    return intCodes[0]
}