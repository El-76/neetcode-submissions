func lengthOfLongestSubstring(s string) int {
    runes := make(map[rune]int, 0)
    l := 0
    m := 0
    b := 0
    
    for i, r := range s {
        j, ok := runes[r]

        if ok && j >= b {
            b = j + 1

            l = i - b + 1
        } else {
            l++
        }

        if m < l {
            m = l
        }

        runes[r] = i
    }

    return m
}
