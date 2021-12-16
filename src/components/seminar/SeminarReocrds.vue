<script setup>
import { useStore } from "vuex";
import APIs from "../../utils/apis";
import httpTool from "../../utils/http-tool"
import { dateFromTimestamp } from "../../utils/utils"

const store = useStore()

if (store.state.seminarRecords == null) {
    httpTool.get(APIs.seminar_record).then((response) => {
        store.commit('updateSeminarRecords', response.data)
    })
}

function openNewTab(url) {
    window.open(url)
}
</script>

<template>
    <el-card v-for="seminar in store.state.seminarRecords">
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
                <span style="position: relative; top: -3px;">观看回放视频</span>

                <video-play :width="18" :height="18" />
            </el-button>
        </p>
    </el-card>
</template>

<style lang="scss" scoped>
svg {
    position: relative;
    top: 1px;
    padding-left: 10px;
}

.el-card {
    margin-top: 40px;

    .time {
        color: var(--el-text-color-secondary);
    }
}
</style>
