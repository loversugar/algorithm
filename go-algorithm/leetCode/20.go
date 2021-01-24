package leetCode

func IsValid(s string) bool  {
	if len(s) <= 0 {
		return true
	}

	stack := make([]int32, 0)

	for _, value := range s {
		if value == '(' || value == '[' || value == '{' {
			stack = append(stack, value)
		} else if (value == ')' && len(stack) > 0 && stack[len(stack)-1] == '(') ||
			(value == ']' && len(stack) > 0 && stack[len(stack)-1] == '[') ||
			(value == '}' && len(stack) > 0 && stack[len(stack)-1] == '{') {
			stack = stack[0:len(stack) - 1]
		} else {
			return false
		}
	}

	return len(stack) == 0
}
