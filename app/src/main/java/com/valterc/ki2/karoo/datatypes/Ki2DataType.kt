package com.valterc.ki2.karoo.datatypes

import com.valterc.ki2.data.shifting.UpcomingSynchroShiftType

class Ki2DataType {

    object Type {
        const val DFLY = "TYPE_DFLY"
        const val DI2 = "TYPE_DI2"
        const val STEPS = "TYPE_STEPS"
    }

    object Field {
        const val DFLY_CHANNEL_1 = "FIELD_DFLY_CHANNEL_1"
        const val DFLY_CHANNEL_2 = "FIELD_DFLY_CHANNEL_2"
        const val DFLY_CHANNEL_3 = "FIELD_DFLY_CHANNEL_3"
        const val DFLY_CHANNEL_4 = "FIELD_DFLY_CHANNEL_4"

        const val DI2_FRONT_GEAR_INDEX = "FIELD_DI2_FRONT_GEAR_INDEX"
        const val DI2_FRONT_GEAR_TEETH = "FIELD_DI2_FRONT_GEAR_TEETH"
        const val DI2_FRONT_GEAR_MAX = "FIELD_DI2_FRONT_GEAR_MAX"
        const val DI2_REAR_GEAR_INDEX = "FIELD_DI2_REAR_GEAR_INDEX"
        const val DI2_REAR_GEAR_TEETH = "FIELD_DI2_REAR_GEAR_TEETH"
        const val DI2_REAR_GEAR_MAX = "FIELD_DI2_REAR_GEAR_MAX"
        const val DI2_BATTERY = "FIELD_DI2_BATTERY"
        const val DI2_SHIFTING_MODE = "FIELD_DI2_SHIFTING_MODE"
        const val DI2_UPCOMING_SYNCHRO_SHIFT = "FIELD_DI2_UPCOMING_SYNCHRO_SHIFT"

        const val STEPS_BATTERY = "FIELD_STEPS_BATTERY"
    }

    object UpcomingSynchroShiftValue {
        const val NONE = 0.0
        const val UPCOMING_UP = 1.0
        const val UPCOMING_DOWN = 2.0

        /** Stable public wire values; deliberately independent of enum declaration order. */
        fun from(type: UpcomingSynchroShiftType): Double = when (type) {
            UpcomingSynchroShiftType.NONE -> NONE
            UpcomingSynchroShiftType.UPCOMING_UP -> UPCOMING_UP
            UpcomingSynchroShiftType.UPCOMING_DOWN -> UPCOMING_DOWN
        }
    }

}
