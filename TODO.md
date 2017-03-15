#Notes on Cargo/Rust Behavior
Rust output always goes in the following format:

/target								Root folder for output
	/release, /debug, /dev, ...		Configuration-specific output
	/doc							Documentation

#Needed Tasks
We need some basic tasks:
##Build
Generates crate artifacts.
###Command
`cargo build`
###Command Parameters
		-p SPEC, --package SPEC ...  Package to build
		-j N, --jobs N               Number of parallel jobs, defaults to # of CPUs
		--lib                        Build only this package's library
		--bin NAME                   Build only the specified binary
		--example NAME               Build only the specified example
		--test NAME                  Build only the specified test target
		--bench NAME                 Build only the specified benchmark target
		--release                    Build artifacts in release mode, with optimizations
		--features FEATURES          Space-separated list of features to also build
		--all-features               Build all available features
		--no-default-features        Do not build the `default` feature
		--target TRIPLE              Build for the target triple
		--manifest-path PATH         Path to the manifest to compile
		-v, --verbose ...            Use verbose output (-vv very verbose/build.rs output)
		-q, --quiet                  No output printed to stdout
		--color WHEN                 Coloring: auto, always, never
		--message-format FMT         Error format: human, json [default: human]
		--frozen                     Require Cargo.lock and cache are up to date
		--locked                     Require Cargo.lock is up to date

## Test
Runs test functions specified in source.
###Command
`cargo test`
###Needed Parameters
* String `filter`: For example, `cargo test shenme` will run any tests that have `shenme` in the name.
Default is blank.
###Command Parameters
--lib                        Test only this package's library
--doc                        Test only this library's documentation
--bin NAME                   Test only the specified binary
--example NAME               Test only the specified example
--test NAME                  Test only the specified integration test target
--bench NAME                 Test only the specified benchmark target
--no-run                     Compile, but don't run tests
-p SPEC, --package SPEC ...  Package to run tests for
--all                        Test all packages in the workspace
-j N, --jobs N               Number of parallel jobs, defaults to # of CPUs
--release                    Build artifacts in release mode, with optimizations
--features FEATURES          Space-separated list of features to also build
--all-features               Build all available features
--no-default-features        Do not build the `default` feature
--target TRIPLE              Build for the target triple
--manifest-path PATH         Path to the manifest to build tests for
-v, --verbose ...            Use verbose output (-vv very verbose/build.rs output)
-q, --quiet                  No output printed to stdout
--color WHEN                 Coloring: auto, always, never
--message-format FMT         Error format: human, json [default: human]
--no-fail-fast               Run all tests regardless of failure
--frozen                     Require Cargo.lock and cache are up to date
--locked                     Require Cargo.lock is up to date

##Format
Reformats source to common style guidelines.
This isn't part of cargo out of the box; it requires a `cargo install rustfmt` if it's not already there.
###Command
`cargo fmt`
###Needed Parameters
TODO
###Command Parameters

##Run
###Command
`cargo run`

#Optional Tasks
Additionally, we would like:
##Build Documentation
###Command
`cargo doc`
###Needed Parameters
TODO
###Command Parameters
--open                       Opens the docs in a browser after the operation
-p SPEC, --package SPEC ...  Package to document
--no-deps                    Don't build documentation for dependencies
-j N, --jobs N               Number of parallel jobs, defaults to # of CPUs
--lib                        Document only this package's library
--bin NAME                   Document only the specified binary
--release                    Build artifacts in release mode, with optimizations
--features FEATURES          Space-separated list of features to also build
--all-features               Build all available features
--no-default-features        Do not build the `default` feature
--target TRIPLE              Build for the target triple
--manifest-path PATH         Path to the manifest to document
-v, --verbose ...            Use verbose output (-vv very verbose/build.rs output)
-q, --quiet                  No output printed to stdout
--color WHEN                 Coloring: auto, always, never
--message-format FMT         Error format: human, json [default: human]
--frozen                     Require Cargo.lock and cache are up to date
--locked                     Require Cargo.lock is up to date

##Benchmark
###Command
`cargo bench`
###Needed Parameters
* String `filter`: For example, `cargo bench shenme` will benchmark any functions that have `shenme` in the name.
Default is blank.
###Command Parameters
--lib                        Benchmark only this package's library
--bin NAME                   Benchmark only the specified binary
--example NAME               Benchmark only the specified example
--test NAME                  Benchmark only the specified test target
--bench NAME                 Benchmark only the specified bench target
--no-run                     Compile, but don't run benchmarks
-p SPEC, --package SPEC ...  Package to run benchmarks for
-j N, --jobs N               Number of parallel jobs, defaults to # of CPUs
--features FEATURES          Space-separated list of features to also build
--all-features               Build all available features
--no-default-features        Do not build the `default` feature
--target TRIPLE              Build for the target triple
--manifest-path PATH         Path to the manifest to build benchmarks for
-v, --verbose ...            Use verbose output (-vv very verbose/build.rs output)
-q, --quiet                  No output printed to stdout
--color WHEN                 Coloring: auto, always, never
--message-format FMT         Error format: human, json [default: human]
--frozen                     Require Cargo.lock and cache are up to date
--locked                     Require Cargo.lock is up to date

##Clean
Removes output artifacts.
###Command
`cargo clean`
###Needed Parameters
TODO
###Command Parameters
-p SPEC, --package SPEC ...  Package to clean artifacts for
--manifest-path PATH         Path to the manifest to the package to clean
--target TRIPLE              Target triple to clean output for (default all)
--release                    Whether or not to clean release artifacts
-v, --verbose ...            Use verbose output (-vv very verbose/build.rs output)
-q, --quiet                  No output printed to stdout
--color WHEN                 Coloring: auto, always, never
--frozen                     Require Cargo.lock and cache are up to date
--locked                     Require Cargo.lock is up to date

##Publish
Publishes crate to a host.
###Command
`cargo publish`
###Needed Parameters
TODO
###Command Parameters
--host HOST              Host to upload the package to
--token TOKEN            Token to use when uploading
--no-verify              Don't verify package tarball before publish
--allow-dirty            Allow publishing with a dirty source directory
--manifest-path PATH     Path to the manifest of the package to publish
-j N, --jobs N           Number of parallel jobs, defaults to # of CPUs
--dry-run                Perform all checks without uploading
-v, --verbose ...        Use verbose output (-vv very verbose/build.rs output)
-q, --quiet              No output printed to stdout
--color WHEN             Coloring: auto, always, never
--frozen                 Require Cargo.lock and cache are up to date
--locked                 Require Cargo.lock is up to date

##Update
Updates dependencies as specified in Cargo.lock.
###Command
`cargo update`
###Needed Parameters
TODO
###Command Parameters
-p SPEC, --package SPEC ...  Package to update
--aggressive                 Force updating all dependencies of <name> as well
--precise PRECISE            Update a single dependency to exactly PRECISE
--manifest-path PATH         Path to the crate's manifest
-v, --verbose ...            Use verbose output (-vv very verbose/build.rs output)
-q, --quiet                  No output printed to stdout
--color WHEN                 Coloring: auto, always, never
--frozen                     Require Cargo.lock and cache are up to date
--locked                     Require Cargo.lock is up to date