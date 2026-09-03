func findDuplicate(nums []int) int {
    i := 0
    j := 0
    for {
        if i > 0 && nums[i] == nums[j] {
            break
        }

        j = nums[j]

        if i > 0 && nums[i] == nums[j] {
            j = nums[j]

            break
        }

        i = nums[i]
        j = nums[j]
    }

    i = 0
    for {
        if nums[i] == nums[j] {
            break
        }

        i = nums[i]
        j = nums[j]
    }

    return nums[i]
}
