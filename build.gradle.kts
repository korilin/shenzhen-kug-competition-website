
group = "cn.shenzhen-kug"
version = "1.0.0"

task("deploy", Copy::class) {
    group = "build"
    project.delete("docs")
    project.mkdir("docs")
    from("build/js/packages/shenzhen-kug-website-shenzhen-kug-home-page/kotlin")
    into("docs")
    from("CNAME")
    into("docs")
}
