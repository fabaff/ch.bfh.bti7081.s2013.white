Task 02
=======
(see also the file "[questions.md](https://github.com/fabaff/ch.bfh.bti7081.s2013.white/blob/master/ch.bfh.bti7081.s2013.white/doc/cs01/questions.md)")

Plan-driven vs. agile process models
------------------------------------

- There are not yet detailed requirements available -> detailed plans are not possible and useful at the moment.
- It is a small developer team with 5 people -> focus on development and coding is better than a planning overkill.
- The team members have a limited time budget -> flexibility and an efficient time management is important (agile).
- Perhaps the team members don't have any experience with agile methods -> some plans could be useful.

Overall, an agile SE process model is recommendable (with some plan-driven elements).

Agile Development: Extreme Programming vs. Scrum
------------------------------------------------
We have the choice between Extreme Programming and Scrum (both are agile process models).

### Extreme Programming:
- Small releases: short release cycles are useful because we have a short time horizon in our project (start: Feb 2013, end: June 2013).
- On-site customer: Not possible because the professor is our customer and he is not always available.
- Incremental planning: danger of time consuming architecture refactoring.
- Pair programming: is difficult to realize because sometimes the team members work at home.

### Scrum:
- This process model gives more structures (Outline planning and architectual design first, followed by the sprint cycles).
- A good architectural design is important and it will be done before the sprint cycles (avoiding time consuming architecture refactoring).
- The fixed sprint cycles are easy to integrate in our week plan (short sprint cycles).

Scrum is a good choice for our project.

Our process model
-----------------
Activities:
- 1. Specification
- 2. Design and development
- 3. Validation
- 4. Evolution

### 1. Specification
- Requirements engineering process: The requirements of the system are collected.
- The product backlog is created based on the user requirements.
- The sprint backlog is created based on the system requirements.

- Output: requirements document, product backlog
- Stakeholders: customer, developers, management
  
### 2. Design and development
- Decision about the used technologies.
- The outline planning and architectural design comes first (before the sprint cycles).
- New and changed requirements are respected and the product/system backlog is updated during the sprint cycles.
- The fine tuning design will be realized during a sprint cycle. 

- Output: source codes with comments, running unit tests, UML-diagramms, system documentation, ...
- Stakeholders: customer, developers
  
### 3. Validation
- All components of the system must have running unit tests at the end of a sprint cycle.
- The implemented system is validated against the system requirements after each sprint cycle.
- Integration and acceptance test for the whole system when all sprint cycles have finished.

- Output: results from integration and acceptance tests, final release of the system with integrated help
- Stakeholders: customer, developers, users, management
  
### 4. Evolution
- Adapt the system to changed requirements.
- This activity comes after the project closure.
