def sum_dig_pow(a, b):
    result = []
    for num in range(a, b+1):
        sumOfSqrdDigits = 0
        digitMap = map(int, str(num))
        for i in range(0, len(str(num))):
            sumOfSqrdDigits += digitMap[i] ** (i+1)
        if num == sumOfSqrdDigits:
            result.append(num)
    return result


print(sum_dig_pow(88, 150))