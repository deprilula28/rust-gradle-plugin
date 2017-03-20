# rust-gradle-plugin
A Gradle plugin that adds custom task types to build Rust artifacts, such as `cargo build`, `cargo test`, etc.

## How to Use
Add this to the beginning of build.gradle:
```Gradle
buildscript {
  repositories {
    maven {
      url "https://plugins.gradle.org/m2/"
    }
  }
  dependencies {
    classpath "gradle.plugin.com.jtitor:jtitor-rust-gradle-plugin:0.1-SNAPSHOT"
  }
}

apply plugin: "com.jtitor.rust"
```

You can now use the plugin's custom task types as part of your Gradle project:
```Gradle
task exampleBuildTask(type:RustBuild) {
  group 'example'
  description 'Builds the project as a Rust crate.'

  // This also supports some of the flags
  // used by cargo...
  release = true
  quiet = true
  // When run, this would call "cargo build --release --quiet".
}
```

## Currently Supported Tasks
* RustBuild: performs `cargo build`.
* RustDoc: performs `cargo doc`.
* RustRun: performs `cargo run`.
* RustTest: performs `cargo test`.

*Please note that the flags are not sanity checked*; you can set verbose and quiet at the same time without complaint from the plugin.

## How to contribute
I didn't actually know what a pull request was until this commit, but if you want to contribute I'm okay with it.

The main points are:
* Pull requests should always go to `wip`.
* Make sure you have unit tests when possible (under `src/test/groovy/com/jtitor/gradle/`).
* **All commits are under MIT license.**