<script setup>
import { reactive, ref } from "vue-demi";
import APIs from "../lib/apis";
import { httpTool } from "../lib/utils"

let seminars = reactive([])
const seminarNow = ref(null)

httpTool.get(APIs.seminar_all, {}).then((response) => {
    console.log(response);
    for (const index in response.data) {
        seminars.push(response.data[index])
    };
    console.log(seminars);
})

function dateByTimestamp(timestamp) {
    const date = new Date(timestamp)
    return date.toLocaleDateString() + " " + date.toLocaleTimeString()
}

function openNewTab(url) {
    window.open(url)
}
</script>

<template>
    <div class="wrap">
        <h1>本期 Thematic Seminar 信息</h1>
        <el-empty v-if="seminarNow == null" :image-size="100" description="还没开始"></el-empty>

        <el-divider>
            <span class="divider-text">往期活动记录</span>
        </el-divider>

        <el-card v-for="seminar in seminars">
            <h2>{{ seminar.title }}</h2>
            <p class="time">活动开始时间：{{ dateByTimestamp(seminar.eventTime) }}</p>
            <p class="theme">活动主题：{{ seminar.theme }}</p>
            <p>{{ seminar.description }}</p>
            <p style="text-align: center; margin-top: 40px;">
                <el-button
                    type="primary"
                    :disabled="seminar.bilibiliUrl == null"
                    @click="openNewTab(seminar.bilibiliUrl)"
                    round
                >观看回放视频</el-button>
            </p>
        </el-card>
    </div>
    <el-backtop />
</template>

<style lang="scss" scoped>
.wrap {
    max-width: 900px;
    margin: auto;
}

.divider-text {
    font-weight: 600;
    font-size: 1rem;
}

.el-card {
    margin-top: 40px;

    .time {
        color: var(--el-text-color-secondary);
    }

    .theme {
        color: var(--el-color-primary);
        font-weight: bold;
    }
}
</style>
