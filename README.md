# Custom Collections Framework

A Java collections framework built from scratch to understand how common data structures work behind the scenes.

This project is not intended to replace Java's standard Collections Framework. It is a hands-on implementation of the ideas behind collections such as lists, maps, stacks, queues, and priority queues, with the internal logic written from the ground up.

## What This Project Covers

The framework currently includes implementations for:

- ArrayList
- LinkedList
- HashMap
- Queue
- Stack
- PriorityQueue

Each collection manages its own internal storage and operations instead of delegating the core data-structure logic to Java's collection classes.

## Highlights

- Generic collections using Java Generics
- Dynamic array resizing
- Doubly linked list operations
- Hash table with separate chaining
- HashMap resizing and rehashing
- FIFO queue operations
- LIFO stack operations
- Min-heap based priority queue
- Custom exception classes
- Basic collection operations such as add, remove, search, update, clear, and size
- Driver classes for trying the implementations directly

## Project Structure

```text
customCollectionFramewrok/
└── src/
    ├── customCollectionFramewrok/
    │   ├── driver/
    │   │   ├── ArrayListDriver.java
    │   │   ├── HashMapDriver.java
    │   │   ├── LinkedListDriver.java
    │   │   ├── PriorityQueueDriver.java
    │   │   └── StackDriver.java
    │   │
    │   ├── exception/
    │   │   ├── MyIllegalArgumentException.java
    │   │   ├── MyIndexOutOfBoundsException.java
    │   │   └── MyNoSuchElementException.java
    │   │
    │   ├── list/
    │   │   ├── ArrayList.java
    │   │   ├── HashMap.java
    │   │   ├── LinkedList.java
    │   │   ├── Queue.java
    │   │   └── Stack.java
    │   │
    │   └── queue/
    │       └── PriorityQueue.java
    │
    └── module-info.java
```

## How It Works

### ArrayList

Uses a dynamically resized array to store elements. When the current storage is full, the internal array grows and existing elements are copied into the new storage.

Common operations include `add()`, `addFirst()`, `addLast()`, `get()`, `set()`, `remove()`, `contains()`, `indexOf()`, and `clear()`.

### LinkedList

Uses a doubly linked structure where every node keeps references to the previous and next node. The implementation supports operations at both ends as well as indexed access.

Common operations include `add()`, `addFirst()`, `addLast()`, `get()`, `set()`, `remove()`, `removeFirst()`, `removeLast()`, `peek()`, `poll()`, and `contains()`.

### HashMap

Uses an array of buckets with linked lists for collision handling. Keys are converted into bucket positions using their hash codes. When the number of stored entries grows beyond the configured load factor, the table is resized and the entries are rehashed.

Common operations include `put()`, `get()`, `remove()`, `containsKey()`, `keySet()`, `size()`, `isEmpty()`, and `clear()`.

### Queue

Uses a circular array to maintain FIFO behaviour. Elements are inserted at the rear and removed from the front. The internal array expands when additional capacity is required.

Common operations include `add()`, `offer()`, `remove()`, `poll()`, `element()`, `peek()`, and `clear()`.

### Stack

Uses an array to provide LIFO behaviour. The implementation grows its internal storage when necessary.

Common operations include `push()`, `pop()`, `peek()`, `empty()`, `size()`, and `clear()`.

### PriorityQueue

Uses a binary min-heap. The smallest element is kept at the root, and heap operations maintain the ordering after insertion and removal.

Common operations include `add()`, `offer()`, `peek()`, `element()`, `poll()`, `remove()`, `size()`, `isEmpty()`, and `clear()`.

## Getting Started

### Requirements

- Java 17 or later
- Eclipse, IntelliJ IDEA, VS Code, or another Java IDE
- Basic understanding of Java Generics and data structures

### Run the Project

Clone the repository and open the `customCollectionFramewrok` directory as a Java project.

Then run any of the driver classes from `src/customCollectionFramewrok/driver/`.

## Example

```java
ArrayList<Integer> numbers = new ArrayList<>();

numbers.add(10);
numbers.add(20);
numbers.add(30);

System.out.println(numbers);
System.out.println(numbers.get(1));
System.out.println(numbers.contains(20));
```

Output:

```text
[10, 20, 30]
20
true
```

## Why I Built This

The main goal of this project is to learn by building.

Instead of only using `java.util` collections, the project focuses on understanding what happens internally when elements are added, removed, searched, stored, resized, hashed, or reordered.

It is also a practical way to strengthen Java fundamentals, especially:

- Object-oriented programming
- Generics
- Arrays
- Linked data structures
- Hashing
- Collision handling
- Resizing and rehashing
- Heap operations
- Time and space complexity

## Project Status

The core collection implementations are in place and the project is being developed incrementally.

Future improvements can include iterators, collection interfaces, additional data structures, stronger test coverage, and further API improvements.

## License

This project is available for learning and personal use. Add a formal license to the repository if you plan to distribute or reuse it under specific terms.