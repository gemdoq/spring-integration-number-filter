# Spring Integration Number Splitter

Spring Integration to split a collection of integers into individual messages and route them to different channels based on their divisibility properties. 
It showcases how to use core Spring Integration components like `Splitter`, `Filter`, and `QueueChannel`.

## Features

- Split a list of numbers into individual messages.
- Route numbers to different channels based on their divisibility by 3:
    - Numbers divisible by 3.
    - Numbers with a remainder of 1 when divided by 3.
    - Numbers with a remainder of 2 when divided by 3.
- Use Spring Integration components to build robust and testable message flows.

## Prerequisites

- Java 21
- Gradle as a build tool