package subtask5

class HighestPalindrome {

    fun highestValuePalindrome(n: Int, k: Int, digitString: String): String {
        // false - вывод -1, иначе палиндром
        var vychlop = true
        // создадим пустую строку для вывода
        var out = "-1"
        // счетчик изменений
        var shetchik = 0
        // перевод строки в массив символов для обработки
        var bufer: CharArray = digitString.toCharArray()
        // длина проверки полинома
        var length = 0
        if (bufer.size / 2 == 0) { length = (bufer.size/2).toInt() - 1} else { length = (bufer.size/2).toInt() }

        // индекс изменения
        var index = 0
        var shetchik_first = 0
        // обработка второго этапа изменений
        while(shetchik_first != k)
        {
            // можно исправлять
            if (index <= length)
            {
                // исправляем
                if ((k - shetchik) >= 2)
                {
                    if (bufer[index] != bufer[bufer.size - 1 - index])
                    {
                        bufer[index] = '9'
                        bufer[bufer.size - 1 - index] = '9'
                        shetchik += 2
                        shetchik_first += 2
                        index++
                    }
                }
                else { shetchik_first = k }
            }
            else {shetchik_first = k}
        }

        // обработка первого этапа изменений
        for (i in 0..length)
        {
            // выход с первого этапа из-за количества изменений
            if (shetchik == k) { break }
            // обнаружение ошибки на первом этапе исправления
            if (bufer[i] != bufer[bufer.size - 1 - i])
            {
                if (bufer[i].toInt() > bufer[bufer.size - 1 - i].toInt())
                {
                    // выставляемся на задание по первому элементу
                    bufer[bufer.size - 1 - i] = bufer[i]
                }
                else
                {
                    // выставляем на задание по второму элементу
                    bufer[i] = bufer[bufer.size - 1 - i]
                }
                // изменяем счетчик изменений на один вперед
                shetchik++
            }
        }

        for (j in 0..length)
        {
            if (bufer[j] != bufer[bufer.size - 1 - j])
            {
                vychlop = false
                break
            }
        }

        // если надо выдать массив
        if (vychlop)
        {
            out = ""
            for(i in 0..bufer.size - 1) { out+=bufer[i].toString()}
        }

        return out
    }
}
