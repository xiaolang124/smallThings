1������map()���������û�����Ĳ��淶��Ӣ�����֣���Ϊ����ĸ��д������Сд�Ĺ淶���֡����룺['adam', 'LISA', 'barT']�������['Adam', 'Lisa', 'Bart']��

def normalize(name):
    ls = list(name.lower())
    ls[0] = ls[0].upper()
    return reduce(lambda a, b: a + b, ls)


L1 = ['adam', 'LISA', 'barT']
L2 = list(map(normalize, L1))
print(L2)
2��Python�ṩ��sum()�������Խ���һ��list����ͣ����дһ��prod()���������Խ���һ��list������reduce()�����

def prod(ls):
    return reduce(lambda a, b: a * b, ls)


print('3 * 5 * 7 * 9 =', prod([3, 5, 7, 9]))
3������map��reduce��дһ��str2float���������ַ���'123.456'ת���ɸ�����123.456��

def str2float(s):
    def char2num(s): return {'0': 0, '1': 1, '2': 2, '3': 3, '4': 4, '5': 5, '6': 6, '7': 7, '8': 8, '9': 9}[s]

    def fn(a, b): return a * 10 + b

    left, right = s.split('.')
    length = len(right)
    left = reduce(fn, map(char2num, left))
    right = reduce(fn, map(char2num, right))
    return left + right * (10 ** -length)


print('str2float(\'123.456\') =', str2float('123.456'))