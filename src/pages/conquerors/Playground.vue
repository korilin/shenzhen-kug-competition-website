<script setup>
import { CaretRight, Setting } from '@element-plus/icons-vue'

const versions = ["1.6.10", "1.5.30"]

const running = ref(false)
const version = ref(versions[0])

</script>
<template>
    <div class="tools">
        <el-button type="primary" size="small" :icon="CaretRight" :loading="running">Run</el-button>
        <el-select v-model="version" placeholder="版本选择">
            <el-option v-for="v in versions" :key="v" :value="v" />
        </el-select>
    </div>

    <div id="editor" ref="editor"></div>
</template>

<script>
import * as monaco from 'monaco-editor';
import editorWorker from 'monaco-editor/esm/vs/editor/editor.worker?worker'
import { ref } from 'vue';

self.MonacoEnvironment = {
    getWorker(_, label) {
        console.log(label);
        return new editorWorker()
    }
}
export default {
    name: 'app',
    async mounted() {
        const el = this.$refs.editor;
        this.editor = monaco.editor.create(el, {
            value: `fun main() {\n\tprintln("Hello world!");\n}`,
            language: 'kotlin',

            scrollbar: {
                arrowSize: 5,
                vertical: 'auto',
                horizontal: 'hidden',
                verticalScrollbarSize: 5,
                horizontalHasArrows: false
            },
            minimap: {
                enabled: false,
            },
            formatOnPaste: true,
            renderValidationDecorations: 'on',
            scrollBeyondLastLine: false
        })
    },
};
</script>

<style lang="scss" scoped>
.wrap {
    height: 100%;
    background: coral;
}

.tools {
    display: flex;
    margin: 20px auto;
    padding: 0 50px;

    .el-button {
        margin: 0 10px;
    }
}
.wrap {
    height: 100%;
    background: coral;
}

.tools {
    display: flex;
    margin: 20px auto;
    padding: 0 50px;

    .el-button {
        margin: 0 10px;
    }
}

#editor {
    width: 100%;
    height: 80vh;
}
</style>

<style  lang="scss">
.monaco-editor,
.monaco-scrollable-element,
.overflow-guard {
    width: 100% !important;
    height: 100% !important;
}

.view-lines,
.current-line,
.lines-content {
    width: calc(100% - 70px) !important;
    height: 100% !important;
}

.decorationsOverviewRuler {
    display: none;
}
</style>