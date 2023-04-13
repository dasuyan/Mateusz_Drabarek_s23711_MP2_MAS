package compositioninner
class Qualification(private val qualificationName: String) {

    private val treatments: MutableList<Treatment> = ArrayList()

    fun createTreatment(partName: String): Treatment {
        val treatment = Treatment(partName)
        treatments.add(treatment)
        return treatment
    }

    override fun toString(): String {
        return qualificationName
    }

    inner class Treatment (private val treatmentName: String) {
        val qualification: Qualification
            get() = this@Qualification

        override fun toString(): String {
            return "Treatment: $treatmentName"
        }
    }
}