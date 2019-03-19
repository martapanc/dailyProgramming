import re

with open("fourInput.txt", "r") as fp:
    line = fp.readline()
    while line:
        line = line.replace('Guard ', '').replace(' begins shift\n', '').replace('falls asleep\n', 'asleep').replace('wakes up\n', 'awaken')
        line = line.replace('[', '').replace(']', '').replace('-', ' ').replace(':', ' ').replace('#', '')
        vals = line
        print(vals)
        line = fp.readline()
