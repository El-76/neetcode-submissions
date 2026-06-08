func isValid(s string) bool {
    stack := make([]rune, 0)

    for _, r := range s {
        if (r == '(' || r == '[' || r == '{') {
            stack = append(stack, r)
        } else {
            l := len(stack)
            if l == 0 {
                return false
            }

            p := stack[l - 1]
            if ((p == '(' && r != ')') ||
                (p == '[' && r != ']') ||
                (p == '{' && r != '}')) {

                return false
            } 

            stack = stack[:l - 1]
        }
    }

    return len(stack) == 0
}
