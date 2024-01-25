import java.util.*
import kotlin.math.sqrt

fun main(args: Array<String>) {
    // Create Square
    println("Enter name for Square:")
    val squareName = readln()
    println("Enter length for Square:")
    val squareLength = readln().toDouble()
    println("Enter height for Square:")
    val squareHeight = readln().toDouble()
    val square: Shape = Square(squareName, squareLength, squareHeight)

    // Create Circle
    println("Enter name for Circle:")
    val circleName = readln()
    println("Enter radius for Circle:")
    val circleRadius = readln().toDouble()
    val circle: Shape = Circle(circleName, circleRadius)

    // Create Triangle
    println("Enter name for Triangle:")
    val triangleName = readln()
    println("Enter side1 for Triangle:")
    val triangleSide1 = readln().toDouble()
    println("Enter side2 for Triangle:")
    val triangleSide2 = readln().toDouble()
    println("Enter side3 for Triangle:")
    val triangleSide3 = readln().toDouble()
    val triangle: Shape = Triangle(triangleName, triangleSide1, triangleSide2, triangleSide3)

    // Create Equilateral Triangle
    println("Enter name for Equilateral Triangle:")
    val equilateralTriangleName = readln()
    println("Enter side for Equilateral Triangle:")
    val equilateralTriangleSide = readln().toDouble()
    val equilateralTriangle: Shape = EquilateralTriangle(equilateralTriangleName, equilateralTriangleSide)

    // Print details
    val shapes = listOf(square, circle, triangle, equilateralTriangle) //creates array for all shapes created
    shapes.forEach { shape -> //iterates through shapes
        println("\n${shape.name.uppercase(Locale.getDefault())} DETAILS")
        shape.printDimensions()
        println("Area: ${shape.getArea()}")
    }
}

abstract class Shape (_name : String) : Dimensionable{
    var name = _name
    open fun getArea(): Double {
        return 0.0;
    }
}

interface Dimensionable {
    fun printDimensions()
}

class Square(_name: String, val squareLength: Double, val squareHeight: Double) : Shape(_name) {
    var length = squareLength
    var height = squareHeight
    override fun getArea(): Double {
        return length * height
    }
    fun setDimensions(givenLength: Double, givenHeight: Double){
        length = givenLength
        height = givenHeight
    }

    override fun printDimensions() {
        println("Square with length of $length and height of $height")
    }
}

class Circle(_name: String, val circleRadius: Double) : Shape(_name) {
    private var radius = circleRadius
    override fun getArea(): Double {
        return Math.PI * radius * radius
    }

    fun setDimensions(givenRadius: Double){
        radius = givenRadius
    }

    override fun printDimensions() {
        println("Circle with radius $radius")
    }
}

open class Triangle(_name: String, private val  triangleSide1: Double, private val triangleSide2: Double, private val triangleSide3: Double) : Shape(_name) {
    private var side1 = triangleSide1
    private var side2 = triangleSide2
    private var side3 = triangleSide3
    override fun getArea(): Double {
        val s = (side1 + side2 + side3) / 2
        return sqrt(s*(s-side1)*(s-side2)*(s-side3))
    }

    fun setDimensions(givenSide1: Double, givenSide2: Double, givenSide3: Double){
        side1 = givenSide1
        side2 = givenSide2
        side3 = givenSide3
    }

    override fun printDimensions() {
        println("Triangle with side 1: $side1, side 2: $side2, and side 3: $side3 ")
    }
}

class EquilateralTriangle(_name: String, triangleSide: Double) : Triangle(_name, triangleSide, triangleSide, triangleSide) {
    var side = triangleSide
    override fun getArea(): Double {
        val s = (side * 3) / 2
        return sqrt(s*(s-side)*(s-side)*(s-side))
    }

    fun setDimensions(givenSide:Double){
        side = givenSide
    }

    override fun printDimensions() {
        println("Triangle with side length $side")
    }
}