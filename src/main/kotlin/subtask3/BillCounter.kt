package subtask3

class BillCounter {

    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        // сумма счета
         var summa = bill.sum()
        //создадим пустую строку для вывода
         var out = ""
        // сколько надо заплатить ей для счета
         var resh = 0
        // индекс в границах
         if ((k < bill.size) and (k >= 0)) { resh = ((summa - bill[k])/2).toInt() } else { resh = (summa/2).toInt() }
         if (resh == b) {out = "Bon Appetit"} else { resh = b - resh; out = "$resh"}
         return out
    }
}
