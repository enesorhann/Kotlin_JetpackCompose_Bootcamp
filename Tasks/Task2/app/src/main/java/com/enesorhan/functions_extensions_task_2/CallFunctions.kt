package com.enesorhan.functions_extensions_task_2

fun main(){
    val functions = Functions()
    val mileResult = functions.kmToMilConversion(300)
    println("Mile Result -> $mileResult")
    println("*****************************")
    functions.rectangleEdgesCalculator(5,6)
    println("*****************************")
    val resFact = functions.factCalc(6)
    println("Result of Fact -> $resFact")
    println("*****************************")
    functions.chrCalc("Enes")
    println("*****************************")
    val totalAngle = functions.calcInteriorAngle(8)
    println("Total of Interior Angle -> $totalAngle")
    println("*****************************")
    val salaryAmount = functions.salaryAmount(30)
    println("Amount of Salary -> $salaryAmount")
    println("*****************************")
    val totalParkingFee = functions.parkingFee(250.0)
    println("Total of Parking Fee -> $totalParkingFee")
}