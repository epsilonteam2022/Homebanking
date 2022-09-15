# BANK

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

