func longestConsecutive(nums []int) int {
	if (len(nums) == 0) {
		return 0
	}

	numMap := make(map[int]struct{}, 0)

	for _, num := range nums {
		numMap[num] = struct{}{}
	}

	maxLength := 1

	for num, _ := range numMap {
		l := num - 1
		r := num + 1

		for {
			_, ok := numMap[l]
			
			if ok {
				delete(numMap, l)

				l--
			} else {
				break
			}
		}

		for {
			_, ok := numMap[r]
			
			if ok {
				delete(numMap, r)

				r++
			} else {
				break
			}
		}

		delete(numMap, num)

		length := r - l - 1
		if maxLength < length {
			maxLength = length
		}
	}

	return maxLength
}
