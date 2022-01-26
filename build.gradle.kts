group = "cn.shenzhen-kug"
version = "1.0.0"

val submodules = arrayOf("shenzhen-kug-home-page")

task("deploy", Copy::class) {
    group = "build"
    project.delete("docs")
    project.mkdir("docs")
    submodules.forEach {
        from("$it/build/js/packages/$it/kotlin")
        into("docs")
    }
    from("CNAME")
    into("docs")
}