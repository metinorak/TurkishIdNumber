# TurkishIdNumber Class

This is a class that contains a string for Turkish id number. It gets the value if it is valid, otherwise throws an exception.
Generating an object using this class, you can keep the Turkish id numbers as objects and validate its value at the same time.

## Usage
* Add TurkishIdNumber.java to your project.

## Examples
```java
public static void main(String[] args) {
    try{
        TurkishIdNumber tid = new TurkishIdNumber("10000000146");
    }
    catch(IllegalArgumentException e){
        e.printStackTrace();
    }
}

```

* You can also change the value later:


```java
public static void main(String[] args) {
    try{
        TurkishIdNumber tid = new TurkishIdNumber("10000000146");
        tid.setValue("10000000140");
    }
    catch(IllegalArgumentException e){
        e.printStackTrace();
    }
}
```

* And get the value as a String using `toString method.`


* You don't have to create an object. If you just want to validate the value, use static isValid method. 

```java
if(TurkishIdNumber.isValid("10000000146")){
    System.out.println("The number is valid.");
}
```

* You can also generate a random number using static 'generate' method.
```java
System.out.println(TurkishIdNumber.generate());
```
