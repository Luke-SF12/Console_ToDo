data class Task(
    val id: Int,
    val nameTask: String,
    val description: String,
    var isComplete: Boolean = false
)