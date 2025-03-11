package com.toedter.calendar;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	protected Date minSelectableDate;

	protected Date maxSelectableDate;

	protected Date defaultMinSelectableDate;

	protected Date defaultMaxSelectableDate;

	public DateUtil() {
		Calendar tmpCalendar = Calendar.getInstance();
		tmpCalendar.set(1, 0, 1, 1, 1);
		defaultMinSelectableDate = tmpCalendar.getTime();
		minSelectableDate = defaultMinSelectableDate;
		tmpCalendar.set(9999, 0, 1, 1, 1);
		defaultMaxSelectableDate = tmpCalendar.getTime();
		maxSelectableDate = defaultMaxSelectableDate;
	}

	/**
	 * Sets a valid date range for selectable dates. If max is before min, the
	 * default range with no limitation is set.
	 * 
	 * @param min
	 *            the minimum selectable date or null (then the minimum date is
	 *            set to 01\01\0001)
	 * @param max
	 *            the maximum selectable date or null (then the maximum date is
	 *            set to 01\01\9999)
	 */
	public void setSelectableDateRange(Date min, Date max) {
		if (min == null) {
			minSelectableDate = defaultMinSelectableDate;
		} else {
			minSelectableDate = min;
		}
		if (max == null) {
			maxSelectableDate = defaultMaxSelectableDate;
		} else {
			maxSelectableDate = max;
		}
		if (maxSelectableDate.before(minSelectableDate)) {
			minSelectableDate = defaultMinSelectableDate;
			maxSelectableDate = defaultMaxSelectableDate;
		}
	}

	/**
	 * Sets the maximum selectable date. If null, the date 01\01\9999 will be set instead.
	 * 
	 * @param max the maximum selectable date
	 * 
	 * @return the maximum selectable date
	 */
	public Date setMaxSelectableDate(Date max) {
		if (max == null) {
			maxSelectableDate = defaultMaxSelectableDate;
		} else {
			maxSelectableDate = max;
		}
		return maxSelectableDate;
	}

	/**
	 * Sets the minimum selectable date. If null, the date 01\01\0001 will be set instead.
	 * 
	 * @param min the minimum selectable date
	 * 
	 * @return the minimum selectable date
	 */
	public Date setMinSelectableDate(Date min) {
		if (min == null) {
			minSelectableDate = defaultMinSelectableDate;
		} else {
			minSelectableDate = min;
		}
		return minSelectableDate;
	}

	/**
	 * Gets the maximum selectable date.
	 * 
	 * @return the maximum selectable date
	 */
	public Date getMaxSelectableDate() {
		return maxSelectableDate;
	}

	/**
	 * Gets the minimum selectable date.
	 * 
	 * @return the minimum selectable date
	 */
	public Date getMinSelectableDate() {
		return minSelectableDate;
	}

	/**
	 * Checks a given date if it is in the formally specified date range.
	 * 
	 * @param date
	 *            the date to check
	 * @return true, if the date is within minSelectableDate and
	 *         maxSelectableDate
	 */
	public boolean checkDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		Calendar minCal = Calendar.getInstance();
		minCal.setTime(minSelectableDate);
		minCal.set(Calendar.HOUR_OF_DAY, 0);
		minCal.set(Calendar.MINUTE, 0);
		minCal.set(Calendar.SECOND, 0);
		minCal.set(Calendar.MILLISECOND, 0);

		Calendar maxCal = Calendar.getInstance();
		maxCal.setTime(maxSelectableDate);
		maxCal.set(Calendar.HOUR_OF_DAY, 0);
		maxCal.set(Calendar.MINUTE, 0);
		maxCal.set(Calendar.SECOND, 0);
		maxCal.set(Calendar.MILLISECOND, 0);
		
		return !(calendar.before(minCal) || calendar.after(maxCal));
	}

}
