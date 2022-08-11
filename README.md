# Cafemaster-demo
基于Vue.js框架，使用Vue-cli搭建一个移动端餐馆小程序项目，具备菜单展示、菜品轮播、订单结算、用户登录等功能
实验环境：
Visual Studio Code2015
MyEclipse Professional 2014
MySQL Workbench 8.0 CE
一）网站简介
网站的名称为：新白鹿餐厅点餐网站，其使用的技术主要有基于Vue.js框架的移动web开发技术，使用了element-ui样式工具。
1、功能展示
在本网站中，主要菜单下方样式栏包含四个切换页面，分别是首页、店内就餐、外卖点餐和会员中心。
在“首页”界面，主要为宣传图片轮播图展示与开始点餐按钮跳转，路由变换；在“店内就餐”界面，左侧悬浮栏展示了不同类别的菜品选择，可供点击后在右侧展示对应菜品，点击右侧菜品后会显示菜品详细信息；在“外卖点餐”界面，从服务器取值前端渲染菜品，点击菜品后会进入菜品详情页，单击“添加到外卖单”会在外卖单中添加对应菜品，点击返回按钮可返回，单击“我的外卖单”后，会显示外卖单信息；在“会员中心”界面，上册有“登录/注册”按钮，单击后跳转登录页面，单击登录页面的注册按钮进入注册页面，在“会员中心”页面中间有餐馆宣传动画，在下方有相应的功能按钮。
页面效果截图如下：
           ![image](https://user-images.githubusercontent.com/70763281/184146219-56db428e-5031-4107-a162-dd0f3ce5aa81.png)
           ![image](https://user-images.githubusercontent.com/70763281/184146255-90ddf83d-046a-4c25-8721-169c83262afd.png)
           ![image](https://user-images.githubusercontent.com/70763281/184146340-95e0fd10-b6da-46f1-bb61-ee652cd1581a.png)
           ![image](https://user-images.githubusercontent.com/70763281/184146365-1d58984a-de79-4b8b-96c5-b02450781f3b.png)

2、网站目录和文件结构
主要介绍src文件下的目录与文件结构：
在assets文件下，主要存放网页链接中的媒体文件，在css下存放的是bootstrap，css样式文件；fonts存放的是字体样式文件；images中存放的是网页中菜品的图片；js文件中存放了bootstrap的js文件。Components文件夹中存放的是主界面的vue文件。Home文件夹中存有Home.vue和commodity.vue文件，分别是首页与外卖点餐界面子组件文件；Meal文件主要是店内就餐界面文件，firstpage是其主页面样式，list是其详情页样式，placeorder是其结算页界面；My文件夹中My2为会员中心页面，css中包含了会员中心页面中动画样式，并有供网页引用的图片；Share文件夹主要为自定义子组件与供主页面调用的子组件文件；store文件夹中主要储存了供主页面调用的js文件；login页面为登录界面；router界面中记录路由信息；APP.vue记录总体页面的信息与下方导引栏信息；menu.json记录了meal文件夹中引用的json数据。


