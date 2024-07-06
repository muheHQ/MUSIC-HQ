<template>
  <el-header class="custom-header">
    <div class="music-name">
      <img src="../img/HQ.jpg">
      <h1>{{ MUSIC_NAME }}</h1>
    </div>

    <div class="input">
      <input type="text" v-model="input1" placeholder="请输入搜索的歌曲">
      <el-button type="success" class="el-button" plain>搜索</el-button>
    </div>


    <div class="nav-menu">
      <ul>
        <li v-for="item in labelPath" :key="item.path">
          <router-link :to="item.path">{{ item.name }}</router-link>
        </li>
      </ul>
    </div>

    <div class="setting">
      <el-icon><Setting /></el-icon>
    </div>

  </el-header>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import { MUSIC_NAME } from '@/enum/musicName'
import {labelPath} from "@/enum/label";

const input1 = ref('')
</script>

<style scoped>
.custom-header {
  background-color: #FFCCCC;
  line-height: 60px;
  display: flex;
  align-items: center;
}

.music-name {
  display: flex;
  align-items: center;
  width: 15%;
  margin: 5px;
  border: 1px solid white; /* 修改为白色边框 */
}

.music-name img {
  width: 20%; /* 调整图片宽度 */
  border-radius: 25px;
  margin-right: 10px; /* 适当调整图片和文字之间的间距 */
}

.input {
  width: 15%;
  display: flex;
  align-items: center; /* 垂直居中 */
  border: 1px solid white;
  height: 40px; /* 设置容器高度 */
  margin: 5px;
}

.input input {
  flex: 1; /* 填充剩余空间 */
  border-radius: 8px;
  margin-right: 5px;
  height: 100%; /* 继承父容器高度 */
}

.input .el-button {
  flex: 0 0 auto; /* 不拉伸且不收缩 */
  height: 100%; /* 继承父容器高度 */
}

.nav-menu {
  width: 15%;
  height: 40px;
  border: 1px solid white;
  padding: 0; /* 去除内边距 */
  margin-left: 20px;
}

.nav-menu ul {
  list-style-type: none; /* 去除默认的列表符号 */
  margin: 0; /* 去除外边距 */
  padding: 0; /* 去除内边距 */
  height: 100%; /* 占满父元素高度 */
  display: flex; /* 使列表项水平排列 */
  align-items: center; /* 垂直居中 */
}

.nav-menu ul li {
  flex: 1; /* 平均分配空间 */
  text-align: center; /* 文本居中 */
}

.setting {
  width: 30%;
  height: 40px;
  border: 1px solid white;
  margin-left: auto;
  margin-right: 50px;
  display: flex;
  align-items: center;
  justify-content: right;
}

</style>