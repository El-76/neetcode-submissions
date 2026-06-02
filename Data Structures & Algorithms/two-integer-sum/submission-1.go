func twoSum(nums []int, target int) []int {
    indexByNum := make(map[int][]int, 0)

    for index, num := range nums {
        indexByNum[num] = append(indexByNum[num], index)
    }

    for num, indices := range indexByNum {
        for _, index := range indices {
            indices2, ok := indexByNum[target - num]

            if ok {
                for _, index2 := range indices2 {
                    if index < index2 {
                        return []int{index, index2}
                    } else if index > index2 {
                        return []int{index2, index}
                    }
                }
            }
        }
    }

    return []int{}
}
