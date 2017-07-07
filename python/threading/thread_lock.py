import threading
import time

class myThread (threading.Thread):
    def __init__(self, threadID, name, counter):
        threading.Thread.__init__(self)
        self.threadID = threadID
        self.name = name
        self.counter = counter
    def run(self):
        print ("�����̣߳� " + self.name)
        # ��ȡ���������߳�ͬ��
        threadLock.acquire()
        print_time(self.name, self.counter, 3)
        # �ͷ�����������һ���߳�
        threadLock.release()

def print_time(threadName, delay, counter):
    while counter:
        time.sleep(delay)
        print ("%s: %s" % (threadName, time.ctime(time.time())))
        counter -= 1

threadLock = threading.Lock()
threads = []

# �������߳�
thread1 = myThread(1, "Thread-1", 1)
thread2 = myThread(2, "Thread-2", 2)

# �������߳�
thread1.start()
thread2.start()

# ����̵߳��߳��б�
threads.append(thread1)
threads.append(thread2)

# �ȴ������߳����
for t in threads:
    t.join()
print ("�˳����߳�")