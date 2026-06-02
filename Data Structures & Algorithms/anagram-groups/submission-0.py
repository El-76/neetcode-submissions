class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        freqToStr = {}

        for s in strs:
            freq = {}

            for c in s:
                freq[c] = freq.get(c, 0) + 1

            freqKey = frozenset(freq.items())

            freqToStr[freqKey] = freqToStr.get(freqKey, []) + [s]

        return list(freqToStr.values())