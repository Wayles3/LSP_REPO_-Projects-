Heuristic 1:

Name: Heuristic 2.1 

Heuristic: All abstract state should be hidden. 

Explanation: This improves maintainability by ensuring that external classes cannot directly access or modify the internal data of an object, preventing a ripple effect of changes if the data structure is modified. In lecture, this was illustrated by showing how making class variables private protects the integrity of the object's state. 


Heuristic 2:

Name: Heuristic 3.1 

Heuristic: Users of a class must be dependent on its public interface, but a class should not be dependent on its users. 

Explanation: This improves readability and promotes decoupling. It was explained in lecture that a class should be a self-contained "black box" that provides services without needing to know the context or identity of the calling code.



Heuristic 3:

Name: Heuristic 4.6 

Heuristic: Most of the methods defined in a class should be using most of the data members most of the time. 

Explanation: This improves maintainability by enforcing high cohesion. In lecture, this was used to identify when a class is becoming too large or "God-like," suggesting that it should be refactored into smaller, more focused components.