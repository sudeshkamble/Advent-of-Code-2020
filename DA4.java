package com.sb.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DA4 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/main/resources/passport.info");
		Scanner myReader = new Scanner(file);
		ArrayList<String> passportsList = new ArrayList<String>();
		String passport = "";
		int i = 0;
		while (myReader.hasNextLine()) {
			String data = myReader.nextLine();
			// System.out.println(i + " " + data + " " + data.length());
			if (data.length() != 0) {
				passport = passport + data + " ";
			} else {

				passportsList.add(passport);
				passport = "";
			}
			i++;
		}
		int validPassports = 0;
		passportsList.add(passport);
		for (String passP : passportsList) {
			if (passP.contains("byr:") && passP.contains("iyr:") && passP.contains("eyr:") && passP.contains("hgt:")
					&& passP.contains("hcl:") && passP.contains("ecl:") && passP.contains("pid:")) {

				if (validateValues(passP)) {
					System.out.println(passP);
					validPassports++;
				}
			}
		}

		System.out.println(validPassports);

	}

	private static boolean validateValues(String passP) {
		passP = passP.replace("\\n", " ");
		String passDetails[] = passP.split("\\s");
		System.out.println("============================");
		//System.out.println(Arrays.toString(passDetails));
		for (String detail : passDetails) {
			String key = detail.split(":")[0];
			String value = detail.split(":")[1];
			//System.out.println(key + "=" + value);
			if (key.equals("byr")) {
				if (value.length() == 4) {
					int byr = Integer.parseInt(value);
					if (byr >= 1920 && byr <= 2002) {
						System.out.println("Birthday OK");
					} else {
						return false;
					}
				} else {
					return false;
				}
			}
			if (key.equals("iyr")) {
				if (value.length() == 4) {
					int iyr = Integer.parseInt(value);
					if (iyr >= 2010 && iyr <= 2020) {
						System.out.println("Issue Year OK");
					} else {
						return false;
					}
				} else {
					return false;
				}
			}
			if (key.equals("eyr")) {
				if (value.length() == 4) {
					int eyr = Integer.parseInt(value);
					if (eyr >= 2020 && eyr <= 2030) {
						System.out.println("Expiration Year OK");
					} else {
						return false;
					}
				} else {
					return false;
				}
			}
			if (key.equals("hgt")) {
				String metric = value.substring(value.length() - 2);
				if (metric.equals("in")) {
					String height = value.substring(0, value.length() - 2);
					System.out.println("Height:" + height);
					int hgt = Integer.parseInt(height);
					if (hgt >= 59 && hgt <= 76) {
						System.out.println("Height in Inches: OK");

					} else {
						return false;
					}
				} else if (metric.equals("cm")) {
					String height = value.substring(0, value.length() - 2);
					System.out.println("Height:" + height);
					int hgt = Integer.parseInt(height);
					if (hgt >= 150 && hgt <= 193) {
						System.out.println("Height in CM: OK");
					} else {
						return false;
					}
				} else {
					return false;
				}
			}
			if (key.equals("hcl")) {
				if (value.length() == 7) {
					Pattern pattern = Pattern.compile("#[0-9a-f]{6}");
					Matcher matcher = pattern.matcher(value);
					boolean ok = matcher.find();
					if (ok) {
						System.out.println("Hair Colour OK");

					} else {
						return false;
					}
				} else {
					return false;
				}
			}
			if (key.equals("ecl")) {
				if (value.equals("amb") || value.equals("blu") || value.equals("brn") || value.equals("gry")
						|| value.equals("grn") || value.equals("hzl") || value.equals("oth")) {
					System.out.println("Eye Colur OK");
				} else {
					return false;
				}
			}
			if (key.equals("pid")) {
				if (value.length() == 9) {
					Pattern pattern = Pattern.compile("\\d{9}");
					Matcher matcher = pattern.matcher(value);
					boolean ok = matcher.find();
					if (ok) {
						System.out.println("PID OK");

					} else {
						return false;
					}
				} else {
					return false;
				}
			}

		}

		return true;
	}

}
