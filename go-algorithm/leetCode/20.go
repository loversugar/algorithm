package leetCode

func isValid(s string)  {
	getIntByString(s[0:1])
}

func getIntByString(c string) int {
	switch c {
	case "(":
		return -1
	case ")":
		return 1
	case "[":
		return -2
	case "]":
		return 2
	case "{":
		return 3
	default:
		return -3
	}
}
