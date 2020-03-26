package subtask4

class StringParser {

    fun getResult(inputString: String): Array<String> {
        var out_buf: MutableList<String> = mutableListOf<String>()

        // длина выходного массива строк
        var length = 0
        // рабочая строка
        var bufferstring = inputString
        // проверяемый индекс
        var i = 0
        var provstartmassiv: CharArray = charArrayOf('[', '<', '(')
        var provstopmassiv: CharArray = charArrayOf(']', '>', ')')

        while (i < bufferstring.length)
        {
            // буферный массив поисковых индексов и сначала ищем стартовый индекс
            var massivindex: IntArray = IntArray(3)
            for (h in 0.. (provstartmassiv.size - 1))
            {
                if (bufferstring.indexOf(provstartmassiv[h], i) != -1) {massivindex[h] = bufferstring.indexOf(provstartmassiv[h], i)}
                else {massivindex[h] = bufferstring.length}
            }

            // наш индекс в массиве стартов
            var p =  massivindex.min()?.let { massivindex.indexOf(it) }
            if (p != null)
            {
                i = massivindex[p] + 1
                var massivindex_stop = bufferstring.indexOf(provstopmassiv[p], massivindex[p]+ 1)

                var okej_stop = true
                var okej_length = 0
                var strart = massivindex[p] + 1

                while(okej_stop)
                {
                    if ((bufferstring.indexOf(provstartmassiv[p], strart) < massivindex_stop) and (bufferstring.indexOf(provstartmassiv[p], strart) != -1))
                    {
                        okej_length++
                        strart = bufferstring.indexOf(provstartmassiv[p], strart) + 1
                    }
                    else
                    {
                        okej_stop= false
                    }
                }

                strart = massivindex[p] + 1

                for( k in 0..okej_length)
                {
                    massivindex_stop = bufferstring.indexOf(provstopmassiv[p], strart)
                    strart = massivindex_stop + 1
                }

                if ((massivindex_stop != null) and (massivindex_stop != -1))
                {
                    out_buf.add(bufferstring.substring(massivindex[p]+1, massivindex_stop))
                    length++
                }
            }
            else {i = bufferstring.length}
            // стартовые индексы не найдены, значит они закончились
        }

        var out: Array<String> = Array<String> (length,{""})
        for (k in 0..length - 1)
        {
            out[k] = out_buf[k]
        }

        return out
    }
}
