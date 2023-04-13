package associationattribute

import java.time.LocalDate

data class Caretaker(
    val name: String,
    val email: String,
    val dateOfEmployment: LocalDate,
    val cares: MutableList<Care> = mutableListOf()
) {
    fun addCare(care: Care) {
        if (!cares.contains(care)) {
            cares.add(care)
        }
    }

    fun removeCare(care: Care) {
        require(cares.contains(care)) { "Caretaker doesn't have this Care record" }
        care.animal.removeCare(care)
        cares.remove(care)
    }
    fun getAnimals(): String {
        var res = "Care records for Mr./Mrs. $name: \n"
        for (care in cares) {
            res += "    name: " + care.animal.name + "; species: " + care.animal.species + "; duration in days: " + care.numberOfDays + "\n"
        }
        return res
    }
}