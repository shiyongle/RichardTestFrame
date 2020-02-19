FROM centos
# RUN yum install -y openssl
###############################
#引入本地jdk，下载maven并解压需求
#add jdk /user/local
#RUN yum install -y wget
#RUN wget http://mirror.olnevhost.net/pub/apache/maven/maven-3/3.0.5/binaries/apache-maven-3.0.5-bin.tar.gz
#RUN tar zxvf apache-maveb-3.0.5-bin.tar.gz
#######################################


###############################
#安装jdk、maven、git并配置环境变量；驱动自动化框架

RUN yum install -y wget
RUN wget http://mirror.olnevhost.net/pub/apache/maven/maven-3/3.0.5/binaries/apache-maven-3.0.5-bin.tar.gz
RUN tar zxvf apache-maven-3.0.5-bin.tar.gz
RUN yum install -y git
RUN yum install -y java-1.8.0-openjdk*

ENV JAVA_HOME=/user/lib/jvm/java-1.8.0
ENV MAVEN_HOME=/apache-maven-3.0.5
ENV PATH=$PATH;$MAVEN_HOME/bin;$JAVE_HOME/bin

WORKDIR  /root
ENTRYPOINT ["/bin/bash", "/root/entrypoint.sh"]
##################################
