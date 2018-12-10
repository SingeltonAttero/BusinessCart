package com.yakov.weber.businesscart.system.message

/**
 * Created on 10.12.18
 * @author YWeber
 * project BusinessCart */

data class SystemMessage (val message:String,
                          val type: SystemMessageType = SystemMessageType.TOAST)