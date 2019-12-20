# plane_search
## 基于J2EE的飞机航班查询系统
### 前台技术：springboot + springdatajpa + bootstrap + redis + thymeleaf + quartz + elasticsearch
### 后台技术：springboot + springdatajpa + bootstrap + thymeleaf

- 查询功能  搜索引擎  elasticsearch
- 采用redis进行页面缓存
- 前后端分离

#### 前台功能：
1. 首页分为三部分（航班信息搜索、国内航班最新信息展示、国外航班最新信息展示） - -OK
根据ip定位进行展示      城市点击联动 - - 12.1

2. 航班动态及时更新，设置前端定时器，每隔半小时从数据库中读取数据（Redis过期时间也设置为半小时）

3. 使用redis进行页面访问量统计，计算热门城市，然后根据ip和热门城市展示首页   - - 11.30

4. redis页面缓存   - - 11.30

5. 搜索优化ealsticsearch  - - 11.30
     ajax  get请求搜索

6. 添加短信提醒功能（绑定手机号，添加起飞提醒） - -OK
     整合quartz      - - 11.30

     Job的名称可以采用md5(用户账号加上航班id)确保唯一，执行后删除任务，如果发送失败，再次尝试，超过3次失败则添加到错误日志，然后发错误消息

#### 后台功能：

1. 图片信息上传至七牛云服务器CDN加速（工具类封装）   - - OK
2. 批量数据的添加、删除（excel、csv导入）  - - 11.30（航班信息、客机信息导入）
3. layui表格动态修改  - -12.1



### JMeter压力测试

1. 首页访问测试
2. 搜索性能测试

参考论文：https://wenku.baidu.com/view/64ba49c108a1284ac8504376.html

> 12.1 论文
>
> 前端数据均采用layui模板渲染
>
> 搜索实现后进行索引优化、数据库优化