# -*- encoding=utf-8 -*-
import functools


def log(text):
    def decorator(func):
        @functools.wraps(func)
        def wrapper(*args, **kw):
            print('%s %s():' % (text, func.__name__))
            return func(*args, **kw)
        return wrapper
    return decorator

'''
@log的decorator，使它既支持：
@log
def f():
    pass
又支持：
@log('execute')
def f():
    pass
'''

def log_call(arg):
    # 判断传入的参数是函数还是字符串参数
    if callable(arg):
        # 是函数的话，直接定义wrapper
        @functools.wraps(arg)
        def wrapper(*args, **kw):
            print("call %s" % arg.__name__)
            a = arg(*args, **kw)
            print("end call")
            return a

        return wrapper
    else:
        # 是字符串参数的话，再定义一层返回decorator的函数
        def decorator(func):
            @functools.wraps(func)
            def wrapper(*args, **kw):
                print("call %s_%s" % (func.__name__, arg))
                f = func(*args, **kw)
                print("end call")
                return f

            return wrapper

        return decorator


@log_call
def now():
    print('now')


@log_call('execute')
def today():
    print('today')


if __name__ == '__main__':
    now()
    today()