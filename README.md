# ReflectiveObjectInspector

Create a reflective object inspector that does a complete 
introspection of an object at runtime and prints to standard out. 

This introspection includes:
- name of the declaring class
- name of the immediate superclass
- name of the interfaces the class implements
- methods the class declares. For each, also find the following:
	- exceptions thrown
	- parameter types
	- return type
	- modifiers
- constructors the class declares. For each, also finds the following:
	- parameter types
	- modifiers
- fields the class declares. For each, also find the following:
	- type
	- modifiers
- current value of each field. If the field is an object reference, 
and recursive is set to false, it simply prints out the 
“pointer value” (an unsigned integer).
		  
Also traverses the inheritance hierarchy to find all the methods, 
constructors, fields, and field values that each superclass and 
superinterface declares. 
	
If the inspect method is invoked with recursive set to false, it simply 
finds information for the object specified. If it is set to true, 
then it recursively inspects each field that is an object.
