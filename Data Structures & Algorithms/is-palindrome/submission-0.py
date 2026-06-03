class Solution:
    def isPalindrome(self, s: str) -> bool:
        l = 0
        r = len(s) - 1
        ls = s.lower()

        while l <= r:
            lc = ls[l]
            rc = ls[r]

            if (lc >= 'a' and lc <= 'z') or (lc >= '0' and lc <= '9'):
                if (rc >= 'a' and rc <= 'z') or (rc >= '0' and rc <= '9'):
                    if rc != lc:
                        return False
                    else:
                        r -= 1
                        l += 1
                else:
                    r -= 1
            else:
                l += 1

        return True
        