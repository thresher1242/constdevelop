// 2025 02-01
// 계정 만들기

class Account {

    companion object {
        private fun password(): Boolean {
            println("비밀번호를 입력하세요: ")
            val passwordMake = readln()


            if (passwordMake.isEmpty()) {
                println("보안이 좋지 않습니다. 비밀번호를 입력하세요"); return false
            }
            if (passwordMake.length < 12) {
                println("보안이 좋지 않습니다. 12자 이상 입력하세요"); return false
            }
            if (passwordMake.length >= 20) {
                println("20자 미만으로 입력하세요"); return false
            }
            if (passwordMake.contains(" ")) {
                println("보안이 좋지 않습니다. 띄어쓰기를 제거하세요"); return false
            }


            if (!passwordMake.any { it.digitToIntOrNull() != null }) {
                println("보안이 좋지 않습니다. 숫자를 추가하세요"); return false
            }
            if (!passwordMake.any { it in 'a'..'z' || it in 'A'..'Z' } ) {
                println("알파벳을 입력하세요"); return false
            }
            if (!passwordMake.any { !it.isLetterOrDigit() }) {
                println("보안이 좋지 않습니다. 특수문자를 추가하세요"); return false
            }

            println("비밀번호: $passwordMake")
            return true
        }

        private fun name(): Boolean {
            println("\n닉네임을 입력하세요: ")
            val nameMake = readln()


            if (nameMake.isEmpty()) {
                println("올바르지 못한 닉네임입니다. 비밀번호를 입력하세요"); return false
            }
            if (nameMake.length < 2) {
                println("올바르지 못한 닉네임입니다. 2자 이상 입력하세요"); return false
            }
            if (nameMake.length > 16) {
                println("올바르지 못한 닉네임입니다. 16자 미만 입력하세요"); return false
            }
            if (nameMake.contains(" ")) {
                println("올바르지 못한 닉네임입니다. 띄어쓰기를 제거하세요"); return false
            }


            println("닉네임: $nameMake")
            return true
        }

        fun makeAcc() {
            var passwordValid = false
            while (!passwordValid) {
                passwordValid = password()
            }

            var nameValid = false
            while (!nameValid) {
                nameValid = name()
            }

        }
        
    }
    
}

fun main() {
    println("계정 만들기")
    Account.makeAcc()
}
