package problems

//import groovy.transform.ToString

class PrimeEvolution extends BitStringProblem {
	def maximalQuality = {
		Math.pow(2, numBits)
	}
	
	def quality = { a ->
		++evalCount
		def total = 0
		def pos = 1
		for (i in a) {
			if (i == 1) {
				total += Math.pow(2, numBits - pos)
			}
			pos++
		}
		
		if (total < 2) {
			return total
		} else if (total % 2 == 0) {
			return 2
		} else {
			for (int i = 3; i <= Math.pow(2, numBits / 2); i += 2) {
				if (total % i == 0) {
					return i
				}
			}
			return total
		}
	}
}