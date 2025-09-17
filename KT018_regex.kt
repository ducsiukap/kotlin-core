// Regex: Regular Expression -> pattern maching

fun main() {

    // Create regex via Regex class
    /*  Constructor
    - Regex(pattern: String)
    - Regex(pattern: String, option: RegexOption)
    - Regex(pattern: String, options: Set<RegexOption>)


    // pattern:
    + ^/$ : bắt đầu/kết thúc chuỗi
    + .: bất kì ký tự nào
    + * / + / ? -> 0 or more /  1 or more / 0 or 1
    + \d / \D -> là số / không phải só
    + \w / \W -> alphabet or numeric or _ / not(alphabet and numeric and _)
    + \s / \S -> space (tab, space, newline) / not space
    + {n} -> xuất hiện đúng n lần
    + {n, } -> xuất hiện ít nhất n lần (>= n)
    + {n, m} -> xuất hiện từ n tới m lần
    + [abcde] -> 1 trong các ký tự a,b,c,d,e
    + [^abcde] -> không phải ký tự nào trong a,b,c,d,e
    + [a-mx-z] -> một trong các ký tự a, b, c, ..., m, x, y, z
    + [^a-m] -> không phải 1 trong các ký tự a, b, c, .. m
        // [<start>-<end>] -> các ký tự có unicode trong khoảng unicode của start và end
    + (ab) -> nhóm ab // (ab)+ -> ab, ababa, ababab, ...file // (\\w+)
            // lưu kết quả để reference
    + (?:ab) -> nhóm ab nhưng
            // không lưu để reference (không chiếm reference)
        // reference: \1, \2, ... -> refer lại value đã khớp với nhóm () trước đó
        // cần khớp chính xác
        ex: (ab)+\\s\\1
        thì: abab ab -> true
             abab abab -> false
             ab a -> false

    // RegexOption:
    + RegexOption.IGNORE_CASE -> khong phan biet hoa thuong
    + Regex.Option.MULTILINE -> coi mỗi \n là kết thúc 1 line, áp dụng trên từng line
                //  ex: Hello\nWorld -> nếu không có MULTILINE thì coi tất cả là 1 chuỗi.file
    + RegexOption.LITERAL -> coi pattern là chuỗi nguyên bản, không xử lý ký tự đặc biệt regex.
    + RegexOption.DOT_MATCHES_ALL -> ký tự '.' sẽ khớp với mọi ký tự, kể cả \n, \t (bình thường là 0 khớp)
    + RegexOption.COMMENTS -> viết comment trong regex :)
        ex: Regex("""
            \d+ # comment
            [a-z]+ # comment
        """.trimIndent(), RegexOption.COMMENTS) -> == Regex("\d+[a-z]+")
        // note: with raw string """"""
        - trimIndent() -> xóa khoảng trắng đầu dòng
        - trimMargin() -> xóa khoảng trắng đầu dòng đến ký tự margin prefix (mặc định là '|')
            # có thể trimMargin("#") -> đổi margin prefix thành #
    */

    // regex vietnamese telephone number
    println("\n--------------------")
    var pattern = "^(((0|\\+84[\\s-]?)[3-9][0-9]{8})|(02([0-9]|[0-9]{2})[3-9][0-9]{5,7}))$"

    // create regex object
    var regex = Regex(pattern)
    println("pattern: ${regex.pattern}")

    val telephonNumbers =
            arrayOf(
                    "0399123123", // true
                    "+84 123456789", // false
                    "+84 323456789", // true
                    "0123456789", // false
                    "024123456", // false
                    "0204123456", // true
                    "024134567" // false
            )

    // method
    telephonNumbers.forEach {
        println("======")
        // .maches(input: CharSequence) : Boolean -> match toàn bộ:
        // matchesEntire(input: CharSequence) -> giống matches
        println("maches($it): ${regex.matches(it)}")

        // containsMatchIn(input: Charsequence) : Boolean -> kiểm tra chuỗi có chứa pattern
        println("containsMatchIn($it): ${regex.containsMatchIn(it)}")

        /*
        find(input:Charsequence, startIndex:Int = 0) : MatchResult? -> match đầu tiền / null
        findAll(input:Charsequence, startIndex:Int = 0) : Sequence<MatchResult> -> tất cả match

                MatchResult:
                - value: chuỗi match
                - range: IntRange -> vị trí bắt đầu &kết thúc trong chuỗi gốc
                - groups: MatchGroupCollection -> các group con (nếu có (... ) -> (group & refer))
                tất cả groups (cả group[0] -> toàn bộ match)
                - destructured: MatchGroup.Destructured -> trả về các group con
         */

        //  replace(input: CharSequence, replacement: String) : String -> thay thế chuỗi match
        println("replace($it, \"helloworld:)\"): ${regex.replace(it, "helloworld:)")}")
        // replace(input: CharSequence, transform: (MatchResult) -> CharSequence)

        // split(input: CharSequence, limit: Int = 0): List<String> -> tách chuỗi theo regex
    }

    // group & refer
    println("\n--------------------")
    regex = "(\\d{2})\\s(?:\\d{3})\\s(\\d{2})\\s\\1-\\2".toRegex()
    // (group1) (non-capturing-group) (group2) ref_group1 ref_group2
    // ref_group1 -> value of group1
    // ref_group2 -> value of group2
    // vì non-capturing-group không lưu giá trị nên không chiếm reference.
    val test =
            setOf(
                    "12 345 67 12-67", // true
                    "12 345 67 12-345", // false
                    "21 345 67 12-12", // false
            )
    test.forEach {
        println("==================")
        println("matches($it): ${regex.matches(it)}")

        val matchResult = regex.find(it, 0) // MatchResult? / false
        println("find($it).groups: ${matchResult?.groups}")
        // groups[0] : match regex
        // groups[1] - groups[n]: subgroup
    }

    // RegexOption
    println("\n--------------------")
    pattern = "^hello world"
    val options =
            setOf(
                    RegexOption.IGNORE_CASE, //
                    RegexOption.MULTILINE // each line
            )
    regex = Regex(pattern, options)

    val strTest = "Hello WOrld abc\nHello world\nHello Worldxxx\nHi world"
    val result = regex.findAll(strTest)

    result.forEach { println(it.value) }

    println("\n--------------------")
    println("#vduczz")
}
