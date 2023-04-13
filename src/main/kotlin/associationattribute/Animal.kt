package associationattribute

data class Animal(
    val name: String,
    val species: String,
    val age: Int,
    val cares: MutableList<Care> = mutableListOf()
) {
    fun addCare(care: Care) {
        if (!cares.contains(care)) {
            cares.add(care)
        }
    }

    fun removeCare(careToRemove: Care) {
        if (cares.contains(careToRemove)){
            //cares.remove(careToRemove)
            careToRemove.removeCare()
        }
    }

    fun getCaretakers(): String {
        var res = "Care records for $name the $species: \n"
        for (care in cares) {
            res += "    name: " + care.caretaker.name + "; email: " + care.caretaker.email + ", duration in days; " + care.numberOfDays + "\n"
        }
        return res
    }
}