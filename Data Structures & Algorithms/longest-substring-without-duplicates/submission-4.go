func lengthOfLongestSubstring(s string) int {
    runes := make(map[rune]int, 0)
    l := 0
    m := 0
    b := 0
    
    for i, r := range s {
        j, ok := runes[r]

        if ok && j >= b {
            b = j 

            l = i - b
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
