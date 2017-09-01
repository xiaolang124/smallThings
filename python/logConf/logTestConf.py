import logging


class LoggingInfoFilter(logging.Filter):
    def filter(self, record):
        return record.levelno == logging.INFO


class LoggingErrorFilter(logging.Filter):
    def filter(self, record):
        return record.levelno == logging.ERROR


LOGGING = {
    'version': 1,
    'disable_existing_loggers': False,
    'formatters':
        {
            'default':
                {
                    'format': '%(asctime)s - %(name)s - %(thread)8d - %(levelname)s - %(message)s'
                }
        },
    'filters':
        {
            'info_filter':
                {
                    '()': LoggingInfoFilter,
                },
            'error_filter':
                {
                    '()': LoggingErrorFilter,
                }
        },
    'handlers':
        {
            'stdout':
                {
                    'class': 'logging.StreamHandler',
                    'formatter': 'default',
                    'stream': 'ext://sys.stdout'
                },
            'info_file_handler':
                {
                    'class': 'logging.handlers.TimedRotatingFileHandler',
                    'level': 'DEBUG',
                    'formatter': 'default',
                    'filename': 'd:/test/log/info.log',
                    'when': 'S',
                    'filters': ['info_filter']
                },
            'error_file_handler':
                {
                    'class': 'logging.handlers.TimedRotatingFileHandler',
                    'level': 'ERROR',
                    'formatter': 'default',
                    'filename': 'd:/test/log/error.log',
                    'when': 'S',
                    'filters': ['error_filter']
                }
        },
    'loggers':
        {
            '':
                {
                    'handlers': ['stdout', 'info_file_handler', 'error_file_handler'],
                    'level': 'DEBUG',
                    'propagate': True
                }
        }
}
