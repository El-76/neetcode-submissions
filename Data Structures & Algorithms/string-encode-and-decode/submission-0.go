type Solution struct{}

func (s *Solution) Encode(strs []string) string {
    l := 0

    for _, s := range strs {
        l += (len(s) + 1)
    }

    e := make([]byte, l, l)

    i := 0
    for _, s := range strs {
        l := len(s)

        e[i] = byte(l)

        copy(e[i+1:], []byte(s))

        i += (l+1)
    }

    return string(e)
}

func (s *Solution) Decode(encoded string) []string {
    d := make([]string, 0)
    encodedBytes := []byte(encoded)

    for i := 0; i < len(encodedBytes); {
        l := int(encodedBytes[i])
        d = append(d, string(encodedBytes[i+1:i+1+l]))
        i += (l+1)
    }

    return d
}
