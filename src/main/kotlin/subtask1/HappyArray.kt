package subtask1

class HappyArray {
    fun convertToHappy(sadArray: IntArray): IntArray {
        // массив в виде листа - начальная установка
        var massiv_buffer: MutableList<Int> = mutableListOf<Int>()
        for (i in 0..sadArray.size - 1) {massiv_buffer.add(sadArray[i])}

        // смысл проверки только при больше 2
        if (massiv_buffer.size > 2)
        {
            var i = 1
            while (i <= massiv_buffer.size - 2)
            {
                if ((massiv_buffer[i - 1] + massiv_buffer[i + 1]) < massiv_buffer[i])
                {
                    massiv_buffer.removeAt(i)
                    if (i!=1) i--
                }
                else
                {
                    i++
                }
            }
        }
        var HappyArray: IntArray = IntArray(massiv_buffer.size)
        for (j in 0..massiv_buffer.size - 1) { HappyArray[j] = massiv_buffer[j]}
        // вывод счастливого массива
        return HappyArray
    }
}
