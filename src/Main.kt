/**
 * Kotlin Collections Task 4- Automation
 *
 *              OOOOO  OOO   OOO
 *                 O  O   O O   O
 *                O   O   O O   O
 *              OOOOO  OOO   OOO
 * +-------------+-------------+-------------+
 * |    __v__    |             |             |
 * |v__( o o )   |             |             |
 * | o )(---)__v_|   EMPTY?!   |   EMPTY?!   |
 * |--) __|_( o o|             |             |
 * ||  /|. .|\---|             |             |
 * +-------------+-------------+-------------+
 *
 * Well... Even with your awesome error-checking in the
 * monkey cage system, it seems that the zookeepers still
 * can't manage the monkeys properly...
 *
 * Monkeys are ending up in the wrong cages, some are
 * squashed three-to-a-cage. It's just a mess!
 *
 * We need you to automate the cage system so that the
 * zookeepers don't have to make decisions.
 */


/**
 * Constant vales used to define some key values
 * which can then be used throughout the code...
 */
const val NUMCAGES = 8      // The total number of cages
const val EMPTY = "---"     // Represents an empty cage


/**
 * Program entry point
 */
fun main() {
    //-------------------------------------------------
    println("Setting up the cages...")

    val cages = setupCages()
    println()

    //-------------------------------------------------
    println("Placing existing monkeys into cages...")

    placeMonkeyInCage(cages, 1, "Kevin")
    placeMonkeyInCage(cages, 8, "Sally")
    placeMonkeyInCage(cages, 3, "Pam")
    println()

    showMonkeyCages(cages)
    println()

    check(cages == listOf("Kevin", EMPTY, "Pam", EMPTY, EMPTY, EMPTY, EMPTY, "Sally"))

    //-------------------------------------------------
    println("Automatically placing some new monkeys...")

    val nigelCage = placeMonkey(cages, "Nigel")
    showMonkeyCages(cages)
    check(nigelCage == 2)
    check(cages == listOf("Kevin", "Nigel", "Pam", EMPTY, EMPTY, EMPTY, EMPTY, "Sally"))

    val jimCage = placeMonkey(cages, "Jim")
    showMonkeyCages(cages)
    check(jimCage == 4)

    check(cages == listOf("Kevin", "Nigel", "Pam", "Jim", EMPTY, EMPTY, EMPTY, "Sally"))

    println()

}


/**
 * Places a monkey in the first free, empty cage (starting from 1)
 * - If the monkey is placed successfully, returns the cage number
 * - If all cages are occupied, returns -1
 */
fun placeMonkey(cageList: MutableList<String>, name: String): Int {
    println("+++ Putting $name into a cage")

    // YOUR CODE HERE
    return -1
}


/**
 * Violent monkeys cannot be placed next to other monkeys!
 * Places a monkey in the first free, empty cage (starting from 1)
 * that has empty cages either side (or is an end cage)
 * - If the monkey is placed successfully, returns the cage number
 * - If all cages are occupied, returns -1
 */
fun placeViolentMonkey(cageList: MutableList<String>, name: String): Int {
    println("+++ Putting $name into a cage")

    // YOUR CODE HERE
    return -1
}













/**
 * ========================================================
 * FUNCTIONS BELOW ARE PROVIDED FOR FREE!
 * ========================================================
 * The functions below are similar to the ones you have
 * already developed over the previous tasks
 * ========================================================
 */


/**
 * Creates and returns a Mutable List, size NUMCAGES,
 * populated with strings representing empty cages
 */
fun setupCages(): MutableList<String> {
    val cageList = mutableListOf<String>()
    for (i in 1..NUMCAGES) cageList.add(EMPTY)
    println(">>> Created $NUMCAGES empty cages")
    return cageList
}


/**
 * Put a given monkey into the specified cage number (1...MAX)
 */
fun placeMonkeyInCage(cageList: MutableList<String>, cageNum: Int, name: String) {
    // Check for invalid cage number
    if (cageNum !in 1..NUMCAGES) return
    // Check for blank name
    if (name.isBlank()) return
    // Ok to go ahead and place the monkey
    println("+++ Putting $name into cage $cageNum")
    cageList[cageNum - 1] = name
}


/**
 * Show all cages from the given list, formatted as a horizontal table:
 *
 * +--------+--------+--------+--------+----
 * | Cage 1 | Cage 2 | Cage 3 | Cage 4 | Etc.
 * +--------+--------+--------+--------+----
 * | Kevin  | ---    | Samson | Pam    | Etc.
 * +--------+--------+--------+--------+----
 */
fun showMonkeyCages(cageList: List<String>) {
    val divider = "+--------".repeat(cageList.size) + "+"

    println(divider)
    for (i in 0 ..< cageList.size) print("| Cage ${i+1} ")
    println("|")

    println(divider)
    for ((i, name) in cageList.withIndex()) print("| ${name.padEnd(6)} ")
    println("|")

    println(divider)
}


