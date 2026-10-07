package com.valterc.ki2.karoo.datatypes

import com.valterc.ki2.data.shifting.BuzzerType
import com.valterc.ki2.data.shifting.FrontTeethPattern
import com.valterc.ki2.data.shifting.RearTeethPattern
import com.valterc.ki2.data.shifting.ShiftingInfo
import com.valterc.ki2.data.shifting.ShiftingMode
import com.valterc.ki2.data.shifting.UpcomingSynchroShiftType
import com.valterc.ki2.karoo.shifting.BuzzerTracking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Ki2DataTypeTest {

    @Test
    fun `upcoming synchro shift has stable explicit wire values`() {
        assertEquals(0.0, value(UpcomingSynchroShiftType.NONE))
        assertEquals(1.0, value(UpcomingSynchroShiftType.UPCOMING_UP))
        assertEquals(2.0, value(UpcomingSynchroShiftType.UPCOMING_DOWN))
    }

    @Test
    fun `upcoming up returns to none through the existing tracker lifecycle`() {
        val tracker = BuzzerTracking()
        tracker.setShiftingInfo(shifting(BuzzerType.DEFAULT, rearGear = 5))
        tracker.setShiftingInfo(shifting(BuzzerType.UPCOMING_SYNCHRO_SHIFT, rearGear = 6))
        assertEquals(1.0, value(tracker.upcomingSynchroShiftType))

        tracker.setShiftingInfo(shifting(BuzzerType.DEFAULT, rearGear = 7))
        assertEquals(0.0, value(tracker.upcomingSynchroShiftType))
    }

    @Test
    fun `upcoming down returns to none through the existing tracker lifecycle`() {
        val tracker = BuzzerTracking()
        tracker.setShiftingInfo(shifting(BuzzerType.DEFAULT, rearGear = 7))
        tracker.setShiftingInfo(shifting(BuzzerType.UPCOMING_SYNCHRO_SHIFT, rearGear = 6))
        assertEquals(2.0, value(tracker.upcomingSynchroShiftType))

        tracker.setShiftingInfo(shifting(BuzzerType.DEFAULT, rearGear = 5))
        assertEquals(0.0, value(tracker.upcomingSynchroShiftType))
    }

    @Test
    fun `existing DI2 field ids remain unchanged`() {
        assertEquals("FIELD_DI2_FRONT_GEAR_INDEX", Ki2DataType.Field.DI2_FRONT_GEAR_INDEX)
        assertEquals("FIELD_DI2_FRONT_GEAR_TEETH", Ki2DataType.Field.DI2_FRONT_GEAR_TEETH)
        assertEquals("FIELD_DI2_FRONT_GEAR_MAX", Ki2DataType.Field.DI2_FRONT_GEAR_MAX)
        assertEquals("FIELD_DI2_REAR_GEAR_INDEX", Ki2DataType.Field.DI2_REAR_GEAR_INDEX)
        assertEquals("FIELD_DI2_REAR_GEAR_TEETH", Ki2DataType.Field.DI2_REAR_GEAR_TEETH)
        assertEquals("FIELD_DI2_REAR_GEAR_MAX", Ki2DataType.Field.DI2_REAR_GEAR_MAX)
        assertEquals("FIELD_DI2_BATTERY", Ki2DataType.Field.DI2_BATTERY)
        assertEquals("FIELD_DI2_SHIFTING_MODE", Ki2DataType.Field.DI2_SHIFTING_MODE)
        assertEquals(
            "FIELD_DI2_UPCOMING_SYNCHRO_SHIFT",
            Ki2DataType.Field.DI2_UPCOMING_SYNCHRO_SHIFT,
        )
    }

    private fun value(type: UpcomingSynchroShiftType): Double =
        Ki2DataType.UpcomingSynchroShiftValue.from(type)

    private fun shifting(buzzerType: BuzzerType, rearGear: Int) = ShiftingInfo(
        buzzerType,
        1,
        2,
        rearGear,
        12,
        FrontTeethPattern.UNKNOWN,
        RearTeethPattern.UNKNOWN,
        ShiftingMode.SYNCHRONIZED_SHIFT_MODE_2,
    )
}
