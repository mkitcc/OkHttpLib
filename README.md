# OkHttpLib
对okhttp的简单封装，参考了
>鸿洋大神的 [okhttp-utils](https://github.com/hongyangAndroid/okhttp-utils)


## 用法

* Android Studio

  可以导入源码然后在Module 的builde.greadle 文件里添加
  ```
  compile project(':okhttplib')
  ```
  也可以直接添加
  ```
    compile 'com.libvirus.okhttplib:okhttplib:1.0.0'
  ```

* Eclipse

  下载最新的[okhttplib.jar](https://github.com/psuwgipgf/OkHttpLib/tree/master/okhttplib/okhttplib.jar)

  注：需要同时导入okhttp和okio的jar，下载见：[https://github.com/square/okhttp](https://github.com/square/okhttp).

* 配置

  ```java
  OkHttpManager.getInstace().host(host);
  ```
  
  
## 支持的功能

  * 一般的get请求
  * 一般的post请求(参数可以是数组)
  * 根据tag，取消某个请求，可以设置多级tag.
  * 日志
  
## 以后要支持的功能
  * cookie 自动管理
  * post上传文件
  * post上传文件返回进度

## 用法示例

### 普通的GET请求

  ```java
  OkHttpManager.get()
            .url("/")
            .tag("get")
            .exec(new CallResult(){
                @Override
                public void onResponse(Call call, final Response response) throws IOException {
                    view.post(new Runnable() {
                        @Override
                        public void run() {
                                try {
                                    text.setText(response.body().string());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }

                    @Override
                    public void onFailure(Call call, IOException e) {

                    }
                });
  ```

### 普通POST请求

```java
    OkHttpManager.post()
            .url("/")
            .exec(new CallResult(){
                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    Log.e("post",response.body().string());
                }
            });
```

## 配置

### 全局配置

可以在Application中
```java
OkHttpManager.getInstace().host(host).log("psuwgipgf");
```
也可以自己配置一个`OkHttpClient` 传入
```java
new OkHttpManager(mOkHttpClient);
```
### 单独设置某个请求的`OkHttpClient`
```java
OkHttpManager.post()
                .url("/")
                .setOkHttpClient(new OkHttpClient)
                .exec(new CallResult(){
                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Log.e("post",response.body().string());
                    }
                });
```
