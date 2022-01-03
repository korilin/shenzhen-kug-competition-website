<script setup>
import { CaretRight,Setting } from '@element-plus/icons-vue'

const running = ref(false)

</script>
<template>
    <div class="tools">
        <el-button type="primary" size="small" :icon="CaretRight" :loading="running">Run</el-button>
        <el-button :icon="Setting" :loading="running"></el-button>
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
                enabled: true,
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
    flex-direction: row-reverse;

    .el-button {
        margin: 0 10px;
    }
}

#editor {
    width: 100%;
    height: 80vh
}
</style>
