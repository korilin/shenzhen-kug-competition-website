<script setup>
const infos = {
    "组建日期": "2021年",
    "活动方式": "QQ群组",
    "QQ群号": "811981478",
}
const me = {
    link: "https://github.com/korilin",
    text: "@korilin"
}

const github = {
    link: "https://github.com/shenzhen-kug/shenzhen-kug-website-v2",
    text: "shenzhen-kug-website"
}

const icp = {
    link: "http://beian.miit.gov.cn/",
    text: "--"
}

const links = {
    "组建人": me,
    "站点源码": github,
    "备案号": icp
}
</script>

<template>
    <div id="footer">
        <el-descriptions column="1" title="Info">
            <el-descriptions-item :label="label + '：'" v-for="(info, label) in infos">{{ info }}</el-descriptions-item>
        </el-descriptions>

        <el-descriptions column="1" title="Link">
            <el-descriptions-item :label="label + '：'" v-for="(info, label) in links">
                <el-link :href="info.link" target="_blank" type="primary">{{ info.text }}</el-link>
            </el-descriptions-item>
        </el-descriptions>

        <img src="../assets/kug-qq-group-qrcode.jpg" alt />
    </div>
</template>

<style lang="scss" scoped>
#footer {
    display: flex;
    position: fixed;
    bottom: 0;
    width: 100%;
    border-top: solid 1px #e6e6e6;
    padding: 20px;
    justify-content: space-around;
}
</style>
