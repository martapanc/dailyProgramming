def find_uniq(arr):
    arr.sort()
    return arr[0] if arr[0] != arr[1] else arr[-1]


print(find_uniq([ 1, 1, 1, 2, 1, 1 ]))


def high_and_low(numbers):
    numbersArr = numbers.split()
    numbersArr = [int(x) for x in numbersArr]
    numbersArr.sort()
    return str(numbersArr[-1]) + " and " + str(numbersArr[0])


print(high_and_low("4 5 29 54 4 0 -214 542 -64 1 -3 6 -6"))