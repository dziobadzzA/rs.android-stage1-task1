package subtask2

class MiniMaxSum {

    fun getResult(input: IntArray): IntArray {
        // выходной массив
        var result: IntArray = IntArray(2)

        if (input.size >= 1)
        {
        // буфер
         var buffer: IntArray = IntArray(input.size)
         var summa = input.sum()

        for (j in 0..buffer.size - 1) { buffer[j] += (summa - input[j]) }
        var maximum = buffer.max()
        var minimum = buffer.min()

        if (minimum != null) { result[0] = minimum }
        if (maximum != null) { result[1] = maximum }
        }
        return  result
    }
}
