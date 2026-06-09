func dailyTemperatures(temperatures []int) []int {
    result := make([]int, len(temperatures))

    stack := make([]int, 0)

    for j, t := range temperatures {
        for {
            l := len(stack)
            if l > 0 {
                peek := stack[l - 1]

                if temperatures[peek] < t {
                    result[peek] = j - peek

                    stack = stack[:l - 1]

                    continue
                }
            }

            break
        }

        stack = append(stack, j)
    }

    return result
}
