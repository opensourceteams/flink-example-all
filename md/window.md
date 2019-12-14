# window 常用命令

## 端口

#### 查看端口占用情况
```aidl
netstat -ano
```
  
#### 查看某个端口被哪个和序占用
```aidl
netstat -aon|findstr "1234"  
```  