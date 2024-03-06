# Java notes

## Generics and Autoboxing

### Autoboxing
Java converts primitive to Object type version of the primitive automatically \
```java
public class BasicArrayList {
    public static void main(String[] args) {
      ArrayList<Integer> L = new ArrayList<Integer>();
      L.add(5); // Instead of having to define: L.add(Integer(5))
      L.add(6);
      int first = L.get(0);
    }
}

```
### Immutability
Immutable data type is a data type whose instances cannot change after instantiation\
For example, `String` objects are immutable in Java. So, when you concat to a `String`, you're creating a new string object every time

Use `final` keyword to prevent variables from being changed

### Generics
Parameterized types. Encapsulate operations on an object that are not specific to a data type. Allows you to perform normal operations like for an array or hashmap, on different object types.

## Packages and Access Control

### Packages
Packages are "folders" of java code. A good way to organize java classes so there is less file complexity. Packages are a namespace of classes and interfaces.

Naming convention (starts with website address, backwards):\
`ug.joshh.animal // website is joshh.ug `\
To use packages, either reference it like \
`ug.joshh.animal.Dog d = ...` \
or import it

**Default Package**: Code that doesn't have a package declaration is automatically part of default package. 

### Access Control
Defining access Controls for class access


*Public*: Open to class, package, subclass, and world\
*Private*: Open to class, closed to package, subclass, and world\
*Protected*: Open to class, package, subclass, closed to world\
*Private Protected*: Open to class, package. Closed to subclass and world