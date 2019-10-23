# vue-cli
## 增加无条件查询权限菜单树
# 合并出错
```$xslt
error: You have not concluded your merge (MERGE_HEAD exists).
hint: Please, commit your changes before merging.
fatal: Exiting because of unfinished merge.
```
解决
```$xslt
git reset --hard origin/master
```
# 接口编写
1. 通过订单号删除所有账单
delete from tb_bill where order_no = #{order_no}