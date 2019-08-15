# java-basics
Basics of Java and OOP

What are Objects?
Object is nothing but a collection of fields and methods. Everything in Java is an object. Building blocks of these 
objects are fields and methods which can either be of primtive types or instead be other objects.  

Objects helps us to keep the code easy to understand and modular.

What are Classes?
Classes are the blueprint of these objects which dictate how an object will look like and what it will contain.

Constructors
These are methods which are run whenever an object is created, used for initiliazing the state of the object.
By default there exists an empty constructor. If we add our own constructor then we need to add the empty constructor manually.

Methods and Fields
Method usually means functions defined inside a class and Fields usually means variables defined inside a class. 

Static & Non-Static
Static functions or variables are those which exist without an object. They exist on a class.

Non-static functions or variables on the other hand exist ONLY within an object.

Inheritance
Parent class or base class
Child class or derived class
Java does not allow multiple inheritance. A child class cannot inherit from multiple parent classes. A parent class can
be extended by multiple child classes.

Inheritance allows the child class to extend all public methods and fields of the base class. Also, allows child class to add
it's own methods and fields

When child class inherits from parent class, child's constructor automatically calls parent's default constructor. If
default constructor does not exist, you will manually have to call the parent's constructor.

Overriding
A child class can override a public function of the parent class to customize or change the implementation

Interfaces
These are layouts which define what but not how. This is used to have clearer and more understandable code. A class which
implements an interface must implement all methods inside that interface. 

Final
Final methods cannot be overridden by a child class. Final fields are those whose value cannot be changed.

Accessors
These are getter setter methods used to encapsulate logic and objects.

Array
Array Limitations

Collections
ArrayList
Stacks
Queue

Generics
