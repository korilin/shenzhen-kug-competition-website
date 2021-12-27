<script setup>
const userGroupListLink = "https://kotlinlang.org/user-groups/user-group-list.html"
const userGroupListName = "Kotlin User Groups List (kotlinlang.org)"

const events = {
    "Thematic Seminar": "社区每隔一段时间发起的 Kotlin 主题交流会，Kotlin 爱好者进行 Kotlin 相关主题的技术分享，参与者可对分享内容进行讨论",
    "Kotlin Conqueror 竞赛": "一个综合的 Kotlin 竞赛活动（开发中）"
}

const welcome = "欢迎来到深圳 Kotlin User Group 站点，这里是 Kotlin 爱好者的聚集地"
const timeDesc = "如果你对 Kotlin 感兴趣，欢迎加入到用户组和我们一起讨论"

</script>

<template>
    <div id="home">
        <div class="content">
            <h1>{{ welcome }}</h1>
            <h2>
                <div>{{ timeDesc }}</div>
                <div style="margin-top: 10px">
                    站点已收录到
                    <a :href="userGroupListLink" target="_blank">{{ userGroupListName }}</a>
                </div>
            </h2>
            <div class="card-wrap">
                <el-card class="box-card" v-for="(desc, name) in events">
                    <template #header>
                        <span class="title">{{ name }}</span>
                    </template>
                    {{ desc }}
                </el-card>
            </div>
        </div>

        <div class="logo">
            <img src="../assets/shenzhen-kug-logo.jpg" alt srcset />
        </div>
    </div>
</template>

<style lang="scss" scoped>
#home {
    @media screen and (max-width: 1480px) {
        padding: 20px !important;
    }

    margin: auto;
    display: flex;
    flex-wrap: wrap-reverse;
    justify-content: space-around;

    .logo {
        text-align: center;
        margin: auto;
        img {
            max-width: 500px;
            max-height: 500px;
        }
    }

    .content {
        margin: auto;
    }

    @media screen and (min-width: 1480px) {
        max-width: 1480px;
    }
}

h1 {
    font-size: 3rem;
    max-width: 900px;
}

h2 {
    font-size: 1.3rem !important;
    font-weight: 400;
    a {
        --el-link-text-color: var(--el-color-primary);
        color: var(--el-link-text-color);
    }
}

.card-wrap {
    display: flex;
    flex-wrap: wrap;
    margin-top: 80px;
    justify-content: center;
}

.box-card {
    min-width: 300px;
    max-width: 400px;
    margin: 20px 20px;
    font-size: 1.2rem;
    line-height: 1.8;

    .title {
        font-weight: 700;
        font-size: 1.3rem;
        color: var(--el-color-primary);
    }
}
</style>
