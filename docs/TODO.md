# Notes on Cargo/Rust Behavior
Rust output always goes in the following format:

```
/target                             Root folder for output
    /release, /debug, /dev, ...     Configuration-specific output
    /doc                            Documentation
```

# Needed Tasks
All tasks have additional details in `cargo-commands.md`. In general, output from commands should always be kept as task output.
We need some basic tasks:

## Build
Generates crate artifacts.
### Command
`cargo build`
### Needed Parameters
* TODO
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
### Needed Parameters
* TODO
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
* TODO
### Expected Results
#### Failure Only
* Task throws an exception.

## Run
Runs the crate at the given project.
### Command
`cargo run`
### Needed Parameters
* TODO
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
* TODO
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
### Needed Parameters
* TODO
### Expected Results
* Benchmark results are printed to output.
#### Failure Only
* Task throws an exception. This could happen if a rebuild is needed and the rebuild failed.

## Clean
Removes output artifacts.
### Command
`cargo clean`
### Needed Parameters
* TODO
### Expected Results
* /target/... is deleted.
#### Failure Only
* Task throws an exception.

## Publish
Publishes crate to a host.
### Command
`cargo publish`
### Needed Parameters
* TODO
### Expected Results
#### Failure Only
* Task throws an exception.

## Update
Updates dependencies as specified in Cargo.lock.
### Command
`cargo update`
### Needed Parameters
* TODO
### Expected Results
#### Failure Only
* Task throws an exception.

## Check (Rust 1.16+)
Runs compilation checks, but does not generate binaries. Usually used while developing to see when to perform an actual build and `cargo test`, so this isn't a very high priority.
### Command
`cargo check`
### Needed Parameters
* TODO
### Expected Results
#### Failure Only
* Task throws an exception.