#                                         仿京东ES搜索Demo

### 简介 

**使用 jsoup 爬取京东数据, 并写入到 elasticsearch 中, 并根据关键字搜索高亮展示内容**
![image-20230816150315120](https://img2023.cnblogs.com/blog/2169049/202308/2169049-20230816150323373-2100294217.png)

### 技术栈
- Spring Boot 2.2.5.RELEASE
- ElasticSearch 7.9.3
- Jsoup
- Vue.js

### 建立索引

```json
PUT /content
{
  "mappings": {
    "properties": {
      "name":{
        "type": "text",
        "analyzer": "ik_smart"
      },
      "price":{
        "type": "keyword",
        "index": "false"
      },
      "image":{
        "type": "keyword",
        "index": "false"
      }
    }
  }
}
```