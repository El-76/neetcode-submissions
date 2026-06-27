class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        freq = {}

        sl = len(s)
        l = 0
        r = 0
        m = 0
        mw = 0

        for r in range(0, sl):
            c = s[r]
            n = freq.get(c, 0) + 1
            freq[c] = n

            if n > m:
                m = n

            w = r - l + 1

            if m < w - k:
                c = s[l]
            
                freq[c] = freq.get(c, 0) - 1

                l = l + 1
            else:
                mw = w

        return mw

