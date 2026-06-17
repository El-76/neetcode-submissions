func findMin(nums []int) int {
    l := 0
    r := len(nums) - 1

    if nums[l] < nums[r] {
        return nums[l]
    }

    for {
        m := l + ((r - l) / 2)

        if l == r {
            return nums[l]
        }

        if nums[m] > nums[r] {
            l = m + 1
        } else {
            r = m
        }
    }
}
