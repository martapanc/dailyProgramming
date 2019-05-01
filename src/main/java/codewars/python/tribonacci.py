def tribonacci_rec(signature, n):
    
    if n == 1:
        return signature[0]
    if n == 2:
        return signature[1]
    if n == 3:
        return signature[2]
    return tribonacci_rec(signature, n-1) + tribonacci_rec(signature, n-2) + tribonacci_rec(signature, n-3) 


def tribonacci(signature, n):
	result = []
	for i in range(1, n+1) : 
		result.append(tribonacci_rec(signature, i))
	return result

# print(tribonacci_rec([0.5, 0.5, 0.5], 30))
# print(tribonacci([0.5, 0.5, 0.5], 30))


def trib(signature,n):
    while len(signature) < n:
        signature.append(sum(signature[-3:]))
    
    return signature[:n]

print(trib([0.5, 0.5, 0.5], 30))