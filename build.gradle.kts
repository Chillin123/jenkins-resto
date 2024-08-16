plugins {
    base
    id("com.palantir.docker") version "0.35.0"
    id("com.palantir.docker-run") version "0.35.0"
    id("pl.allegro.tech.build.axion-release") version "1.15.2"
}

version = scmVersion.version

docker {
    name = "${project.name}:${project.version}"
    files("plugins.txt", "seedJob.xml")
}

dockerRun {
    name = project.name
    image = "${project.name}:${project.version}"
    ports("8080:8080")
    clean = true
    daemonize = false
}
