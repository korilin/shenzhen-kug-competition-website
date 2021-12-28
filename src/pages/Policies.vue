<script setup>
import { ref } from "vue";
import PrivacyPolicy from "../assets/md/privacy-policy.md"
import ToS from "../assets/md/tos.md"

const activeName = ref("PrivacyPolicy");

</script>
<template>
    <div id="privacy-policy">
        <h1>Shenzhen Kotlin User Group Policies</h1>
        <el-tabs v-model="activeName">
            <el-tab-pane label="隐私政策" name="PrivacyPolicy" />
            <el-tab-pane label="服务条款" name="ToS" />
        </el-tabs>
        <PrivacyPolicy v-show="activeName == 'PrivacyPolicy'" />
        <ToS  v-show="activeName == 'ToS'" />
    </div>
</template>

<style lang="scss" scoped>
#privacy-policy {
    max-width: 800px;
    padding: 20px;
    margin: auto;
}

h1 {
    color: var(--el-color-primary);
    text-align: center;
    margin-bottom: 50px;
}
</style>
