# Notes on Cargo/Rust Behavior
Rust output always goes in the following format:

```
/target                             Root folder for output
    /release, /debug, /dev, ...     Configuration-specific output
    /doc                            Documentation
```

# Needed Tasks
In general, output from commands should always be kept as task output.
We need some basic tasks:
## Build
Generates crate artifacts.
### Command
`cargo build`
### Command Parameters
* -p SPEC, --package SPEC ...  Package to build
* -j N, --jobs N               Number of parallel jobs, defaults to # of CPUs
* --lib                        Build only this package's library
* --bin NAME                   Build only the specified binary
* --example NAME               Build only the specified example
* --test NAME                  Build only the specified test target
* --bench NAME                 Build only the specified benchmark target
* --release                    Build artifacts in release mode, with optimizations
* --features FEATURES          Space-separated list of features to also build
* --all-features               Build all available features
* --no-default-features        Do not build the `default` feature
* --target TRIPLE              Build for the target triple
* --manifest-path PATH         Path to the manifest to compile
* -v, --verbose ...            Use verbose output (-vv very verbose/build.rs output)
* -q, --quiet                  No output printed to stdout
* --color WHEN                 Coloring: auto, always, never
* --message-format FMT         Error format: human, json [default: human]
* --frozen                     Require Cargo.lock and cache are up to date
* --locked                     Require Cargo.lock is up to date
### Expected Results
* Output folder /target/... actually contains artifacts.
* Said artifacts are actually modified if a prior version existed on disk.
#### Failure Only
* Task throws an exception.

## Test
Runs test functions specified in source.
### Command
`cargo test`
### Needed Parameters
* String `filter`: For example, `cargo test shenme` will run any tests that have `shenme` in the name.
Default is blank.
### Command Parameters
* --lib                        Test only this package's library
* --doc                        Test only this library's documentation
* --bin NAME                   Test only the specified binary
* --example NAME               Test only the specified example
* --test NAME                  Test only the specified integration test target
* --bench NAME                 Test only the specified benchmark target
* --no-run                     Compile, but don't run tests
* -p SPEC, --package SPEC ...  Package to run tests for
* --all                        Test all packages in the workspace
* -j N, --jobs N               Number of parallel jobs, defaults to # of CPUs
* --release                    Build artifacts in release mode, with optimizations
* --features FEATURES          Space-separated list of features to also build
* --all-features               Build all available features
* --no-default-features        Do not build the `default` feature
* --target TRIPLE              Build for the target triple
* --manifest-path PATH         Path to the manifest to build tests for
* -v, --verbose ...            Use verbose output (-vv very verbose/build.rs output)
* -q, --quiet                  No output printed to stdout
* --color WHEN                 Coloring: auto, always, never
* --message-format FMT         Error format: human, json [default: human]
* --no-fail-fast               Run all tests regardless of failure
* --frozen                     Require Cargo.lock and cache are up to date
* --locked                     Require Cargo.lock is up to date
### Expected Results
* Test results are listed to output.
#### Failure Only
* Task throws an exception.

## Format
Reformats source to common style guidelines.
This isn't part of cargo out of the box; it requires a `cargo install rustfmt` if it's not already there.
### Command
`cargo fmt`
### Needed Parameters
TODO
### Command Parameters
* -q, --quiet         no output printed to stdout
* -v, --verbose       use verbose output
### Command Details
This utility formats all bin and lib files of the current crate using rustfmt. Arguments after `--` are passed to rustfmt.
### Expected Results
#### Failure Only
* Task throws an exception.

## Run
### Command
`cargo run`
### Needed Parameters
TODO
### Command Parameters
* --bin NAME              Name of the bin target to run
* --example NAME          Name of the example target to run
* -j N, --jobs N          Number of parallel jobs, defaults to # of CPUs
* --release               Build artifacts in release mode, with optimizations
* --features FEATURES     Space-separated list of features to also build
* --all-features          Build all available features
* --no-default-features   Do not build the `default` feature
* --target TRIPLE         Build for the target triple
* --manifest-path PATH    Path to the manifest to execute
* -v, --verbose ...       Use verbose output (-vv very verbose/build.rs output)
* -q, --quiet             No output printed to stdout
* --color WHEN            Coloring: auto, always, never
* --message-format FMT    Error format: human, json [default: human]
* --frozen                Require Cargo.lock and cache are up to date
* --locked                Require Cargo.lock is up to date
### Command Details
If neither `--bin` nor `--example` are given, then if the project only has one
bin target it will be run. Otherwise `--bin` specifies the bin target to run,
and `--example` specifies the example target to run. At most one of `--bin` or
`--example` can be provided.

All of the trailing arguments are passed to the binary to run. If you're passing
arguments to both Cargo and the binary, the ones after `--` go to the binary,
the ones before go to Cargo.
### Expected Results
Program output is printed to output.
#### Failure Only
Task throws an exception.

# Optional Tasks
Additionally, we would like:
## Build Documentation
### Command
`cargo doc`
### Needed Parameters
TODO
### Command Parameters
* --open                       Opens the docs in a browser after the operation
* -p SPEC, --package SPEC ...  Package to document
* --no-deps                    Don't build documentation for dependencies
* -j N, --jobs N               Number of parallel jobs, defaults to # of CPUs
* --lib                        Document only this package's library
* --bin NAME                   Document only the specified binary
* --release                    Build artifacts in release mode, with optimizations
* --features FEATURES          Space-separated list of features to also build
* --all-features               Build all available features
* --no-default-features        Do not build the `default` feature
* --target TRIPLE              Build for the target triple
* --manifest-path PATH         Path to the manifest to document
* -v, --verbose ...            Use verbose output (-vv very verbose/build.rs output)
* -q, --quiet                  No output printed to stdout
* --color WHEN                 Coloring: auto, always, never
* --message-format FMT         Error format: human, json [default: human]
* --frozen                     Require Cargo.lock and cache are up to date
* --locked                     Require Cargo.lock is up to date
### Expected Results
* Output folder /target/... actually contains documentation artifacts.
* Said artifacts are actually modified if a prior version existed on disk.
#### Failure Only
* Task throws an exception.

## Benchmark
### Command
`cargo bench`
### Needed Parameters
* String `filter`: For example, `cargo bench shenme` will benchmark any functions that have `shenme` in the name.
Default is blank.
### Command Parameters
* --lib                        Benchmark only this package's library
* --bin NAME                   Benchmark only the specified binary
* --example NAME               Benchmark only the specified example
* --test NAME                  Benchmark only the specified test target
* --bench NAME                 Benchmark only the specified bench target
* --no-run                     Compile, but don't run benchmarks
* -p SPEC, --package SPEC ...  Package to run benchmarks for
* -j N, --jobs N               Number of parallel jobs, defaults to # of CPUs
* --features FEATURES          Space-separated list of features to also build
* --all-features               Build all available features
* --no-default-features        Do not build the `default` feature
* --target TRIPLE              Build for the target triple
* --manifest-path PATH         Path to the manifest to build benchmarks for
* -v, --verbose ...            Use verbose output (-vv very verbose/build.rs output)
* -q, --quiet                  No output printed to stdout
* --color WHEN                 Coloring: auto, always, never
* --message-format FMT         Error format: human, json [default: human]
* --frozen                     Require Cargo.lock and cache are up to date
* --locked                     Require Cargo.lock is up to date
### Expected Results
* Benchmark results are printed to output.
#### Failure Only
* Task throws an exception. This could happen if a rebuild is needed and the rebuild failed.

## Clean
Removes output artifacts.
### Command
`cargo clean`
### Needed Parameters
TODO
### Command Parameters
* -p SPEC, --package SPEC ...  Package to clean artifacts for
* --manifest-path PATH         Path to the manifest to the package to clean
* --target TRIPLE              Target triple to clean output for (default all)
* --release                    Whether or not to clean release artifacts
* -v, --verbose ...            Use verbose output (-vv very verbose/build.rs output)
* -q, --quiet                  No output printed to stdout
* --color WHEN                 Coloring: auto, always, never
* --frozen                     Require Cargo.lock and cache are up to date
* --locked                     Require Cargo.lock is up to date
### Expected Results
* /target/... is deleted.
#### Failure Only
* Task throws an exception.

## Publish
Publishes crate to a host.
### Command
`cargo publish`
### Needed Parameters
TODO
### Command Parameters
* --host HOST              Host to upload the package to
* --token TOKEN            Token to use when uploading
* --no-verify              Don't verify package tarball before publish
* --allow-dirty            Allow publishing with a dirty source directory
* --manifest-path PATH     Path to the manifest of the package to publish
* -j N, --jobs N           Number of parallel jobs, defaults to # of CPUs
* --dry-run                Perform all checks without uploading
* -v, --verbose ...        Use verbose output (-vv very verbose/build.rs output)
* -q, --quiet              No output printed to stdout
* --color WHEN             Coloring: auto, always, never
* --frozen                 Require Cargo.lock and cache are up to date
* --locked                 Require Cargo.lock is up to date
### Expected Results
#### Failure Only
* Task throws an exception.

## Update
Updates dependencies as specified in Cargo.lock.
### Command
`cargo update`
### Needed Parameters
TODO
### Command Parameters
* -p SPEC, --package SPEC ...  Package to update
* --aggressive                 Force updating all dependencies of (name) as well
* --precise PRECISE            Update a single dependency to exactly PRECISE
* --manifest-path PATH         Path to the crate's manifest
* -v, --verbose ...            Use verbose output (-vv very verbose/build.rs output)
* -q, --quiet                  No output printed to stdout
* --color WHEN                 Coloring: auto, always, never
* --frozen                     Require Cargo.lock and cache are up to date
* --locked                     Require Cargo.lock is up to date
### Expected Results
#### Failure Only
* Task throws an exception.