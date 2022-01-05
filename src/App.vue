<script setup>
import Header from "./components/Header.vue"
import Footer from "./components/Footer.vue"
import { ref } from "vue";


var showFooter = ref(true)

const footerHiddenRegular = ['/playground']
for (var index in footerHiddenRegular) {
    if (window.location.pathname.includes(footerHiddenRegular[index])) {
        showFooter.value = false;
        break;
    }
}
</script>

<template>
    <el-container>
        <el-header>
            <Header />
        </el-header>
        <el-main :class="showFooter?'has-footer':''">
            <router-view />
        </el-main>
        <el-footer v-if="showFooter">
            <Footer />
        </el-footer>
    </el-container>
</template>

<style lang="scss">
body {
    padding: 0;
    margin: 0;
    min-height: 100vh;
    position: relative;
}
#app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    color: #2c3e50e6;
    line-height: 1.5;
}

.md2vue-wrapper {
    li {
        margin-bottom: 10px;
    }
}

.el-main {
    height: 100%;
}

.has-footer {
    margin-bottom: 210px;
}

.el-header,
.el-footer {
    padding: 0 !important;
    margin: 0 !important;
}

.el-footer {
    position: absolute;
    bottom: 0px;
    width: 100%;
    height: auto !important;
}

.el-container {
    height: 100% !important;
}
</style>
