<template>
<!--  因为是抽取成组件里面没有el-header或者el-footer默认会是水平排列我们可以自定义vertical-->
  <el-container style="height: 100vh" direction="vertical">
    <Header />
    <el-container>
      <Aside />
      <el-container direction="vertical">
        <Main />
        <Footer />
      </el-container>
    </el-container>
  </el-container>
</template>


<script setup>
import Header from '@/components/Header.vue';
import Aside from '@/components/Aside.vue';
import Main from '@/components/Main.vue';
import Footer from '@/components/Footer.vue';
</script>

<style>
*{
  padding: 0;
  margin: 0;
}
</style>
