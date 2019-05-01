
def validate(n):
    if len(str(n)) > 16: return False
    # Reverse items in list to loop from right to left
    listOfDigits = list(map(int, str(n)))[::-1]
    # Double every other digit from the second digit (from right to left)
    listOfDigits = [x*2 if index % 2 != 0 else x for index, x in enumerate(listOfDigits)]
    # Compute digital root (recursive sum of digits)
    listOfDigits = [9 if (n != 0 and n % 9 == 0) else n % 9 for n in listOfDigits]

    return sum(listOfDigits) % 10 == 0


print(validate(4658597233262023))
