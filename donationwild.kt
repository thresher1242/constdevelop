// 2025 01-31
// 후원야생
class Donation {
    companion object {

        fun reaction(realAmount: Int): String {
            return when {
                realAmount in 1000.. 1999 -> "모루"
                realAmount < 3000 -> "아이템 섞기"
                realAmount < 4000 -> "아이템 랜덤 삭제"
                realAmount < 5000 -> "TNT 소환"
                realAmount < 10000 -> "레시피 삭제"
                realAmount < 100000 -> "레시피 복구"
                else ->"인벤토리 전체 삭제"
            }
            
        }

        fun donate(): Int {
            println("1000원 부터 100000원 사이 후원가: ")
            val tempAmount = readln().toIntOrNull()
            return if (tempAmount != null && tempAmount in 1000..100000) {
                tempAmount
            } else {
                println("올바른 수를 입력하세요")
                0
            }
            
        }
        
    }
    
}

fun main() {
    while (true) {
        val amount = Donation.donate()
        val give = Donation.reaction(amount)
        if (amount == 0) continue

        println("후원! 후원 금액: $amount \"$give\"")
    }
    
}
