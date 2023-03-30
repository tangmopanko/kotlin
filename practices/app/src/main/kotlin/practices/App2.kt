package practices

fun main() {
    val pickupStatus = PickupStatus.valueOf("ORDER_CANCLE")

    if (pickupStatus == PickupStatus.ORDER_CANCLE) println("주문취소함..")

    for (status in PickupStatus.values()) {
        println("${status.ordinal}- ${status}: ${status.label}")
    }
}

/**
주문 -> 주문확인 -> 준비중 -> 준비완료 -> 픽업완료
 */ 
enum class PickupStatus(val label: String): Cancle, Alarm {
    ORDER("주문") {
        override fun isCancle() = true
    },
    ORDER_CANCLE("주문취소") {
        override fun isCancle() = true
    }, 
    ORDER_CONFIRM("주문확인") {
        override fun isCancle() = true
    },
    READY("준비중") {
        override fun isCancle() = false
    }, 
    READY_COMPELETE("준비완료") {
        override fun isCancle() = false  
    },
    PICKUP("픽업완료") {
        override fun isCancle() = false
    };
}

interface Cancle {
    fun isCancle(): Boolean
}

interface Alarm {
    fun sendMessage(msg: String): Boolean {
        println("PICK_STATUS : CURRENT[${msg}]")
        
        return true 
    } 
}