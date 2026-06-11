func searchMatrix(matrix [][]int, target int) bool {
    m := len(matrix)
    n := len(matrix[0])

    l := 0
    r := m * n - 1

    for {
        k := l + ((r - l) / 2)

        v := matrix[k / n][k % n]

        if v == target {
            return true
        }

        if l == r {
            return false
        }
        
        if (v < target) {
            l = k + 1
        } else {
            r = k
        }
    }
}
