# EPSILON HOMEBANK

### PROJECT SETUP

1. Download and install JDK 11.
    1. You can use [SDKMAN](https://sdkman.io/install).
    2. Verify your version using: `java --version`.
2. Download and install [Apache Maven 3.8.4](https://maven.apache.org/download.cgi).
    1. Verify your version using: `mvn --version`.
3. Install [MySQL](https://dev.mysql.com/doc/refman/8.0/en/installing.html).
    1. For local purposes, you can use H2 database. If you do it, ensure you do not commit it.
4. Select the IDE that you want to use: IntelliJ, VS Code, Eclipse, etc.
    1. Based on your selection, download the `*-style.xml` file for your IDE
       from [Google Style Guide](https://github.com/google/styleguide).
    2. Set up the downloaded file in the IDE preferences.
    3. Ensure `import with '*'` option is configured as 99.
5. Download and install [Postman](https://www.postman.com/downloads/).

### CODE STANDARDS

We follow the rules
from [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html) and:

- Package names are in singular.
- The names of attributes/fields from Java classes must be written using camel case. Example:
  firstName.
- The name of columns in the entities must be written using underscore and uppercase. Example:
  FIRST_NAME.
- The name of the tables is always in plural, but the entity name should be in singular.
- Exceptions should be handled by an implementation of ControllerAdvice.
- All the configuration classes must go in the config package.
- The integration test must go into the bigtest package.
- If you add a new endpoint, make sure to set the role access for it in the SecurityConfig class.

### KEEP IN MIND FOR PULL REQUEST AND CODE REVIEW

#### FORMAT

- The branch name format is: `{jiraTicket#}`.
- The pull request title format is: `{jiraTicket#}: {jiraTitle}`.
- The commits format is: `{jiraTicket#}: {commitDescription}`. Small commits are a nice to have.
- The pull request has to contain only the changes related to the scope defined in the ticket.
    - If you pull request contains unrelated changes, it will be rejected until those changes be
      removed.
- If your pull request does not pass all the checks, it will not be review until checks passed.

