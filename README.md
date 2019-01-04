安装地址
http://rocketmq.apache.org/release_notes/release-notes-4.2.0/

配置环境变量
ROCKETMQ_HOME
MQ解压路径\MQ文件夹名


启动
cmd命令框执行进入至‘MQ文件夹\bin’下

start mqnamesrv.cmd
启动NAMESERVER

start mqbroker.cmd -n 127.0.0.1:9876 autoCreateTopicEnable=true
启动BROKER


注意：
假如弹出提示框提示‘错误: 找不到或无法加载主类 xxxxxx’。打开runbroker.cmd，然后将‘%CLASSPATH%’加上英文双引号


控制台
https://github.com/apache/rocketmq-externals.git
\rocketmq-externals\rocketmq-console
这是个springboot项目
http://localhost:8081