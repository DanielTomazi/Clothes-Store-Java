package com.toedter.calendar;

import java.awt.Color;
import java.util.Date;

/**
 * Implementations of this interface can be added to various JCalendar
 * components to check if certain dates are valid for selection.
 * 
 * @author Kai Toedter
 * @version $LastChangedRevision: 142 $
 * @version $LastChangedDate: 2011-06-05 07:06:03 +0200 (So, 05 Jun 2011) $
 * 
 */
public interface IDateEvaluator {
	/**
	 * Checks if a date is a special date (might have different colors and tooltips)
	 * 
	 * @param date
	 *            the date to check
	 * @return true, if the date can be selected
	 */
	boolean isSpecial(Date date);

	/**
	 * @return the foreground color (used by JDayChooser)
	 */
	Color getSpecialForegroundColor();

	/**
	 * @return the background color (used by JDayChooser)
	 */
	Color getSpecialBackroundColor();
	
	/**
	 * @return the tooltip (used by JDayChooser)
	 */
	String getSpecialTooltip();
	
	/**
	 * Checks if a date is invalid for selection
	 * 
	 * @param date
	 *            the date to check
	 * @return true, if the date is invalid and cannot be selected
	 */
	boolean isInvalid(Date date);

	/**
	 * @return the foreground color (used by JDayChooser)
	 */
	Color getInvalidForegroundColor();

	/**
	 * @return the background color (used by JDayChooser)
	 */
	Color getInvalidBackroundColor();
	
	/**
	 * @return the tooltip (used by JDayChooser)
	 */
	String getInvalidTooltip();

}
