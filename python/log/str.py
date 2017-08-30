#-*- encoding=UTF-8 -*-

import re
import logging
from logging import handlers
import time
import traceback

# 1.logger要设置level为DEBUG，否则Info的日志打不出来
# 2.logging.Formatter的使用方式，给handler加formatter的方法
# 3.筛选不同level日志进入不同文件的方法，增加filter的方法
# 4.TimedRotatingFileHandler按时间分文件导出的方法，注意先生成默认指定文件名，需要切换的时候切换文件名，并新创建指定文件名保存日志，
#   注意多线程处理会带来问题
# 5.python装饰器的用法


traceback.print_exc()
logger = logging.getLogger('__name__')
logger.setLevel(logging.DEBUG)


def initLog():
    formatter = logging.Formatter('%(asctime)s - %(name)s - %(thread)8d - %(levelname)s - %(message)s')

    class LogLevelFilter(logging.Filter):
        def __init__(self, name='', level=logging.DEBUG):
            super(LogLevelFilter,self).__init__(name)
            self.level = level

        def filter(self, record):
            return record.levelno == self.level

    error_file_handler = handlers.TimedRotatingFileHandler('D:/test/log/error', when='S')
    error_file_handler.suffix = '%Y-%m-%d--%H-%M-%S.log'
    error_file_handler.setLevel(logging.ERROR)
    error_file_handler.setFormatter(formatter)
    error_filter = LogLevelFilter(level=logging.ERROR)
    error_file_handler.addFilter(error_filter)
    logger.addHandler(error_file_handler)

    info_file_handler = handlers.TimedRotatingFileHandler('D:/test/log/info', when='S')
    info_file_handler.suffix = '%Y-%m-%d--%H-%M-%S.log'
    info_file_handler.setLevel(logging.INFO)
    info_file_handler.setFormatter(formatter)
    info_filter = LogLevelFilter(level=logging.INFO)
    info_file_handler.addFilter(info_filter)
    logger.addHandler(info_file_handler)

def log(level, *args, **kwargs):
    def inner(func):
        def wrapper(*args, **kwargs):
            print(level, 'before calling', func.__name__)
            func(*args, **kwargs)
            print(level, 'after calling', func.__name__)
        return wrapper
    return inner


@log(level='INFO')
def hello(name, msg):
    print('hello', name, msg)

if __name__ == '__main__':
    # hello(name='hi', msg='you')

    # logging.basicConfig(filename='d:/test/log/debugLog.log', level=logging.DEBUG)
    #
    # logging.basicConfig(format='%(asctime)s %(message)s')
    # logging.debug('This message should go to the log file')
    # logging.info('So should this')
    # logging.warning('And this, too')

    initLog()

    print(logger.__dict__)

    logger.log(logging.INFO, 'Info')
    # time.sleep(2)
    # logger.log(logging.ERROR, 'Error')