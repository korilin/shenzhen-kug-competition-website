<script setup>
import { ref } from "vue-demi"
import { useStore } from "vuex"
import APIs from "../../utils/apis"
import httpTool from "../../utils/http-tool"
import { dateFromTimestamp } from "../../utils/utils"
import { ElMessageBox } from 'element-plus';
import { reactive } from 'vue-demi';

const svgSize = 18
const store = useStore()

const seminarNow = ref(store.state.seminarNow)
const isEnter = ref(false)
const formDialog = ref(false)

if (store.state.seminarNow === null) {
    httpTool.get(APIs.seminar_now).then((response) => {
        store.commit('updateSeminarNow', response.data);
        seminarNow.value = store.state.seminarNow;
    })
}

const form = reactive({
    name: "",
    email: "",
    city: "",
    org: "",
    rank: ""
})

// 简单正则，中间有`@`有`.`就行
const emailReg =/.+@.+\..+/

const rules = {
    name: {
        required: true,
        message: '请填写你的称呼',
    },
    email: {
        required: true,
        message: '请填写你的联系邮箱',
        validator: (rule, value) => emailReg.test(value)
    }
}

</script>

<script>
export default {
    methods: {
        onSubmit() {
            this.$refs["seminarForm"].validate((valid) => {
                if (valid) {
                    ElMessageBox.alert("我们会发送一封附带活动信息的邮件到您填写的邮箱，请留意查收。", "感谢你的报名", {
                        confirmButtonText: 'OK',
                        callback: () => {
                            this.formDialog = false
                            this.isEnter = true
                        }
                    }).catch()
                } else {
                    return false
                }
            })
        }
    }
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
                @click="formDialog = true"
            >{{ isEnter ? "已报名" : "报名参加本期 Seminar" }}</el-button>

            <el-dialog v-model="formDialog" :title="seminarNow.title + ' 报名表单'" center>
                <el-form
                    label-position="left"
                    label-width="120px"
                    :model="form"
                    :rules="rules"
                    ref="seminarForm"
                >
                    <el-form-item label="称呼" prop="name">
                        <el-input v-model="form.name"></el-input>
                    </el-form-item>
                    <el-form-item label="邮箱" prop="email" type="email">
                        <el-input v-model="form.email"></el-input>
                    </el-form-item>
                    <el-form-item label="城市">
                        <el-input v-model="form.city"></el-input>
                    </el-form-item>
                    <el-form-item label="公司/组织/学校">
                        <el-input v-model="form.org"></el-input>
                    </el-form-item>
                    <el-form-item label="职称">
                        <el-input v-model="form.rank"></el-input>
                    </el-form-item>
                </el-form>
                <template #footer>
                    <el-button type="primary" @click="onSubmit">报名</el-button>
                </template>
            </el-dialog>
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
