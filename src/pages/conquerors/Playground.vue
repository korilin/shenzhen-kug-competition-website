
<template>
    <div id="editor" ref="editor"></div>
</template>

<script>
import * as monaco from 'monaco-editor';
import editorWorker from 'monaco-editor/esm/vs/editor/editor.worker?worker'

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
            value: "fun main() {\n\println('Hello world!');\n}",
            language: 'kotlin',

            scrollbar: {
                arrowSize: 5,
                verticalScrollbarSize: 8,
                horizontalScrollbarSize: 8,
            },
            minimap: {
                enabled: true,
            },
            formatOnPaste: true,
            renderValidationDecorations: 'on',
        })
    },
};
</script>

<style lang="scss" scoped>
#editor {
    height: 50vh;
}
</style>
