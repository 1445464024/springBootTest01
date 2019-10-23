#统一控制
#设置对输出参数的格式化
#spring.jackson.date-format=yyyy-MM-dd HH:mm:ss

#北京时间相对伦敦有8个小时时差所以使用GMT+8，这样才能正常显示日期
spring.jackson.time-zone=GMT+8

#设置对输入参数的格式化，这样后台的接口就可以接收Date类型
spring.mvc.date-format=yyyy-MM-dd

#修改默认配置
server.port=8090
#server.servlet.context-path=/sb

#配置一些公共信息
resource.imageServer=http://image2
resource.emailServer=http://email
#image.server=http://image
