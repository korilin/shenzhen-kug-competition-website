<script setup>
import router from "../plugins/router";
const backToHome = () => {
    router.push("/")
}
</script>

<template>
    <div style="width: 100%">
        <div class="content">
            <div style="font-size: 200px">404</div>
            <div>肥肠抱歉，你要的页面不见了</div>
            <el-divider></el-divider>
            <el-button type="primary" @click="backToHome">回到主页</el-button>
        </div>
    </div>
</template>

<style lang="scss" scoped>
.content {
    text-align: center;
}
</style>
