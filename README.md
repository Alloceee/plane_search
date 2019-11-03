# plane_search
## 基于J2EE的飞机航班查询系统
### 前台技术：springboot + springdatajpa + bootstrap + redis + angular + thymeleaf
### 后台技术：springboot + springdatajpa + bootstrap + thymeleaf

- 查询功能  搜索引擎  elasticsearch
- 采用redis进行页面缓存
- 前后端分离

#### 前台功能：
1. 首页分为三部分（航班信息搜索、国内航班最新信息展示、国外航班最新信息展示）
根据ip定位进行展示

2. redis页面缓存
3. 航班信息一次加载成功（数据绑定与交换）
4. 搜索引擎优化
ajax  get请求搜索，urlendcode编码
5. 添加短信提醒功能（绑定手机号，添加起飞提醒）

#### 后台功能：
1. 批量数据的添加、删除与修改
datatable展示

11.3  基本实现前台展示与后台功能，整合jpa
