/*
Navicat MySQL Data Transfer

Source Server         : 10.10.7.37
Source Server Version : 50624
Source Host           : 10.10.7.37:3306
Source Database       : control_center

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-10-13 10:12:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_engineering
-- ----------------------------
DROP TABLE IF EXISTS `t_engineering`;
CREATE TABLE `t_engineering` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectId` int(11) NOT NULL COMMENT '工程ID',
  `engineeringName` varchar(50) DEFAULT NULL COMMENT '工程名称',
  `engineeringCode` varchar(50) DEFAULT NULL COMMENT '工程唯一编码',
  `personLiable` varchar(50) DEFAULT NULL COMMENT '责任人',
  `createTime` datetime DEFAULT NULL,
  `createUser` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_engineering
-- ----------------------------
INSERT INTO `t_engineering` VALUES ('10', '11', 'rising-zptc-admin', 'RISING_ZPTC_ADMIN', '曹阳', '2016-03-28 17:08:35', 'admin');
INSERT INTO `t_engineering` VALUES ('11', '11', 'rising-zptc-client', 'RISING_ZPTC_CLIENT', '曹阳', '2016-03-29 14:36:57', 'admin');
INSERT INTO `t_engineering` VALUES ('12', '11', 'rising-zptc-server', 'RISING_ZPTC_SERVER', '曹阳', '2016-03-29 14:37:21', 'admin');

-- ----------------------------
-- Table structure for t_engin_config_info
-- ----------------------------
DROP TABLE IF EXISTS `t_engin_config_info`;
CREATE TABLE `t_engin_config_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `enginId` int(11) DEFAULT NULL COMMENT '工程ID',
  `envType` varchar(50) DEFAULT NULL COMMENT '环境类型编码；ENV_TYPE_DEVELOP：开发环境；ENV_TYPE_DEVELOP_TEST：开发测试环境；ENV_TYPE_TEST：测试环境；ENV_TYPE_PREVIEW：预生产环境；ENV_TYPE_FORMAL：生产环境；',
  `configTypeId` int(11) DEFAULT NULL COMMENT '配置类型ID',
  `data` text COMMENT '配置数据',
  `createTime` datetime DEFAULT NULL,
  `createUser` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2696 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_engin_config_info
-- ----------------------------
INSERT INTO `t_engin_config_info` VALUES ('2489', '10', 'ENV_TYPE_DEVELOP', '1', 'jdbc.url=jdbc:mysql://localhost:3306/post_telecom_college?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true\njdbc.username=root\njdbc.password=123456\nvalidation.query=select 1\n', '2016-09-22 18:20:58', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2490', '10', 'ENV_TYPE_DEVELOP', '4', 'roll.image.dir=C\\:\\\\tlbank\\\\roll\\\\image\n\nclassify.image.dir=C\\:\\\\tlbank\\\\classify\\\\image\n\napp.downUrl.dir=C\\:\\\\zptc\\\\apps\n\nroot.dir=/usr/resources/hzrs/\n\nenter_picture_path=http://localhost:8080/rising-zptc-admin/resources/enterPicture/\n\nad_picture_path=http://localhost:8080/rising-zptc-admin/resources/adPicture/\n\napp_file_path=http://localhost:8080/rising-zptc-admin/resources/app/\n\narticle_path=http://localhost:8080/rising-zptc-admin/\n\narticle_link=http://localhost:8080/rising-zptc-client/\n\nftp_host=115.239.171.231\nftp_port=6688\nftp_username=eytftp\nftp_password=JB^%Ysdw75f', '2016-09-22 18:20:58', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2491', '10', 'ENV_TYPE_DEVELOP', '12', '  log4j.rootLogger=DEBUG, stdout, R\n  log4j.appender.stdout=org.apache.log4j.ConsoleAppender\n  log4j.appender.stdout.layout=org.apache.log4j.PatternLayout\n  \n  log4j.logger.org.apache.commons.httpclient=DEBUG\n  log4j.logger.httpclient.wire.content=DEBUG\n  log4j.logger.httpclient.wire.header=DEBUG\n\n  # Pattern to output the caller\'s file name and line number.\n  log4j.appender.stdout.layout.ConversionPattern=%-4r %-5p [%d{yyyy-MM-dd HH:mm:ss}]  %m%n\n\n  log4j.appender.R=org.apache.log4j.DailyRollingFileAppender\n  log4j.appender.R.File=${catalina.home}/logs/rising-zptc-client.log\n  # log4j.appender.R.MaxFileSize= 1000KB\n\n  # Keep one backup file\n  #log4j.appender.R.MaxBackupIndex=1\n\n  log4j.appender.R.layout=org.apache.log4j.PatternLayout\n  log4j.appender.R.layout.ConversionPattern=%-4r %-5p [%d{yyyy-MM-dd HH:mm:ss}]  %m%n\n  log4j.appender.LOGFILE.encoding=UTF-8', '2016-09-22 18:20:58', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2492', '10', 'ENV_TYPE_DEVELOP', '13', 'tag_syntax=auto_detect\ntemplate_update_delay=2\ndefault_encoding=utf-8\noutput_encoding=utf-8\nlocale=zh_CN\ndate_format=yyyy-MM-dd\ntime_format=HH\\:mm\\:ss\ndatetime_format=yyyy-MM-dd HH\\:mm\\:ss\nclassic_compatible=true\nnumber_format=#\n', '2016-09-22 18:20:58', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2493', '10', 'ENV_TYPE_DEVELOP_TEST', '1', 'jdbc.url=jdbc:mysql://127.0.0.1:3306/post_telecom_college?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true\njdbc.username=root\njdbc.password=123456\nvalidation.query=select 1', '2016-09-22 18:20:58', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2494', '10', 'ENV_TYPE_DEVELOP_TEST', '4', 'roll.image.dir=C\\:\\\\tlbank\\\\roll\\\\image\n\nclassify.image.dir=C\\:\\\\tlbank\\\\classify\\\\image\n\napp.downUrl.dir=C\\:\\\\zptc\\\\apps\n\nroot.dir=/usr/resources/hzrs/\n\nenter_picture_path=http://115.239.171.231:8866/rising-zptc-admin/resources/enterPicture/\n\nad_picture_path=http://115.239.171.231:8866/rising-zptc-admin/resources/adPicture/\n\napp_file_path=http://115.239.171.231:8866/rising-zptc-admin/resources/app/\n\narticle_path=http://115.239.171.231:8866/rising-zptc-admin/\n\narticle_link=http://115.239.171.231:8899/rising-zptc-client/', '2016-09-22 18:20:58', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2495', '10', 'ENV_TYPE_DEVELOP_TEST', '12', '  log4j.rootLogger=DEBUG, stdout, R\n  log4j.appender.stdout=org.apache.log4j.ConsoleAppender\n  log4j.appender.stdout.layout=org.apache.log4j.PatternLayout\n  \n  log4j.logger.org.apache.commons.httpclient=DEBUG\n  log4j.logger.httpclient.wire.content=DEBUG\n  log4j.logger.httpclient.wire.header=DEBUG\n\n  # Pattern to output the caller\'s file name and line number.\n  log4j.appender.stdout.layout.ConversionPattern=%-4r %-5p [%d{yyyy-MM-dd HH:mm:ss}]  %m%n\n\n  log4j.appender.R=org.apache.log4j.DailyRollingFileAppender\n  log4j.appender.R.File=${catalina.home}/logs/rising-zptc-admin.log\n  # log4j.appender.R.MaxFileSize= 1000KB\n\n  # Keep one backup file\n  #log4j.appender.R.MaxBackupIndex=1\n\n  log4j.appender.R.layout=org.apache.log4j.PatternLayout\n  log4j.appender.R.layout.ConversionPattern=%-4r %-5p [%d{yyyy-MM-dd HH:mm:ss}]  %m%n\n  log4j.appender.LOGFILE.encoding=UTF-8', '2016-09-22 18:20:58', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2496', '10', 'ENV_TYPE_DEVELOP_TEST', '13', 'tag_syntax=auto_detect\ntemplate_update_delay=2\ndefault_encoding=utf-8\noutput_encoding=utf-8\nlocale=zh_CN\ndate_format=yyyy-MM-dd\ntime_format=HH\\:mm\\:ss\ndatetime_format=yyyy-MM-dd HH\\:mm\\:ss\nclassic_compatible=true\nnumber_format=#\n', '2016-09-22 18:20:58', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2497', '10', 'ENV_TYPE_FORMAL', '18', 'dubbo.registry.address=redis://127.0.0.1:6379\ndubbo.registry.timeout=10000', '2016-09-22 18:20:58', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2498', '10', 'ENV_TYPE_FORMAL', '1', 'jdbc.url=jdbc:mysql://10.10.7.37:3306/post_telecom_college?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true\njdbc.username=root\njdbc.password=zptc_!@#$%^\nvalidation.query=select 1', '2016-09-22 18:20:58', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2499', '10', 'ENV_TYPE_FORMAL', '4', 'roll.image.dir=C\\:\\\\tlbank\\\\roll\\\\image\n\nclassify.image.dir=C\\:\\\\tlbank\\\\classify\\\\image\n\napp.downUrl.dir=C\\:\\\\zptc\\\\apps\n\nroot.dir=/usr/resources/hzrs/\n\nenter_picture_path=http://eyt.zptc.cn/resources/enterPicture/\n\nad_picture_path=http://eyt.zptc.cn/resources/adPicture/\n\napp_file_path=http://eyt.zptc.cn/resources/app/\n\narticle_path=http://eyt.zptc.cn/\n\narticle_link=http://eyt.zptc.cn:8899/rising-zptc-client/\n\nftp_host=10.10.7.38\nftp_port=6688\nftp_username=eytftp\nftp_password=JB^%Ysdw75f', '2016-09-22 18:20:58', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2500', '10', 'ENV_TYPE_FORMAL', '12', '  log4j.rootLogger=INFO, stdout, R\n  log4j.appender.stdout=org.apache.log4j.ConsoleAppender\n  log4j.appender.stdout.layout=org.apache.log4j.PatternLayout\n  \n  log4j.logger.org.apache.commons.httpclient=INFO\n  log4j.logger.httpclient.wire.content=INFO\n  log4j.logger.httpclient.wire.header=INFO\n\n  # Pattern to output the caller\'s file name and line number.\n  log4j.appender.stdout.layout.ConversionPattern=%-4r %-5p [%d{yyyy-MM-dd HH:mm:ss}]  %m%n\n\n  log4j.appender.R=org.apache.log4j.DailyRollingFileAppender\n  log4j.appender.R.File=${catalina.home}/logs/rising-zptc-admin.log\n  # log4j.appender.R.MaxFileSize= 1000KB\n\n  # Keep one backup file\n  #log4j.appender.R.MaxBackupIndex=1\n\n  log4j.appender.R.layout=org.apache.log4j.PatternLayout\n  log4j.appender.R.layout.ConversionPattern=%-4r %-5p [%d{yyyy-MM-dd HH:mm:ss}]  %m%n\n  log4j.appender.LOGFILE.encoding=UTF-8', '2016-09-22 18:20:58', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2501', '10', 'ENV_TYPE_FORMAL', '13', 'tag_syntax=auto_detect\ntemplate_update_delay=2\ndefault_encoding=utf-8\noutput_encoding=utf-8\nlocale=zh_CN\ndate_format=yyyy-MM-dd\ntime_format=HH\\:mm\\:ss\ndatetime_format=yyyy-MM-dd HH\\:mm\\:ss\nclassic_compatible=true\nnumber_format=#\n', '2016-09-22 18:20:58', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2628', '11', 'ENV_TYPE_DEVELOP', '15', 'dubbo.registry.address=zookeeper://127.0.0.1:2181\ndubbo.registry.timeout=10000', '2016-10-11 18:43:36', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2629', '11', 'ENV_TYPE_DEVELOP', '4', 'client_path=http://121.40.149.140:8899/rising-zptc-client/\nserver_out_ip=115.239.171.231\n\n#可以支付的时间段，01:00:00-23:00:00为每天的1点到23点之间可以支付\npayment_limit_time=01:00:00-23:00:00\n\npayment_limit_instruction=23:00至次日凌晨1:00为系统对账时间，充值和缴费等功能将暂时关闭！给您带来的不便，敬请谅解。', '2016-10-11 18:43:36', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2630', '11', 'ENV_TYPE_DEVELOP', '12', '  log4j.rootLogger=DEBUG, stdout, R\n  log4j.appender.stdout=org.apache.log4j.ConsoleAppender\n  log4j.appender.stdout.layout=org.apache.log4j.PatternLayout\n  \n  log4j.logger.org.apache.commons.httpclient=DEBUG\n  log4j.logger.httpclient.wire.content=DEBUG\n  log4j.logger.httpclient.wire.header=DEBUG\n\n  # Pattern to output the caller\'s file name and line number.\n  log4j.appender.stdout.layout.ConversionPattern=%-4r %-5p [%d{yyyy-MM-dd HH:mm:ss}]  %m%n\n\n  log4j.appender.R=org.apache.log4j.DailyRollingFileAppender\n  log4j.appender.R.File=${catalina.home}/logs/rising-zptc-client.log\n  # log4j.appender.R.MaxFileSize= 1000KB\n\n  # Keep one backup file\n  #log4j.appender.R.MaxBackupIndex=1\n\n  log4j.appender.R.layout=org.apache.log4j.PatternLayout\n  log4j.appender.R.layout.ConversionPattern=%-4r %-5p [%d{yyyy-MM-dd HH:mm:ss}]  %m%n\n  log4j.appender.LOGFILE.encoding=UTF-8', '2016-10-11 18:43:36', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2631', '11', 'ENV_TYPE_DEVELOP', '13', 'tag_syntax=auto_detect\ntemplate_update_delay=2\ndefault_encoding=utf-8\noutput_encoding=utf-8\nlocale=zh_CN\ndate_format=yyyy-MM-dd\ntime_format=HH\\:mm\\:ss\ndatetime_format=yyyy-MM-dd HH\\:mm\\:ss\nclassic_compatible=true\nnumber_format=#', '2016-10-11 18:43:36', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2632', '11', 'ENV_TYPE_DEVELOP_TEST', '15', 'dubbo.registry.address=zookeeper://127.0.0.1:2181\ndubbo.registry.timeout=10000', '2016-10-11 18:43:36', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2633', '11', 'ENV_TYPE_DEVELOP_TEST', '4', 'client_path=http://121.40.149.140:8899/rising-zptc-client/', '2016-10-11 18:43:36', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2634', '11', 'ENV_TYPE_DEVELOP_TEST', '12', '  log4j.rootLogger=DEBUG, stdout, R\n  log4j.appender.stdout=org.apache.log4j.ConsoleAppender\n  log4j.appender.stdout.layout=org.apache.log4j.PatternLayout\n  \n  log4j.logger.org.apache.commons.httpclient=DEBUG\n  log4j.logger.httpclient.wire.content=DEBUG\n  log4j.logger.httpclient.wire.header=DEBUG\n\n  # Pattern to output the caller\'s file name and line number.\n  log4j.appender.stdout.layout.ConversionPattern=%-4r %-5p [%d{yyyy-MM-dd HH:mm:ss}]  %m%n\n\n  log4j.appender.R=org.apache.log4j.DailyRollingFileAppender\n  log4j.appender.R.File=${catalina.home}/logs/rising-zptc-client.log\n  # log4j.appender.R.MaxFileSize= 1000KB\n\n  # Keep one backup file\n  #log4j.appender.R.MaxBackupIndex=1\n\n  log4j.appender.R.layout=org.apache.log4j.PatternLayout\n  log4j.appender.R.layout.ConversionPattern=%-4r %-5p [%d{yyyy-MM-dd HH:mm:ss}]  %m%n\n  log4j.appender.LOGFILE.encoding=UTF-8', '2016-10-11 18:43:36', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2635', '11', 'ENV_TYPE_DEVELOP_TEST', '13', 'tag_syntax=auto_detect\ntemplate_update_delay=2\ndefault_encoding=utf-8\noutput_encoding=utf-8\nlocale=zh_CN\ndate_format=yyyy-MM-dd\ntime_format=HH\\:mm\\:ss\ndatetime_format=yyyy-MM-dd HH\\:mm\\:ss\nclassic_compatible=true\nnumber_format=#', '2016-10-11 18:43:36', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2636', '11', 'ENV_TYPE_TEST', '15', 'dubbo.registry.address=zookeeper://127.0.0.1:2181\ndubbo.registry.timeout=10000', '2016-10-11 18:43:36', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2637', '11', 'ENV_TYPE_TEST', '4', 'client_path=http://115.239.171.231:8899/rising-zptc-client/\nserver_out_ip=115.239.171.231\n\n#23:00:00为开始时间，-为分隔符号，2为23:00:00之后的两个小时\npayment_limit_time=23:00:00-2\n\npayment_limit_instruction=23:00至次日凌晨1:00为系统对账时间，充值和缴费等功能将暂时关闭！给您带来的不便，敬请谅解。', '2016-10-11 18:43:36', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2638', '11', 'ENV_TYPE_TEST', '12', '  log4j.rootLogger=DEBUG, stdout, R\n  log4j.appender.stdout=org.apache.log4j.ConsoleAppender\n  log4j.appender.stdout.layout=org.apache.log4j.PatternLayout\n  \n  log4j.logger.org.apache.commons.httpclient=DEBUG\n  log4j.logger.httpclient.wire.content=DEBUG\n  log4j.logger.httpclient.wire.header=DEBUG\n\n  # Pattern to output the caller\'s file name and line number.\n  log4j.appender.stdout.layout.ConversionPattern=%-4r %-5p [%d{yyyy-MM-dd HH:mm:ss}]  %m%n\n\n  log4j.appender.R=org.apache.log4j.DailyRollingFileAppender\n  log4j.appender.R.File=${catalina.home}/logs/rising-zptc-client.log\n  # log4j.appender.R.MaxFileSize= 1000KB\n\n  # Keep one backup file\n  #log4j.appender.R.MaxBackupIndex=1\n\n  log4j.appender.R.layout=org.apache.log4j.PatternLayout\n  log4j.appender.R.layout.ConversionPattern=%-4r %-5p [%d{yyyy-MM-dd HH:mm:ss}]  %m%n\n  log4j.appender.LOGFILE.encoding=UTF-8', '2016-10-11 18:43:36', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2639', '11', 'ENV_TYPE_TEST', '13', 'tag_syntax=auto_detect\ntemplate_update_delay=2\ndefault_encoding=utf-8\noutput_encoding=utf-8\nlocale=zh_CN\ndate_format=yyyy-MM-dd\ntime_format=HH\\:mm\\:ss\ndatetime_format=yyyy-MM-dd HH\\:mm\\:ss\nclassic_compatible=true\nnumber_format=#', '2016-10-11 18:43:36', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2640', '11', 'ENV_TYPE_FORMAL', '15', 'dubbo.registry.address=redis://10.10.7.35:6379\ndubbo.registry.timeout=10000', '2016-10-11 18:43:36', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2641', '11', 'ENV_TYPE_FORMAL', '4', 'client_path=http://eyt.zptc.cn:8899/rising-zptc-client/\nserver_out_ip=115.239.171.231\n\n#可以支付的时间段，01:00:00-23:00:00为每天的1点到23点之间可以支付\npayment_limit_time=01:00:00-23:00:00\n\npayment_limit_instruction=23:00至次日凌晨1:00为系统对账时间，充值和缴费等功能将暂时关闭！给您带来的不便，敬请谅解。', '2016-10-11 18:43:36', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2642', '11', 'ENV_TYPE_FORMAL', '12', '  log4j.rootLogger=INFO, stdout, R\n  log4j.appender.stdout=org.apache.log4j.ConsoleAppender\n  log4j.appender.stdout.layout=org.apache.log4j.PatternLayout\n  \n  log4j.logger.org.apache.commons.httpclient=INFO\n  log4j.logger.httpclient.wire.content=INFO\n  log4j.logger.httpclient.wire.header=INFO\n\n  # Pattern to output the caller\'s file name and line number.\n  log4j.appender.stdout.layout.ConversionPattern=%-4r %-5p [%d{yyyy-MM-dd HH:mm:ss}]  %m%n\n\n  log4j.appender.R=org.apache.log4j.DailyRollingFileAppender\n  log4j.appender.R.File=${catalina.home}/logs/rising-zptc-client.log\n  # log4j.appender.R.MaxFileSize= 1000KB\n\n  # Keep one backup file\n  #log4j.appender.R.MaxBackupIndex=1\n\n  log4j.appender.R.layout=org.apache.log4j.PatternLayout\n  log4j.appender.R.layout.ConversionPattern=%-4r %-5p [%d{yyyy-MM-dd HH:mm:ss}]  %m%n\n  log4j.appender.LOGFILE.encoding=UTF-8', '2016-10-11 18:43:36', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2643', '11', 'ENV_TYPE_FORMAL', '13', 'tag_syntax=auto_detect\ntemplate_update_delay=2\ndefault_encoding=utf-8\noutput_encoding=utf-8\nlocale=zh_CN\ndate_format=yyyy-MM-dd\ntime_format=HH\\:mm\\:ss\ndatetime_format=yyyy-MM-dd HH\\:mm\\:ss\nclassic_compatible=true\nnumber_format=#', '2016-10-11 18:43:36', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2670', '12', 'ENV_TYPE_DEVELOP', '14', 'dubbo.registry.address=zookeeper://127.0.0.1:2181\ndubbo.registry.timeout=10000\ndubbo.protocol.host=127.0.0.1\ndubbo.protocol.port=20001', '2016-10-11 18:44:07', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2671', '12', 'ENV_TYPE_DEVELOP', '16', 'redis.ip=127.0.0.1\nredis.port=6379\nredis.pool.maxTotal=1024\nredis.pool.maxIdle=200\nredis.pool.minIdle=10\nredis.pool.maxWaitMillis=3000\nredis.pool.testOnBorrow=true\nredis.pool.testOnReturn=true\nredis.pool.testWhileIdle=false', '2016-10-11 18:44:07', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2672', '12', 'ENV_TYPE_DEVELOP', '17', 'post_url=http://202.91.244.252/puxun/SmsSend\nuser_id=7649\nuser_pwd=zyy1dxx@7649\nextension_number=88888', '2016-10-11 18:44:07', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2673', '12', 'ENV_TYPE_DEVELOP', '1', 'validation.query=select 1\n\njdbc.url=jdbc:mysql://localhost:3306/post_telecom_college?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true\njdbc.username=root\njdbc.password=123456\n\njdbc.url.sms=jdbc:mysql://localhost:3306/post_telecom_college?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true\njdbc.username.sms=root\njdbc.password.sms=123456', '2016-10-11 18:44:07', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2674', '12', 'ENV_TYPE_DEVELOP', '4', 'client_path=http://121.40.149.140:8899/rising-zptc-client/\n\n#可以支付的时间段，01:00:00-23:00:00为每天的1点到23点之间可以支付\npayment_limit_time=01:00:00-23:00:00\n\npayment_limit_instruction=23:00至次日凌晨1:00为系统对账时间，充值和缴费等功能将暂时关闭！给您带来的不便，敬请谅解。\n\n##找回密码，密码短信模板##\nretrieve_password=【e云通】您的e云通账号新密码是：{}\n\n##注册验证码短信模板##\nregister_verify_code=【e云通】您正在注册e云通账号，您的验证码是：{}（此验证码20分钟内有效）\n\n##注册验证码短信模板##\nbind_mobile_verify_code=【e云通】您正在给e云通账号绑定手机号码，您的验证码是：{}（此验证码20分钟内有效）\n\n##找回密码验证码短信模板##\nretrieve_password_verify_code=【e云通】您正在找回e云通账号的密码，您的验证码是：{}（此验证码20分钟内有效）\n\n##充值一卡通短信模板##\nrech_one_card=【e云通】您的一卡通账户收到充值金额：{}元，充值金额将在1分钟内到达一卡通余额！\n\n##报名缴费短信模板##\nenter_pay=【e云通】您已经报名/缴费成功，报名项目为：“{enter_name}”，您的交易流水号为：{trade_no}', '2016-10-11 18:44:07', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2675', '12', 'ENV_TYPE_DEVELOP', '12', '  log4j.rootLogger=DEBUG, stdout, R\n  log4j.appender.stdout=org.apache.log4j.ConsoleAppender\n  log4j.appender.stdout.layout=org.apache.log4j.PatternLayout\n  \n  log4j.logger.org.apache.commons.httpclient=DEBUG\n  log4j.logger.httpclient.wire.content=DEBUG\n  log4j.logger.httpclient.wire.header=DEBUG\n\n  # Pattern to output the caller\'s file name and line number.\n  log4j.appender.stdout.layout.ConversionPattern=%-4r %-5p [%d{yyyy-MM-dd HH:mm:ss}]  %m%n\n\n  log4j.appender.R=org.apache.log4j.DailyRollingFileAppender\n  log4j.appender.R.File=${catalina.home}/logs/rising-zptc-server.log\n  # log4j.appender.R.MaxFileSize= 1000KB\n\n  # Keep one backup file\n  #log4j.appender.R.MaxBackupIndex=1\n\n  log4j.appender.R.layout=org.apache.log4j.PatternLayout\n  log4j.appender.R.layout.ConversionPattern=%-4r %-5p [%d{yyyy-MM-dd HH:mm:ss}]  %m%n\n  log4j.appender.LOGFILE.encoding=UTF-8', '2016-10-11 18:44:07', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2676', '12', 'ENV_TYPE_DEVELOP', '13', 'tag_syntax=auto_detect\ntemplate_update_delay=2\ndefault_encoding=utf-8\noutput_encoding=utf-8\nlocale=zh_CN\ndate_format=yyyy-MM-dd\ntime_format=HH\\:mm\\:ss\ndatetime_format=yyyy-MM-dd HH\\:mm\\:ss\nclassic_compatible=true\nnumber_format=#', '2016-10-11 18:44:07', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2677', '12', 'ENV_TYPE_DEVELOP_TEST', '14', 'dubbo.registry.address=zookeeper://127.0.0.1:2181\ndubbo.registry.timeout=10000\ndubbo.protocol.host=127.0.0.1\ndubbo.protocol.port=20000', '2016-10-11 18:44:07', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2678', '12', 'ENV_TYPE_DEVELOP_TEST', '16', 'redis.ip=127.0.0.1\nredis.port=6379\nredis.pool.maxTotal=1024\nredis.pool.maxIdle=200\nredis.pool.minIdle=10\nredis.pool.maxWaitMillis=3000\nredis.pool.testOnBorrow=true\nredis.pool.testOnReturn=true\nredis.pool.testWhileIdle=false', '2016-10-11 18:44:07', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2679', '12', 'ENV_TYPE_DEVELOP_TEST', '1', 'validation.query=select 1\n\njdbc.url=jdbc:mysql://121.40.149.140:3306/post_telecom_college?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true\njdbc.username=chapter\njdbc.password=123456\n\njdbc.url.sms=jdbc:mysql://121.40.149.140:3306/post_telecom_college?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true\njdbc.username.sms=root\njdbc.password.sms=123456', '2016-10-11 18:44:07', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2680', '12', 'ENV_TYPE_DEVELOP_TEST', '4', 'client_path=http://121.40.149.140:8899/rising-zptc-client/', '2016-10-11 18:44:07', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2681', '12', 'ENV_TYPE_DEVELOP_TEST', '12', '  log4j.rootLogger=DEBUG, stdout, R\n  log4j.appender.stdout=org.apache.log4j.ConsoleAppender\n  log4j.appender.stdout.layout=org.apache.log4j.PatternLayout\n  \n  log4j.logger.org.apache.commons.httpclient=DEBUG\n  log4j.logger.httpclient.wire.content=DEBUG\n  log4j.logger.httpclient.wire.header=DEBUG\n\n  # Pattern to output the caller\'s file name and line number.\n  log4j.appender.stdout.layout.ConversionPattern=%-4r %-5p [%d{yyyy-MM-dd HH:mm:ss}]  %m%n\n\n  log4j.appender.R=org.apache.log4j.DailyRollingFileAppender\n  log4j.appender.R.File=${catalina.home}/logs/rising-zptc-server.log\n  # log4j.appender.R.MaxFileSize= 1000KB\n\n  # Keep one backup file\n  #log4j.appender.R.MaxBackupIndex=1\n\n  log4j.appender.R.layout=org.apache.log4j.PatternLayout\n  log4j.appender.R.layout.ConversionPattern=%-4r %-5p [%d{yyyy-MM-dd HH:mm:ss}]  %m%n\n  log4j.appender.LOGFILE.encoding=UTF-8', '2016-10-11 18:44:07', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2682', '12', 'ENV_TYPE_DEVELOP_TEST', '13', 'tag_syntax=auto_detect\ntemplate_update_delay=2\ndefault_encoding=utf-8\noutput_encoding=utf-8\nlocale=zh_CN\ndate_format=yyyy-MM-dd\ntime_format=HH\\:mm\\:ss\ndatetime_format=yyyy-MM-dd HH\\:mm\\:ss\nclassic_compatible=true\nnumber_format=#', '2016-10-11 18:44:07', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2683', '12', 'ENV_TYPE_TEST', '14', 'dubbo.registry.address=zookeeper://127.0.0.1:2181\ndubbo.registry.timeout=10000\ndubbo.protocol.host=127.0.0.1\ndubbo.protocol.port=20000', '2016-10-11 18:44:07', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2684', '12', 'ENV_TYPE_TEST', '16', 'redis.ip=127.0.0.1\nredis.port=6379\nredis.pool.maxTotal=1024\nredis.pool.maxIdle=200\nredis.pool.minIdle=10\nredis.pool.maxWaitMillis=3000\nredis.pool.testOnBorrow=true\nredis.pool.testOnReturn=true\nredis.pool.testWhileIdle=false', '2016-10-11 18:44:07', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2685', '12', 'ENV_TYPE_TEST', '1', 'validation.query=select 1\n\njdbc.url=jdbc:mysql://127.0.0.1:3306/post_telecom_college?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true\njdbc.username=root\njdbc.password=123456\n\n#jdbc.url.sms=jdbc:mysql://127.0.0.1:3306/post_telecom_college?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true\n#jdbc.username.sms=root\n#jdbc.password.sms=123456\n\njdbc.url.sms=jdbc:mysql://202.107.225.155:3306/sms?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true\njdbc.username.sms=sytest\njdbc.password.sms=sytest', '2016-10-11 18:44:07', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2686', '12', 'ENV_TYPE_TEST', '4', 'client_path=http://115.239.171.231:8899/rising-zptc-client/\n\n#23:00:00为开始时间，-为分隔符号，2为23:00:00之后的两个小时\npayment_limit_time=23:00:00-2\n\npayment_limit_instruction=23:00至次日凌晨1:00为系统对账时间，充值和缴费等功能将暂时关闭！给您带来的不便，敬请谅解。\n\n\n##找回密码，密码短信模板##\nretrieve_password=【e云通】您的e云通账号新密码是：{}\n\n##注册验证码短信模板##\nregister_verify_code=【e云通】您正在注册e云通账号，您的验证码是：{}（此验证码20分钟内有效）\n\n##注册验证码短信模板##\nbind_mobile_verify_code=【e云通】您正在给e云通账号绑定手机号码，您的验证码是：{}（此验证码20分钟内有效）\n\n##找回密码验证码短信模板##\nretrieve_password_verify_code=【e云通】您正在找回e云通账号的密码，您的验证码是：{}（此验证码20分钟内有效）\n\n##充值一卡通短信模板##\nrech_one_card=【e云通】您的一卡通账户收到充值金额：{}元，充值金额将在1分钟内到达一卡通余额！\n\n##报名缴费短信模板##\nenter_pay=【e云通】您已经报名/缴费成功，报名项目为：“{enter_name}”，您的交易流水号为：{trade_no}', '2016-10-11 18:44:07', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2687', '12', 'ENV_TYPE_TEST', '12', '  log4j.rootLogger=DEBUG, stdout, R\n  log4j.appender.stdout=org.apache.log4j.ConsoleAppender\n  log4j.appender.stdout.layout=org.apache.log4j.PatternLayout\n  \n  log4j.logger.org.apache.commons.httpclient=DEBUG\n  log4j.logger.httpclient.wire.content=DEBUG\n  log4j.logger.httpclient.wire.header=DEBUG\n\n  # Pattern to output the caller\'s file name and line number.\n  log4j.appender.stdout.layout.ConversionPattern=%-4r %-5p [%d{yyyy-MM-dd HH:mm:ss}]  %m%n\n\n  log4j.appender.R=org.apache.log4j.DailyRollingFileAppender\n  log4j.appender.R.File=${catalina.home}/logs/rising-zptc-server.log\n  # log4j.appender.R.MaxFileSize= 1000KB\n\n  # Keep one backup file\n  #log4j.appender.R.MaxBackupIndex=1\n\n  log4j.appender.R.layout=org.apache.log4j.PatternLayout\n  log4j.appender.R.layout.ConversionPattern=%-4r %-5p [%d{yyyy-MM-dd HH:mm:ss}]  %m%n\n  log4j.appender.LOGFILE.encoding=UTF-8', '2016-10-11 18:44:07', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2688', '12', 'ENV_TYPE_TEST', '13', 'tag_syntax=auto_detect\ntemplate_update_delay=2\ndefault_encoding=utf-8\noutput_encoding=utf-8\nlocale=zh_CN\ndate_format=yyyy-MM-dd\ntime_format=HH\\:mm\\:ss\ndatetime_format=yyyy-MM-dd HH\\:mm\\:ss\nclassic_compatible=true\nnumber_format=#', '2016-10-11 18:44:07', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2689', '12', 'ENV_TYPE_FORMAL', '14', 'dubbo.registry.address=redis://10.10.7.35:6379\ndubbo.registry.timeout=10000\ndubbo.protocol.host=127.0.0.1\ndubbo.protocol.port=20000', '2016-10-11 18:44:07', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2690', '12', 'ENV_TYPE_FORMAL', '16', 'redis.ip=10.10.7.35\nredis.port=6379\nredis.pool.maxTotal=1024\nredis.pool.maxIdle=200\nredis.pool.minIdle=10\nredis.pool.maxWaitMillis=3000\nredis.pool.testOnBorrow=true\nredis.pool.testOnReturn=true\nredis.pool.testWhileIdle=false', '2016-10-11 18:44:07', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2691', '12', 'ENV_TYPE_FORMAL', '17', 'post_url=http://202.91.244.252/puxun/SmsSend\nuser_id=7649\nuser_pwd=zyy1dxx@7649\nextension_number=88888', '2016-10-11 18:44:07', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2692', '12', 'ENV_TYPE_FORMAL', '1', 'validation.query=select 1\n\njdbc.url=jdbc:mysql://10.10.7.37:3306/post_telecom_college?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true\njdbc.username=root\njdbc.password=zptc_!@#$%^\n\njdbc.url.sms=jdbc:mysql://202.107.225.155:3306/sms?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true\njdbc.username.sms=sytest\njdbc.password.sms=sytest', '2016-10-11 18:44:07', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2693', '12', 'ENV_TYPE_FORMAL', '4', 'client_path=http://eyt.zptc.cn:8899/rising-zptc-client/\n\n#可以支付的时间段，01:00:00-23:00:00为每天的1点到23点之间可以支付\npayment_limit_time=01:00:00-23:00:00\n\npayment_limit_instruction=23:00至次日凌晨1:00为系统对账时间，充值和缴费等功能将暂时关闭！给您带来的不便，敬请谅解。\n\n\n##找回密码，密码短信模板##\nretrieve_password= 【e云通】 您的e云通账号新密码是：{}\n\n##注册验证码短信模板##\nregister_verify_code= 【e云通】 您正在注册e云通账号，您的验证码是：{}（此验证码20分钟内有效）\n\n##注册验证码短信模板##\nbind_mobile_verify_code= 【e云通】 您正在给e云通账号绑定手机号码，您的验证码是：{}（此验证码20分钟内有效）\n\n##找回密码验证码短信模板##\nretrieve_password_verify_code= 【e云通】 您正在找回e云通账号的密码，您的验证码是：{}（此验证码20分钟内有效）\n\n##充值一卡通短信模板##\nrech_one_card= 【e云通】 您的一卡通账户收到充值金额：{}元，充值金额将在1分钟内到达一卡通余额！\n\n##报名缴费短信模板##\nenter_pay= 【e云通】 您已经报名/缴费成功，报名项目为：“{enter_name}”，您的交易流水号为：{trade_no}', '2016-10-11 18:44:07', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2694', '12', 'ENV_TYPE_FORMAL', '12', '  log4j.rootLogger=INFO, stdout, R\n  log4j.appender.stdout=org.apache.log4j.ConsoleAppender\n  log4j.appender.stdout.layout=org.apache.log4j.PatternLayout\n  \n  log4j.logger.org.apache.commons.httpclient=INFO\n  log4j.logger.httpclient.wire.content=INFO\n  log4j.logger.httpclient.wire.header=INFO\n\n  # Pattern to output the caller\'s file name and line number.\n  log4j.appender.stdout.layout.ConversionPattern=%-4r %-5p [%d{yyyy-MM-dd HH:mm:ss}]  %m%n\n\n  log4j.appender.R=org.apache.log4j.DailyRollingFileAppender\n  log4j.appender.R.File=${catalina.home}/logs/rising-zptc-server.log\n  # log4j.appender.R.MaxFileSize= 1000KB\n\n  # Keep one backup file\n  #log4j.appender.R.MaxBackupIndex=1\n\n  log4j.appender.R.layout=org.apache.log4j.PatternLayout\n  log4j.appender.R.layout.ConversionPattern=%-4r %-5p [%d{yyyy-MM-dd HH:mm:ss}]  %m%n\n  log4j.appender.LOGFILE.encoding=UTF-8', '2016-10-11 18:44:07', 'admin');
INSERT INTO `t_engin_config_info` VALUES ('2695', '12', 'ENV_TYPE_FORMAL', '13', 'tag_syntax=auto_detect\ntemplate_update_delay=2\ndefault_encoding=utf-8\noutput_encoding=utf-8\nlocale=zh_CN\ndate_format=yyyy-MM-dd\ntime_format=HH\\:mm\\:ss\ndatetime_format=yyyy-MM-dd HH\\:mm\\:ss\nclassic_compatible=true\nnumber_format=#', '2016-10-11 18:44:07', 'admin');

-- ----------------------------
-- Table structure for t_engin_config_type
-- ----------------------------
DROP TABLE IF EXISTS `t_engin_config_type`;
CREATE TABLE `t_engin_config_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `enginId` int(11) DEFAULT NULL COMMENT '工程ID',
  `configName` varchar(50) DEFAULT NULL COMMENT '配置类别名称',
  `fileName` varchar(50) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL COMMENT '状态；0：待启用；1：启用；80：删除；',
  `createTime` datetime DEFAULT NULL,
  `createUser` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_engin_config_type
-- ----------------------------
INSERT INTO `t_engin_config_type` VALUES ('1', '0', '数据库连接配置', 'properties/jdbc.properties', '1', '2015-08-28 00:00:00', null);
INSERT INTO `t_engin_config_type` VALUES ('4', '0', '其他配置', 'properties/other.properties', '1', '2015-08-28 00:00:00', 'admin');
INSERT INTO `t_engin_config_type` VALUES ('12', '0', '日志配置', 'properties/log4j.properties', '1', '2015-09-06 15:22:21', 'admin');
INSERT INTO `t_engin_config_type` VALUES ('13', '0', 'freemarker模板配置', 'properties/freemarker.properties', '1', '2015-09-30 10:28:47', 'admin');
INSERT INTO `t_engin_config_type` VALUES ('14', '12', 'dubbo相关配置', 'properties/dubbo.properties', '1', '2016-03-29 14:50:30', 'admin');
INSERT INTO `t_engin_config_type` VALUES ('15', '11', 'dubbo相关配置', 'properties/dubbo.properties', '1', '2016-03-29 14:51:31', 'admin');
INSERT INTO `t_engin_config_type` VALUES ('16', '12', 'redis相关配置', 'properties/redis.properties', '1', '2016-03-30 09:22:13', 'admin');
INSERT INTO `t_engin_config_type` VALUES ('17', '12', '短信通道配置', 'properties/sms.properties', '1', '2016-06-02 16:41:02', 'admin');
INSERT INTO `t_engin_config_type` VALUES ('18', '10', 'dubbo', 'properties/dubbo.properties', '1', '2016-09-22 18:20:23', 'admin');

-- ----------------------------
-- Table structure for t_envir_type
-- ----------------------------
DROP TABLE IF EXISTS `t_envir_type`;
CREATE TABLE `t_envir_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '环境ID',
  `envirName` varchar(50) DEFAULT NULL COMMENT '环境名称',
  `envirCode` varchar(50) DEFAULT NULL COMMENT '环境编码',
  `createTime` datetime DEFAULT NULL,
  `createUser` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_envir_type
-- ----------------------------
INSERT INTO `t_envir_type` VALUES ('1', '开发环境', 'ENV_TYPE_DEVELOP', '2015-08-31 13:57:25', 'caoy');
INSERT INTO `t_envir_type` VALUES ('2', '开发测试环境', 'ENV_TYPE_DEVELOP_TEST', '2015-08-31 13:57:45', 'caoy');
INSERT INTO `t_envir_type` VALUES ('3', '测试环境', 'ENV_TYPE_TEST', '2015-08-31 13:58:03', 'caoy');
INSERT INTO `t_envir_type` VALUES ('4', '预生产环境', 'ENV_TYPE_PREVIEW', '2015-08-31 13:58:15', 'caoy');
INSERT INTO `t_envir_type` VALUES ('5', '生产环境', 'ENV_TYPE_FORMAL', '2015-08-31 13:58:35', 'caoy');
INSERT INTO `t_envir_type` VALUES ('6', '扩展环境', 'ENV_TYPE_OTHER', '2015-08-31 13:58:55', 'caoy');

-- ----------------------------
-- Table structure for t_project
-- ----------------------------
DROP TABLE IF EXISTS `t_project`;
CREATE TABLE `t_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectName` varchar(50) DEFAULT NULL COMMENT '项目名称',
  `projectCode` varchar(50) DEFAULT NULL COMMENT '项目唯一编码',
  `personLiable` varchar(50) DEFAULT NULL COMMENT '责任人',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态；0：待启用；1：启用；80：删除；',
  `createTime` datetime DEFAULT NULL,
  `createUser` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_project
-- ----------------------------
INSERT INTO `t_project` VALUES ('11', '浙江邮电职业技术学院支付平台', 'RISING_ZPTC_PLATFORM', '曹阳', '1', '2016-03-28 17:07:54', 'admin');

-- ----------------------------
-- Table structure for t_sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_permission`;
CREATE TABLE `t_sys_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标识ID',
  `permName` varchar(50) NOT NULL COMMENT '权限名称',
  `permLevel` tinyint(4) DEFAULT NULL COMMENT '权限等级',
  `permUrl` varchar(150) DEFAULT NULL COMMENT '权限地址',
  `permRel` varchar(150) DEFAULT NULL COMMENT '权限标识',
  `permType` tinyint(4) DEFAULT NULL COMMENT '权限类型；0：菜单；1：按钮；',
  `sortNum` tinyint(4) DEFAULT NULL COMMENT '排序',
  `parentId` int(11) DEFAULT NULL COMMENT '父级ID',
  `isEnable` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否启用，0：不启用；1：启用；',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `createUser` varchar(50) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=139 DEFAULT CHARSET=utf8 COMMENT='系统权限表';

-- ----------------------------
-- Records of t_sys_permission
-- ----------------------------
INSERT INTO `t_sys_permission` VALUES ('1', '系统管理', '1', '', null, '0', '0', null, '1', '2015-08-10 19:07:10', 'admin');
INSERT INTO `t_sys_permission` VALUES ('2', '权限管理', '3', 'perm/to_perm_list', '', '0', '0', '1', '1', '2015-08-10 19:07:56', 'admin');
INSERT INTO `t_sys_permission` VALUES ('3', '角色管理', '2', 'role/to_role_list', null, '0', '2', '1', '1', '2015-08-10 19:08:34', 'admin');
INSERT INTO `t_sys_permission` VALUES ('4', '用户管理', '4', 'user/to_user_list', null, '0', '1', '1', '1', '2015-08-10 19:09:10', null);
INSERT INTO `t_sys_permission` VALUES ('19', '查询权限树列表', '4', 'perm/perm_nestable_list', '', '1', '0', '2', '1', '2015-08-27 13:34:21', 'admin');
INSERT INTO `t_sys_permission` VALUES ('20', '修改按钮权限', '4', 'perm/find_perm', '', '1', '1', '2', '1', '2015-08-27 13:35:10', 'admin');
INSERT INTO `t_sys_permission` VALUES ('21', '拖动权限排序', '4', 'perm/update_perm_position', '', '1', '3', '2', '1', '2015-08-27 13:36:33', 'admin');
INSERT INTO `t_sys_permission` VALUES ('22', '修改保存权限', '4', 'perm/update_perm', '', '1', '2', '2', '1', '2015-08-27 13:36:51', 'admin');
INSERT INTO `t_sys_permission` VALUES ('23', '新增权限', '4', 'perm/add_perm', '', '1', '4', '2', '1', '2015-08-27 13:37:10', 'admin');
INSERT INTO `t_sys_permission` VALUES ('24', '删除权限', '4', 'perm/delete_perm', '', '1', '5', '2', '1', '2015-08-27 13:37:26', 'admin');
INSERT INTO `t_sys_permission` VALUES ('25', '新增用户', '5', 'user/save_userinfo?oper=add', '', '1', '0', '4', '1', '2015-08-27 13:44:19', 'admin');
INSERT INTO `t_sys_permission` VALUES ('26', '修改用户', '5', 'user/save_userinfo?oper=edit', '', '1', '1', '4', '1', '2015-08-27 13:45:10', 'admin');
INSERT INTO `t_sys_permission` VALUES ('27', '删除用户', '5', 'user/save_userinfo?oper=del', '', '1', '2', '4', '1', '2015-08-27 13:45:20', 'admin');
INSERT INTO `t_sys_permission` VALUES ('28', '查询用户列表', '5', 'user/user_list', '', '1', '3', '4', '1', '2015-08-27 13:46:03', 'admin');
INSERT INTO `t_sys_permission` VALUES ('29', '打开设置权限', '5', 'user/find_user_role', '', '1', '4', '4', '1', '2015-08-27 13:46:43', 'admin');
INSERT INTO `t_sys_permission` VALUES ('30', '设置权限保存', '5', 'user/set_role', '', '1', '5', '4', '1', '2015-08-27 13:47:08', 'admin');
INSERT INTO `t_sys_permission` VALUES ('31', '查询角色列表', '3', 'role/role_list', '', '1', '0', '3', '1', '2015-08-27 13:48:17', 'admin');
INSERT INTO `t_sys_permission` VALUES ('32', '新增角色', '3', 'role/save_role?oper=add', '', '1', '1', '3', '1', '2015-08-27 13:49:20', 'admin');
INSERT INTO `t_sys_permission` VALUES ('33', '修改角色', '3', 'role/save_role?oper=edit', '', '1', '2', '3', '1', '2015-08-27 13:49:48', 'admin');
INSERT INTO `t_sys_permission` VALUES ('34', '删除角色', '3', 'role/save_role?oper=del', '', '1', '3', '3', '1', '2015-08-27 13:50:04', 'admin');
INSERT INTO `t_sys_permission` VALUES ('35', '设置权限', '3', 'role/perm_node_child_list', '', '1', '4', '3', '1', '2015-08-27 13:52:41', 'admin');
INSERT INTO `t_sys_permission` VALUES ('36', '设置权限保存', '3', 'role/set_perm', '', '1', '5', '3', '1', '2015-08-27 13:53:00', 'admin');
INSERT INTO `t_sys_permission` VALUES ('41', '项目配置管理', '1', '', '', '0', '1', null, '1', '2015-08-28 10:15:18', 'admin');
INSERT INTO `t_sys_permission` VALUES ('42', '项目管理', '2', 'project/to_project_list', '', '0', '0', '41', '1', '2015-08-28 10:16:28', 'admin');
INSERT INTO `t_sys_permission` VALUES ('43', '工程管理', '2', 'engin/to_engin_list', '', '0', '1', '41', '1', '2015-08-28 10:19:49', 'admin');
INSERT INTO `t_sys_permission` VALUES ('44', '工程配置类型管理', '2', 'engin_config_type/to_engin_config_type_list', '', '0', '2', '41', '1', '2015-08-28 10:20:52', 'admin');
INSERT INTO `t_sys_permission` VALUES ('45', '查询列表', '3', 'engin_config_type/engin_config_type_list', '', '1', '0', '44', '1', '2015-08-28 14:44:05', 'admin');
INSERT INTO `t_sys_permission` VALUES ('46', '新增配置类型', '3', 'engin_config_type/save_engin_config_type?oper=add', '', '1', '1', '44', '1', '2015-08-28 15:14:17', 'admin');
INSERT INTO `t_sys_permission` VALUES ('47', '修改配置类型', '3', 'engin_config_type/save_engin_config_type?oper=edit', '', '1', '2', '44', '1', '2015-08-28 15:14:35', 'admin');
INSERT INTO `t_sys_permission` VALUES ('48', '删除配置类型', '3', 'engin_config_type/save_engin_config_type?oper=del', '', '1', '3', '44', '1', '2015-08-28 15:14:54', 'admin');
INSERT INTO `t_sys_permission` VALUES ('50', '查询列表', '3', 'project/project_list', '', '1', '0', '42', '1', '2015-08-28 15:52:38', 'admin');
INSERT INTO `t_sys_permission` VALUES ('51', '新增项目', '3', 'project/save_project?oper=add', '', '1', '1', '42', '1', '2015-08-28 16:22:30', 'admin');
INSERT INTO `t_sys_permission` VALUES ('52', '修改项目', '3', 'project/save_project?oper=edit', '', '1', '2', '42', '1', '2015-08-28 16:22:44', 'admin');
INSERT INTO `t_sys_permission` VALUES ('53', '删除项目', '3', 'project/save_project?oper=del', '', '1', '3', '42', '1', '2015-08-28 16:22:58', 'admin');
INSERT INTO `t_sys_permission` VALUES ('56', '查询列表', '3', 'engin/engin_list', '', '1', '0', '43', '1', '2015-08-29 10:34:24', 'admin');
INSERT INTO `t_sys_permission` VALUES ('57', '新增工程', '3', 'engin/save_engin?oper=add', '', '1', '1', '43', '1', '2015-08-29 10:34:47', 'admin');
INSERT INTO `t_sys_permission` VALUES ('58', '修改工程', '3', 'engin/save_engin?oper=edit', '', '1', '2', '43', '1', '2015-08-29 10:36:57', 'admin');
INSERT INTO `t_sys_permission` VALUES ('59', '删除工程', '3', 'engin/save_engin?oper=del', '', '1', '3', '43', '1', '2015-08-29 10:37:14', 'admin');
INSERT INTO `t_sys_permission` VALUES ('62', '打开修改配置', '3', 'engin/to_update_config', '', '1', '4', '43', '1', '2015-08-29 14:18:00', 'admin');
INSERT INTO `t_sys_permission` VALUES ('64', '保存配置', '3', 'engin/update_config', '', '1', '5', '43', '1', '2015-08-31 10:52:15', 'admin');
INSERT INTO `t_sys_permission` VALUES ('129', '重置密码', '5', 'user/reset_pwd', '', '1', '6', '4', '1', '2015-09-30 08:56:31', 'admin');
INSERT INTO `t_sys_permission` VALUES ('137', '设置用户环境权限', '5', 'user/set_user_envir', '', '1', '7', '4', '1', '2015-11-17 10:24:21', 'admin');
INSERT INTO `t_sys_permission` VALUES ('138', '打开用户环境设置', '3', 'user/to_set_user_envir', '', '1', '8', '4', '1', '2015-11-17 10:25:40', 'admin');

-- ----------------------------
-- Table structure for t_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role`;
CREATE TABLE `t_sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `roleName` varchar(50) NOT NULL COMMENT '岗位名称',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态，1：正常；80：删除；',
  `isBuilt` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否内置，0：外置；1：内置；',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `createUser` varchar(50) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='系统岗位表';

-- ----------------------------
-- Records of t_sys_role
-- ----------------------------
INSERT INTO `t_sys_role` VALUES ('1', 'admin', '1', '1', '2015-08-04 11:07:26', null);
INSERT INTO `t_sys_role` VALUES ('2', '测试', '1', '1', '2015-08-26 09:26:50', null);

-- ----------------------------
-- Table structure for t_sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role_permission`;
CREATE TABLE `t_sys_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `roleId` int(11) NOT NULL COMMENT '岗位ID',
  `permId` int(11) NOT NULL COMMENT '权限ID',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `createUser` varchar(50) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14022 DEFAULT CHARSET=utf8 COMMENT='系统岗位权限表';

-- ----------------------------
-- Records of t_sys_role_permission
-- ----------------------------
INSERT INTO `t_sys_role_permission` VALUES ('13876', '1', '1', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13877', '1', '2', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13878', '1', '3', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13879', '1', '4', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13880', '1', '7', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13881', '1', '8', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13882', '1', '9', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13883', '1', '10', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13884', '1', '11', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13885', '1', '12', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13886', '1', '19', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13887', '1', '21', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13888', '1', '20', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13889', '1', '23', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13890', '1', '22', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13891', '1', '25', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13892', '1', '24', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13893', '1', '27', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13894', '1', '26', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13895', '1', '29', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13896', '1', '28', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13897', '1', '31', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13898', '1', '30', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13899', '1', '34', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13900', '1', '35', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13901', '1', '32', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13902', '1', '33', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13903', '1', '38', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13904', '1', '39', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13905', '1', '36', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13906', '1', '42', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13907', '1', '43', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13908', '1', '40', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13909', '1', '41', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13910', '1', '46', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13911', '1', '47', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13912', '1', '44', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13913', '1', '45', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13914', '1', '51', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13915', '1', '50', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13916', '1', '49', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13917', '1', '48', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13918', '1', '55', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13919', '1', '54', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13920', '1', '53', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13921', '1', '52', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13922', '1', '59', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13923', '1', '58', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13924', '1', '57', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13925', '1', '56', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13926', '1', '63', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13927', '1', '62', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13928', '1', '61', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13929', '1', '60', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13930', '1', '68', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13931', '1', '69', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13932', '1', '70', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13933', '1', '71', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13934', '1', '64', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13935', '1', '65', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13936', '1', '66', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13937', '1', '67', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13938', '1', '76', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13939', '1', '77', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13940', '1', '78', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13941', '1', '79', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13942', '1', '72', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13943', '1', '73', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13944', '1', '74', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13945', '1', '75', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13946', '1', '85', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13947', '1', '84', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13948', '1', '87', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13949', '1', '86', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13950', '1', '81', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13951', '1', '80', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13952', '1', '83', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13953', '1', '82', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13954', '1', '93', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13955', '1', '92', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13956', '1', '95', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13957', '1', '94', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13958', '1', '89', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13959', '1', '88', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13960', '1', '91', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13961', '1', '90', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13962', '1', '102', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13963', '1', '103', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13964', '1', '100', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13965', '1', '101', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13966', '1', '98', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13967', '1', '99', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13968', '1', '96', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13969', '1', '97', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13970', '1', '110', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13971', '1', '111', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13972', '1', '108', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13973', '1', '109', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13974', '1', '106', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13975', '1', '107', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13976', '1', '104', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13977', '1', '105', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13978', '1', '119', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13979', '1', '118', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13980', '1', '117', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13981', '1', '116', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13982', '1', '115', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13983', '1', '114', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13984', '1', '113', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13985', '1', '112', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13986', '1', '125', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13987', '1', '124', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13988', '1', '123', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13989', '1', '122', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13990', '1', '121', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13991', '1', '120', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13992', '1', '137', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13993', '1', '136', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13994', '1', '139', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13995', '1', '138', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13996', '1', '141', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13997', '1', '140', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13998', '1', '143', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('13999', '1', '142', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('14000', '1', '129', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('14001', '1', '131', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('14002', '1', '130', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('14003', '1', '133', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('14004', '1', '132', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('14005', '1', '135', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('14006', '1', '134', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('14007', '1', '152', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('14008', '1', '153', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('14009', '1', '154', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('14010', '1', '155', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('14011', '1', '156', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('14012', '1', '157', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('14013', '1', '158', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('14014', '1', '144', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('14015', '1', '145', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('14016', '1', '146', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('14017', '1', '147', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('14018', '1', '148', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('14019', '1', '149', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('14020', '1', '150', '2015-12-29 14:49:59', 'admin');
INSERT INTO `t_sys_role_permission` VALUES ('14021', '1', '151', '2015-12-29 14:49:59', 'admin');

-- ----------------------------
-- Table structure for t_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `userName` varchar(20) NOT NULL COMMENT '管理员账号',
  `userPwd` varchar(50) NOT NULL COMMENT '密码',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态：0：禁用；1：启用；80：删除；',
  `isBuilt` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否内置：0：外置；1：内置；',
  `note` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COMMENT='系统管理员表';

-- ----------------------------
-- Records of t_sys_user
-- ----------------------------
INSERT INTO `t_sys_user` VALUES ('1', 'admin', '76115847869088aa182248fe20e593ca', '1', '1', '西双版纳州');
INSERT INTO `t_sys_user` VALUES ('32', 'caoy', 'e10adc3949ba59abbe56e057f20f883e', '1', '1', '');

-- ----------------------------
-- Table structure for t_sys_user_basicinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user_basicinfo`;
CREATE TABLE `t_sys_user_basicinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `userId` int(11) NOT NULL COMMENT '用户ID',
  `realName` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `telphone` varchar(20) DEFAULT NULL COMMENT '电话',
  `deptId` int(11) DEFAULT NULL COMMENT '部门ID',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `createUser` varchar(50) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8 COMMENT='系统管理员基本信息表';

-- ----------------------------
-- Records of t_sys_user_basicinfo
-- ----------------------------
INSERT INTO `t_sys_user_basicinfo` VALUES ('1', '1', '无心1112222', 'cynasi@nasi.com', '18608672405', null, '2015-08-11 16:13:46', null);
INSERT INTO `t_sys_user_basicinfo` VALUES ('48', '32', '123456', '123456@ss.com', '12345678911', null, '2015-11-18 10:05:10', 'admin');

-- ----------------------------
-- Table structure for t_sys_user_envir
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user_envir`;
CREATE TABLE `t_sys_user_envir` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `envirId` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `createUser` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_sys_user_envir
-- ----------------------------
INSERT INTO `t_sys_user_envir` VALUES ('39', '1', '1', '2015-11-17 11:18:42', 'admin');
INSERT INTO `t_sys_user_envir` VALUES ('40', '1', '2', '2015-11-17 11:18:42', 'admin');
INSERT INTO `t_sys_user_envir` VALUES ('41', '1', '5', '2015-12-10 10:14:00', 'admin');
INSERT INTO `t_sys_user_envir` VALUES ('42', '1', '3', '2016-03-28 17:09:10', 'admin');
INSERT INTO `t_sys_user_envir` VALUES ('43', '1', '4', '2016-03-28 17:09:10', 'admin');
INSERT INTO `t_sys_user_envir` VALUES ('44', '1', '6', '2016-03-28 17:09:10', 'admin');
INSERT INTO `t_sys_user_envir` VALUES ('45', '32', '1', '2016-03-28 17:09:15', 'admin');

-- ----------------------------
-- Table structure for t_sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user_role`;
CREATE TABLE `t_sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `userId` int(11) NOT NULL COMMENT '管理员ID',
  `roleId` int(11) NOT NULL COMMENT '角色ID',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `createUser` varchar(50) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COMMENT='系统管理员岗位表';

-- ----------------------------
-- Records of t_sys_user_role
-- ----------------------------
INSERT INTO `t_sys_user_role` VALUES ('46', '1', '1', '2015-11-26 13:37:22', 'admin');

-- ----------------------------
-- Function structure for func_get_all_child_perm
-- ----------------------------
DROP FUNCTION IF EXISTS `func_get_all_child_perm`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` FUNCTION `func_get_all_child_perm`(rootId INT) RETURNS varchar(1000) CHARSET utf8
BEGIN      
 DECLARE sChildList VARCHAR(1000);       
 DECLARE sChildTemp VARCHAR(1000);       
 SET sChildTemp =cast(rootId as CHAR);       
 WHILE sChildTemp is not null DO       
  IF (sChildList is not null) THEN       
   SET sChildList = concat(sChildList,',',sChildTemp);   
  ELSE    
   SET sChildList = concat(sChildTemp);    
  END IF; 
  SELECT group_concat(id) INTO sChildTemp FROM t_sys_permission where FIND_IN_SET(parentId,sChildTemp)>0; 
 END WHILE;    
 RETURN sChildList;  
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for func_get_all_parent_perm
-- ----------------------------
DROP FUNCTION IF EXISTS `func_get_all_parent_perm`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` FUNCTION `func_get_all_parent_perm`(rootId INT) RETURNS varchar(1000) CHARSET utf8
BEGIN      
 DECLARE sParentList varchar(1000);       
 DECLARE sParentTemp varchar(1000);       
 SET sParentTemp =cast(rootId as CHAR);       
 WHILE sParentTemp is not null DO     
  IF (sParentList is not null) THEN         
   SET sParentList = concat(sParentTemp,',',sParentList);     
  ELSE     
   SET sParentList = concat(sParentTemp);     
  END IF;         
  SELECT group_concat(parentId) INTO sParentTemp FROM t_sys_permission where FIND_IN_SET(id,sParentTemp)>0;      
 END WHILE;       
 RETURN sParentList;     
END
;;
DELIMITER ;
