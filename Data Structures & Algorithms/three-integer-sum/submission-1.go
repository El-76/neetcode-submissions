func threeSum(nums []int) [][]int {
    resultMap := make(map[[3]int]struct{}, 0)

    indicesByNum := make(map[int][]int, 0)

    for i, num := range nums {
        indicesByNum[num] = append(indicesByNum[num], i)
    }

    for i, num := range nums {
        sums := twoSum(nums, indicesByNum, i+1, -num)

        for _, sum := range sums {
            r1 := num
            r2 := sum[0]
            r3 := sum[1]

            var key [3]int
            if r1 < r2 {
                key =[3]int{r1, r2, r3}
            } else if r1 > r3 {
                key = [3]int{r2, r3, r1}
            } else {
                key = [3]int{r2, r1, r3}
            }

            resultMap[key] = struct{}{}
        }
    }

    result := make([][]int, 0)

    for key, _ := range resultMap {
        result = append(result, []int{key[0], key[1], key[2]})
    }

    return result
}

func twoSum(nums []int, indicesByNum map[int][]int, from, target int) [][]int {
    result := make([][]int, 0)

    for num, indices := range indicesByNum {
        indices2, ok := indicesByNum[target - num]

        if ok {
            for _, index := range indices {
                if index < from {
                    continue
                }

                for _, index2 := range indices2 {
                    if index < index2 && index2 >= from {
                        r1 := nums[index]
                        r2 := nums[index2]

                        if r1 < r2 {
                            result = append(result, []int{r1, r2})
                        } else {
                            result = append(result, []int{r2, r1})
                        }
                    }
                }
            } 
        }
    }

    return result  
}
