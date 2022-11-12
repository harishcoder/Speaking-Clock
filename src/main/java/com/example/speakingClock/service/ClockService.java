package com.example.speakingClock.service;

import org.springframework.stereotype.Service;

@Service
public class ClockService {
	

    private static final String[] TENS = {
            "oh ", "", "twenty ", "thirty ", "forty ", "fifty "
    };

    private static final String[] ONES = {
            "twelve ", "one ", "two ", "three ", "four ", "five ",
            "six ", "seven ", "eight ", "nine ", "ten ", "eleven ",
            "twelve ", "thirteen ", "fourteen ", "fifteen ",
            "sixteen ", "seventeen ", "eighteen ", "nineteen "
    };
	
	public String timeConversion(String time) {
		String[] hours = time.trim().split(":");
		String errorMessage = "Please provide the time in the correct format.Format is HH:MM.";
		 try {
	            Integer.parseInt(hours[0]);
	            Integer.parseInt(hours[1]);
	        } catch (NumberFormatException e) {
	            throw new NumberFormatException(errorMessage);
	        } catch (ArrayIndexOutOfBoundsException e) {
	        	throw new ArrayIndexOutOfBoundsException(errorMessage);
	        }
		 String text = convertTimeToText(Integer.parseInt(hours[0]),
         Integer.parseInt(hours[1]));
		return text;
	}

	private String convertTimeToText(int hours, int minutes) {
		 StringBuilder result = new StringBuilder();

	        if (minutes == 0) {

	            if (hours == 12) {
	                return result.append("It's Midday").toString();
	            }

	            if (hours == 24) {
	                return result.append("It's Midnight").toString();
	            }

	            result.append("It's ").append(ONES[hours]);

	        } else if (minutes % 10 == 0) {
	            result.append("It's ").append(ONES[hours]).append(TENS[minutes / 10]);
	        } else if (minutes < 10 || minutes > 20) {
	            result.append("It's ").append(ONES[hours]).append(TENS[minutes / 10]).append(ONES[minutes % 10]);
	        } else {
	            // minutes > 10 && minutes < 20
	            result.append("It's ").append(ONES[hours]).append(ONES[minutes]);
	        }

	        return result.toString();
	}

}
