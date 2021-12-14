<script setup>
import { ref } from '@vue/reactivity';
import router from "../plugins/router";

const linklist = {
    "主页": "/",
    "Thematic Seminar": "/seminars",
    "Kotlin Conquerors": "/conquerors",
}
const activeIndex = ref(window.location.pathname)

// 测试用
function handleSelect(key, keyPath) {
    // console.log(key, keyPath ,activeIndex);
}

router.beforeResolve(to => {
    activeIndex.value = to.path
})

</script>

<template>
    <div id="header">
        <div class="title">
            <img
                class="banner"
                src="../assets/shenzhen-kug-banner.jpg"
                alt="Shenzhen Kotlin User Group"
            />
        </div>
        <el-menu
            :default-active="activeIndex"
            class="el-menu-demo"
            mode="horizontal"
            :router="true"
            @select="handleSelect"
        >
            <template v-for="(path, name) in linklist">
                <el-menu-item :index="path" :route="path">{{ name }}</el-menu-item>
            </template>
        </el-menu>
    </div>
</template>

<style lang="scss" scoped>
#header {
    display: flex;
    border-bottom: solid 1px #e6e6e6;
}

.title {
    display: flex;
    align-items: flex-end;

    div {
        font-size: 1.3rem;
        font-weight: 600;
    }
}

.banner {
    display: flex;
    padding: 5px 20px;
    height: 60px;
}
.el-menu {
    align-items: flex-end;
    justify-content: flex-end;
    width: 100%;
}

.el-menu-item {
    font-weight: 600;
    user-select: none;
}

.el-menu--horizontal {
    border: 0;
}
</style>
