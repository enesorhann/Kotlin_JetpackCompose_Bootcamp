package com.enesorhan.variable_task_1




fun main(){
    var list = arrayListOf<Any>()

    val district:String = "SEYHAN"
    list.add(district)
    val continent:String = "Europe"
    list.add(continent)
    val fax:Int = 666
    list.add(fax)
    val postal_code:String = "01200"
    list.add(postal_code)
    val insta_address:String = "genomlib"
    list.add(insta_address)
    val department_you_work_in:String = "Mobile"
    list.add(department_you_work_in)
    val product_quantity:Int = 10000
    list.add(product_quantity)
    val customer_last_name:String = "Mutlu"
    list.add(customer_last_name)
    val payment_amount:Int = 6000
    list.add(payment_amount)
    val date_of_birth:String = "28/08/2003"
    list.add(date_of_birth)
    val debt:Int = 500
    list.add(debt)
    val marital_status:String = "married"
    list.add(marital_status)
    val video_commentary:String = "It is amazing!"
    list.add(video_commentary)
    val payment_time:String = "10/10/24"
    list.add(payment_time)
    val EFT_amount:Int = 6889
    list.add(EFT_amount)
    val quantity_sold:String = " %25 || 1/4 "
    list.add(quantity_sold)
    val phoneModel:String = "iPhone"
    list.add(phoneModel)
    val journal_name:String = "ScienceOfComputer"
    list.add(journal_name)
    val publication_date:String = "06/06/1999"
    list.add(publication_date)
    val raise_amount:Int = 6565
    list.add(raise_amount)
    val number_of_flats:String = "3+1"
    list.add(number_of_flats)
    val latitude:String = "37.000000"
    list.add(latitude)
    val longitude:String = "35.321335"
    list.add(longitude)
    val food_name:String = "Burger"
    list.add(food_name)
    val product_price:String = "55 $"
    list.add(product_price)
    val company:String = "MGO Company"
    list.add(company)
    val video_name:String = "variables_defination"
    list.add(video_name)
    val music_duration:String = "2.46 minutes"
    list.add(music_duration)
    val venue_score:Double = 4.9
    list.add(venue_score)
    val file_name:String = "img"
    list.add(file_name)
    val image_format:String = ".jpg"
    list.add(image_format)
    val colour:String = "White"
    list.add(colour)
    val color_code:String = "FFFFFF"
    list.add(color_code)
    val computer_model:String = "IdeaPad Gaming 3"
    list.add(computer_model)
    val screen_size:String = "1920/1080"
    list.add(screen_size)
    val duration_of_use:String = "3.45 Minutes"
    list.add(duration_of_use)
    val pressure:Double = 8.64
    list.add(pressure)
    val event_day:String = "Wednesday"
    list.add(event_day)
    val payment_day:String = "Friday"
    list.add(payment_day)
    val trip_exit_date:String = "07/03/24"
    list.add(trip_exit_date)
    val neighborhood_name:String = "Hurriyet"
    list.add(neighborhood_name)
    val bus_line:String = "Selcuker-Kampus"
    list.add(bus_line)
    val minutes_used:Int = 36
    list.add(minutes_used)
    val shipping_number:String = "29475699999"
    list.add(shipping_number)
    val coupon_period:String = "5 Day"
    list.add(coupon_period)
    val coupon_code:String = "38EKIM24INALLCOURSES"
    list.add(coupon_code)
    val invoice_date:String = "28/10/2024"
    list.add(invoice_date)

    list.forEach{
        println(it)
    }

   // print(list)
    println("\nLength Of List -> ${list.count()}")
}