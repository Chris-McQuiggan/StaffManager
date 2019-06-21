package com.bae.util;

import com.bae.persistence.domain.CheckIn;
import com.bae.persistence.domain.Staff;

public class Constant {
	// staff map testing values
	public static final JSONUtil util = new JSONUtil();
	public static final Staff staff1 = new Staff(1, "Matt", "Hunt", "mat.hunt@mail.com", "Trainer", 2);
	public static final Staff staff2 = new Staff(2, "Chester", "Gardner", "chester@mail.com", "Trainer", 2);
	public static final Staff staff3 = new Staff(3, "Louis", "Simth", "Louis@gmail.com", "Consoltant", 4);
	public static final String jSONStaff1 = "{\"staffID\":1,\"firstName\":\"Matt\",\"lastName\":\"Hunt\",\"email\":\"mat.hunt@mail.com\",\"jobRole\":\"Trainer\",\"payTier\":2}";
	public static final String jSONStaff2 = "{\"staffID\":2,\"firstName\":\"Chester\",\"lastName\":\"Gardner\",\"email\":\"chester@mail.com\",\"jobRole\":\"Trainer\",\"payTier\":2}";

	// check in map testing values
	public static final CheckIn check1 = new CheckIn(1, "09:00", "17:00", 8.0, 1);
	public static final CheckIn check2 = new CheckIn(2, "08:50", "17:20", 8.0, 2);
	public static final CheckIn check3 = new CheckIn(3, "08:30", "16:00", 8.5, 3);
	public static final CheckIn checkIn = new CheckIn(4, "08:50", 1);
	public static final String jSONCheck1 = "{\"logID\":1,\"timeIn\":\"09:00\",\"timeOut\":\"17:00\",\"hours\":8.0,\"staffID\":1}";
	public static final String jSONCheck2 = "{\"logID\":2,\"timeIn\":\"08:50\",\"timeOut\":\"17:20\",\"hours\":8.0,\"staffID\":2}";
	public static final String jSONCheckIn = "{\"logID\":4,\"timeIn\":\"08:50\",\"staffID\":1}";
	public static final String jSONCheckOut = "{\"timeOut\":\"17:20\",\"hours\":\"8.5\"}";
	public static final String jSONCheckInOut = "{\"logID\":4,\"timeIn\":\"08:50\",\"timeOut\":\"17:20\",\"hours\":8.5,\"staffID\":1}";
}
