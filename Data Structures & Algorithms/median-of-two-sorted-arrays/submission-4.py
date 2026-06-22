class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        m = len(nums1)
        n = len(nums2)

        if m > n:
            small = nums2
            large = nums1
            sl = n
            ll = m
        else:
            small = nums1
            large = nums2
            sl = m
            ll = n

        tl = m + n
        thl = int(tl / 2) + int(tl % 2)

        shl = int(sl / 2) + int(sl % 2)
        lhl = thl - shl

        sil = 0
        sir = sl - 1
        while True:
            print(shl, lhl)

            if shl == 0 or lhl == ll or small[shl - 1] <= large[lhl]:
                if lhl == 0 or shl == sl or small[shl] >= large[lhl - 1]:
                    break
                else:
                    shl = shl + int((thl - shl) / 2) + 1
            else:
                shl = int(shl / 2)

            lhl = thl - shl

        if shl == 0:
            if lhl == 0:
                return float('nan')
            else:
                e1 = large[lhl - 1]
        elif lhl > 0 and large[lhl - 1] > small[shl - 1]:
            e1 = large[lhl - 1]
        else:
            e1 = small[shl - 1]

        if tl % 2 == 1:
            return float(e1)

        if shl == sl:
            if lhl == ll:
                return float('nan')
            else:
                e2 = large[lhl]
        elif lhl < ll and large[lhl] < small[shl]:
            e2 = large[lhl]
        else:
            e2 = small[shl]

        return float((e1 + e2) / 2)
        