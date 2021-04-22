'''
Python 能够以文本和二进制两种方式处理文件
'''
# 在 windows下面，新文件的默认编码是 gbk，这样的话，python解释器会用gbk编码去解析txt
# 如果不在读文件时加入参数 encoding='utf-8'，那么会报错
textFile = open("/GitHub/Schoolstudy/Python/Fundation/FIle/7.1.txt","rt",encoding='utf-8')#t表示文本文件方式
print(textFile.readline())
textFile.close