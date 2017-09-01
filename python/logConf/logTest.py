import logTestConf
import logging.config
import time

if __name__ == '__main__':

    logging.config.dictConfig(logTestConf.LOGGING)

    logging.info('Hello, log')
    time.sleep(2)
    logging.error('Hello, log 2')
    time.sleep(2)
    logging.info('Hello, log 3')
    time.sleep(2)
    logging.error('Hello, log 4')
    time.sleep(2)
    logging.info('Hello, log')
    time.sleep(2)
    logging.error('Hello, log 2')
    time.sleep(2)
    logging.info('Hello, log 3')
    time.sleep(2)
    logging.error('Hello, log 4')
    time.sleep(2)

