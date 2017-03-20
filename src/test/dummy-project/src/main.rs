//! Entry point for the dummy project.
//! This comment block tests `rust doc`;
//! you should be able to see it from the documentation
//! folder after running the project's rustDoc task
//! in Gradle.

/// Prints a message to test documentation of
/// functions.
///
/// # Parameters
/// * `message`: The message to print.
///
/// # Examples
/// This prints "Hi!":
///
/// ```
/// sayHello("Hi!");
/// ```
pub fn sayHello(message: &str) {
	println!("{}", message);
}

/// Entry point for the program.
fn main() {
	sayHello("Rust works!");
}