//_______________________________________________by.luk1s_______________________________________________

fun main() {
    println("Добро пожаловать в to-do list")

    val tasksMutableList: MutableList<Task> = mutableListOf()
    var taskIdCount = 0

    while(true) {
        println("\n1) Добавить задачу\n2) Просмотр всех задач\n3) Отметить задачу выполненной\n4) Выход из программы")
        print("Выберие один из пунктов: ")
        val taskSelection = readln()

        when (taskSelection) {
            "1" -> tasksMutableList.add(addTask(++taskIdCount))
            "2" -> {
                tasksMutableList.forEach { i ->
                    println(i)
                }
                print("Хотите удалить одну из задач? y/n: ")
                val deleteTaskFromTasks = readln()
                when (deleteTaskFromTasks) {
                    "y" -> {
                        print("Напишите id задачи, которую хотите удалить: ")
                        val id = readln().toInt()
                        if (deleteTask(id, tasksMutableList)) println("Задача удалена")
                        else println("Задача с id: \"$id\" не найдена.")
                    }
                    "n" -> {}
                }
            }
            "3" -> {
                println(tasksMutableList)
                print("Какую задачу считать выполненной? Введите id: ")
                val idExecute = readln().toInt()
                completeTask(idExecute, tasksMutableList)
            }
            "4" -> {
                println("Выход из программы.")
                break
            }
            else -> println("Неверный выбор. Попробуйте еще раз.")
        }
    }
}

private fun addTask(id: Int): Task {
    print("Введите название задачи: ")
    val nameTask = readln()
    print("Введите задачу: ")
    val description = readln()
    return Task(id, nameTask, description, false)
}

private fun deleteTask(id: Int, tasks: MutableList<Task>): Boolean {
    return tasks.removeIf { it.id == id }
}

private fun completeTask(id: Int, tasks: MutableList<Task>) {
    val task = tasks.find { it.id == id }
    if (task != null) {
        task.isComplete = true
        println("Задача с id: \"$id\" отмечена как выполненная.")
    } else {
        println("Задача с id \"$id\" не найдена.")
    }
}




