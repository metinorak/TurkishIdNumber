# TurkishIdNumber Class

This is a class that contains a string for Turkish id number. It gets the value if it is valid, otherwise throws an exception.
Generating an object using this class, you can keep the Turkish id numbers as objects and validate its value at the same time.

## Usage
* Add TurkishIdNumber.java to your project.

## Examples
```java
public static void main(String[] args) {
    TurkishIdNumber tid = null;
    try{
        tid = new TurkishIdNumber("10000000146");
    }
    catch(IllegalArgumentException e){
        e.printStackTrace();
    }
}

```

* You can also change the value later:


```java
public static void main(String[] args) {
    TurkishIdNumber tid = null;
    try{
        tid = new TurkishIdNumber("10000000146");
    }
    catch(IllegalArgumentException e){
        e.printStackTrace();
    }

    try{
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
if(TurkishIdNumber.isValid("10000000146"){
    System.out.println("The number is valid."));
}
```

