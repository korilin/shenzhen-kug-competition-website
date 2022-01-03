
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
            value: "fun main() {\n\tprintln('Hello world!');\n}",
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

#editor {
    margin: 20px auto;
    width: 100%;
    height: 80vh
}
</style>
