<script setup>
import SeminarNow from "../../components/seminar/SeminarNow.vue";
import SeminarReocrds from "../../components/seminar/SeminarReocrds.vue";
</script>

<template>
    <div class="wrap">
        <h1>本期活动信息</h1>

        <SeminarNow />

        <el-divider style="margin: 80px auto;">
            <span class="divider-text">往期活动记录</span>
        </el-divider>

        <SeminarReocrds />
    </div>
    <el-backtop />
</template>

<style lang="scss" scoped>
.wrap {
    max-width: 1080px;
    margin: auto;
}

.divider-text {
    font-weight: 600;
    font-size: 1rem;
}
</style>