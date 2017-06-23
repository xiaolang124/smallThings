import difflib

dif_file1_num, dif_file2_num, same_file_num = 0, 0, 0
dif_file1_list, dif_file2_list, same_file_list = [], [], []

a = open('D:/logs/1.txt', "U").read()
a = a.splitlines(keepends=False)

b = open('D:/logs/2.txt', "U").read()
b = b.splitlines(keepends=False)

diff = difflib.ndiff(a, b)
diff = list(diff)

for line in diff:
    if line.startswith('-'):
        dif_file1_num = dif_file1_num + 1
        dif_file1_list.append(line[2:])
    elif line.startswith('+'):
        dif_file2_num = dif_file2_num + 1
        dif_file2_list.append(line[2:])
    else:
        same_file_num = same_file_num + 1
        same_file_list.append(line[2:])

print('same : ', same_file_num)
print('file1 only num : ', dif_file1_num)
print('file1 only :')
for line in dif_file1_list:
    print(line)
print('file2 only num : ', dif_file2_num)
print('file2 only :')
for line in dif_file2_list:
    print(line)