func minWindow(s string, t string) string {
    sl := len(s)

    if sl == 0 {
        return ""
    }
    
    tl := len(t)

    freqt := make(map[byte]int, 0)
    freqs := make(map[byte]int, 0)

    argMin := ""
    min := sl + 1

    for i := 0; i < tl; i++ {
        b := t[i]

        f, ok := freqt[b]

        if ok {
            f++
        } else {
            f = 1
        }

        freqt[b] = f
    }

    ut := len(freqt)
    d := 0

    l := 0
    r := 0

    for {
        b := s[l]

        _, ok := freqt[b]

        if ok {
            break
        }

        l++
        r++

        if l == sl {
            return ""
        }
    }

    for {
        for {
            b := s[r]

            ft, ok := freqt[b]

            if ok {
                f := freqs[b]

                f++

                freqs[b] = f

                if f == ft {
                    d++
                }

                if d == ut {
                    if r - l + 1 < min {
                        min = r - l + 1
                        argMin = s[l:r+1]
                    }

                    r++

                    break
                }
            }

            r++

            if r == sl {
                break
            }
        }

        for {
            if l == r {
                break
            }

            b := s[l]

            ft, ok := freqt[b]

            f := freqs[b]

            if ok {
                if d < ut {
                    break
                }

                if f == ft {
                    d--
                }

                f--

                freqs[b] = f

                if r - l < min {
                    min = r - l
                    argMin = s[l:r]
                }
            }

            l++
        }

        if r == sl {
            break
        }
    }

    return argMin
}
