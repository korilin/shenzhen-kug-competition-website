<script setup>
import Hello from "../components/Hello.vue"
</script>

<template>
    <div id="home">
        <Hello />
    </div>
</template>

<style lang="scss" scoped>
#home {
    padding: 80px;

    @media screen and (max-width: 1480px) {
        padding: 20px !important;
    }
}

.el-divider {
    margin: 100px auto;
    padding: 0px 20px;

    .info {
        color: var(--el-color-primary) !important;
        font-size: 1.3rem !important;
    }
}
</style>
