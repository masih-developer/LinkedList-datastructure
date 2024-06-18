# 🚀 LinkedList Implementation in Java

Welcome to the **LinkedList** project! This project provides a non-generic implementation of the classic LinkedList data structure in Java. 🌟

## 📚 Introduction to LinkedList

A **LinkedList** is a linear data structure where elements are not stored in contiguous memory locations. Instead, each element (known as a node) points to the next element in the sequence, forming a chain-like structure. This allows for efficient insertion and deletion of elements.

## 📂 Project Structure

This project consists of the following main files:

- `ListNode.java`: Defines the nodes that make up the LinkedList.
- `List.java`: Contains the main implementation of the LinkedList, including various methods to manipulate the list.

## ✨ Additional Methods

In addition to the standard methods, the following extra methods have been implemented to extend the functionality of the LinkedList:

- `total()`: Calculates the total number of elements in the list (non-recursive method).
- `delete(int index)`: Deletes the element at the specified index.
- `removeAll(int item)`: Removes all occurrences of the specified item from the list.
- `equals(List other)`: Compares the LinkedList with another object for equality.

## 📦 How to Use

1. Clone the repository:
    ```sh
    https://github.com/masih-developer/LinkedList-datastructure.git
    ```
2. Navigate to the project directory:
    ```sh
    cd LinkedList-datastructure
    ```
3. Compile the Java files:
    ```sh
    javac ListNode.java List.java
    ```
4. Run the main class (if applicable):
    ```sh
    java List
    ```

## 💡 Examples

Here's how you can use the additional methods in your LinkedList:

```java
// Create a new LinkedList
List myList = new List();

// Add elements to the list
myList.add(1);
myList.add(2);
myList.add(3);
myList.add(2);

// Calculate the total number of elements
int total = myList.total(); // Output: 4

// Delete the element at index 1
myList.delete(1); // Removes the element '2' at index 1

// Remove all occurrences of '2'
myList.removeAll(2); // Removes all '2's from the list

// Check if two lists are equal
List anotherList = new List();
// Add elements to anotherList...
boolean isEqual = myList.equals(anotherList);
