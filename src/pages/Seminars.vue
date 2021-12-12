<script setup>
import { reactive } from "vue-demi";
import SeminarNow from "../components/SeminarNow.vue";
import APIs from "../utils/apis";
import httpTool from "../utils/http-tool"
import { dateFromTimestamp } from "../utils/utils"

let seminars = reactive([])

httpTool.get(APIs.seminar_record).then((response) => {
    for (const index in response.data) {
        seminars.push(response.data[index])
    };
})

function openNewTab(url) {
    window.open(url)
}
</script>

<template>
    <div class="wrap">
        <h1>本期 Thematic Seminar 信息</h1>

        <SeminarNow />

        <el-divider>
            <span class="divider-text">往期活动记录</span>
        </el-divider>

        <el-card v-for="seminar in seminars">
            <h2>{{ seminar.title }}</h2>
            <p class="time">活动开始时间：{{ dateFromTimestamp(seminar.eventTime) }}</p>
            <p class="theme">
                活动主题：
                <el-tag v-for="theme in seminar.themes" style="margin-right: 10px;">{{ theme }}</el-tag>
            </p>
            <p>{{ seminar.description }}</p>
            <p style="text-align: center; margin-top: 40px;">
                <el-button
                    type="primary"
                    :disabled="seminar.bilibiliUrl == null"
                    @click="openNewTab(seminar.bilibiliUrl)"
                >
                    <span style="line-height: 25px;">观看回放视频</span>

                    <video-play :width="18" :height="18" />
                </el-button>
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

svg {
    position: relative;
    top: 4px;
    padding-left: 10px;
}

.el-card {
    margin-top: 40px;

    .time {
        color: var(--el-text-color-secondary);
    }

    .theme {
        font-weight: bold;
    }
}
</style>