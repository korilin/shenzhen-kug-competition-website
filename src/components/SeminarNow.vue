<script setup>
import { ref } from "vue-demi"
import { useStore } from "vuex"
import APIs from "../utils/apis"
import httpTool from "../utils/http-tool"
import { dateFromTimestamp } from "../utils/utils"

const svgSize = 18
const store = useStore()

const seminarNow = ref(store.state.seminarNow)
const isEnter = ref(false)


if (store.state.seminarNow === null) {
    httpTool.get(APIs.seminar_now).then((response) => {
        store.commit('updateSeminarNow', response.data);
        seminarNow.value = store.state.seminarNow;
    })
}
</script>

<template>
    <el-empty v-if="seminarNow == null" :image-size="100" description="还没开始"></el-empty>

    <div v-else>
        <el-descriptions class="margin-top" :column="1" border :title="seminarNow.title">
            <el-descriptions-item>
                <template #label>
                    <div class="el-desc-label">
                        <timer :width="svgSize" :height="svgSize" />开始时间
                    </div>
                </template>
                {{ dateFromTimestamp(seminarNow.eventTime) }}
            </el-descriptions-item>
            <el-descriptions-item>
                <template #label>
                    <div class="el-desc-label">
                        <notebook :width="svgSize" :height="svgSize" />主题
                    </div>
                </template>
                <el-tag v-for="theme in seminarNow.themes" style="margin-right: 10px;">{{ theme }}</el-tag>
            </el-descriptions-item>
            <el-descriptions-item>
                <template #label>
                    <div class="el-desc-label">
                        <tickets :width="svgSize" :height="svgSize" />介绍
                    </div>
                </template>
                {{ seminarNow.description }}
            </el-descriptions-item>
        </el-descriptions>
        <div style="margin: 50px auto; text-align: center;">
            <el-button
                type="success"
                :disabled="isEnter"
                @click="formDrawer = true"
            >{{ isEnter ? "已报名" : "报名参加本期 Seminar" }}</el-button>
        </div>
    </div>
</template>

<style lang="scss" scoped>
svg {
    position: relative;
    top: 4px;
    padding-left: 8px;
    left: -5px;
}

.el-desc-label {
    min-width: 120px;
}
</style>
