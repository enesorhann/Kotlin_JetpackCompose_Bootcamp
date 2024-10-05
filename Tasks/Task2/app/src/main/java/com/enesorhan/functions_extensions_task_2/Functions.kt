package com.enesorhan.functions_extensions_task_2

import kotlin.math.ceil

class Functions(){
    fun kmToMilConversion(inputKm:Int):Double{
        val mile = inputKm * 0.621
        return mile
    }
    fun rectangleEdgesCalculator(edge1:Int,edge2: Int){
        val res = (edge1+edge2)*2
        println("Area of Rectangle -> $res")
    }
    fun factCalc(inputValue:Int):Int{
        var num=1
        var res=1
        while (num<=inputValue){
            res *= num
            num++
        }
        return res
    }
    fun chrCalc(word:String){
        var total = 0
        for (i in word.lowercase()){
            if(i =='e'){
                total += 1
            }
        }
        println("Contains $total letter")
    }
    fun calcInteriorAngle(edgeCount:Int):Int{
        val  totalIntrAngl = ( (edgeCount - 2) * 180 ) / edgeCount
        return totalIntrAngl
    }

    fun salaryAmount(day:Int):Int{
        val hourforDay = day*8
        var totalSalary=0
        if(hourforDay<=150){
            totalSalary+=hourforDay*40
        }else{
            totalSalary+= (150*40) + ((hourforDay-150)*80)
        }
        return totalSalary
    }

    fun parkingFee(parkingTimeMinute:Double):Int{
        var parkingFeeAmount = 0
        if (parkingTimeMinute<=60){
            parkingFeeAmount += 50
        }else{
            parkingFeeAmount += 50 + (ceil(parkingTimeMinute/60-1)).toInt()*10
        }
    return parkingFeeAmount
    }





}